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
    <title>Term Modifying</title>
    <link rel="stylesheet" href="../../resources/fonts/fonts.css">
    <link rel="stylesheet" type="text/css" href="../../resources/css/style.css">
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
                <div><a href="/home">На главную</a></div>
                <div><a href="/terms">Назад</a></div>
            </div>
            <div class="main">
                <h2>Для модификации семестра отредактируйте данные и нажмите кнопку "Применить".</h2>
                <div class="form_cm">
                    <form action="/term_modifying" method="post">
                        <input type="hidden" name="idTermModify" value="1">
                        <div class="line5">
                            <div>Длительность (в неделях)</div>
                            <label>
                                <input name="duration" type="text" value="24 недели">
                            </label>
                        </div>
                        <div class="line5">
                            <div>Дисциплины в семестре</div>
                            <label>
                                <select multiple="multiple" name="idsDisc">

                                    <option value="1">Высшая математика</option>

                                    <option value="2">История Науки и Техники</option>

                                    <option value="3">Политология</option>

                                    <option value="4">Информатика</option>

                                    <option value="5">Теория Алгоритмизации</option>

                                    <option value="6">Системный Анализ</option>

                                    <option value="7">Управление проектами</option>

                                    <option value="8">Основы Дискретной Математики</option>

                                </select>
                            </label>
                        </div>
                        <input class="button_cm_term" type="submit" value="Применить">
                    </form>
                </div>
            </div>
        </section>
    </main>
</div>
</body>
</html>
