package controllers;

import db.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DisciplinesDeleteController", urlPatterns = "/discipline_deleting")
public class DisciplinesDeleteController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ids = name="deleteHidden"
        String ids = req.getParameter("deleteHidden");
        String[] idsArray = ids.split(" ");
        DBManager.deleteDisciplines(idsArray);
        resp.sendRedirect("/disciplines_list");
    }
}
