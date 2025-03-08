package com.example.galacticadventurejournal;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class StarSpottingChallengeActivity extends AppCompatActivity {

    private ListView challengesListView;
    private List<StarSpottingChallenge> challenges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_spotting_challenge);

        challengesListView = findViewById(R.id.challengesListView);
        challenges = new ArrayList<>();
        populateChallenges(); // Populate the challenges list

        // Create a custom adapter to display the challenges
        StarSpottingChallengeAdapter adapter = new StarSpottingChallengeAdapter(this, challenges);
        challengesListView.setAdapter(adapter); // Set the adapter to the ListView
    }

    private void populateChallenges() {
        challenges.add(new StarSpottingChallenge("Orion", "Look for Orion tonight!", "7 PM - 10 PM"));
        challenges.add(new StarSpottingChallenge("Big Dipper", "Spot the Big Dipper!", "8 PM - 11 PM"));
        challenges.add(new StarSpottingChallenge("Cassiopeia", "Find the W-shaped constellation!", "9 PM - 12 AM"));
        challenges.add(new StarSpottingChallenge("Andromeda", "Try to spot the Andromeda galaxy!", "10 PM - 1 AM"));
        challenges.add(new StarSpottingChallenge("Sirius", "Locate the brightest star in the night sky.", "8 PM - 10 PM"));
        challenges.add(new StarSpottingChallenge("Pleiades", "Find the Seven Sisters star cluster.", "9 PM - 11 PM"));
        challenges.add(new StarSpottingChallenge("Scorpius", "Look for the scorpion shape in the sky.", "10 PM - 1 AM"));
        challenges.add(new StarSpottingChallenge("Hercules", "Spot the Hercules constellation.", "9 PM - 12 AM"));
        challenges.add(new StarSpottingChallenge("Leo", "Identify the Lion constellation.", "8 PM - 11 PM"));
        challenges.add(new StarSpottingChallenge("Virgo", "Look for the Maiden constellation.", "10 PM - 1 AM"));
    }
}
