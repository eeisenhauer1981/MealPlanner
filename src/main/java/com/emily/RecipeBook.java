package com.emily;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class RecipeBook {

    //all recipes
    ArrayList <Recipe> recipes = new ArrayList<>();

    public void printRecipes() {

        for (int i = 0; i < recipes.size(); i++) {
            System.out.println(recipes.get(i).getName());
            System.out.println("Vegetarian: " + recipes.get(i).getVegetarian());
            System.out.println(recipes.get(i).getURL());
            System.out.println(recipes.get(i).getDirections());
        }
    }

    public void chooseRecipes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many recipes?");
        int numberRecipes = scanner.nextInt();
        scanner.nextLine();
        Collections.shuffle(recipes);
        for (int i = 0; i < numberRecipes; i++) {
            System.out.println(recipes.get(i).getName() + " | " + recipes.get(i).getVegetarian());
        }
        scanner.close();
    }

}
