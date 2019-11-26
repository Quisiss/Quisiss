<%-- 
    Document   : class
    Created on : Nov 13, 2019, 10:26:33 PM
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
            .navbar-dark .navbar-nav .nav-link:focus, .navbar-dark .navbar-nav .nav-link:hover {
                color: #ffffff;
            }
            body{
                background-image: linear-gradient(to left top, #e098ae, #efa3a9, #f8b1a5, #fec0a4, #ffd0a6);
                background-repeat: no-repeat;
                height: 100%;
                background-size: cover;
                background-attachment: fixed;
            }
            .btn-dark{
                background-color: #d24dff;
                border: solid #d24dff 1px;
            }
            .btn-dark:hover{
                background-color: #c61aff;
                border: solid #d24dff 1px;
            }
            .btn-outline-dark{
                color: #d24dff;
                border: solid #d24dff 1px;
            }
            .btn-outline-dark:hover{
                background-color: #c61aff;
                border: solid #d24dff 1px;
            }
            .navbar-dark .navbar-text {
                color:white;
            }
            hr{
                width:50%;
            }           
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #4D3A4D;">
            <a class="navbar-brand" href="createClass">Quisiss</a>
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
                    <a href="Logout"><button class="btn btn-info btn-sm" style="margin:6px;">Logout</button></a>
                </ul>    
            </div>
        </nav>
        <div class="container">
            <div class="card text-center" style="margin-top:1em;">
<!--                <h3 class="card-title" style="padding-top:20px;margin-bottom:10px;">Welcome : ${user.userName}</h3>-->
                <div class="card-body">
                    <form class="form-inline justify-content-center" action="createClass">
                        <input class="form-control mr-sm-1" type="text" name="classCode" value="${param.classCode}" required/> 
                        <button class="btn btn-dark my-2 my-sm-0" type="submit">
                            Join Class
                        </button>              
                    </form>
                    <hr>
                    <button type="button" class="btn btn-outline-dark" data-toggle="modal" data-target="#exampleModal" > Create your new class ${user.userName}</button>
                </div>
            </div>  
            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Create your new class</h5>
                        </div>
                        <div class="modal-body">
                            <form action="createClass">
                                <div class="form-group">
                                    <label for="recipient-name" class="col-form-label">Classname:</label>
                                    <input type="text" class="form-control" id="recipient-name" name="className" value="${param.className}" required><br>
                                    <button class="btn btn-dark my-2 my-sm-0" type="submit">Create class!</button> 
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <h4 style="color:red;margin-top: 10px;">${message}</h4>
            <div class="row">
                <div class="col-12">
                    <h1>Owned class</h1>
                </div>               
                <c:forEach items="${ownClass}" var="j" >                   
                        <c:choose>
                            <c:when test="${j.ownerId==user.userId}">                           
                            <div class="card col-3" style="margin:10px;">
                                <div class="card-body">
                                    <a href="deleteClass?classId=${j.classId}">
                                        <button type="button" class="close" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </a>
                                    <h5 class="card-title">${j.className}</h5>
                                    <p class="card-text"> code : ${j.classCode}</p>
                                    <a href="ManageClass?classId=${j.classId}" class="btn btn-primary">
                                        Manage your class
                                    </a>
                                </div>
                            </div>                           
                        </c:when>                      
                    </c:choose>
                </c:forEach>
            </div>
            <div class="row">
                <div class="col-12">
                    <h1>Joined class</h1>
                </div>

                <c:forEach items="${joinedClasses}" var="j">
                    <div class="card" style="width: 18rem;margin:10px; ">
                        <div class="card-body">
                            <h5 class="card-title">${j.className}</h5>
                            <p class="card-text">Own by : ${j.ownerId}</p>
                            <a href="ManageClass" class="btn btn-primary">View class</a>
                        </div>
                    </div>

                </c:forEach>
            </div>
        </div>
    </body>
</html>