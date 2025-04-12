package com.example.finalprojectenglish;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView=findViewById(R.id.bottom_navigation);
       bottomNavigationView.setOnItemSelectedListener(item -> {
           Fragment selectFragment=null;
           switch (item.getItemId()){
               case R.id.menu_home:
                   selectFragment=new HomeFrag();
                   break;
               case R.id.menu_quiz:
                   selectFragment=new QuizFrag();
                   break;
               case R.id.menu_progress:
                   selectFragment=new ProgressFrag();
                   break;
               case R.id.menu_settings:
                   selectFragment=new SettingsFrag();
                   break;


           }
           if (savedInstanceState == null) {
               bottomNavigationView.setSelectedItemId(R.id.menu_home);
           }
           return true;
       });

    }
    }
