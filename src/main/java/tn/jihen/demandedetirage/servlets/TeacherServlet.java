package tn.jihen.demandedetirage.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import tn.jihen.demandedetirage.dao.TeacherActions;
import tn.jihen.demandedetirage.entity.Teacher;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "teacherServlet", value = "/teacher")
@MultipartConfig
public class TeacherServlet extends HttpServlet {

    public void init() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Object[]> subjects = TeacherActions.getTeachersSubjects(2L);

        request.setAttribute("subjects", subjects);
        // Forward the request to the JSP page
        request.getRequestDispatcher("teacher.jsp").forward(request, response);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String subject = request.getParameter("subjects");
        String arrivalDate = request.getParameter("arrivalDate");
        String arrivalTime = request.getParameter("arrivalTime");
        int copies = Integer.parseInt(request.getParameter("copies"));

        // Get the uploaded file part
        Part filePart = request.getPart("document");

        // Generate a random filename with a .pdf extension
        String fileName = UUID.randomUUID().toString() + ".pdf";
        String fullPath = "";
        if (filePart != null && filePart.getSize() > 0) {

            // Save the uploaded file to the static folder with the random filename
            String uploadPath = "C:\\Users\\win10\\Desktop\\nodeleteme";
            fullPath = uploadPath+"\\"+fileName;
            try (InputStream input = filePart.getInputStream()) {
                Files.copy(input, Paths.get(uploadPath, fileName));
            } catch (IOException e) {
                e.printStackTrace(); // Handle the exception appropriately
            }
        }
        String arrivalDateTimeStr = arrivalDate + "T" + arrivalTime;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime arrivalDateTime = LocalDateTime.parse(arrivalDateTimeStr, formatter);
        // Get subject
        // TODO remove me later
        Teacher teacher = TeacherActions.getByUsername("jihen");
        int max = TeacherActions.getSubject(subject,teacher.getId());
        if (copies> max){
            response.sendError(HttpServletResponse.SC_BAD_GATEWAY, "Cannot copy this much");
            return;
        }
        TeacherActions.addRequest(arrivalDateTime,	fullPath,	copies,	subject,	teacher);
        response.sendRedirect(request.getContextPath() +"/teacher");

    }

    public void destroy() {
    }
}
