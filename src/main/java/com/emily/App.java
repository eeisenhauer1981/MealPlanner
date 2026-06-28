package com.emily;


public class App {

    public static void main(String[] args) {

        RecipeBook recipeBook = new RecipeBook();
        
        SQL.loadRecipes(recipeBook);

        recipeBook.printRecipes();
    
    }
}
