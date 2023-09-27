package dao;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private String jdbcURL = "jdbc:postgresql://localhost:5432/public?useSSL=false";
    private String jdbcUsername = "postgres";
    private String jdbcPassword = "Jrheu666666";

    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (firstName, lastName, email," +
            " phoneNumber, hireDate, jobId, salary, commissionPct, managerId, departmentId) VALUES "
            + " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select employeeId, firstName, lastName, email," +
            " phoneNumber, hireDate, jobId, salary, commissionPct, managerId," +
            " departmentId from users where employeeId =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where employeeId = ?;";
    private static final String UPDATE_USERS_SQL = "update users set firstName =?, lastName =?," +
            " email =?, phoneNumber =?, hireDate =?, jobId =?, salary =?, commissionPct =?," +
            " managerId =?, departmentId =?, country =? where employeeId = ?;";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhoneNumber());
            preparedStatement.setDate(5, user.getHireDate());
            preparedStatement.setString(6, user.getJobId());
            preparedStatement.setFloat(7, user.getSalary());
            preparedStatement.setFloat(8, user.getCommissionPct());
            preparedStatement.setLong(9, user.getManagerId());
            preparedStatement.setLong(10, user.getDepartmentId());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPhoneNumber());
            statement.setDate(5, user.getHireDate());
            statement.setString(6, user.getJobId());
            statement.setFloat(7, user.getSalary());
            statement.setFloat(8, user.getCommissionPct());
            statement.setLong(9, user.getManagerId());
            statement.setLong(10, user.getDepartmentId());
            statement.setLong(11, user.getEmployeeId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    public User selectUser(Long employeeId) {
        User user = null;
        try (Connection connection = getConnection();             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setLong(1, employeeId);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phoneNumber");
                Date hireDate = rs.getDate("hireDate");
                String jobId = rs.getString("jobId");
                Float salary = rs.getFloat("salary");
                Float commissionPct = rs.getFloat("commissionPct");
                Long managerId = rs.getLong("managerId");
                Long departmentId = rs.getLong("departmentId");
                user = new User(employeeId, firstName, lastName, email, phoneNumber, hireDate,
                        jobId, salary, commissionPct, managerId, departmentId);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }
    public List<User> selectAllUsers() {

        List<User> users = new ArrayList<>();

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Long employeeId = rs.getLong("employeeId");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phoneNumber");
                Date hireDate = rs.getDate("hireDate");
                String jobId = rs.getString("jobId");
                Float salary = rs.getFloat("salary");
                Float commissionPct = rs.getFloat("commissionPct");
                Long managerId = rs.getLong("managerId");
                Long departmentId = rs.getLong("departmentId");
                users.add(new User(employeeId, firstName, lastName, email, phoneNumber, hireDate,
                        jobId, salary, commissionPct, managerId, departmentId));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }
    public boolean deleteUser(Long employeeId) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setLong(1, employeeId);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}