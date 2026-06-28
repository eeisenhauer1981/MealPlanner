package com.emily;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQL {

    //loads recipes from database into app
    public static void loadRecipes(RecipeBook recipeBook) {
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
                String URL = rs.getString("URL");
                String directions = rs.getString("directions");

                boolean vegetarian = false;
                if (vegetarianInt == 1) {
                    vegetarian = true;
                }
              
                Recipe newRecipe = new Recipe(id, name, vegetarian, URL, directions);

                recipeBook.recipes.add(newRecipe);

            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //adds new recipe to database
    public static void addRecipes(String newName, int newVegetarian) {
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

    //deletes recipe from database
    public static void deleteRecipes(int deleteID) {
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
    public static void updateRecipes(String updateName, int updateVegetarian, int updateID) {
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
