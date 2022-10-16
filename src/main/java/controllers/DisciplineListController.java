package controllers;

import db.DBManager;
import entity.Discipline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DisciplineListController", urlPatterns = "/disciplines_list")
public class DisciplineListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Discipline> disciplines = DBManager.getAllActiveDiscipline();
        req.setAttribute("disciplines", disciplines);
        req.getRequestDispatcher("WEB-INF/jsp/disciplines_list.jsp").forward(req, resp);
    }
}
