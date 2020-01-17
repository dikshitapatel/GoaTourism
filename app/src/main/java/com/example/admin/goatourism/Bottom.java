package com.example.admin.goatourism;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

public class Bottom extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        Toast.makeText(Bottom.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_explore:
                        Toast.makeText(Bottom.this, "Explore", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_scan:
                        Toast.makeText(Bottom.this, "Scanner", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_feedback:
                        Toast.makeText(Bottom.this, "Feedback", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }
}