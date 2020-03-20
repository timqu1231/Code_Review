package com.example.navigationdrawer.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
//import android.widget.Toolbar;

import com.example.navigationdrawer.fragment.FavoriteFragment;
import com.example.navigationdrawer.fragment.ListFragment;
import com.example.navigationdrawer.fragment.SearchFragment;
import com.example.navigationdrawer.fragment.SearchListFragment;
import com.example.navigationdrawer.R;
import com.example.navigationdrawer.helper.Utils;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import static com.example.navigationdrawer.activities.LoginActivity.databaseHelper;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
        String email = intent.getStringExtra("EMAIL");

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headView = navigationView.getHeaderView(0);
        ImageView imageView = (ImageView) headView.findViewById(R.id.user_image);
        TextView textView = (TextView) headView.findViewById(R.id.user_name);
        TextView textView2 = (TextView) headView.findViewById(R.id.user_email);
        textView.setText(name);
        textView2.setText(email);

        byte[] image = databaseHelper.getUserImage(email);
        imageView.setImageBitmap(Utils.getImage(image));


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ListFragment())
//                    .commit();

            // for test map functionality
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SearchFragment())
                    .commit();
            navigationView.setCheckedItem(R.id.nav_search);
        }



    }

    @Override
    public void onBackPressed(){
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_search:
                SearchFragment searchFragment = new SearchFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, searchFragment)
                        .commit();
                break;
            case R.id.nav_recommend:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ListFragment())
                        .commit();
                break;
            case R.id.nav_favorite:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FavoriteFragment())
                        .commit();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
