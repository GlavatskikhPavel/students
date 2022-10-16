package controllers;

import db.DBManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "StudentCreatingController", urlPatterns = "/student_creating")
public class StudentCreatingController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/student_creating.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // заберет то что у нас лежит в поле фамилия и запишет в переменную surname, в верстке name="surname"
        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        String group = req.getParameter("group");
        String stringDate = req.getParameter("date");

        // isEmpty проверяет строку на пустоту
        if (surname.isEmpty() || name.isEmpty() || group.isEmpty() || stringDate.isEmpty()) {
            req.setAttribute("error", "1");
            req.getRequestDispatcher("WEB-INF/jsp/student_creating.jsp").forward(req, resp);
            return;
        }

        // форматирование даты для записи в БД в нужном нам формате
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        Date date;
        try {
            date = format.parse(stringDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateForDB = formatter.format(date);

        int groupId = DBManager.getGroupId(group);
        DBManager.creatingStudent(surname, name, groupId, dateForDB);
        // перенаправим пользователя на страничку со студентами.
        resp.sendRedirect("/students_list");
    }
}
