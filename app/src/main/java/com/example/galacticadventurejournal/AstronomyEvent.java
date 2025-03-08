package com.example.galacticadventurejournal;

public class AstronomyEvent {
    private String eventName;
    private String eventDate;
    private String description;
    private int iconResource;

    public AstronomyEvent(String eventName, String eventDate, String description, int iconResource) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.description = description;
        this.iconResource = iconResource;
    }

    public String getEventName() { return eventName; }
    public String getEventDate() { return eventDate; }
    public String getDescription() { return description; }
    public int getIconResource() { return iconResource; }
}
