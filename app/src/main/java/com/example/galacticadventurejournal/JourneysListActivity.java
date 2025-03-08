package com.example.galacticadventurejournal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JourneysListActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private CustomJourneyAdapter adapter;
    private List<String> journeyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journeys_list);

        ListView journeysListView = findViewById(R.id.journeysListView);

        sharedPreferences = getSharedPreferences("JourneysPrefs", Context.MODE_PRIVATE);
        Set<String> journeySet = sharedPreferences.getStringSet("journeys", new HashSet<>());
        journeyList = new ArrayList<>(journeySet);

        adapter = new CustomJourneyAdapter(
                this,
                journeyList,
                this::updateJourney,
                this::deleteJourney
        );

        journeysListView.setAdapter(adapter);
    }

    private void updateJourney(String oldJourney, String newJourney) {
        int index = journeyList.indexOf(oldJourney);
        if (index != -1) {
            journeyList.set(index, newJourney);
            saveJourneys();
            adapter.notifyDataSetChanged();
        }
    }

    private void deleteJourney(String journey) {
        journeyList.remove(journey);
        saveJourneys();
        adapter.notifyDataSetChanged();
    }

    private void saveJourneys() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putStringSet("journeys", new HashSet<>(journeyList));
        editor.apply();
    }
}
