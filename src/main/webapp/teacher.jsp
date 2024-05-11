<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Random" %>

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
<form action="teacher" method="post" enctype="multipart/form-data">
    <label for="subjects">Subject:</label>

    <select name="subjects">
        <% for (Object[] subjectRow : (List<Object[]>)request.getAttribute("subjects")) { %>
        <option value="<%= subjectRow[0] %>"><%= subjectRow[0] %> - <%= subjectRow[1] %></option>
        <% } %>
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
    <%
        class PreviousRequest {
            private String subject;
            private String document;
            private String arrivalDate;
            private String arrivalTime;
            private int copies;
            private String status;

            public String getSubject() {
                return subject;
            }

            public void setSubject(String subject) {
                this.subject = subject;
            }

            public String getDocument() {
                return document;
            }

            public void setDocument(String document) {
                this.document = document;
            }

            public String getArrivalDate() {
                return arrivalDate;
            }

            public void setArrivalDate(String arrivalDate) {
                this.arrivalDate = arrivalDate;
            }

            public String getArrivalTime() {
                return arrivalTime;
            }

            public void setArrivalTime(String arrivalTime) {
                this.arrivalTime = arrivalTime;
            }

            public int getCopies() {
                return copies;
            }

            public void setCopies(int copies) {
                this.copies = copies;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }
        }

        // Define some sample data
        String[] subjects = {"Subject A", "Subject B", "Subject C", "Subject D", "Subject E"};
        String[] documents = {"Document 1", "Document 2", "Document 3", "Document 4", "Document 5"};
        String[] arrivalDates = {"2024-05-01", "2024-05-02", "2024-05-03", "2024-05-04", "2024-05-05"};
        String[] arrivalTimes = {"09:00", "10:00", "11:00", "12:00", "13:00"};
        int[] copies = {1, 2, 3, 4, 5};
        String[] statuses = {"Pending", "Approved", "Rejected"};

        // Generate random data for 5 previous requests
        List<PreviousRequest> previousRequests = new ArrayList<>();
        Random random = new Random();
        PreviousRequest r;
        for (int i = 0; i < 5; i++) {
            r = new PreviousRequest();
            r.setSubject(subjects[random.nextInt(subjects.length)]);
            r.setDocument(documents[random.nextInt(documents.length)]);
            r.setArrivalDate(arrivalDates[random.nextInt(arrivalDates.length)]);
            r.setArrivalTime(arrivalTimes[random.nextInt(arrivalTimes.length)]);
            r.setCopies(copies[random.nextInt(copies.length)]);
            r.setStatus(statuses[random.nextInt(statuses.length)]);
            previousRequests.add(r);
        }
    %>
    <!-- Loop through the list of previous requests and display them -->
    <% for (PreviousRequest f : previousRequests) { %>
    <tr>
        <td><%= f.getSubject() %></td>
        <td><%= f.getDocument() %></td>
        <td><%= f.getArrivalDate() %></td>
        <td><%= f.getArrivalTime() %></td>
        <td><%= f.getCopies() %></td>
        <td><%= f.getStatus() %></td>
    </tr>
    <% } %>
</table>
</body>
</html>
