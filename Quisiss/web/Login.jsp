<%-- 
    Document   : Login
    Created on : Oct 26, 2019, 12:08:08 AM
    Author     : theeradonjaroonchon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
                background-image: linear-gradient(to right top, #eb2b9c, #ff607c, #ff956f, #ffc47f, #fbedaa);
                /*background: linear-gradient(to top right, #ef1c98 0%, #f9f871 100%);*/
                background-repeat: no-repeat;
                height: 100vh;

<<<<<<< HEAD
input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: #ffc0cb;
  color: black;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #ffc0cb;
}

.imgcontainer {
  text-align: center;
  margin: 12px 0 6px 0;
}

img.avatar {
  width: 40%;
  border-radius: 50%;
}

.container {
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}
</style>
</head>
<body>

<h2>Login</h2>
${msg}<br>
<form action="Login" method="post">

  <div class="container">
    <label for="username"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username">

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password">
        
    <button type="submit">Login</button>
    <label><input type="checkbox" checked="checked" name="remember">Remember me</label>
  </div>

  <div class="container" style="background-color:#f1f1f1">
      <button type="button" class="cancelbtn"><a href="Register">Register</a></button>
    <span class="psw"><a href="RePassword">Forgot Password?</a></span>
  </div>
</form>

</body>
=======
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-3"></div>
                <div class="col-6">
                    <div class="card justify-content-center" style="margin-top:7em;">
                    <div class="card-body">
                        <div class="col-12 justify-content-center">
                            <form action="Login" method="post">
                                <h2 class="mb-4 mt-0 text-center">Log in</h2>
                                ${msg}
                                <div class="form-group">
                                    <label for="username"><b>Username</b></label>
                                    <input type="text" class="form-control" placeholder="Username" name="username">
                                </div>
                                <div class="form-group">
                                    <label for="password"><b>Password</b></label>
                                    <input type="password" class="form-control" placeholder="Password" name="password">
                                </div>
                                <div class="form-group">
                                    <input type="submit" class="btn btn-dark btn-lg btn-block" value="Log in">
                                    <label style="padding-top:20px;"><input type="checkbox" checked="checked" name="remember">Remember me</label>
                                </div>
                                <hr>
                                <div class="form-group">
                                    <a href="Register.jsp"><input type="button" class="btn btn-outline-secondary  btn-block btn-pill  btn-shadow-blue" value="Register"></a>
                                </div>
                            </form>
                        </div>    
                    </div>
                    </div>
                </div> 
                <div class="col-3"></div>
            </div>
        </div>
    </body>
>>>>>>> develop
</html>
