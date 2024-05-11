
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
    <!-- Loop through the list of tasks and display them -->
    <c:forEach items="${tasks}" var="task">
        <tr>
            <td>${task.teacherName}</td>
            <td>${task.numCopies}</td>
            <td>${task.arrivalDate}</td>
            <td>${task.document}</td>
            <td><a href="printDocument?id=${task.id}">Print</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
