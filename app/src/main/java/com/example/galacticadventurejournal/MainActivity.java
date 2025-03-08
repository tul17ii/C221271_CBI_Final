 package com.example.galacticadventurejournal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hide the action bar for a cleaner look
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // Journal button click listener
        findViewById(R.id.saveJournalButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to navigate to JournalActivity
                Intent intent = new Intent(MainActivity.this, JournalActivity.class);
                startActivity(intent);
            }
        });

        // Explore button click listener
        findViewById(R.id.exploreButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to navigate to PlanetExploreActivity
                Intent intent = new Intent(MainActivity.this, PlanetExploreActivity.class);
                startActivity(intent);
            }
        });

        // Events button click listener
        findViewById(R.id.eventButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to navigate to AstronomyEventsActivity
                Intent intent = new Intent(MainActivity.this, AstronomyEventsActivity.class);
                startActivity(intent);
            }
        });

        // Share button click listener
        findViewById(R.id.shareButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Share adventure content
                String content = "Check out my latest adventure in the Galactic Adventure Journal!";
                shareContent(content);
            }
        });

        // Challenges button click listener
        findViewById(R.id.challengesButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to navigate to StarSpottingChallengeActivity
                Intent intent = new Intent(MainActivity.this, StarSpottingChallengeActivity.class);
                startActivity(intent);
            }
        });
    }

    // Method to handle sharing content
    private void shareContent(String content) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, content);

        // Show share options
        startActivity(Intent.createChooser(shareIntent, "Share via"));
    }
}