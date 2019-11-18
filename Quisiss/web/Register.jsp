<%-- 
    Document   : Register
    Created on : Nov 14, 2019, 9:14:35 AM
    Author     : INT303
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<<<<<<< HEAD
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
    <input type="password" placeholder="Repeat Password" name="cfpassword">
    <hr>
    <p>By creating an account you agree to our <a href="Term">Terms & Privacy</a>.</p>

    <a href="RegisterSuccess.jsp"><input type="submit" class="registerbtn" value="Register"></a>
  </div>
  
  <div class="container signin">
    <p>Already have an account? <a href="Login">Sign in</a>.</p>
  </div>
</form>

</body>
=======
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>        
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            .btn-dark{
                background-color: #ff3385;
            }
            .btn-dark:hover{
                background-color: #ff1a75;
            }
            body{
                background-image: linear-gradient(to right, #eb2b9c, #ff607c, #ff956f, #ffc47f, #fbedaa);
                background-repeat: no-repeat;
                height: 100vh;
            }
        </style>
    </head>
    <body>
         <div class="container">
            <div class="row">
                <div class="col-2"></div>
                <div class="col-8">
                    <div class="card justify-content-center" >
                    <div class="card-body">
                        <div class="col-12 justify-content-center">
                            <form action="Register" method="post">
                                <h2 class="mb-4 mt-0 text-center">Register</h2>
                                <p>Please fill in this form to create an account.</p>
                                ${msg}
                                <hr>
                                <div class="form-group">
                                    <label for="username"><b>Username</b></label>
                                    <input type="text" class="form-control" placeholder="Username" name="username">
                                </div>
                                <div class="form-group">
                                    <label for="email"><b>E-mail</b></label>
                                    <input type="email" class="form-control" placeholder="E-mail" name="email">
                                </div>
                                <div class="form-group">
                                    <label for="password"><b>Password</b></label>
                                    <input type="password" class="form-control" placeholder="Password" name="password">
                                </div>
                                <div class="form-group">
                                    <label for="password"><b>Confirm Password</b></label>
                                    <input type="password" class="form-control" placeholder="Confirm Password" name="cfpassword">
                                </div>
                                <hr>
                                <div class="form-group">
                                    <p>By creating an account you agree to our <a href="Term">Terms & Privacy</a>.</p>
                                </div>
                                <div class="form-group">
                                    <a href="RegisterSuccess.jsp"><input type="submit" class="btn btn-dark btn-lg btn-block" value="Register"></a>
                                </div>
                                <div class="form-group">
                                    <p style="text-align: center;">Already have an account? <a href="Login.jsp">Sign in</a>.</p>
                                </div>
                            </form>
                        </div>    
                    </div>
                    </div>
                </div> 
                <div class="col-2"></div>
            </div>
        </div>      
    </body>
>>>>>>> develop
</html>
