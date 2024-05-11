<%@ page import="tn.jihen.demandedetirage.entity.PrintAgent" %>
<%@ page import="java.util.List" %>
<%@ page import="tn.jihen.demandedetirage.entity.Teacher" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Interface</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        .button {
            background-color: #4CAF50; /* Green */
            border: none;
            color: white;
            padding: 8px 14px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 4px;
        }
        .button.delete {
            background-color: #f44336; /* Red */
        }
        .button:hover {
            background-color: #45a049;
        }
        .button.delete:hover {
            background-color: #e57373; /* Light red */
        }
    </style>
</head>
<body>
<h1>Admin Interface</h1>

<h2>Teachers</h2>
<%
    List<Teacher> teachers = (List<Teacher>) request.getAttribute("teachers");
%>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Password</th>
        <th>Actions</th>
    </tr>
    <!-- Loop through the list of teachers and display them -->
    <% for (int i = 0; i < teachers.size(); i++) { %>
    <tr>
        <td>${teachers.get(i).getId()}</td>
        <td>${teachers.get(i).getName()}</td>
        <td>${teachers.get(i).getUsername()}</td>
        <td>${teachers.get(i).getPassword()}</td>
        <td>
            <a class="button" href="editPrintAgent?id=${teachers.get(i).getId()}">Edit</a>
            <a class="button delete" href="deletePrintAgent?id=${teachers.get(i).getId()}">Delete</a>
        </td>
    </tr>
    <% } %>
</table>

<h2>Print Agents</h2>
<%
    List<PrintAgent> agents = (List<PrintAgent>) request.getAttribute("agents");
%>


<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Password</th>
        <th>Actions</th>
    </tr>

    <% for (int i = 0; i < agents.size(); i++) { %>
    <tr>
        <td>${agents.get(i).getId()}</td>
        <td>${agents.get(i).getName()}</td>
        <td>${agents.get(i).getUsername()}</td>
        <td>${agents.get(i).getPassword()}</td>
        <td>
            <a class="button" href="editPrintAgent?id=${agents.get(i).getId()}">Edit</a>
            <a class="button delete" href="deletePrintAgent?id=${agents.get(i).getId()}">Delete</a>
        </td>
    </tr>
    <% } %>

</table>
</body>
</html>
