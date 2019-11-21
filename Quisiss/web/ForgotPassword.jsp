<%-- 
    Document   : RePassword
    Created on : Nov 16, 2019, 11:46:19 PM
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Password</title>
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
                background-image: linear-gradient(to right top, #e098ae, #efa3a9, #f8b1a5, #fec0a4, #ffd0a6);
                background-repeat: no-repeat;
                height: 100vh;
            }
            hr{
                width:80%;
            }
            .btn-outline-danger{
                color: #966FD6;
                border-color: #966FD6;
            }
            .btn-outline-danger:hover{
                background-color: #8c60d2;
                border-color: #966FD6;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-1"></div>
                <div class="col-10 justify-content-center">
                    <div class="card text-center" style="margin-top: 12em;">
                        <div class="card-body">
                            <h1>Show Your Password</h1><br>
                            <h5 style="color:#966FD6;">${message}</h5>
                            <hr><br>
                            <form class="form" action="ForgotPassword" method="post">
                                <div class="form-group">                    
                                    <div class="row">
                                        <div class="col-1"></div>
                                        <div class="col-3">
                                            <h5 style="margin-top: 5px;">Enter Your Email</h5>
                                        </div>
                                        <div class="col-5">
                                            <input type="email" class="form-control" placeholder="Email" name="email">
                                        </div>
                                        <div class="col-2">
                                            <button type="submit" class="btn btn-dark">Send</button>
                                        </div>
                                        <div class="col-1"></div>
                                    </div>
                                </div> 
                            </form>
                            <br>
                            <hr>
                            <br>
                            <a href="Login"><button class="btn btn-outline-danger btn-sm">Back to Login</button></a>
                        </div>
                    </div> 
                    <div class="col-1"></div>
                </div>
            </div>            
        </div>        
    </body>
</html>
