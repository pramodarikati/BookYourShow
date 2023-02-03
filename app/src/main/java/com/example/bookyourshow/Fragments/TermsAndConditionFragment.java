package com.example.bookyourshow.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bookyourshow.Activities.SelectSeat;
import com.example.bookyourshow.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class TermsAndConditionFragment extends BottomSheetDialogFragment {

    private Button btnAcceptTerms,btncancel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_terms_and_condition, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setStyle(STYLE_NORMAL, R.style.bottomSheetCorner);

        btnAcceptTerms = view.findViewById(R.id.btnAcceptTerms);
        btncancel = view.findViewById(R.id.btncancel);

        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        btnAcceptTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SelectSeat.class);
                startActivity(intent);

            }
        });
    }
}