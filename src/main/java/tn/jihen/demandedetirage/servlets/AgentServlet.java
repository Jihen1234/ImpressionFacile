package tn.jihen.demandedetirage.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import tn.jihen.demandedetirage.dao.PrintGuyActions;
import tn.jihen.demandedetirage.dao.TeacherActions;
import tn.jihen.demandedetirage.entity.PrintRequest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "agentServlet", value = "/agent")
@MultipartConfig
public class AgentServlet extends HttpServlet {

    public void init() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<PrintRequest> tasks = PrintGuyActions.getTasksForToday();

        request.setAttribute("tasks", tasks);
        // Forward the request to the JSP page
        request.getRequestDispatcher("agent.jsp").forward(request, response);

    }

    public void destroy() {
    }
}
