<%-- 
    Document   : Profile
    Created on : Nov 18, 2019, 2:21:36 PM
    Author     : Acer Nitro
--%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>        
        <style>
            .navbar-dark .navbar-nav .nav-link:focus, .navbar-dark .navbar-nav .nav-link:hover {
                color: #ffffff;
            }
            body{
                background-image: linear-gradient(to bottom, #fb58d1, #ff75a1, #ffa489, #ffd094, #fff4bd);
                background-repeat: no-repeat;
                height: 100vh;
            }
            .btn-outline-dark{
                color: #ff3385;
                border: solid #ff3385 1px;
            }
            .btn-outline-dark:hover{
                background-color: #ff1a75;
                border: solid #ff1a75 1px;
            }
            .navbar-dark .navbar-text {
                color:white;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="Home">Quisiss</a>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="Exam">Exam </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Profile">Profile</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="CreateQuiz">Create Quiz</a>
                    </li>
                </ul>              
                <ul class="navbar-nav ml-md-auto">
                    <span class="navbar-text">
                        ${user.userName} |
                    </span>
                    <a href="Logout"><button class="btn btn-outline-info btn-sm" style="margin:6px;">Logout</button></a>
                </ul>    
            </div>
        </nav>
        <div class="container">
            <div class="row">
                <div class="col-3"></div>
                <div class="col-6" style="margin-top:60px;">
                    <div class="card text text-center border-dark">
                        <div class="card-header">                           
                            <h2 class="card-text" style="text-transform: uppercase;">${user.userName}</h2>
                        </div>
                        <div class="card-body" style="padding:20px;">
                            <img src="images/user1.png" alt="user" style="width:30%;"><br><br>
                            <h4 class="card-text">Welcome : ${user.userName}</h4>
                            <h4 class="card-text">Your ID : ${user.userId}</h4>
                            <h4 class="card-text">Your Email : ${user.email}</h4>
                            <a href="EditUserName"><button class="btn btn-outline-dark" style="margin-top:20px;">Edit Profile</button></a>
                        </div>
                    </div> 
                </div>
                <div class="col-3"></div>
            </div>
        </div>          
    </body>
</html>