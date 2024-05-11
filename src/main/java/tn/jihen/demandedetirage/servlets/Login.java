package tn.jihen.demandedetirage.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tn.jihen.demandedetirage.dao.DefaultUserActions;
import tn.jihen.demandedetirage.dao.AdministratorActions;
import tn.jihen.demandedetirage.dao.PrintGuyActions;
import tn.jihen.demandedetirage.dao.TeacherActions;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import tn.jihen.demandedetirage.entity.Teacher;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet", value = "/login")
public class Login extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello!";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // check if already lgoged in
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");
        if (role!=null){
            if (role.equals("admin")){
                RequestDispatcher dispatcher = request.getRequestDispatcher(request.getContextPath() +"/admin");
                dispatcher.forward(request, response);

            }else if (role.equals("teacher")){
                RequestDispatcher dispatcher = request.getRequestDispatcher(request.getContextPath() +"/teacher");
                dispatcher.forward(request, response);
            }else if (role.equals("print_agent")){
                RequestDispatcher dispatcher = request.getRequestDispatcher(request.getContextPath() +"/print_agent");
                dispatcher.forward(request, response);
            }else {
                request.getRequestDispatcher(request.getContextPath() +"index.jsp").forward(request, response);

            }
        }
        request.getRequestDispatcher(request.getContextPath() +"index.jsp").forward(request, response);

    }

    // Handle POST request
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        try {

            if (role.equals("admin") && AdministratorActions.login(username, password)){
                HttpSession session = request.getSession();

                // Store username and role in the session
                session.setAttribute("username", username);
                session.setAttribute("role", role);

                // Redirect to the home page or any other page
                RequestDispatcher dispatcher = request.getRequestDispatcher(request.getContextPath() +"/admin");
                dispatcher.forward(request, response);

            }else if (role.equals("teacher") && TeacherActions.login(username, password)){
                HttpSession session = request.getSession();
                Teacher teacher = TeacherActions.getByUsername(username);
                // Store username and role in the session
                session.setAttribute("id", teacher.getId());
                session.setAttribute("username", username);
                session.setAttribute("role", role);
response.sendRedirect(request.getContextPath() +"/teacher");


            }else if (role.equals("print_agent") && PrintGuyActions.login(username, password)){
                HttpSession session = request.getSession();

                // Store username and role in the session
                session.setAttribute("username", username);
                session.setAttribute("role", role);

                // Redirect to the home page or any other page
                RequestDispatcher dispatcher = request.getRequestDispatcher(request.getContextPath() +"/print_agent");
                dispatcher.forward(request, response);
            }else{
                response.sendRedirect(request.getContextPath() +"index.jsp");

                //out.println("<h1>WHO ARE YOU</h1>");
            }
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() +"index.jsp");

            // out.println("<h1>Error happened: Check console.</h1>");

            e.printStackTrace();
        }


    }

    public void destroy() {
    }
}
