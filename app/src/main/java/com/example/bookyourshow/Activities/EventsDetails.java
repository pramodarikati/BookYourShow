package com.example.bookyourshow.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.bookyourshow.APIS.FragmentCommunication;
import com.example.bookyourshow.R;

public class EventsDetails extends AppCompatActivity {

    private Spinner spinner;
    private Button btnPayment;
    private TextView terms;
    private ImageView imageView;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_details);
        btnPayment = findViewById(R.id.update);
        terms  = findViewById(R.id.terms);
        imageView = findViewById(R.id.back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SelectSeat.class));
            }
        });
        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), TermsandConditionsActivity.class));
            }
        });

        btnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventsDetails.this, PaymentPage.class);
                startActivity(intent);
            }
        });


    }



}