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
                background-image: url("../images/pink_bg.png");
                background-repeat: no-repeat;
                background-size: 100%
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    ${message}
                    <h1>Create Question</h1>
                    ${quiz.quizId}
                    ${class.classId}
                    <form action="SubjectiveQuiz" method="post">
                        <div class="input-group">
                            <input type="hidden" name="quizId" value="${quiz.quizId}">
                            <input type="hidden" name="classId" value="${class.classId}">
                            <textarea class="form-control" name="question" placeholder="Write Question"></textarea>
                            <input type="submit" class="btn btn-info">
                        </div>
                    </form>  
                </div>
            </div>
        </div>
    </body>
</html>

