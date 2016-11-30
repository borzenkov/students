package servlets;

import entities.Lecture;
import utils.LectureDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by imac on 29.11.16.
 */
@WebServlet("/addLecture")
public class AddLectureServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String topic = req.getParameter("topic");
        String date = req.getParameter("date");

        Lecture lecture = new Lecture();
        lecture.setTopic(topic);
        lecture.setDate(date);

        LectureDAO.addLecture(lecture);

        resp.sendRedirect("/lectures");
    }
}
