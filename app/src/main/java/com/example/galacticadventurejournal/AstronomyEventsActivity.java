package com.example.galacticadventurejournal;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class AstronomyEventsActivity extends AppCompatActivity {
    private List<AstronomyEvent> eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_astronomy_events);
        getSupportActionBar().hide();

        RecyclerView eventRecyclerView = findViewById(R.id.eventRecyclerView);
        eventRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        eventList = new ArrayList<>();
        loadEventData();

        AstronomyEventAdapter adapter = new AstronomyEventAdapter(eventList);
        eventRecyclerView.setAdapter(adapter);
    }

    private void loadEventData() {
      eventList.add(new AstronomyEvent("Perseid Meteor Shower", "August 12-13", "Best visible in Northern Hemisphere", R.drawable.perseid));
     eventList.add(new AstronomyEvent("Partial Lunar Eclipse", "October 28", "Visible in most parts of Asia, Europe", R.drawable.luna));
        eventList.add(new AstronomyEvent("Orionid Meteor Shower", "October 21-22", "Produced by Halley's Comet, best seen in the early morning", R.drawable.orion));
       eventList.add(new AstronomyEvent("Total Solar Eclipse", "April 8", "Visible across parts of North America", R.drawable.tsolar));
        eventList.add(new AstronomyEvent("Annular Solar Eclipse", "October 14", "Visible across parts of South America and the United States", R.drawable.annul));
       eventList.add(new AstronomyEvent("Mars Opposition", "December 8", "Best time to observe Mars as it is closest to Earth", R.drawable.marsop));
       eventList.add(new AstronomyEvent("Jupiter Opposition", "September 26", "Greatest visibility of Jupiter, visible worldwide", R.drawable.jupi));
       eventList.add(new AstronomyEvent("Blue Moon", "August 31", "A rare second full moon in a calendar month, visible worldwide", R.drawable.blumoon));
    }
    }

