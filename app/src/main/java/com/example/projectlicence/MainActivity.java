package com.example.projectlicence;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
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
    private com.example.projectlicence.DBHelper dbHelper;

    public FragmentManager fragmentManager = getSupportFragmentManager();
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user User1 = new user(1, 1, 1, 1, 1);

        dbHelper = new com.example.projectlicence.DBHelper(this);
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
                    selectedFragment = new getUserDataFragment();
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

//    public class DBHelper extends SQLiteOpenHelper {
//        public DBHelper(Context context) {
//            super(context, "AdventurerDB", null, 1);
////          "AdventurerDB" >> 생성할 DB의 이름
//        }
//        @Override
//        public void onCreate(SQLiteDatabase db) {
//            db.execSQL("CREATE TABLE Adventurer (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, level INTEGER, grade TEXT)");
//        }
//
//        @Override
//        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        }
//    }
}