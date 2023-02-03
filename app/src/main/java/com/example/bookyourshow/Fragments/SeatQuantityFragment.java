package com.example.bookyourshow.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bookyourshow.Adapters.MovieDataHelper;
import com.example.bookyourshow.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class SeatQuantityFragment extends BottomSheetDialogFragment implements View.OnClickListener {

    int click = 0;
    int totalPrice = 220;
    private MovieDataHelper movieDataHelper;
    private TableLayout tableLayout;
    private ImageView ivVehicle;
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btnSeatQuantity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_seat_quantity, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);

    }

    private void initViews(View view) {

        btn1 = view.findViewById(R.id.seat1);
        btn2 = view.findViewById(R.id.seat2);
        btn3 = view.findViewById(R.id.seat3);
        btn4 = view.findViewById(R.id.seat4);
        btn5 = view.findViewById(R.id.seat5);
        btn6 = view.findViewById(R.id.seat6);

        btnSeatQuantity = view.findViewById(R.id.btnSelectSeat);
        ivVehicle = view.findViewById(R.id.ivVehicle);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);

        btnSeatQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.seat1:
                movieDataHelper = new MovieDataHelper("https://in.bmscdn.com/discovery-catalog/events/tr:w-400,h-600,bg-CCCCCC:w-400.0,h-660.0,cm-pad_resize,bg-000000,fo-top:oi-discovery-catalog@@icons@@heart_202006300400.png,ox-24,oy-617,ow-29:ote-NzklICAxNmsgdm90ZXM%3D,ots-29,otc-FFFFFF,oy-612,ox-70/et00117102-gukaentnqs-portrait.jpg", "Avatar", totalPrice + "", 1 + "", "05-09-2021");

                if (click % 2 == 0) {
                    ivVehicle.setImageResource(R.drawable.bicycle);
                    btn1.setBackgroundColor(Color.parseColor("#C62222"));
                    btn1.setTextColor(Color.parseColor("#FFFFFF"));
                } else {
                    btn1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    btn1.setTextColor(Color.parseColor("#FF000000"));
                }
                click++;
                break;
            case R.id.seat2:

                movieDataHelper = new MovieDataHelper("https://in.bmscdn.com/discovery-catalog/events/tr:w-400,h-600,bg-CCCCCC:w-400.0,h-660.0,cm-pad_resize,bg-000000,fo-top:oi-discovery-catalog@@icons@@heart_202006300400.png,ox-24,oy-617,ow-29:ote-NzklICAxNmsgdm90ZXM%3D,ots-29,otc-FFFFFF,oy-612,ox-70/et00117102-gukaentnqs-portrait.jpg", "Bell Bottom", totalPrice + "", 1 + "", "05-09-2021");

                if (click % 2 == 0) {
                    ivVehicle.setImageResource(R.drawable.motorcycle);
                    btn2.setBackgroundColor(Color.parseColor("#C62222"));
                    btn2.setTextColor(Color.parseColor("#FFFFFF"));
                } else {
                    btn2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    btn2.setTextColor(Color.parseColor("#FF000000"));
                }
                click++;
                break;
            case R.id.seat3:
                movieDataHelper = new MovieDataHelper("https://in.bmscdn.com/discovery-catalog/events/tr:w-400,h-600,bg-CCCCCC:w-400.0,h-660.0,cm-pad_resize,bg-000000,fo-top:oi-discovery-catalog@@icons@@heart_202006300400.png,ox-24,oy-617,ow-29:ote-NzklICAxNmsgdm90ZXM%3D,ots-29,otc-FFFFFF,oy-612,ox-70/et00117102-gukaentnqs-portrait.jpg", "Bell Bottom", totalPrice * 2 + "", 2 + "", "05-09-2021");

                if (click % 2 == 0) {
                    ivVehicle.setImageResource(R.drawable.rickshaw);
                    btn3.setBackgroundColor(Color.parseColor("#C62222"));
                    btn3.setTextColor(Color.parseColor("#FFFFFF"));
                } else {
                    btn3.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    btn3.setTextColor(Color.parseColor("#FF000000"));
                }
                click++;

                break;
            case R.id.seat4:

                movieDataHelper = new MovieDataHelper("https://in.bmscdn.com/discovery-catalog/events/tr:w-400,h-600,bg-CCCCCC:w-400.0,h-660.0,cm-pad_resize,bg-000000,fo-top:oi-discovery-catalog@@icons@@heart_202006300400.png,ox-24,oy-617,ow-29:ote-NzklICAxNmsgdm90ZXM%3D,ots-29,otc-FFFFFF,oy-612,ox-70/et00117102-gukaentnqs-portrait.jpg", "Bell Bottom", totalPrice * 4 + "", 4 + "", "05-09-2021");
                if (click % 2 == 0) {
                    ivVehicle.setImageResource(R.drawable.baby_car);
                    btn4.setBackgroundColor(Color.parseColor("#C62222"));
                    btn4.setTextColor(Color.parseColor("#FFFFFF"));
                } else {
                    btn4.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    btn4.setTextColor(Color.parseColor("#FF000000"));
                }
                click++;
                break;
            case R.id.seat5:
                movieDataHelper = new MovieDataHelper("https://in.bmscdn.com/discovery-catalog/events/tr:w-400,h-600,bg-CCCCCC:w-400.0,h-660.0,cm-pad_resize,bg-000000,fo-top:oi-discovery-catalog@@icons@@heart_202006300400.png,ox-24,oy-617,ow-29:ote-NzklICAxNmsgdm90ZXM%3D,ots-29,otc-FFFFFF,oy-612,ox-70/et00117102-gukaentnqs-portrait.jpg", "Bell Bottom", totalPrice * 5 + "", 5 + "", "05-09-2021");

                if (click % 2 == 0) {
                    ivVehicle.setImageResource(R.drawable.suv);
                    btn5.setBackgroundColor(Color.parseColor("#C62222"));
                    btn5.setTextColor(Color.parseColor("#FFFFFF"));
                } else {
                    btn5.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    btn5.setTextColor(Color.parseColor("#FF000000"));
                }
                click++;

                break;
            case R.id.seat6:

                movieDataHelper = new MovieDataHelper("https://in.bmscdn.com/discovery-catalog/events/tr:w-400,h-600,bg-CCCCCC:w-400.0,h-660.0,cm-pad_resize,bg-000000,fo-top:oi-discovery-catalog@@icons@@heart_202006300400.png,ox-24,oy-617,ow-29:ote-NzklICAxNmsgdm90ZXM%3D,ots-29,otc-FFFFFF,oy-612,ox-70/et00117102-gukaentnqs-portrait.jpg", "Bell Bottom", totalPrice * 6 + "", 6 + "", "05-09-2021");

                if (click % 2 == 0) {
                    ivVehicle.setImageResource(R.drawable.bus);
                    btn6.setBackgroundColor(Color.parseColor("#C62222"));
                    btn6.setTextColor(Color.parseColor("#FFFFFF"));
                } else {
                    btn6.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    btn6.setTextColor(Color.parseColor("#FF000000"));
                }
                click++;

                break;
        }
    }
}