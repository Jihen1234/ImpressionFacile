package tn.jihen.demandedetirage.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import tn.jihen.demandedetirage.dao.AdministratorActions;
import tn.jihen.demandedetirage.dao.TeacherActions;
import tn.jihen.demandedetirage.entity.PrintAgent;
import tn.jihen.demandedetirage.entity.Teacher;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "adminServlet", value = "/admin")
@MultipartConfig
public class AdminServlet extends HttpServlet {

    public void init() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Teacher> teachers = AdministratorActions.GetTeachers();
        List<PrintAgent> agents = AdministratorActions.GetAgents();

        request.setAttribute("teachers", teachers);
        request.setAttribute("agents", agents);
        // Forward the request to the JSP page
        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }

    public void destroy() {
    }
}
