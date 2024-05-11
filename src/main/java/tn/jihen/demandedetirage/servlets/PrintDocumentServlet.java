package tn.jihen.demandedetirage.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import tn.jihen.demandedetirage.dao.PrintGuyActions;
import tn.jihen.demandedetirage.dao.TeacherActions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "documentServlet", value = "/printDocument")
@MultipartConfig
public class PrintDocumentServlet extends HttpServlet {

    public void init() {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve document ID from request parameter
        String documentId = request.getParameter("id");

        // Retrieve document path from database based on document ID
        String documentPath = getDocumentPathFromDatabase(documentId);

        // Check if document path is valid
        if (documentPath != null) {
            // Get the file input stream
            File file = new File(documentPath);

            if (file.exists()) {
                // Set the content type and header attributes
                response.setContentType("application/pdf");
                response.setHeader("Content-Disposition", "inline; filename=" + file.getName());

                // Get the input stream of the file
                try (InputStream inputStream = new FileInputStream(file)) {
                    // Copy the file content to the response output stream
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        response.getOutputStream().write(buffer, 0, bytesRead);
                    }
                }
            } else {
                // Document not found, handle error response
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Document not found + "+documentPath);
            }
        } else {
            // Document path not found in database, handle error response
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Document path not found in database");
        }
    }

    // Method to retrieve document path from database based on document ID (Replace with your actual implementation)
    private String getDocumentPathFromDatabase(String documentId) {
        return PrintGuyActions.getDocumentFromDB(documentId);

    }


    public void destroy() {
    }
}
