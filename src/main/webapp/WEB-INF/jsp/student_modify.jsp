<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Student Modifying</title>
    <link rel="stylesheet" href="../../resources/fonts/fonts.css">
    <link rel="stylesheet" type="text/css" href="../../resources/css/style.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
    <script>
        $(function () {
            $("#datepicker").datepicker();
        });
    </script>
</head>
<body>
<div id="container">
    <header>
        <nav class="head">
            <h1 class="title">Система управления студентами и их успеваемостью</h1>
            <div class="login">

                <div><p>Привет, admin!</p></div>
                <div><a href="/logout">Logout</a></div>

            </div>
        </nav>
    </header>
    <main>
        <section class="content">
            <div class="side_menu">
                <div><a href="/">На главную</a></div>
                <div><a href="students_list">Назад</a></div>
            </div>
            <div class="main">
                <h2>Для модификации, введите новые значения и нажмите кнопку "Применить".</h2>
                <div class="form_cm">
                    <form action="student_modifying" method="post">
                        <!-- value - в этом поле сидит id студента, сервер будет его получать-->
                        <input type="hidden" name="id" value="${student.id}">
                        <div class="line2">
                            <div>Фамилия</div>
                            <label>
                                <input type="text" name="surname" value="${student.surname}">
                            </label>
                        </div>
                        <div class="line2">
                            <div>Имя</div>
                            <label>
                                <input type="text" name="name" value="${student.name}">
                            </label>
                        </div>
                        <div class="line2">
                            <div>Группа</div>
                            <label>
                                <input type="text" name="group" value="${student.group.group}">
                            </label>
                        </div>
                        <div class="line2">
                            <div>Дата поступления</div>
                            <label>
                                <input type="text" name="date" id="datepicker"
                                       value="<fmt:formatDate value="${student.date}" pattern="dd/MM/yyyy"/>">
                            </label>
                        </div>
                        <input class="button_cm_student" type="submit" value="Применить">
                    </form>
                </div>

            </div>
        </section>
    </main>
</div>
</body>
</html>
