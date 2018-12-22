package com.example.estephens.r6matchhistory;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;



public class mainActivity extends AppCompatActivity {

    MenuItem filter;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.new_match:
                    fragment = new MatchHistoryFragment();
                    loadFragment(fragment);
                    //filter.setVisible(false);
                    return true;
                case R.id.match_history:
                    fragment = new NewMatchFragment();
                    loadFragment(fragment);
                    //filter.setVisible(true);
                    return true;
            }
            return false;
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Fragment fragment;
        switch (item.getItemId()) {
            case R.id.top_match_history:
                fragment = new NewMatchFragment();
                loadFragment(fragment);
                filter.setVisible(true);
                return true;
            case R.id.top_new_match:
                fragment = new MatchHistoryFragment();
                loadFragment(fragment);
                filter.setVisible(false);
            case R.id.filter:

                return true;
            default:
                return false;
        }
    }

    private boolean loadFragment(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_view, fragment).commit();
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_navigation, menu);
        filter = findViewById(R.id.filter);
        return true;
    }

}
