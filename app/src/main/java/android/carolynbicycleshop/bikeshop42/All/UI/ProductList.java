package android.carolynbicycleshop.bikeshop42.All.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.carolynbicycleshop.bikeshop42.All.Database.Repository;
import android.carolynbicycleshop.bikeshop42.All.Entities.Thing;
import android.carolynbicycleshop.bikeshop42.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;
import java.util.Objects;

public class ProductList extends AppCompatActivity {
    private Repository repository;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        repository=new Repository(getApplication());
        List<Thing> allThings=repository.getAllThings();
        RecyclerView recyclerView=findViewById(R.id.recyclerview);
        final ThingAdapter thingAdapter=new ThingAdapter(this);
        recyclerView.setAdapter(thingAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        thingAdapter.setThings(allThings);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recyclerview, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.refresh:
                repository=new Repository(getApplication());
                List<Thing> allThings=repository.getAllThings();
                final ThingAdapter thingAdapter=new ThingAdapter(this);
                RecyclerView recyclerView=findViewById(R.id.recyclerview);
                recyclerView.setAdapter(thingAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                thingAdapter.setThings(allThings);
        }
        return super.onOptionsItemSelected(item);
    }

    public void enterParts(View view) {
        Intent intent=new Intent(ProductList.this, PartsList.class);
        startActivity(intent);
    }
}