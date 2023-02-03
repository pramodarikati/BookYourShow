package com.example.bookyourshow.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

import com.example.bookyourshow.R;

public class MainActivity extends AppCompatActivity {

    private ProgressBar loadingPB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadingPB = findViewById(R.id.idPBLoading);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingPB.setVisibility(View.VISIBLE);
                Intent splashIntent = new Intent(MainActivity.this, LoginScreen.class);
                startActivity(splashIntent);
                finish();
            }
        }, 3000);
    }

}