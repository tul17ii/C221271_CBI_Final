package com.example.galacticadventurejournal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.List;

public class CustomJourneyAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final List<String> journeys;
    private final UpdateJourneyListener updateListener;
    private final DeleteJourneyListener deleteListener;

    public interface UpdateJourneyListener {
        void onUpdateJourney(String oldJourney, String newJourney);
    }

    public interface DeleteJourneyListener {
        void onDeleteJourney(String journey);
    }

    public CustomJourneyAdapter(Context context, List<String> journeys,
                                UpdateJourneyListener updateListener,
                                DeleteJourneyListener deleteListener) {
        super(context, 0, journeys);
        this.context = context;
        this.journeys = journeys;
        this.updateListener = updateListener;
        this.deleteListener = deleteListener;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.journey_item, parent, false);
        }

        String journey = journeys.get(position);

        TextView journeyText = listItemView.findViewById(R.id.journeyText);
        journeyText.setText(journey);

        ImageButton menuButton = listItemView.findViewById(R.id.menuButton);
        menuButton.setOnClickListener(v -> showPopupMenu(v, journey));

        return listItemView;
    }

    @SuppressLint("NonConstantResourceId")
    private void showPopupMenu(View view, String journey) {
        PopupMenu popupMenu = new PopupMenu(context, view);
        popupMenu.getMenuInflater().inflate(R.menu.journey_item_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.menu_edit) {
                updateListener.onUpdateJourney(journey, "Updated Journey"); // Replace with dialog input
                return true;
            } else if (item.getItemId() == R.id.menu_delete) {
                deleteListener.onDeleteJourney(journey);
                return true;
            }
            return false;
        });

        popupMenu.show();
    }
}
