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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Re-Password</h1>
        <form action="RePassword" method="post">
        Email : <input type="text" placeholder="Enter Email" name="email">
        <input type="submit">
        </form>
        <h2>We will send a link to reset password in your email</h2>
        <a href="Login">Back to Login</a>
        
    </body>
</html>
