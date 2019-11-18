<%-- 
    Document   : EditProfile
    Created on : Nov 18, 2019, 4:23:42 PM
    Author     : Acer Nitro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Profile</title>
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
  <li><a class="active" href="Exam">Exam</a></li>
  <li><a href="Profile">Profile</a></li>
  <li><a href="CreateQuiz">Create Quiz</a></li>
</ul>
    <h1>Edit Profile</h1>
    <h2>Welcome : ${user.userName}</h2>
    <h3>Your ID : ${user.userId}</h3>
    <h3>Your Email : ${user.email}</h3>
    ${msg}<br>
    <hr>
    <form action="EditProfile" method="post">
        Change Username : <input type="text" name="username">
        Change Password : <input type="text" name="password">
        Confirm Password : <input type="text" name="cfpassword">
        Change Email : <input type="text" name="email">
        <input type="submit" value="Change Info">
    </form>
    <button><a href="Profile">Back to Profile</a></button>
    </body>
</html>
