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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $('[id^=allsubmit]').click(function () {
                    $('.cloneForm').each(function () {
                        valuesToSend = $(this).serialize();
                        $.ajax($(this).attr('action'),
                                {
                                    method: $(this).attr('method'),
                                    data: valuesToSend
                                }
                        )
                    });
                });
            });  
            $(document).ready(function () {
                $('[id^=cloneButton]').click(function () {
                    $('.cloneForm:first').clone().appendTo(".clone").find("input[type='text']").val("");
                    event.preventDefault();
                });
            });
            $(document).ready(function () {
                $("body").on("click", '[id^=delete]', function () {
                    if ($(".cloneForm").length != 1) {
                        $(".cloneForm:last").remove();
                    }
                    event.preventDefault();
                });
            });
            $(document).ready(function () {
                $('[id^=add]').click(function () {
                    var $div = $('div[id^="innerForm"]:last');
                    var num = parseInt($div.prop("id").match(/\d+/g), 10) + 1;
                    var $innerForm = $div.first().clone().insertBefore(".innerClone").prop({'id': 'innerForm' + num});
                    $innerForm.find("input[type='text']").val("").attr('name', "choice" + num);
                    $innerForm.find("input[type='radio']").val(num);
                    $innerForm.find('p[id^="choice"]:last').text("choice : " + num).prop({'id': 'choice' + num});
                    event.preventDefault();
                });
            });
        </script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    </head>
    <body><ul>
            <li><a class="active" href="Exam">Exam</a></li>
            <li><a href="Profile">Profile</a></li>
            <li><a href="CreateQuiz">Create Quiz</a></li>
        </ul>
        <h1>Create question in ${quiz.quizName}</h1>
        <h2>Welcome : ${user.userName}</h2>
        <h3>Your ID : ${user.userId}</h3>
        <h3>Your Email : ${user.email}</h3>
        <hr>
        <form method="get" action="CreateQuestion" class="cloneForm">
            <div class="container">
                <div class="card">
                    <div class="card-header">
                        <h1><input type="text" class="form-control" name="question" placeholder="Enter question here" value="${param.question}" required/></h1>
                    </div>
                    <div class="innerForm1 form-group d-flex " id="innerForm1">
                        <div class="col-sm-3 choice">
                            <p id="choice1">choice : 1</p>
                        </div>
                        <input type="radio"name="answer" value="1"/>
                        <div class="col-sm-6">                        
                            <input type="text" class="form-control" name="choice1" value="${param.choice}" required/>
                        </div>
                    </div>
                    <div class="innerClone"></div>
                    <div class="col-lg-1">
                        <a href="" id="remove">remove</a> 
                        <a href="" id="add">add</a> 
                    </div>
                </div>
                <button type="submit">create question</button>
            </div>
        </form>
        <div class="clone"></div>
        <button><a href="ManageClass?classId=${class.classId}">save</a></button>
        <c:forEach items="${questions}" var="q">
            <div class="container">
                <div class="card">
                    <div class="card-header">
                        <div class="d-flex">
                            <div class="float-right">
                                <button type="button" >
                                    <a href="DeleteQuestion?questionId=${q.questionid}&&quizId=${q.quizid}&&classId=${class.classId}">&times;</a>
                                </button>
                            </div>

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
    </body>
</html>