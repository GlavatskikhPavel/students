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
    <title>Title page</title>
    <link rel="stylesheet" href="resources/fonts/fonts.css?v=1">
    <link rel="stylesheet" type="text/css" href="resources/css/style.css?v=1">
</head>
<body>
<div id="container">
    <header>
        <nav class="head">
            <h1 class="title">Система управления студентами и их успеваемостью</h1>
            <div class="login">

                <c:choose>
                    <c:when test="${isLogin eq true}">
                        <div><a href="/logout">Logout</a></div>
                    </c:when>
                    <c:otherwise>
                        <div><a href="login">Login</a></div>
                    </c:otherwise>
                </c:choose>
            </div>
        </nav>
    </header>
    <main>
        <section class="menu_title">
            <a href="students_list">Студенты</a>
            <a href="disciplines_list">Дисциплины</a>
            <a href="/terms_list">Семестры</a>
        </section>
    </main>
</div>
</body>
</html>
