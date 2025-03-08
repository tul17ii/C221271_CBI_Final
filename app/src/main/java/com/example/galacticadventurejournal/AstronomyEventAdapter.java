package com.example.galacticadventurejournal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AstronomyEventAdapter extends RecyclerView.Adapter<AstronomyEventAdapter.EventViewHolder> {

    // List to hold AstronomyEvent objects
    private List<AstronomyEvent> eventList;

    // Constructor for adapter, takes in the list of events
    public AstronomyEventAdapter(List<AstronomyEvent> eventList) {
        this.eventList = eventList;
    }

    // Inflates the item layout for each event
    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_astronomy_event, parent, false);
        return new EventViewHolder(view);
    }

    // Binds the data from the eventList to the ViewHolder
    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        AstronomyEvent event = eventList.get(position);
        holder.eventName.setText(event.getEventName());
        holder.eventDate.setText(event.getEventDate());
        holder.eventDescription.setText(event.getDescription());
        holder.eventIcon.setImageResource(event.getIconResource()); // Sets the icon for the event
    }

    // Returns the total count of items in the eventList
    @Override
    public int getItemCount() {
        return eventList.size();
    }

    // ViewHolder class to hold item views for each event
    static class EventViewHolder extends RecyclerView.ViewHolder {
        TextView eventName, eventDate, eventDescription;
        ImageView eventIcon;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            eventName = itemView.findViewById(R.id.eventName);
            eventDate = itemView.findViewById(R.id.eventDate);
            eventDescription = itemView.findViewById(R.id.eventDescription);
            eventIcon = itemView.findViewById(R.id.eventIcon);
        }
    }
}
