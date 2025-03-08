package com.example.galacticadventurejournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class PlanetAdapter extends ArrayAdapter<Planet> {
    private Context context;
    private List<Planet> planetList;

    public PlanetAdapter(Context context, List<Planet> planetList) {
        super(context, 0, planetList);
        this.context = context;
        this.planetList = planetList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.planet_list_item, parent, false);
        }

        // Get the current planet
        Planet planet = planetList.get(position);

        // Set the name, fun fact, and image
        TextView planetName = convertView.findViewById(R.id.planetName);
        TextView planetFunFact = convertView.findViewById(R.id.planetFunFact);
        ImageView planetImage = convertView.findViewById(R.id.planetImage);

        planetName.setText(planet.getName());
        planetFunFact.setText(planet.getFunFact());
        planetImage.setImageResource(planet.getImageResourceId());

        return convertView;
    }
}
