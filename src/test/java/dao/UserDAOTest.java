package dao;

import model.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
public class UserDAOTest {

    @Container
    private static final MySQLContainer<?> mysqlContainer = new MySQLContainer<>("mysql:8.0.26")
            .withUsername("test")
            .withPassword("test")
            .withDatabaseName("test");

    private static Connection connection;

    @BeforeAll
    static void setup() throws SQLException {
        connection = DriverManager.getConnection(
                mysqlContainer.getJdbcUrl(),
                mysqlContainer.getUsername(),
                mysqlContainer.getPassword()
        );
        try (Statement statement = connection.createStatement()) {
            String createTableSQL = "CREATE TABLE users (\n"
                    + "id INT AUTO_INCREMENT PRIMARY KEY,\n"
                    + "name VARCHAR(120),\n"
                    + "email VARCHAR(220),\n"
                    + "country VARCHAR(120),\n"
                    + "cities_id INT\n"
                    + ");";
            statement.execute(createTableSQL);
        }
    }
    @AfterAll
    static void cleanup() throws SQLException {
        if (connection != null) {
            try (Statement statement = connection.createStatement()) {
                String dropTableSQL = "DROP TABLE IF EXISTS users";
                statement.execute(dropTableSQL);
            }
            connection.close();
        }
    }

    @Test
    void testInsertUser() throws SQLException {
        UserDAO userDAO = new UserDAO(connection);
        User user = new User("Ivan", "makhorin0088@gmail.com", "Russia", 1);
        userDAO.insertUser(user);

        try (Statement statement = connection.createStatement()) {
            String countSQL = "SELECT COUNT(*) FROM users";
            assertEquals(1, statement.executeQuery(countSQL).getInt(1));
        }
    }
}