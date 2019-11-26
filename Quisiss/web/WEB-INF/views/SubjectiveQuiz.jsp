<%-- 
    Document   : QuizChoice
    Created on : Nov 16, 2019, 11:33:06 PM
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
            body{
                background-image: url("../images/pink_bg.png");
                background-repeat: no-repeat;
                background-size: 100%
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark sticky-top" style="background-color: #ff1a75;">
            <a class="navbar-brand" href="#">Navbar</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav justify-content-center">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Link</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Dropdown
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">Action</a>
                            <a class="dropdown-item" href="#">Another action</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Something else here</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="container">
            <div class="row">
                <div class="col col-1"></div>
                <div class="col-12">
                    <center>
                        <div class="card w-100" style="margin-top: 20px; text-align: center;">
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
                    <div class="card col-9" style="height:400px;">
                        <div class="card-body">
                            <h5 class="card-title">Question 1</h5>
                            <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>               
                        </div>
                    </div>
                    <div class="card col-2">
                        <center><img src="../images/user1.png" class="card-img-top" alt="user" style="width:50%;margin-top: 20px;"></center>
                        <div class="card-body">
                            <h5 class="card-title">Username</h5>
                            <p class="card-text">This card has supporting text below as a natural lead-in to additional content.</p>                           
                            <a href="ResultQuiz"><input type="submit" class="btn btn-outline-success" value="Finish"></input></a>
                        </div>
                    </div>
                </div>  
            </div>
            <div class="row">
                <div class="col-12">
                    <nav style="padding-top: 20px;">
                       <ul class="pagination justify-content-center">
                        <li class="page-item">
                            <a class="page-link" href="#" tabindex="-1">&laquo;</a>
                        </li>
                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item">
                            <a class="page-link" href="#">&raquo;</a>
                        </li>
                    </ul>
                </nav>  
                </div>              
            </div>
        </div>
    </body>
</html>

