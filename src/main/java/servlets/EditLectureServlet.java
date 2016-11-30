package servlets;

import entities.Lecture;
import entities.Student;
import utils.ConnectionPool;
import utils.LectureDAO;
import utils.StudentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by imac on 29.11.16.
 */
@WebServlet("/editLecture")
public class EditLectureServlet extends HttpServlet {

    private ConnectionPool connectionPool = ConnectionPool.getInstance();
    private int id;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id = Integer.parseInt(req.getParameter("id"));
        Lecture lecture = LectureDAO.getLecture(id);
        req.setAttribute("lecture", lecture);
        getServletContext().getRequestDispatcher("/editLecture.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String topic = req.getParameter("topic");
        String date = req.getParameter("date");

        Lecture lecture = new Lecture();
        lecture.setTopic(topic);
        lecture.setDate(date);
        lecture.setId(id);

        LectureDAO.editLecture(lecture);

        resp.sendRedirect("/lectures");
    }
}
