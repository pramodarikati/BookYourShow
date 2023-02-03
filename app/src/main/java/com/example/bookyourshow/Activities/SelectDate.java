package com.example.bookyourshow.Activities;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.bookyourshow.R;


public class SelectDate extends AppCompatActivity {

    FragmentManager fragmentManager;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_date);
        frameLayout = findViewById(R.id.fragment_container_view_tag);
        launchDateTimeFrag();
    }

    private void launchDateTimeFrag() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        SelectDateTime selectDateTime = new SelectDateTime();
        fragmentTransaction.add(R.id.fragment_container_view_tag, selectDateTime, "selectDateTime").addToBackStack("addDate").commit();
    }

    public void launchSelectTicketFrag(Bundle bundle) {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        SelectTicketQuantity ticketQuantity = new SelectTicketQuantity();
        ticketQuantity.setArguments(bundle);
        fragmentTransaction.replace(R.id.fragment_container_view_tag, ticketQuantity, "ticketQuantity").addToBackStack("Quantity").commit();
    }


}