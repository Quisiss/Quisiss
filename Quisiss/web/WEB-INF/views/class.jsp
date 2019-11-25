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
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="navbar-toggler-icon"></span>
            </button> <a class="navbar-brand" href="#">Brand</a>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Link <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Link</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown">Dropdown link</a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" href="#">Action</a> <a class="dropdown-item" href="#">Another action</a> <a class="dropdown-item" href="#">Something else here</a>
                            <div class="dropdown-divider">
                            </div> <a class="dropdown-item" href="#">Separated link</a>
                        </div>
                    </li>
                </ul>
                <form class="form-inline">
                    <input class="form-control mr-sm-2" type="text" /> 
                    <button class="btn btn-primary my-2 my-sm-0" type="submit">
                        Search
                    </button>
                </form>
                <ul class="navbar-nav ml-md-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Link <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown">Dropdown link</a>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" href="#">Action</a> <a class="dropdown-item" href="#">Another action</a> <a class="dropdown-item" href="#">Something else here</a>
                            <div class="dropdown-divider">
                            </div> <a class="dropdown-item" href="#">Separated link</a>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="container">
            <form class="form-inline" action="createClassServlet">
                <input class="form-control mr-sm-1" type="text" name="classCode" value="${param.classCode}" required/> 
                <button class="btn btn-primary my-2 my-sm-0" type="submit">
                    Join Class
                </button>
            </form>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" > Create your new class ${user.userName}</button>

            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Create your new class</h5>
                        </div>
                        <div class="modal-body">
                            <form action="createClassServlet">
                                <div class="form-group">
                                    <label for="recipient-name" class="col-form-label">Classname:</label>
                                    <input type="text" class="form-control" id="recipient-name" name="className" value="${param.className}" required>
                                    <button class="btn btn-primary my-2 my-sm-0" type="submit">Create class!</button> 
                                </div>
                            </form>
                        </div>

                    </div>
                </div>
            </div>

            ${message}
            <div class="row">
                <div class="col-12">
                    <h1>Owned class</h1>
                </div>
                
                <c:forEach items="${ownClass}" var="j">
                    <c:choose>
                        <c:when test="${j.ownerId==user.userId}">
                            <div class="card" style="width: 18rem;">
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
                            <div class="card" style="width: 18rem;">
                                <div class="card-body">
                                    <h5 class="card-title">${j.className}</h5>
                                        <p class="card-text">Own by : ${j.ownerId}</p>
                                    <a href="#" class="btn btn-primary">View class</a>
                                </div>
                            </div>

                </c:forEach>
            </div>
        </div>
    </body>
</html>
