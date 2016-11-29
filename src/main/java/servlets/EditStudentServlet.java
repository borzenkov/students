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
import java.io.StreamCorruptedException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by vic on 28.11.16.
 */
@WebServlet("/editStudent")
public class EditStudentServlet extends HttpServlet {

    private ConnectionPool connectionPool = ConnectionPool.getInstance();
    private int id;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id = Integer.parseInt(req.getParameter("id"));
        Student student = StudentDAO.getStudent(id);
        req.setAttribute("student", student);
        getServletContext().getRequestDispatcher("/editStudent.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String group_number = req.getParameter("group_number");

        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE students SET name = ?, gender = ?, group_number = ? WHERE id = ?");
            statement.setString(1, name);
            statement.setString(2, gender);
            statement.setString(3, group_number);
            statement.setInt(4, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("/students");
    }
}
