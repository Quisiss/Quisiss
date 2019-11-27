<%-- 
    Document   : ObjectiveQuiz
    Created on : Nov 27, 2019, 10:23:33 PM
    Author     : Lenovo-Y50
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
        <title>Objective</title>
    </head>
    <ul>
            <li><a class="active" href="Exam">Exam</a></li>
            <li><a href="Profile">Profile</a></li>
            <li><a href="CreateQuiz">Create Quiz</a></li>
        </ul>
        <h1>Objective ${quiz.quizName}</h1>
        <h2>Welcome : ${user.userName}</h2>
        <h3>Your ID : ${user.userId}</h3>
        <h3>Your Email : ${user.email}</h3>
        <hr>
        <c:forEach items="${questions}" var="q">
            <div class="container">
                <div class="card">
                    <div class="card-header">
                        <div class="d-flex">
                            <h1>${q.question}</h1>
                        </div>

                    </div>
                    <c:forEach items="${choices}" var="c">
                        <c:choose>
                            <c:when test="${q.questionid==c.questionId}">
                                <div class="innerForm1 d-flex">
                                    <div class="col-sm-3 choice" name="choice1">
                                        choice ${c.choiceId} :
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="radio"name="answer" value="${c.choiceId}"/>
                                        ${c.choice}
                                    </div>
                                </div>
                            </c:when>
                        </c:choose>
                    </c:forEach>
                </div>
            </div>
        </c:forEach>
        <button>finish</button>
    </body>
</html>
