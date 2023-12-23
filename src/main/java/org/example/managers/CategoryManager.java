package org.example.managers;

import org.example.db.DBConnection;
import org.example.models.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CategoryManager {
Connection connection = DBConnection.getInstance().getConnection();
    public void addCategory(Category category){
        String query = "INSERT INTO category(name) VALUES ('%s')";
        String sPL = String.format(query,category.getName());
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sPL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Category updateCategory(Category category, int id){
        String scl="SELECT * FROM category WHERE id =" + id;

        try {
           Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(scl);
            if (resultSet.next()){
                System.out.println("ka");
                Category category1 = new Category();
                return category1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
     return null;
    }


    public Category deleteCategory(int id){
        String sql = "SELECT * FROM category WHERE id =" + id;

        try {
           Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                System.out.println("կա նման id");
                String sql2 = "DELETE FROM category WHERE id =" + id;
                statement.executeUpdate(sql2);
                System.out.println(id + " id-ով պառամետրերը ջնջված են");
                Category category = new Category();
                return category;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }




}
