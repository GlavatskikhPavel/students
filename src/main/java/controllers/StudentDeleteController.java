package controllers;

import db.DBManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentDeleteController", urlPatterns = "/student_deleting")
public class StudentDeleteController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ids = name="deleteHidden"
        String ids = req.getParameter("deleteHidden");
        String[] idsArray = ids.split(" ");
        DBManager.deleteStudents(idsArray);
        resp.sendRedirect("/students_list");
    }
}
