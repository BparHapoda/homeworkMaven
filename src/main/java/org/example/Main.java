package org.example;

import java.sql.*;
import java.util.Properties;

public class Main {
    static final String url = "jdbc:postgresql://localhost:5432/phonebook";

    public static void main(String[] args) {

        Connection connection = null;
        Properties properties = new Properties();
        properties.put("user", "postgres");
        properties.put("password", "12345");

        try {
            connection = DriverManager.getConnection(url, properties);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM abonents");
            while (rs.next()) {
                System.out.println(rs.getString(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}