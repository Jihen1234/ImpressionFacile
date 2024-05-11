package tn.jihen.demandedetirage.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tn.jihen.demandedetirage.dao.DefaultUserActions;
import tn.jihen.demandedetirage.dao.AdministratorActions;
import tn.jihen.demandedetirage.dao.PrintGuyActions;
import tn.jihen.demandedetirage.dao.TeacherActions;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet", value = "/login")
public class Login extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello!";
    }

    // Handle GET request (optional, you can focus on POST if not needed)
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    // Handle POST request
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        try {
            boolean loggedIn = DefaultUserActions.login(username, password);
            if (loggedIn) {
                // Check if the user is an admin
                if (AdministratorActions.login(username, password)) {
                    out.println("<h1>Welcome, you are an admin!</h1>");
                }
                // Check if the user is a teacher
                else if (TeacherActions.login(username, password)) {
                    out.println("<h1>Welcome, you are a teacher!</h1>");
                }
                // Check if the user is a print agent
                else if (PrintGuyActions.login(username, password)) {
                    out.println("<h1>Welcome, you are a print agent!</h1>");
                }
                // If no role matches
                else {
                    out.println("<h1>Unknown role!</h1>");
                }
            } else {
                out.println("<h1>Not logged in :(</h1>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        out.println("</body></html>");
    }

    public void destroy() {
    }
}
