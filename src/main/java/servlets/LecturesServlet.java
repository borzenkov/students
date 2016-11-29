package servlets;

/**
 * Created by imac on 29.11.16.
 */
import entities.Lecture;
import utils.LectureDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by vic on 29.11.16.
 */
@WebServlet("/lectures")
public class LecturesServlet extends HttpServlet  {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Lecture> lectures = LectureDAO.getLectures();
        req.setAttribute("lectures", lectures);
        getServletContext().getRequestDispatcher("/lectures.jsp")
                .forward(req, resp);
    }
}