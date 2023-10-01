package web;

import dao.UserDAO;
import model.City;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/city")
public class CityServlet extends HttpServlet {
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
                default:
                    listCity(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    private void listCity(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<City> listCity = userDAO.selectAllCities();
        request.setAttribute("listCity", listCity);
        RequestDispatcher dispatcher = request.getRequestDispatcher("city-list.jsp");
        dispatcher.forward(request, response);
    }
}