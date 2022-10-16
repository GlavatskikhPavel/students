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
    <title>Discipline Creating</title>
    <link rel="stylesheet" href="../../resources/fonts/fonts.css?v=3">
    <link rel="stylesheet" type="text/css" href="../../resources/css/style.css?v=3">
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
                <div><a href="disciplines_list">Назад</a></div>
            </div>
            <div class="main">
                <h2>Для того чтобы создать новую дисциплину заполните все поля и нажмите кнопку "Создать":</h2>
                <div class="form_cm">
                    <form action="discipline_creating" method="post">
                        <div class="line3">
                            <div>Название</div>
                            <label>
                                <input type="text" name="discipline">
                            </label>
                        </div>
                        <input class="button_cm_discipline" type="submit" value="Создать">
                    </form>
                </div>
                <c:if test="${error eq 1}">
                    <h4>Поля не должны быть пустыми!</h4>
                </c:if>
            </div>
        </section>
    </main>
</div>
</body>
</html>
