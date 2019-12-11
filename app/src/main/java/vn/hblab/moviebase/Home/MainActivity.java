package vn.hblab.moviebase.Home;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import vn.hblab.moviebase.Home.Trending.Trending_Fragments;
import vn.hblab.moviebase.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tranding_layout);
        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, Trending_Fragments.newInstance(this)).commit();

        bottomNavigation.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()){
                case R.id.action_home:{
                    Toast.makeText(MainActivity.this, "ActionHome", Toast.LENGTH_SHORT).show();

                }
                case R.id.action_disvover:{
                    Toast.makeText(MainActivity.this, "ActionDiscover", Toast.LENGTH_SHORT).show();

                }
                case R.id.action_calendar:{
                    Toast.makeText(MainActivity.this, "ActionCalendar", Toast.LENGTH_SHORT).show();

                }
                case R.id.action_user:{
                    Toast.makeText(MainActivity.this, "ActionUser", Toast.LENGTH_SHORT).show();

                }
            }
            return false;
        });
    }
}
