package com.example.java_sql_connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnectionTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/limit_rules";
        String user = "root";
        String password = "1710";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            if (connection != null) {
                System.out.println("✅ Database connection successful!");
            }
        } catch (SQLException e) {
            System.err.println("❌ Failed to connect: " + e.getMessage());
        }
    }
}
