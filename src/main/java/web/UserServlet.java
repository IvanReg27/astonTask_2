package web;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;

@WebServlet("/")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertUser(request, response);
                    break;
                case "/delete":
                    deleteUser(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateUser(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<User> listUser = userDAO.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        //Возможно не правильно!!!

        Long employeeId = Long.valueOf(Integer.parseInt(request.getParameter("employeeId")));
        User existingUser = userDAO.selectUser(employeeId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
    }
    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        Date hireDate = Date.valueOf(request.getParameter("hireDate"));
        String jobId = request.getParameter("jobId");
        Float salary = Float.valueOf(request.getParameter("salary"));
        Float commissionPct = Float.valueOf(request.getParameter("commissionPct"));
        Long managerId = Long.valueOf(request.getParameter("managerId"));
        Long departmentId = Long.valueOf(request.getParameter("departmentId"));
        User newUser = new User(firstName, lastName, email, phoneNumber, hireDate,
                jobId, salary, commissionPct, managerId, departmentId);
        userDAO.insertUser(newUser);
        response.sendRedirect("list");
    }
    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Long employeeId = Long.valueOf(Integer.parseInt(request.getParameter("employeeId")));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        Date hireDate = Date.valueOf(request.getParameter("hireDate"));
        String jobId = request.getParameter("jobId");
        Float salary = Float.valueOf(request.getParameter("salary"));
        Float commissionPct = Float.valueOf(request.getParameter("commissionPct"));
        Long managerId = Long.valueOf(request.getParameter("managerId"));
        Long departmentId = Long.valueOf(request.getParameter("departmentId"));
        User book = new User(employeeId, firstName, lastName, email, phoneNumber, hireDate,
                jobId, salary, commissionPct, managerId, departmentId);
        userDAO.updateUser(book);
        response.sendRedirect("list");
    }
    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Long employeeId = Long.valueOf(Integer.parseInt(request.getParameter("employeeId")));
        userDAO.deleteUser(employeeId);
        response.sendRedirect("list");
    }
}