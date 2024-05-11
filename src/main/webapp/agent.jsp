<%@ page import="tn.jihen.demandedetirage.entity.PrintRequest" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.util.Locale" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Print Agent Interface</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        h1, h2 {
            color: #333;
            text-align: center;
            margin-top: 20px;
        }
        table {
            border-collapse: collapse;
            width: 80%;
            margin: 0 auto;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
            color: #333;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #e9e9e9;
        }
        td:last-child {
            text-align: center;
        }
        a {
            text-decoration: none;
            color: #007bff; /* Blue */
        }
        a:hover {
            text-decoration: underline;
            color: #0056b3; /* Darker Blue */
        }
    </style>
</head>
<body>
<h1>Print Agent Interface</h1>

<h2>Tasks for Today</h2>
<table>
    <tr>
        <th>Teacher Name</th>
        <th>Number of Copies</th>
        <th>Arrival Date</th>
        <th>Document</th>
        <th>Action</th>
    </tr>
    <%
        List<PrintRequest> tasks = (List<PrintRequest>) request.getAttribute("tasks");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm", Locale.ENGLISH);
    %>

    <!-- Loop through the list of tasks and display them -->
    <% for (int i = 0; i < tasks.size(); i++) { %>
    <tr>
        <td><%= tasks.get(i).getTeacher().getName() %></td>
        <td><%= tasks.get(i).getNumOfCopies() %></td>
        <td><%= tasks.get(i).getDateTime().format(formatter) %></td>
        <td><%= tasks.get(i).getDocumentPath() %></td>
        <td><a href="printDocument?id=<%= tasks.get(i).getId() %>">Print</a></td>
    </tr>
    <% } %>
</table>
</body>
</html>
