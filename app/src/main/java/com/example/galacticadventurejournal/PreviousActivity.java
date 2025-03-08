package com.example.galacticadventurejournal;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PreviousActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer;
    private TextView spaceFactTextView;
    private Button goToLoginButton;
    private long lastUpdate = 0;
    private static final int SHAKE_THRESHOLD = 800;

    // List of space facts to display
    private final String[] spaceFacts = {
            "Did you know? The Milky Way galaxy is about 100,000 light-years in diameter!",
            "Space is completely silent, no sound can travel through a vacuum!",
            "A day on Venus is longer than a year on Venus!",
            "Jupiter has 79 known moons!",
            "The largest volcano in the solar system is on Mars, and it's called Olympus Mons!"
    };

    // To ensure a new fact shows only after a shake
    private boolean isShakeDetected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous);

        // Find the Galaxy ImageView
        ImageView galaxyImage = findViewById(R.id.galaxyImage);
        spaceFactTextView = findViewById(R.id.spaceFactTextView);

        // Load the animation for the galaxy
        Animation galaxyAnimation = AnimationUtils.loadAnimation(this, R.anim.galaxy_rotation);
        galaxyImage.startAnimation(galaxyAnimation);

        // Find the Button to navigate to LoginActivity
        goToLoginButton = findViewById(R.id.goToLoginButton);
        goToLoginButton.setOnClickListener(v -> {
            // Create an intent to start LoginActivity
            Intent intent = new Intent(PreviousActivity.this, LoginActivity.class);
            startActivity(intent); // Start the LoginActivity
        });

        // Initialize the sensor manager
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Register the sensor listener when the activity is resumed
        if (accelerometer != null) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_UI);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Unregister the sensor listener when the activity is paused
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            long currentTime = System.currentTimeMillis();
            if ((currentTime - lastUpdate) > 300) { // Add debounce logic
                long timeDifference = currentTime - lastUpdate;
                lastUpdate = currentTime;

                // Get the accelerometer data (x, y, z)
                float x = event.values[0];
                float y = event.values[1];
                float z = event.values[2];

                // Calculate the shake speed
                float speed = Math.abs(x + y + z) / timeDifference * 10000;

                // If the shake speed exceeds the threshold and no shake has been detected yet, trigger the fact display
                if (speed > SHAKE_THRESHOLD && !isShakeDetected) {
                    // Set shakeDetected flag to true to prevent multiple triggers
                    isShakeDetected = true;

                    // Display a new space fact
                    showNewSpaceFact();
                }
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Not used in this case
    }

    // Method to display a new random space fact
    private void showNewSpaceFact() {
        int randomIndex = (int) (Math.random() * spaceFacts.length);
        String newFact = spaceFacts[randomIndex];

        // Display the space fact in the TextView
        spaceFactTextView.setText(newFact);

        // Optional: Show a Toast message for extra feedback
        Toast.makeText(this, "Shake detected! New Space Fact!", Toast.LENGTH_SHORT).show();

        // Reset the shake flag after a short delay (to allow the user to shake again)
        spaceFactTextView.postDelayed(() -> isShakeDetected = false, 1000); // 3 second delay
    }
}
