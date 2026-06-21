package com.emily;


public class App {

    public static void main(String[] args) {

        RecipeBook recipeBook = new RecipeBook();

        recipeBook.loadRecipes();

        recipeBook.printRecipes();

        recipeBook.chooseRecipes();
        
    }
}
