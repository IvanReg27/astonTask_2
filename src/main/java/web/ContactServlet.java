package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        var writer = response.getWriter();
        writer.println("<h1>Hello, my name is Ivan, I am a beginner programmer</h1>"
                + "<h2>in the Java language, if you want to contact me,</h2>" +
                "<h3>here is my telegram contact:</h3>" + "<h4>@Vanes_reg27</h4>");
    }
}
