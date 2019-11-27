<%-- 
    Document   : ManageQuiz
    Created on : Nov 23, 2019, 5:40:54 PM
    Author     : Lenovo-Y50
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
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
            
            <h1>Quiz of ${class.className}</h1>
            <c:choose>
                <c:when test="${quizs==[]}">
                    <div class="card">
                        <div class="card-header">
                            no quiz yet
                            <button type="button" class="btn btn-success float-right" data-toggle="modal" data-target="#exampleModal" > 
                                Create new ${class.className} quiz
                            </button>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${quizs}" var="q">
                        <div class="card">
                            <div class="card-header">
                                ${q.quizName}
                                <a href="deleteQuiz?classId=${class.classId}&&quizId=${q.quizId}" class="btn btn-danger float-right">
                                    Delete
                                </a>
                                <a href="EditQuiz?classId=${q.classId}&&quizId=${q.quizId}" class="btn btn-warning float-right mr-sm-2">
                                    Edit
                                </a>
                            </div>
                        </div>
                    </c:forEach>
                    <div class="card">
                        <div class="card-header">
                            <input type="hidden" name="classId" value="${class.classId}">
                            <button type="button" class="btn btn-success float-right" data-toggle="modal" data-target="#exampleModal" > 
                                add new quiz
                            </button>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>

            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Create your new quiz on ${class.className}</h5>
                        </div>
                        <div class="modal-body">
                            <form action="addQuiz" method="get">
                                <div class="form-group">
                                    <input type="hidden" name="classId" value="${class.classId}">
                                    <label for="recipient-name" class="col-form-label">Name </label>
                                    <input type="text" class="form-control" id="recipient-name" name="quizName" value="${param.quizName}" required>
                                    <label for="recipient-name" class="col-form-label">Time(second) </label>
                                    <input type="number" class="form-control" id="recipient-name" name="quizTime" value="${param.quizTime}" required>
                                    <button class="btn btn-primary mt-3" type="submit" name="classId" value="${class.classId}">Create quiz!</button> 
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            ${message}
            <h1>Student</h1>
            <c:forEach items="${student}" var="s">
                <div class="card">
                    <div class="card-header">
                        ${s.userName}
                        <a href="ManageClass?classId=${j.classId}" class="btn btn-danger float-right">
                            Delete student
                        </a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
