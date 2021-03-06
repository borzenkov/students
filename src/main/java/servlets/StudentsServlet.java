package servlets;

/**
 * Created by imac on 29.11.16.
 */
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by vic on 24.11.16.
 */
@WebServlet("/students")
public class StudentsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = StudentDAO.getStudents();
        req.setAttribute("students", students);
        getServletContext().getRequestDispatcher("/students.jsp")
                .forward(req, resp);
    }
}