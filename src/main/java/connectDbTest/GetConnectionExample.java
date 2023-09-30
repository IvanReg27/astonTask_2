package connectDbTest;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class GetConnectionExample {

    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();
        InputStream inStream = new FileInputStream(new File("src\\main\\resources\\db.properties"));
        properties.load(inStream);

        String DB_USERNAME="db.jdbcUsername";
        String DB_PASSWORD="db.jdbcPassword";
        String DB_URL ="db.jdbcURL";
        try {
            Connection connection = DriverManager.getConnection(properties.getProperty(DB_URL),properties.getProperty(DB_USERNAME),properties.getProperty(DB_PASSWORD));
            if (connection != null) {
                System.out.println("Connected to the database successfully!");
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}