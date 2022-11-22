package com.example.sembakomobile.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;
import com.example.sembakomobile.FirstFragment;
import com.example.sembakomobile.FourthFragment;
import com.example.sembakomobile.R;
import com.example.sembakomobile.SecondFragment;
import com.example.sembakomobile.ThirdFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        BottomNavigationView btNav = (BottomNavigationView) findViewById(R.id.bottomNavigationView);

        btNav = findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,new FirstFragment()).commit();

        btNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selected = null;
                switch (item.getItemId()) {
                    case R.id.firstFragment:
                        selected = new FirstFragment();
                        break;
                    case R.id.secondFragment:
                        selected = new SecondFragment();
                        break;
                    case R.id.thirdFragment:
                        selected = new ThirdFragment();
                        break;
                    case R.id.fourthFragment:
                        selected = new FourthFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, selected).commit();
                return true;
            }
        });
    }
}
