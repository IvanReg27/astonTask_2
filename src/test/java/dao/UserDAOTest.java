package dao;

import connectDB.ConnectionDB;
import model.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MySQLContainer;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserDAOTest {

    static MySQLContainer<?> mysql = new MySQLContainer<>(
            "mysql:8.0.24"
    );

    UserDAO userDAO;

    @BeforeAll
    static void beforeAll() {
        mysql.start();
    }

    @AfterAll
    static void afterAll() {
        mysql.stop();
    }

    @BeforeEach
    void setUp() {
        ConnectionDB connectionProvider = new ConnectionDB(
                mysql.getJdbcUrl(),
                mysql.getUsername(),
                mysql.getPassword()
        );
        userDAO= new UserDAO(connectionProvider);
    }

    @Test
    void shouldGetCustomers() throws SQLException {
        userDAO.insertUser(new User("Ivan", "makhorin0088@gmail.com", "Russia", 1));
        userDAO.insertUser(new User("Maria", "makhorina0089@gmail.com", "Russia", 2));

        List<User> customers = userDAO.selectAllUsers();
        assertEquals(2, customers.size());
    }
}