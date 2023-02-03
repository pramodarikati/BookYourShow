package com.example.bookyourshow.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookyourshow.Adapters.SliderAdapter;
import com.example.bookyourshow.R;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class MoviesActivity extends AppCompatActivity implements View.OnClickListener, MovieClickListener {

    private Button btnEnglish, btnHindi, btnTelugu, btnJapanese, btnPunjabi;
    private RecyclerView recyclerView;
    private List<MoviesModel> moviesModelList = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    SliderView sliderView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        initViews();
        buildMoviesData();
        setRecyclerView();

        list.add(R.drawable.banner8);
        list.add(R.drawable.banner9);
        list.add(R.drawable.banner10);

        setImges();


    }



    private void initViews() {
        sliderView = findViewById(R.id.image_slider);

        recyclerView = findViewById(R.id.recyclerView);
        btnEnglish = findViewById(R.id.btnEnglish);
        btnHindi = findViewById(R.id.btnHindi);
        btnPunjabi = findViewById(R.id.btnPunjabi);
        btnJapanese = findViewById(R.id.btnJapanese);
        btnTelugu = findViewById(R.id.btnTelugu);


        btnTelugu.setOnClickListener(this);
        btnEnglish.setOnClickListener(this);
        btnHindi.setOnClickListener(this);
        btnJapanese.setOnClickListener(this);
        btnPunjabi.setOnClickListener(this);

    }

    private void setImges() {
        SliderAdapter adapter = new SliderAdapter(list);
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();
    }

    private void buildMoviesData() {
        moviesModelList.add(new MoviesModel("Avatar", "English", R.drawable.avatar));
        moviesModelList.add(new MoviesModel("Pataan", "Hindi", R.drawable.pataan));
        moviesModelList.add(new MoviesModel("Vikram", "Telugu, Tamil", R.drawable.vikram));
        moviesModelList.add(new MoviesModel("Beast", "Telugu, Tamil", R.drawable.beast));
        moviesModelList.add(new MoviesModel("sarkaru vaari pata", "Telugu", R.drawable.sarkar));
        moviesModelList.add(new MoviesModel("Kabir Singh", "Hindi", R.drawable.kabirsingh));
        moviesModelList.add(new MoviesModel("HIT", "Telugu", R.drawable.hit));
        moviesModelList.add(new MoviesModel("HIT The First Case", "Telugu", R.drawable.ps1));
//        moviesModelList.add(new MoviesModel("KGF", "Telugu, Hindi", R.drawable.kgf));
//        moviesModelList.add(new MoviesModel("Reminiscence", "Telugu, Hindi, English", R.drawable.reminiscence));
//        moviesModelList.add(new MoviesModel("The Suicide Squad", "Hindi, English", R.drawable.the_suicide));
//        moviesModelList.add(new MoviesModel("Cheruvaina Dooramaina", "Telugu", R.drawable.cheruvaina_dooramaina));
//        moviesModelList.add(new MoviesModel("The Green Knight", "English", R.drawable.green));
//        moviesModelList.add(new MoviesModel("Sridevi Soda Center", "English, Telugu,", R.drawable.sridevi_soda));
//        moviesModelList.add(new MoviesModel("Ichata Vahanamulu Nilupa Radu", "Telugu", R.drawable.nupa_radui));
//        moviesModelList.add(new MoviesModel("Raja Raja Chora", "Telugu", R.drawable.raja_raja_chora));
//        moviesModelList.add(new MoviesModel("House Arrest", "Telugu", R.drawable.arrest));
//        moviesModelList.add(new MoviesModel("Paagal", "Telugu", R.drawable.house));
//        moviesModelList.add(new MoviesModel("KGF", "Telugu, Hindi", R.drawable.kgf));
//        moviesModelList.add(new MoviesModel("Reminiscence", "Telugu, Hindi, English", R.drawable.reminiscence));
    }

    private void setRecyclerView() {
        MovieAdapter movieAdapter = new MovieAdapter(moviesModelList, this);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setAdapter(movieAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnEnglish:
                btnEnglish.setBackgroundColor(ContextCompat.getColor(btnEnglish.getContext(), R.color.light_red));
                btnEnglish.setTextColor(Color.parseColor("#FFFFFF"));
                break;
            case R.id.btnHindi:
                btnHindi.setBackgroundColor(ContextCompat.getColor(btnHindi.getContext(), R.color.light_red));
                btnHindi.setTextColor(Color.parseColor("#FFFFFF"));

                break;
            case R.id.btnPunjabi:
                btnPunjabi.setBackgroundColor(ContextCompat.getColor(btnPunjabi.getContext(), R.color.light_red));
                btnPunjabi.setTextColor(Color.parseColor("#FFFFFF"));

                break;
            case R.id.btnJapanese:
                btnJapanese.setBackgroundColor(ContextCompat.getColor(btnJapanese.getContext(), R.color.light_red));
                btnJapanese.setTextColor(Color.parseColor("#FFFFFF"));

                break;
            case R.id.btnTelugu:
                btnTelugu.setBackgroundColor(ContextCompat.getColor(btnTelugu.getContext(), R.color.light_red));
                btnTelugu.setTextColor(Color.parseColor("#FFFFFF"));
                break;
        }
    }

    @Override
    public void onItemClick(MoviesModel moviesModel, int position) {

        if (position == 0||position==1||position==2||position==3||position==5||position==6||position==7) {
            Intent intent = new Intent(MoviesActivity.this, BookMovieTicket.class);
            startActivity(intent);
        } else {
            //Toast.makeText(Movies.this, "Item Clicked" + position, Toast.LENGTH_SHORT).show();
        }
    }

    public void back(View view) {
        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
    }
}