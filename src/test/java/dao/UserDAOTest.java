package dao;

import model.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
class UserDAOTest {

    @Container
    static MySQLContainer mysql = new MySQLContainer<>(DockerImageName.parse("mysql:5.7.34"));

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
        userDAO = new UserDAO(mysql.getJdbcUrl(), mysql.getUsername(), mysql.getPassword());
        userDAO.selectAllUsers();
    }

    @Test
    void shouldGetUsers() throws SQLException {
        userDAO.insertUser(new User("Ivan", "makhorin0088@gmail.com", "Russia", 1));
        userDAO.insertUser(new User("Maria", "makhorina0089@gmail.com", "Russia", 2));

        List<User> users = userDAO.selectAllUsers();
        assertEquals(2, users.size());
    }
}