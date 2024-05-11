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
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Password</th>
        <th>Actions</th>
    </tr>
    <!-- Loop through the list of teachers and display them -->
    <c:forEach items="${teachers}" var="teacher">
        <tr>
            <td>${teacher.id}</td>
            <td>${teacher.name}</td>
            <td>${teacher.email}</td>
            <td>${teacher.password}</td>
            <td>
                <a class="button" href="editTeacher?id=${teacher.id}">Edit</a>
                <a class="button delete" href="deleteTeacher?id=${teacher.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Print Agents</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Password</th>
        <th>Actions</th>
    </tr>
    <!-- Loop through the list of print agents and display them -->
    <c:forEach items="${printAgents}" var="printAgent">
        <tr>
            <td>${printAgent.id}</td>
            <td>${printAgent.name}</td>
            <td>${printAgent.email}</td>
            <td>${printAgent.password}</td>
            <td>
                <a class="button" href="editPrintAgent?id=${printAgent.id}">Edit</a>
                <a class="button delete" href="deletePrintAgent?id=${printAgent.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
