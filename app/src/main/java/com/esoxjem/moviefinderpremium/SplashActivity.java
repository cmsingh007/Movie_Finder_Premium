package com.esoxjem.moviefinderpremium;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.esoxjem.moviefinderpremium.listing.MoviesListingActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (isFirstRun){
            startActivity(new Intent(this, OnBorading.class));
            finish();
        }else {

            Thread myThread = new Thread() {
                @Override
                public void run() {
                    try {
                        sleep(2000);
                        Intent start = new Intent(getApplicationContext(), MoviesListingActivity.class);
                        startActivity(start);
                        finish();
                    } catch (Exception e) {
                    }
                }
            };
            myThread.start();
        }

        getSharedPreferences("PREFERENCE",MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).commit();
    }
}
