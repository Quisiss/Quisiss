<%-- 
    Document   : RegisterSuccess
    Created on : Nov 18, 2019, 5:25:33 PM
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
                border: solid #ff3385 1px;
            }
            .btn-dark:hover{
                background-color: #ff1a75;
                border: solid #ff3385 1px;
            }
            body{
                background-image: linear-gradient(to right bottom, #eb2b9c, #ff607c, #ff956f, #ffc47f, #fbedaa);
                background-repeat: no-repeat;
                height: 100vh;
            }    
            .card{
                margin-top: 11em;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-3"></div>
                <div class="col-6">
                    <div class="card text-center">
                        <div class="card-body">
                            <img src="images/correct.png" style="width:30%">
                            <h3>Register Success</h3>
                            <hr>
                            <a href="Login.jsp"><button class="btn btn-dark">Go to Login</button></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-3"></div>
        </div>
    </div>
</body>
</html>
