<%-- 
    Document   : Register
    Created on : Nov 14, 2019, 9:14:35 AM
    Author     : INT303
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: black;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color: #ffc0cb;
  color: black;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
</style>
</head>
<body>

<form action="Register" method="post">
  <div class="container">
    <h1>Sign Up</h1>
    <p>Please fill in this form to create an account.</p><br>
    ${msg}
    <hr>
    
    <label for="username"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username"><br>
    
    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email"><br>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password">

    <label for="psw-repeat"><b>Repeat Password</b></label>
    <input type="password" placeholder="Repeat Password" name="passwordrepeat">
    <hr>
    <p>By creating an account you agree to our <a href="Term">Terms & Privacy</a>.</p>

    <input type="submit" class="registerbtn" value="Register">
  </div>
  
  <div class="container signin">
    <p>Already have an account? <a href="Login">Sign in</a>.</p>
  </div>
</form>

</body>
</html>
