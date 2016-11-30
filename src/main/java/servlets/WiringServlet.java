package servlets;

import entities.Lecture;
import entities.Student;
import utils.LectureDAO;
import utils.StudentDAO;
import utils.WiringDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by imac on 29.11.16.
 */
@WebServlet("/wiring")
public class WiringServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = StudentDAO.getStudents();
        req.setAttribute("students", students);

        List<Lecture> lectures = LectureDAO.getLectures();
        req.setAttribute("lectures", lectures);

        getServletContext().getRequestDispatcher("/wiring.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int studentId = Integer.parseInt(req.getParameter("student"));
        int lectureId = Integer.parseInt(req.getParameter("lecture"));

        WiringDAO.wire(studentId, lectureId);
        resp.sendRedirect("/wiring");
    }
}
