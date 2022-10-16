package controllers;

import db.DBManager;
import entity.Student;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentsListController", urlPatterns = "/students_list")
public class StudentsListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = DBManager.getAllActiveStudent();
        // отправляем коллекцию на страничку, название атрибута, сама коллекция
        req.setAttribute("students", students);
        req.getRequestDispatcher("WEB-INF/jsp/students_list.jsp").forward(req, resp);
    }
}
