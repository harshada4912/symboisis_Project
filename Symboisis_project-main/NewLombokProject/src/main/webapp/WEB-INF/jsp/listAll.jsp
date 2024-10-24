<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
body {
  font-family: Arial, sans-serif;
  margin: 20px;
}

h2 {
  color: #333;
}

table {
  width: 100%;
  border-collapse: collapse;
}

th, td {
  padding: 10px;
  text-align: left;
}

th {
  background-color: #f2f2f2;
}

tr:nth-child(even) {
  background-color: #f9f9f9;
}

a {
  color: #0066cc;
  text-decoration: none;
}

a:hover {
  text-decoration: underline;
}
body {
  font-family: Arial, sans-serif;
  background-color: #f2f2f2;
  margin: 0;
  padding: 20px;
}

h2 {
  color: #333;
  text-align: center;
}

table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 20px;
  background-color: #fff;
  border: 1px solid #ddd;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  text-align: center; /* Center-align the table */
}

th, td {
  padding: 12px;
  text-align: center; /* Center-align the fields */
}

th {
  background-color: #f9f9f9;
  font-weight: bold;
  border-bottom: 1px solid #ddd;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}

a {
  color: #0066cc;
  text-decoration: none;
}

a:hover {
  text-decoration: underline;
}
</style>
<title>Employee Details</title>
</head>
<body>

<!-- <td><a href="savedata">Add Employee</a></td> -->
<td><a href="show">Add Employee</a></td>
<h2>List of All Employees</h2>
<table border=1>
<tr>
<th>First Name</th>
<th>Last Name</th>
<th>E-Mail</th>
<th>Contact No.</th>

<th>Delete</th>
<th>Update</th> 
</tr>
<c:forEach var="leads" items="${leads}">
<tr>
<td>${leads.fname}</td>
<td>${leads.lname}</td>
<td>${leads.email}</td>
<td>${leads.mobile}</td>

<td><a href="deletelead?id=${leads.id}">delete</a></td>
<td><a href="updatelead?id=${leads.id}">update</a></td>
</tr>
</c:forEach>
</table>

</body>
</html>

