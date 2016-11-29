package servlets;

/**
 * Created by imac on 29.11.16.
 */
import entities.Student;
import utils.ConnectionPool;

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

    private ConnectionPool connectionPool = ConnectionPool.getInstance();
    private List<Student> students = new LinkedList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from students");
            ResultSet resultSet = statement.executeQuery();
            students.clear();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setGender(resultSet.getString("gender"));
                student.setGroupNumber(resultSet.getString("group_number"));
                students.add(student);
            }
            req.setAttribute("students", students);
            getServletContext().getRequestDispatcher("/students.jsp")
                    .forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}