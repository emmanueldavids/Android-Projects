package com.example.hymnal_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.window.SplashScreen;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    ArrayAdapter<String> arrayAdapter, arrayAdapter1;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        String[] search = getResources().getStringArray(R.array.title_book);
        arrayAdapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, search);
        String[] title = getResources().getStringArray(R.array.title_book);
        final String[] details = getResources().getStringArray(R.array.details_book);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, title);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener((parent, view, i, id) -> {
            String iss = details[i];
            Intent ii = new Intent(MainActivity.this, detailsactivity.class);
            ii.putExtra("detail", iss);
            startActivity(ii);


        });

        //nav bar code
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open,R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId())
            {
                case R.id.share:
                {
                    Toast.makeText(MainActivity.this,"Share Selected", Toast.LENGTH_LONG).show();
                    break;
                }
                case R.id.favorite:
                {
                    Toast.makeText(MainActivity.this,"favorite Selected", Toast.LENGTH_LONG).show();
                    break;
                }
                case R.id.About:
                {
                    Intent i = new Intent(MainActivity.this, AboutUs.class);
                    startActivity(i);
                    Toast.makeText(MainActivity.this,"About Selected", Toast.LENGTH_LONG).show();
                    break;
                }
                case R.id.game:
                {
                    Toast.makeText(MainActivity.this,"Game Selected", Toast.LENGTH_LONG).show();
                    break;
                }
                case R.id.exit:
                {
                    finish();
                    Toast.makeText(MainActivity.this,"Exited", Toast.LENGTH_LONG).show();
                    break;
                }

            }
            return false;
        });
    }
    //Search view code
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_view,menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Search Here...");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                    listView.setAdapter(arrayAdapter1);
                    arrayAdapter1.getFilter().filter(newText);

                    return false;

            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    //nav bar code continue
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}