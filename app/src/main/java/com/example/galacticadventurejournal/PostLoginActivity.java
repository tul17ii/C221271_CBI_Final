package com.example.galacticadventurejournal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class PostLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_login);

        // Initialize the "Click Here" button
        Button clickHereButton = findViewById(R.id.clickHereButton);

        // Set up a click listener to navigate to MainActivity
        clickHereButton.setOnClickListener(v -> {
            Intent intent = new Intent(PostLoginActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}

