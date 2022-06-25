package android.carolynbicycleshop.bikeshop42.All.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.carolynbicycleshop.bikeshop42.All.Database.Repository;
import android.carolynbicycleshop.bikeshop42.All.Entities.Thing;
import android.carolynbicycleshop.bikeshop42.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static int numAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Repository repository=new Repository(getApplication());
        Thing thing= new Thing(1,"Carolyn");
        repository.insert(thing);
    }

    public void enterHere(View view) {
        Intent intent=new Intent(MainActivity.this, ProductList.class);
        startActivity(intent);

    }
}