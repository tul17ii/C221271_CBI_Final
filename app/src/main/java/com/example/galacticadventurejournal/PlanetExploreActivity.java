package com.example.galacticadventurejournal;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class PlanetExploreActivity extends AppCompatActivity {
    private ListView planetListView;

    private List<Planet> planetList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_explore);
        getSupportActionBar().hide();
        ListView planetListView = findViewById(R.id.planetListView);
        planetList = new ArrayList<>();
        initializePlanetData();
        PlanetAdapter adapter = new PlanetAdapter(this, planetList);
        planetListView.setAdapter(adapter);
    }


    private void initializePlanetData() {
        planetList.add(new Planet("Mercury", "The closest planet to the Sun", R.drawable.mercu));
         Log.d("PlanetExploreActivity", "Added Mercury");
        planetList.add(new Planet("Venus", "The hottest planet in the solar system", R.drawable.venu));
         Log.d("PlanetExploreActivity", "Added Venus");
        planetList.add(new Planet("Earth", "The only planet known to support life", R.drawable.earth));
        Log.d("PlanetExploreActivity", "Added Earth");
        planetList.add(new Planet("Mars", "Known as the Red Planet", R.drawable.mars));
        Log.d("PlanetExploreActivity", "Added Mars");
        planetList.add(new Planet("Jupiter", "The largest planet in our solar system", R.drawable.jupitar));
        Log.d("PlanetExploreActivity", "Added Jupiter");
        planetList.add(new Planet("Saturn", "Known for its beautiful rings", R.drawable.saturn));
        Log.d("PlanetExploreActivity", "Added Saturn");
        planetList.add(new Planet("Uranus", "The tilted planet", R.drawable.uranus));
        Log.d("PlanetExploreActivity", "Added uranus");
        planetList.add(new Planet("Neptune", "The farthest planet from the Sun", R.drawable.naptune));
        Log.d("PlanetExploreActivity", "Added Neptune");
    }
}
