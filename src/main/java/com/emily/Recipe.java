package com.emily;

public class Recipe {
    
    private int ID;
    private String name;
    private boolean vegetarian;
    
    public Recipe (int newID, String newname, boolean newvegetarian) {
        this.ID = newID;
        this.name = newname;
        this.vegetarian = newvegetarian;
    }

    public String getName() {
        return name;
    }

    public boolean getVegetarian() {
        return vegetarian;
    }

}
