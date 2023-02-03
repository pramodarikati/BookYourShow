package com.example.bookyourshow.Fragments;

import static com.facebook.FacebookSdk.getApplicationContext;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bookyourshow.Adapters.ImageSliderAdapter;
import com.example.bookyourshow.Activities.AdressLocationActivity;
import com.example.bookyourshow.Activities.MoviesActivity;
import com.example.bookyourshow.Adapters.SliderAdapter;
import com.example.bookyourshow.Models.imageSliderItem;
import com.example.bookyourshow.R;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    SliderView sliderView, sliderView1;
    LinearLayout linearLayout;
    private TextView seeAllStreaming, seeAllOutdoorEvent, seeAllPopular, seeAllLaughter, seeAllSport, hLocation;
    private ImageView ivMovies;
    private ArrayList<Integer> list = new ArrayList<>();
    private ArrayList<imageSliderItem> items = new ArrayList<>();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);

        hLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double latitude = 13.6380416;
                double longitude = 79.4329088;

                AdressLocationActivity locationAddress = new AdressLocationActivity();
                locationAddress.getAddressFromLocation(latitude, longitude,
                        getApplicationContext(), new GeocoderHandler());

            }
        });

        ivMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MoviesActivity.class);
                startActivity(intent);
            }
        });

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MoviesActivity.class);
                startActivity(intent);
            }
        });



        list.add(R.drawable.banner1);
        list.add(R.drawable.banner2);
        list.add(R.drawable.banner3);
        list.add(R.drawable.banner4);

        setImges();

        setDataForSecondSlider();

        setSliderForSecond();

    }

    private void initViews(View view) {
        sliderView = view.findViewById(R.id.image_slider);
        sliderView1 = view.findViewById(R.id.image_slider_two);
        seeAllSport = view.findViewById(R.id.txtSeeAllSport);
        seeAllOutdoorEvent = view.findViewById(R.id.txtSeeAllOutdoor);
        seeAllPopular = view.findViewById(R.id.txtSeeAllPopular);
        seeAllLaughter = view.findViewById(R.id.txtSeeAllLaughter);
        linearLayout = view.findViewById(R.id.layoutFrontRow);
        ivMovies = view.findViewById(R.id.ivMovie);
        hLocation = view.findViewById(R.id.tvLocation);
    }

    private void setSliderForSecond() {
        ImageSliderAdapter sliderAdapter = new ImageSliderAdapter(items);
        sliderView1.setSliderAdapter(sliderAdapter);
        sliderView1.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView1.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView1.startAutoCycle();
    }

    private void setDataForSecondSlider() {
        items.add(new imageSliderItem(R.drawable.blackadams, "Black Adam", "2h 5m,Action, Fantasy UA", "English, Hindi, Tamil, Telugu", "A slave-turned-god,Teth-Adam (Dwayne Johnson) breaks free of...."));
        items.add(new imageSliderItem(R.drawable.newyeareve, "New Year's Eve", "1h 57m, Comedy, Romantic ,13+", "English", "Set in New York, New Year's Eve celebrates love, hope, second chance..."));
        items.add(new imageSliderItem(R.drawable.detection, "Detection of DI -Renji", "1h 33m, Action, Mystery, Thriller 13+", "Hindi, Mandarian, Tamil, Telugu", "In Empress Wu's reign, several bizarre deaths happen in Chang'an. Di R... "));
        items.add(new imageSliderItem(R.drawable.ontheedge, "On the Edge", "1h 40m, Drama 18+", "English, French", "A naive family man signs \nup for a session with the \nmysterious and alluring..."));
        items.add(new imageSliderItem(R.drawable.tumi, "Tumi O Tumi", "2h 2m, Drama,U", "Bengali", "This empowering and \ntouching social drama \nbrings to life the daily str..."));
        items.add(new imageSliderItem(R.drawable.nightmare, "Nightmare\nNeighborhood", "1h 26m, Drama,Thriller U", " English", "Two ambitious and,\ncompetative women take \n their rivalry a step further..."));
        items.add(new imageSliderItem(R.drawable.padachonte, "Padachonte Kadhakal", "1h 38m, Drama,13+", "Malayalam", "This Malayalam anthologty \nbrings to life four stories \nthat explore humanity's r..."));
        items.add(new imageSliderItem(R.drawable.bodies, "Bodies Bodies Bodies", "1h 35m, Horror,Thriller A", "English", "A group of rich friends \nfind their party in a romote \nmansion taking a horrifying..."));
    }

    private void setImges() {
        SliderAdapter adapter = new SliderAdapter(list);
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    public void showSettingsAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                getContext());
        alertDialog.setTitle("SETTINGS");
        alertDialog.setMessage("Enable Location Provider! Go to settings menu?");
        alertDialog.setPositiveButton("Settings",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(
                                Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        getContext().startActivity(intent);
                    }
                });
        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        alertDialog.show();
    }

    private class GeocoderHandler extends Handler {
        @Override
        public void handleMessage(Message message) {
            String locationAddress;
            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    locationAddress = bundle.getString("address");
                    break;
                default:
                    locationAddress = null;
            }
            hLocation.setText(locationAddress);
        }
    }

}