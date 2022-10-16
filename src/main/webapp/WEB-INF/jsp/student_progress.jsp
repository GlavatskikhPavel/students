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
    <title>Student Progress</title>
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
                <div><a href="/students">Назад</a></div>
            </div>
            <div class="main">
                <h2>Отображена успеваемость для следующего студента:</h2>
                <div class="progress">
                    <input type="hidden" name="idStudent" value="1">
                    <table class="list">
                        <tr>
                            <th class="lp_col0">Фамилия</th>
                            <th class="lp_col1">Имя</th>
                            <th class="lp_col2">Группа</th>
                            <th class="lp_col3">Дата поступления</th>
                        </tr>
                        <tr>
                            <td class="lp_col0">Сидоров</td>
                            <td class="lp_col1">Сидор</td>
                            <td class="lp_col2">КТ-21</td>
                            <td class="lp_col3">31/08/2011</td>
                        </tr>
                    </table>
                </div>
                <div class="progress_section">
                    <div class="marks">
                        <table class="list">
                            <tr>
                                <th class="lm_col0">Дисциплина</th>
                                <th class="lm_col1">Оценка</th>
                            </tr>

                            <tr>
                                <td class="lm_col0">Высшая математика</td>
                                <td class="lm_col1">4</td>
                            </tr>

                            <tr>
                                <td class="lm_col0">История Науки и Техники</td>
                                <td class="lm_col1">2</td>
                            </tr>

                            <tr>
                                <td class="lm_col0">Политология</td>
                                <td class="lm_col1">4</td>
                            </tr>

                            <tr>
                                <td class="lm_col0">Информатика</td>
                                <td class="lm_col1">4</td>
                            </tr>

                            <tr>
                                <td class="lm_col0">Теория Алгоритмизации</td>
                                <td class="lm_col1">3</td>
                            </tr>
                        </table>
                    </div>
                    <div class="term_average_mark">
                        <div class="term">
                            Выбрать семестр
                            <form action="/student_progress" method="get">
                                <label>
                                    <input type="hidden" name="progressHidden" value="1">
                                    <select name="idSelectedTerm">
                                        <option selected value="1">Семестр 1</option>
                                        <option value="2">Семестр 2</option>
                                        <option value="3">Семестр 3</option>

                                    </select>
                                </label>
                                <input class="button_term" type="submit" value="Выбрать">
                            </form>
                        </div>
                        <div class="average_mark">
                            Средняя оценка за семестр:
                            <h3>3,40 балла</h3>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>
</div>
</body>
</html>
