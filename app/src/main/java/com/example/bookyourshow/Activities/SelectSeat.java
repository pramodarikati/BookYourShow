package com.example.bookyourshow.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookyourshow.Adapters.SeatBookingAdapter;
import com.example.bookyourshow.Fragments.SeatQuantityFragment;
import com.example.bookyourshow.Models.SeatBookingModel;
import com.example.bookyourshow.APIS.SeatClickListener;
import com.example.bookyourshow.R;

import java.util.ArrayList;
import java.util.List;

public class SelectSeat extends AppCompatActivity implements SeatClickListener {
    private RecyclerView recyclerView, normalRecyclerView;

    private List<SeatBookingModel> seatBookingModels = new ArrayList<>();
    private List<SeatBookingModel> seatBookingModelList = new ArrayList<>();
    private SeatClickListener clickListener;
    private Button btnPaymentMovie;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_seat);

        SeatQuantityFragment quantityFragment = new SeatQuantityFragment();
        quantityFragment.show(getSupportFragmentManager(), "SelectSeat");

        recyclerView = findViewById(R.id.seatRecyclerView);
        btnPaymentMovie = findViewById(R.id.btnMoviePayment);
        normalRecyclerView = findViewById(R.id.seatNormalRecyclerView);

        btnPaymentMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectSeat.this, EventsDetails.class);
                startActivity(intent);
            }
        });

        buildData();
        buildNormalSeatData();
        setRecyclerView();
        setNormalRecyclerView();

    }

    private void buildData() {

        for (int i = 1; i <= 130; i++) {
            seatBookingModels.add(new SeatBookingModel(i + ""));
        }
    }

    private void buildNormalSeatData() {

        for (int i = 1; i <= 100; i++) {
            seatBookingModelList.add(new SeatBookingModel(i + ""));
        }
    }

    private void setRecyclerView() {
        SeatBookingAdapter seatBookingAdapter = new SeatBookingAdapter(seatBookingModels, clickListener);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 10, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(seatBookingAdapter);
    }

    private void setNormalRecyclerView() {
        SeatBookingAdapter seatBookingAdapter = new SeatBookingAdapter(seatBookingModelList, clickListener);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 10, RecyclerView.VERTICAL, false);
        normalRecyclerView.setLayoutManager(layoutManager);
        normalRecyclerView.setAdapter(seatBookingAdapter);
    }

    @Override
    public void OnItemClick(SeatBookingModel bookingModel, int position) {
    }
}