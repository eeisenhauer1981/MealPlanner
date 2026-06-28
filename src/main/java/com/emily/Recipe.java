package com.emily;

public class Recipe {
    
    private int ID;
    private String name;
    private boolean vegetarian;
    private String URL;
    private String directions;
    
    public Recipe (int newID, String newName, boolean newVegetarian, String newURL, String newDirections) {
        this.ID = newID;
        this.name = newName;
        this.vegetarian = newVegetarian;
        this.URL = newURL;
        this.directions = newDirections;
    }

    public String getName() {
        return name;
    }

    public boolean getVegetarian() {
        return vegetarian;
    }

    public String getURL() {
        return URL;
    }

    public String getDirections() {
        return directions;
    }

}
