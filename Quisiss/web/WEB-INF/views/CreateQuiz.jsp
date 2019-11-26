<%-- 
    Document   : CreateQuiz
    Created on : Nov 18, 2019, 2:21:53 PM
    Author     : Acer Nitro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

        <title>Quiz Page</title>
        <style>
            ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
                overflow: hidden;
                background-color: #333;
            }

            li {
                float: left;
            }

            li a {
                display: block;
                color: white;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }

            li a:hover {
                background-color: #111;
            }
        </style>
    </head>
    <body><ul>
            <li><a class="active" href="Exam">Exam</a></li>
            <li><a href="Profile">Profile</a></li>
            <li><a href="CreateQuiz">Create Quiz</a></li>
        </ul>
        <h1>Create Quiz</h1>
        <h2>Welcome : ${user.userName}</h2>
        <h3>Your ID : ${user.userId}</h3>
        <h3>Your Email : ${user.email}</h3>
        <hr>
        <form method="get" action="CreateQuestion">
            <div class="container">
                <div class="card">
                    <div class="card-header">
                        <h1><input type="text" class="form-control" name="question" placeholder="Enter question here" value="${param.question}" /></h1>
                    </div>
                    <c:forEach items="${list}" varStatus="i">
                        <div class="form-group d-flex">
                            <div class="col-sm-3">
                                choice ${i.index+1} : 
                            </div>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" name="choice${i.index+1}" value="${param.choice}"/>
                            </div>
                        </div>
                    </c:forEach>

                    <div class="col-sm-2">
                        <a href="AddQuestion?add=1&&list=${list}">add</a>                                
                    </div>
                    <button type="submit">save</button>
                </div>         
            </div> 
        </form>
    </body>
</html>
