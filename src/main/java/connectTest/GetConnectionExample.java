package connectTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnectionExample {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/demo?useSSL=false";
        String user = "root";
        String password = "xxx";

        try {
            // Attempt to establish a connection to the specified database
            Connection connection = DriverManager.getConnection(url, user, password);
            // Check if the connection is successfully established
            if (connection != null) {
                System.out.println("Connected to the database successfully!");
            }
            // Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}