package com.example.projectlicence;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.example.projectlicence.user;

public class MainActivity extends AppCompatActivity  {

    SharedPreferences sharedPreferences;

    public FragmentManager fragmentManager = getSupportFragmentManager();
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user User1 = new user(1, 1, 1, 1, 1);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(navListener);

        sharedPreferences = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        boolean firstTime = sharedPreferences.getBoolean("firstTime", true);

        if (!firstTime) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("firstTime", false);
            editor.commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.FragmentContainer, new getUserDataFragment()).commit();
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.FragmentContainer, new fragment1()).commit();
        }

    }

    private NavigationBarView.OnItemSelectedListener navListener = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.menu_1:
                    selectedFragment = new fragment1();
                    break;
                case R.id.menu_2:
                    selectedFragment = new fragment2();
                    break;
                case R.id.menu_3:
                    selectedFragment = new fragment3();
                    break;
            }

            TextView testTextView = findViewById(R.id.testTextView);
            testTextView.setVisibility(View.GONE);
            getSupportFragmentManager().beginTransaction().replace(R.id.FragmentContainer, selectedFragment).commit();
            return true;
        }
    } ;
}