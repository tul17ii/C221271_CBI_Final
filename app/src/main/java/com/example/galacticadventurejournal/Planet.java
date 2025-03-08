package com.example.galacticadventurejournal;
public class Planet {
    private String name;
    private String funFact;
    private int imageResourceId;

    public Planet(String name, String funFact, int imageResourceId) {
        this.name = name;
        this.funFact = funFact;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getFunFact() {
        return funFact;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    // Setters (optional, if you want to modify these values later)
    public void setName(String name) {
        this.name = name;
    }

    public void setFunFact(String funFact) {
        this.funFact = funFact;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }
}

