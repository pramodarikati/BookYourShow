package com.example.bookyourshow.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bookyourshow.Activities.LoginScreen;
import com.example.bookyourshow.Activities.UserDetailsActivity;
import com.example.bookyourshow.R;

public class ProfileFragment extends Fragment {

    private View profileViewBar, pPurchaseHistoryBar;
    private ImageView profileTopImage;
    private TextView share;
    private Button login;

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    private void initViews(View view) {
        share = view.findViewById(R.id.tvShare);
        profileViewBar = view.findViewById(R.id.vTopBarProfile);
        pPurchaseHistoryBar = view.findViewById(R.id.purchaseHistoryBar);
        profileTopImage = view.findViewById(R.id.ivProfileTopImage);
        login = view.findViewById(R.id.button2);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");
                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);

            }
        });

        profileTopImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), UserDetailsActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), LoginScreen.class);
                startActivity(intent);
            }
        });

        pPurchaseHistoryBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getContext(), LoginScreen.class);
                startActivity(intent1);
            }
        });
    }


}