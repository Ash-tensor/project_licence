package com.example.projectlicence;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity  {

    public FragmentManager fragmentManager = getSupportFragmentManager();
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(navListener);

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