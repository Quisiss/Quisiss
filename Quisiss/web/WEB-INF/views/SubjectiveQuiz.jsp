<%-- 
    Document   : QuizChoice
    Created on : Nov 16, 2019, 11:33:06 PM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                background-image: linear-gradient(to left top, #e098ae, #efa3a9, #f8b1a5, #fec0a4, #ffd0a6);
                background-repeat: no-repeat;
                height: 100%;
                background-size: cover;
                background-attachment: fixed;
            }
            .navbar-dark .navbar-text {
                color:white;
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
                <div class="col-12">
                    ${message}
                    <h1>Create Question</h1>
                    Quiz Name : ${quiz.quizName} ,
                    Class Name : ${class.className}
                    <form action="SubjectiveQuiz" method="post">
                        <div class="input-group">
                            <input type="hidden" name="quizId" value="${quiz.quizId}">
                            <input type="hidden" name="classId" value="${class.classId}">
                            <textarea class="form-control" name="question" placeholder="Write Question"></textarea>
                            <input type="submit" class="btn btn-info">
                        </div>
                    </form>
                    <br><a href="createClass" class="btn btn-secondary">Back to Home</a>
                </div>
            </div>
        </div>
    </body>
</html>

