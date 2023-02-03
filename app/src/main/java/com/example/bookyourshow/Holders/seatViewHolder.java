package com.example.bookyourshow.Holders;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookyourshow.APIS.SeatClickListener;
import com.example.bookyourshow.Models.SeatBookingModel;
import com.example.bookyourshow.R;

public class seatViewHolder extends RecyclerView.ViewHolder {

    private SeatClickListener clickListener;
    private int countSeat = 1;
    private FragmentManager fragmentManager;
    private TextView tvSeatNumber;
    private Button btnPaymentMovie;

    public seatViewHolder(@NonNull View itemView) {
        super(itemView);
        tvSeatNumber = itemView.findViewById(R.id.tvSeatNumber);
    }

    public void setSeatNumber(SeatBookingModel seatNumber, SeatClickListener clickListener) {
        tvSeatNumber.setText(seatNumber.getSeatNumber() + "");

        tvSeatNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSeatNumber.setBackgroundColor(Color.parseColor("#EC5E71"));
                tvSeatNumber.setTextColor(Color.parseColor("#FFFFFF"));
            }
        });
    }
}
