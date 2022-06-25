package android.carolynbicycleshop.bikeshop42.All.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.carolynbicycleshop.bikeshop42.All.Database.Repository;
import android.carolynbicycleshop.bikeshop42.All.Entities.Thing;
import android.carolynbicycleshop.bikeshop42.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class PartsList extends AppCompatActivity {
    String name;
    EditText editName;
    EditText editPrice;
    int id=1;// made this id 1, not zero since I had sample data
    Repository repository;
    Thing currentThing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parts_list);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        name= getIntent().getStringExtra("name");
        editName=findViewById(R.id.partname);
        editPrice=findViewById(R.id.partprice);
        //I left this line out
        editName.setText(name);
        repository=new Repository(getApplication());


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.share:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                // (Optional) Here we're setting the title of the content
                sendIntent.putExtra(Intent.EXTRA_TITLE, "Send message title");
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
                return true;
            case R.id.notify:
                String dateFromScreen=editPrice.getText().toString();
                String myFormat = "MM/dd/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                Date myDate=null;
                try {
                    myDate=sdf.parse(dateFromScreen);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Long trigger=myDate.getTime();
                Intent intent= new Intent(PartsList.this,MyReceiver.class);
                intent.putExtra("key","message I want to see");
                PendingIntent sender=PendingIntent.getBroadcast(PartsList.this, ++MainActivity.numAlert,intent,0);
                AlarmManager alarmManager=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, trigger, sender);
                return true;

            case R.id.delete:
                for(Thing p:repository.getAllThings()){
                    if(p.getThingID()==1)currentThing=p;
                }

                if(true) {
                    repository.delete(currentThing);
                }
                else{
                    Toast.makeText(PartsList.this,"Can't delete a product with parts", Toast.LENGTH_LONG).show();
                }
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_part4, menu);
        return true;
    }


    public void saveProduct(View view) {
        String screenName=editName.getText().toString();
        if(name==null) {
            id=repository.getAllThings().get(repository.getAllThings().size()-1).getThingID();
            Thing newThing = new Thing(++id, screenName);
            repository.insert(newThing);
        }
        else{
  // I had the key as ThingID, not id
            Thing oldThing=new Thing(getIntent().getIntExtra("id",-1),screenName);
            repository.update(oldThing);
        }
    }

    public void date(View view) {
    }
}