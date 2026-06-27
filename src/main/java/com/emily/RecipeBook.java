package com.emily;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Collections;

public class RecipeBook {

    //all recipes
    ArrayList <Recipe> recipes = new ArrayList<>();
    
    //loads recipes from database into app
    public void loadRecipes() {
        String url = "jdbc:sqlite:recipes.db";

        try (            
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();    
        ) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM recipes");

            while (rs.next()) {

                int id = rs.getInt("ID");
                String name = rs.getString("name");
                int vegetarianInt = rs.getInt("vegetarian");

                boolean vegetarian = false;
                if (vegetarianInt == 1) {
                    vegetarian = true;
                }
              
                Recipe newRecipe = new Recipe(id, name, vegetarian);

                recipes.add(newRecipe);

            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printRecipes() {

        for (int i = 0; i < recipes.size(); i++) {
            System.out.println(recipes.get(i).getName() + " | " + recipes.get(i).getVegetarian());
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

    //adds new recipe to database only
    public void addRecipes(String newName, int newVegetarian) {
        String url = "jdbc:sqlite:recipes.db";

        try (            
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();    
        ) {

            String sql = "INSERT INTO recipes(name, vegetarian) VALUES (?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, newName);
            pstmt.setInt(2, newVegetarian);

            pstmt.executeUpdate(); 
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //deletes recipe from database only
    public void deleteRecipes(int deleteID) {
        String url = "jdbc:sqlite:recipes.db";

        try (            
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();    
        ) {

            String sql = "DELETE FROM recipes WHERE ID = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, deleteID);

            pstmt.executeUpdate(); 
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //upates recipe in database
    public void updateRecipes(String updateName, int updateVegetarian, int updateID) {
        String url = "jdbc:sqlite:recipes.db";

        try (            
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();    
        ) {

            String sql = "UPDATE recipes SET name = ?, vegetarian = ? WHERE ID = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, updateName);
            pstmt.setInt(2, updateVegetarian);
            pstmt.setInt(3, updateVegetarian);

            pstmt.executeUpdate(); 
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
