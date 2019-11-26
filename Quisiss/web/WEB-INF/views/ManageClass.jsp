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
    </head>
    <body>
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
                                <a href="ManageClass?classId=${j.classId}" class="btn btn-warning float-right mr-sm-2">
                                    Edit
                                </a>
                            </div>
                        </div>
                    </c:forEach>
                    <div class="card">
                        <div class="card-header">
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
                            <form action="addQuiz" method="post">
                                <div class="form-group">
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
