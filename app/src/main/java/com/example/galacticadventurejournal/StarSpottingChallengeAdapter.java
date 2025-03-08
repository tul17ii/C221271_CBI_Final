package com.example.galacticadventurejournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class StarSpottingChallengeAdapter extends ArrayAdapter<StarSpottingChallenge> {
    public StarSpottingChallengeAdapter(Context context, List<StarSpottingChallenge> challenges) {
        super(context, 0, challenges);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        StarSpottingChallenge challenge = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
        }

        // Lookup view for data population
        TextView text1 = convertView.findViewById(android.R.id.text1);
        TextView text2 = convertView.findViewById(android.R.id.text2);

        // Populate the data into the template view using the data object
        text1.setText(challenge.getName());
        text2.setText(challenge.getDescription() + "\nBest Time: " + challenge.getBestTime());

        // Return the completed view to render on screen
        return convertView;
    }
}
