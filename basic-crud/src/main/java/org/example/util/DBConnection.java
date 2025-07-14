package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL ="jdbc:postgresql://localhost:5432/simple_university_db";
    private static final String USER ="postgres";
    private static final String PASSWORD = "3113";
    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("PostgreSQL JDBC driver not found", e);
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    public static void closeConnection(Connection connection){
        if(connection != null){
            try{
                connection.close();
            }
            catch(SQLException e){
                System.err.println("Error closing connection: "+ e.getMessage());
            }
        }
    }
}
