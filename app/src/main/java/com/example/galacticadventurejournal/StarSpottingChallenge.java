package com.example.galacticadventurejournal;

public class StarSpottingChallenge {
    private String name; // Name of the constellation
    private String description; // Description of the challenge
    private String bestTime; // When to look for it
    private boolean isCompleted; // Track if the user completed the challenge

    // Constructor
    public StarSpottingChallenge(String name, String description, String bestTime) {
        this.name = name;
        this.description = description;
        this.bestTime = bestTime;
        this.isCompleted = false; // Default to not completed
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getBestTime() {
        return bestTime;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    // Setter to update completion status
    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
