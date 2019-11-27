<%-- 
    Document   : ObjectiveQuiz
    Created on : Nov 27, 2019, 9:36:59 PM
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
     <title>Objective quiz</title>
    </head>
    <body>
        <h1>Objective</h1>
        <div class="container">
            <h1>Quiz of ${class.className}</h1>
            <c:choose>
                <c:when test="${quizs==[]}">
                    <div class="card">
                        <div class="card-header">
                            eieiei
                            no quiz yet
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${quizs}" var="q">
                        <div class="card">
                            <div class="card-header">
                                ${q.quizName}
                                <a href="ObjectiveQuiz?classId=${class.classId}&&quizId=${q.quizId}" class="btn btn-success float-right">
                                    Do a quiz
                                </a>
                            </div>
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
            ${message}
        </div>
    </body>
</html>
