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
    <title>Login page</title>
    <link rel="stylesheet" href="../../resources/fonts/fonts.css?v=1">
    <link rel="stylesheet" type="text/css" href="../../resources/css/style.css?v=1">
</head>
<body>
<div id="container">
    <header>
        <h1>Система управления студентами и их успеваемостью</h1>
    </header>
    <main>
        <section class="form_log">
            <h2 class="log_title">Вход в систему</h2>
            <form action="login" method="post">
                <div class="line">
                    <div>Логин</div>
                    <label>
                        <input type="text" name="login">
                    </label>
                </div>
                <div class="line">
                    <div>Пароль</div>
                    <label>
                        <input type="text" name="password">
                    </label>
                </div>
                <div class="line">
                    <div>Права</div>
                    <label>
                        <select name="role">
                            <option value="3">Студент</option>
                            <option value="2">Учитель</option>
                            <option value="1">Администратор</option>
                        </select>
                    </label>
                </div>
                <input class="button_enter" type="submit" value="Войти">
            </form>
        </section>
    </main>
    <h4>Права "Администратор", "Учитель", "Студент" - Login: admin, Password: 123</h4>
    <h4>Права "Учитель", "Студент" - Login: teacher, Password: 123</h4>
    <h4>Права "Студент" - Login: student, Password: 123</h4>
</div>
</body>
