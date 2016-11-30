package servlets;

/**
 * Created by imac on 29.11.16.
 */
import entities.Student;
import utils.ConnectionPool;
import utils.StudentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by vic on 25.11.16.
 */
@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String group_number = req.getParameter("group_number");

        Student student = new Student();
        student.setName(name);
        student.setGender(gender);
        student.setGroupNumber(group_number);

        StudentDAO.addStudent(student);

        resp.sendRedirect("/students");
    }
}
