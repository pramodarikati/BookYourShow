package com.example.bookyourshow.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookyourshow.Adapters.EventsAdapter;
import com.example.bookyourshow.APIS.EventClickListner;
import com.example.bookyourshow.Models.ResponseModel;
import com.example.bookyourshow.Models.EventsModel;
import com.example.bookyourshow.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SportActivity extends AppCompatActivity implements EventClickListner {

    private List<EventsModel> eventsModels = new ArrayList<>();
    private EventsAdapter adapter;
    private RecyclerView recyclerView;

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            readjson();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport);
        recyclerView = findViewById(R.id.recyclerViewSport);
        adapter = new EventsAdapter(eventsModels, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        startBackground();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    private void startBackground() {
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private void readjson() {
        try {
            InputStream inputStream = this.getAssets().open("sport.json");
            int data = inputStream.read();

            StringBuilder builder = new StringBuilder();

            while (data != -1) {
                char ch = (char) data;
                builder.append(ch);
                data = inputStream.read();
            }
            buildpojofromjson(builder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void buildpojofromjson(String json) {
        Type type = new TypeToken<ResponseModel>() {
        }.getType();
        ResponseModel responseModel = new Gson().fromJson(json, type);
        eventsModels = responseModel.getEvents();
        updateUi();
    }

    private void updateUi() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter.updateData(eventsModels);
            }
        });
    }

    @Override
    public void click(EventsModel model, int position) {
        String image = model.getImages();
        String name = model.getEventName();
        String watch = model.getWhereToWatch();
        String price = model.getPrice();


    }
}