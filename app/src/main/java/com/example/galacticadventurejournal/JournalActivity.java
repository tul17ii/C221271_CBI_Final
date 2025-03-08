package com.example.galacticadventurejournal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class JournalActivity extends AppCompatActivity {

    private EditText journeyTitle;
    private EditText journeyDescription;
    private SharedPreferences sharedPreferences;
    private Set<String> journeySet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);

        journeyTitle = findViewById(R.id.journeyTitle);
        journeyDescription = findViewById(R.id.journeyDescription);
        Button saveJournalButton = findViewById(R.id.saveJournalButton);
        Button viewSavedJourneysButton = findViewById(R.id.showJourneysButton);

        sharedPreferences = getSharedPreferences("JourneysPrefs", Context.MODE_PRIVATE);
        journeySet = sharedPreferences.getStringSet("journeys", new HashSet<>());

        saveJournalButton.setOnClickListener(v -> saveJourney());
        viewSavedJourneysButton.setOnClickListener(v -> {
            Intent intent = new Intent(JournalActivity.this, JourneysListActivity.class);
            startActivity(intent);
        });
    }

    private void saveJourney() {
        String title = journeyTitle.getText().toString().trim();
        String description = journeyDescription.getText().toString().trim();

        if (title.isEmpty() || description.isEmpty()) {
            Toast.makeText(this, "Both fields are required!", Toast.LENGTH_SHORT).show();
            return;
        }

        String journey = title + "\n" + description;
        journeySet.add(journey);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putStringSet("journeys", journeySet);
        editor.apply();

        Toast.makeText(this, "Journey saved!", Toast.LENGTH_SHORT).show();
        journeyTitle.setText("");
        journeyDescription.setText("");
    }
}
