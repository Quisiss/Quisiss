<%-- 
    Document   : QuizPage
    Created on : Nov 16, 2019, 4:47:04 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .navbar-dark .navbar-nav .nav-link:focus, .navbar-dark .navbar-nav .nav-link:hover {
                color: #ffffff;
            }
            .navbar-dark .navbar-text {
                color:white;
            }
            body{
                background-image: linear-gradient(to left top, #e098ae, #efa3a9, #f8b1a5, #fec0a4, #ffd0a6);
                background-repeat: no-repeat;
                height: 100%;
                background-size: cover;
                background-attachment: fixed;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col col-1"></div>
                <div class="col-12">
                    <center>
                        <div class="card w-75" style="margin-top: 20px; text-align: center;">
                            <div class="card-body">
                                <h3 class="card-title">Quiz</h3>
                            </div>                  
                        </div>  
                        <!--<h1 style="margin-top: 20px;">Quiz</h1>-->
                    </center>
                </div>
                <div class="col col-1"></div>
            </div>
            <br>
            <div class="row">
                <div class="card-deck justify-content-center">
                    <div class="card col-6" style="height:400px;">
                        <div class="card-body">
                            <h5 class="card-title">Question 1</h5>
                            <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>               
                            <form action="" method="post" id="form1">
                                <div class="input-group mb-3">
                                    <select class="custom-select" id="inputGroupSelect02">
                                        <option selected>Choose...</option>
                                        <option value="true">True</option>
                                        <option value="false">False</option>
                                    </select>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="card col-2 text-center">
                        <center><img src="images/user1.png" class="card-img-top" alt="user" style="width:50%;margin-top: 20px;"></center>
                        <div class="card-body">
                            <h4 style="color:#ff1a75;">${user.userName}</h4>
                            <h3 class="justify-content-center">00:00</h3>
                            <input type="submit" class="btn btn-outline-success" value="Finish" form="form1"></input>
                        </div>
                    </div>
                </div>  
            </div>
        </div>
    </body>
</html>
