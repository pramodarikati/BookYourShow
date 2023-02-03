package com.example.bookyourshow.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookyourshow.Holders.seatViewHolder;
import com.example.bookyourshow.APIS.SeatClickListener;
import com.example.bookyourshow.Models.SeatBookingModel;
import com.example.bookyourshow.R;

import java.util.List;

public class SeatBookingAdapter extends RecyclerView.Adapter<seatViewHolder> {

    private List<SeatBookingModel> seatBookingModelList;
    private SeatClickListener clickListener;

    public SeatBookingAdapter(List<SeatBookingModel> seatBookingModelList, SeatClickListener clickListener) {
        this.seatBookingModelList = seatBookingModelList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public seatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.availble_seat_layout, parent, false);
        return new seatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull seatViewHolder holder, int position) {
        SeatBookingModel seatBookingModel = seatBookingModelList.get(position);
        holder.setSeatNumber(seatBookingModel, clickListener);
    }

    @Override
    public int getItemCount() {
        return seatBookingModelList.size();
    }
}

