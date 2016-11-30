package servlets;

import utils.LectureDAO;
import utils.StudentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by imac on 29.11.16.
 */
@WebServlet("/deleteLecture")
public class DeleteLectureServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        LectureDAO.deleteLecture(id);
        resp.sendRedirect("/lectures");
    }
}
