package com.example.bookyourshow.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.bookyourshow.Fragments.TermsAndConditionFragment;
import com.example.bookyourshow.R;

import java.util.ArrayList;
import java.util.List;

public class SelectTimeLocation extends AppCompatActivity implements ClickListener {

    private List<TheaterLocationModel> theaterTimeModels = new ArrayList<>();
    private RecyclerView recyclerView;
    private int mYear, mMonth, mDay;
    private Button btnDate, btnProceed;
    private CardView recyclerViewCard;
    private LinearLayout ll1,ll2,ll3,ll4,ll5,ll6,ll7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_time_location);

        recyclerView = findViewById(R.id.timeTheaterRecyclerView);
        recyclerViewCard = findViewById(R.id.recyclerViewCard);

        ll1 = findViewById(R.id.ll1);
        ll2 = findViewById(R.id.ll2);
        ll3 = findViewById(R.id.ll3);
        ll4 = findViewById(R.id.ll4);
        ll5 = findViewById(R.id.ll5);
        ll6 = findViewById(R.id.ll6);
        ll7 = findViewById(R.id.ll7);

        ll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll1.setBackgroundColor(ContextCompat.getColor(ll1.getContext(), R.color.light_red));
            }
        });

        ll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll2.setBackgroundColor(ContextCompat.getColor(ll1.getContext(), R.color.light_red));
            }
        });

        ll3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll1.setBackgroundColor(ContextCompat.getColor(ll1.getContext(), R.color.light_red));
            }
        });

        ll4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll1.setBackgroundColor(ContextCompat.getColor(ll1.getContext(), R.color.light_red));
            }
        });

        ll5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll1.setBackgroundColor(ContextCompat.getColor(ll1.getContext(), R.color.light_red));
            }
        });

        ll6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll1.setBackgroundColor(ContextCompat.getColor(ll1.getContext(), R.color.light_red));
            }
        });
        ll7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll1.setBackgroundColor(ContextCompat.getColor(ll1.getContext(), R.color.light_red));
            }
        });



        buildTimeLocationData();
        setRecyclerView();
    }

    private void buildTimeLocationData() {
        theaterTimeModels.add(new TheaterLocationModel("01:05 PM", "04:15 PM", "Prasads: Hyderabad"));
        theaterTimeModels.add(new TheaterLocationModel("02:45 PM", "05:30 PM", "Miraj Cinemas: Shalini Shivani, Hyderabad"));
        theaterTimeModels.add(new TheaterLocationModel("12:05 PM", "03:15 PM", "PVR: Irrum Manzil, Hyderabad"));
        theaterTimeModels.add(new TheaterLocationModel("03:05 PM", "06:15 PM", "PVR Forum Sujana Mall: Kukatpally, Hyderabad"));
        theaterTimeModels.add(new TheaterLocationModel("02:45 PM", "03:00 PM", "PVR: Next Galleria Mall, Panjagutta"));
        theaterTimeModels.add(new TheaterLocationModel("01:30 PM", "04:00 PM", "INOX: Maheshwari"));
        theaterTimeModels.add(new TheaterLocationModel("09:05 PM", "11:15 PM", "Platinum Movietime: Gachibowli"));
        theaterTimeModels.add(new TheaterLocationModel("04:05 PM", "06:15 PM", "Cinepolis: Sudha Cinemas, Hyderabad"));
        theaterTimeModels.add(new TheaterLocationModel("03:05 PM", "05:00 PM", "AMB Cinemas: Gachibowli"));
        theaterTimeModels.add(new TheaterLocationModel("11:05 AM", "01:15 PM", "Asian Cineplanet Multiplex: Kompally"));
        theaterTimeModels.add(new TheaterLocationModel("07:05 PM", "10:15 PM", "Carnival: Ameerpet"));

    }

    private void setRecyclerView() {
        TheaterAdapter theaterAdapter = new TheaterAdapter(theaterTimeModels, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(theaterAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onItemClick(TheaterLocationModel locationModel) {

        TermsAndConditionFragment termsAndConditionFragment = new TermsAndConditionFragment();
        termsAndConditionFragment.show(getSupportFragmentManager(), "TermsAndCondition");

    }
}

