package com.example.bookyourshow.Models;

import com.example.bookyourshow.Models.EventsModel;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class ResponseModel implements Serializable {

    @SerializedName("Events")
    private List<EventsModel> events;

    public List<EventsModel> getEvents() {
        return events;
    }

}