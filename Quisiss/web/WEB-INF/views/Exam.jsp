<%-- 
    Document   : Exam
    Created on : Nov 18, 2019, 2:20:00 PM
    Author     : Acer Nitro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<ul>
  <li><a class="active" href="Exam">Exam</a></li>
  <li><a href="Profile">Profile</a></li>
  <li><a href="Contact">Contact</a></li>
</ul>
    <h1>Home</h1>
    <h2>Welcome : ${user.userName}</h2>
    <h3>Your ID : ${user.userId}</h3>
    <h3>Your Email : ${user.email}</h3>
    <hr>
    </body>
</html>
