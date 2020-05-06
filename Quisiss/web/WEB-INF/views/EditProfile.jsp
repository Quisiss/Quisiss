<%-- 
    Document   : EditProfile
    Created on : Nov 18, 2019, 4:23:42 PM
    Author     : Acer Nitro
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
                border-color: #ff3385;
            }
            .btn-dark:hover{
                background-color: #ff1a75;
                border-color: #ff3385;
            }
            body{
                background-image: linear-gradient(to left top, #e098ae, #efa3a9, #f8b1a5, #fec0a4, #ffd0a6);
                background-repeat: no-repeat;
                height: 100%;
                background-size: cover;
                background-attachment: fixed;
            }
            .navbar-dark .navbar-text {
                color:white;
            }
            .navbar-dark .navbar-nav .nav-link:focus, .navbar-dark .navbar-nav .nav-link:hover {
                color: #ffffff;
            }
            .btn-outline-dark{
                color: #ff3385;
                border: solid #ff3385 1px;
            }
            .btn-outline-dark:hover{
                background-color: #ff1a75;
                border: solid #ff1a75 1px;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #4D3A4D;">
            <a class="navbar-brand" href="createClass">Quisiss</a>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link disabled" href="Exam">Exam </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Profile">Profile</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="CreateQuiz">Create Quiz</a>
                    </li>
                </ul>              
                <ul class="navbar-nav ml-md-auto">
                    <span class="navbar-text">
                        ${user.userName} |
                    </span>
                    <a href="Logout"><button class="btn btn-info btn-sm" style="margin:6px;">Logout</button></a>
                </ul>    
            </div>
        </nav>
        <div class="container">
            <div class="row">
                <div class="col-12" style="margin-top:50px;">
                    <div class="card-deck">
                        <div class="card col-9">
                            <div class="card-body" style="padding:20px;">
                                <h2>Edit Username</h2>
                                <h5 style="color:red;">${msg1}</h5>
                                <hr>
                                <form action="EditUserName" method="post">
                                    <div class="form-group">
                                        <label for="username"><b>Change Username</b></label>
                                        <input type="text" class="form-control" placeholder="Username" name="username">
                                    </div>
                                    <div class="form-group">
                                        <label for="password"><b>Current Password</b></label>
                                        <input type="password" class="form-control" placeholder="Password" name="password">
                                    </div>
                                    <div class="form-group">
                                        <label for="cfpassword"><b>Confirm Password</b></label>
                                        <input type="password" class="form-control" placeholder="Confirm Password" name="cfpassword">
                                    </div> 
                                    <a href="EditUserName"><button type="submit" class="btn btn-dark" style="margin-top:20px;">Update Username</button></a>
                                </form>
                            </div>
                        </div> 
                                <div class="card col-9">
                            <div class="card-body" style="padding:20px;">
                                <h2>Edit Password</h2>
                                <h5 style="color:red;">${msg}</h5>
                                <hr>
                                <form action="EditPassword" method="post">
                                    <div class="form-group">
                                        <label for="password"><b>Current Password</b></label>
                                        <input type="password" class="form-control" placeholder="Password" name="password">
                                    </div>
                                    <div class="form-group">
                                        <label for="password"><b>Change Password</b></label>
                                        <input type="password" class="form-control" placeholder="New Password" name="newpassword">
                                    </div>
                                    <div class="form-group">
                                        <label for="cfpassword"><b>Confirm Password</b></label>
                                        <input type="password" class="form-control" placeholder="Confirm Password" name="cfpassword">
                                    </div> 
                                    <a href="EditPassword"><button type="submit" class="btn btn-dark" style="margin-top:20px;">Update Password</button></a>
                                </form>
                            </div>
                        </div> 
                        <div class="card col-3 text-center">
                            <div class="card-header">                           
                                <h2 class="card-text" style="text-transform: uppercase;">${user.userName}</h2>
                            </div>
                            <div class="card-body" style="padding:20px;">
                                <img src="images/user1.png" alt="user" style="width:60%;"><br><br>
                                <h4 class="card-text">Username : </h4><h5 style="color:#ff1a75;">${user.userName}</h5>
                                <h4 class="card-text">Your ID : </h4><h5 style="color:#ff1a75;">${user.userId}</h5>
                                <h4 class="card-text">Your Email : </h4><h5 style="color:#ff1a75;">${user.email}</h5>
                                <h4 class="card-text">Your Password : </h4><h5 style="color:#ff1a75;">${user.password}</h5>
                                <a href="Profile"><button class="btn btn-outline-dark" style="margin-top:20px;">Back to Profile</button></a>
                            </div>
                        </div> 
                    </div>
                </div>
            </div>
        </div>          
    </body>



    <!--<ul>
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
        Change Username : <input type="text" name="username"><br><br>
            Change Password : <input type="password" name="password"><br><br>
            Confirm Password : <input type="password" name="cfpassword"><br><br>
            Change Email : <input type="text" name="email"><br><br>
            <input type="submit" value="Change Info"><br><br>
    </form>
    <button><a href="Profile">Back to Profile</a></button>
    </body>-->
</html>
