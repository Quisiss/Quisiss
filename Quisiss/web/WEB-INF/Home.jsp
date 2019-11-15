<%-- 
    Document   : Home
    Created on : Nov 14, 2019, 9:12:41 AM
    Author     : INT303
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover {
  background-color: #111;
}
</style>
</head>
<body>

<ul>
  <li><a class="active" href="DoExam">Exam</a></li>
  <li><a href="Profile">Profile</a></li>
  <li><a href="Contact">Contact</a></li>
</ul>
    <h1>Home</h1>
    <h2>Welcome : ${user.username}</h2>
    <hr>
</body>
</html>



