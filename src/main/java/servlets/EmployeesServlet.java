package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class EmployeesServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter pw = resp.getWriter();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/public",
                    "postgres", "xxx");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT first_name FROM employees");

            while (rs.next());
            pw.println(rs.getString("first_name"));
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}