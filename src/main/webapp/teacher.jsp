<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Teacher Interface</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        h1, h2 {
            color: #333;
        }
        form {
            margin-bottom: 20px;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            margin-bottom: 5px;
            color: #333;
        }
        input[type="text"], input[type="number"], select, input[type="file"], input[type="date"], input[type="time"], input[type="submit"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="file"] {
            cursor: pointer;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        table {
            border-collapse: collapse;
            width: 100%;
            margin-top: 20px;
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
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h1>Teacher Interface</h1>

<h2>Make Printing Request</h2>
<form action="submitRequest" method="post">
    <label for="subject">Subject:</label>
    <select name="subject" id="subject">
        <option value="Math">Math</option>
        <option value="Science">Science</option>
        <option value="History">History</option>
        <!-- Add more subjects as needed -->
    </select>
    <label for="document">Document to Print (PDF):</label>
    <input type="file" name="document" id="document" accept=".pdf">
    <label for="arrivalDate">Arrival Date:</label>
    <input type="date" name="arrivalDate" id="arrivalDate">
    <label for="arrivalTime">Arrival Time:</label>
    <input type="time" name="arrivalTime" id="arrivalTime">
    <label for="copies">Number of Copies:</label>
    <input type="number" name="copies" id="copies" min="1">
    <input type="submit" value="Submit Request">
</form>

<h2>Previous Requests</h2>
<table>
    <tr>
        <th>Subject</th>
        <th>Document</th>
        <th>Arrival Date</th>
        <th>Arrival Time</th>
        <th>Copies</th>
        <th>Status</th>
    </tr>
    <!-- Loop through the list of previous requests and display them -->
    <c:forEach items="${previousRequests}" var="request">
        <tr>
            <td>${request.subject}</td>
            <td>${request.document}</td>
            <td>${request.arrivalDate}</td>
            <td>${request.arrivalTime}</td>
            <td>${request.copies}</td>
            <td>${request.status}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
