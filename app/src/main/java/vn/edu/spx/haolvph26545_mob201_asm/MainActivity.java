package vn.edu.spx.haolvph26545_mob201_asm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentTransaction;



public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        MenuFragment menuFragment = new MenuFragment();
        BaoFragment readFragment = new BaoFragment();
        NhacFragment musicFragment = new NhacFragment();
        UserFragment userFragment = new UserFragment();

        fragmentManager.beginTransaction().add(R.id.container_frag,menuFragment).commit();

        BottomNavigationView bottomNavigationView;
        bottomNavigationView = findViewById(R.id.bottom_nav_bar);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_Menu:
                        replaceFragment(menuFragment.newInstance());
                        break;
                    case R.id.nav_read:
                        replaceFragment(BaoFragment.newInstance());
                        break;
                    case R.id.nav_music:
                        replaceFragment(NhacFragment.newInstance());
                        break;
                    case R.id.nav_user:
                        replaceFragment(userFragment.newInstance());
                        break;
                    default:
                        replaceFragment(menuFragment.newInstance());
                        break;
                }

                return true;
            }
        });

    }
    public void replaceFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container_frag,fragment);
        transaction.commit();
    }







}
