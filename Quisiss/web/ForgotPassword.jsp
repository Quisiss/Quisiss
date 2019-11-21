<%-- 
    Document   : RePassword
    Created on : Nov 16, 2019, 11:46:19 PM
    Author     : Acer Nitro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Password</title>
    </head>
    <body>
        <h1>Show Your Password</h1>
        ${message}<br><br>
        <form action="ForgotPassword" method="post">
        Username : <input type="email" placeholder="Enter Email" name="email">
        <input type="submit">
        </form>
        <br><br>
        <a href="Login">Back to Login</a>
        
    </body>
</html>
