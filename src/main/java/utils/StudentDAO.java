package utils;

/**
 * Created by imac on 29.11.16.
 */
import entities.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by imac on 28.11.16.
 */
public class StudentDAO {

    private static ConnectionPool connectionPool = ConnectionPool.getInstance();

    public static Student getStudent(int id) {
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from students where id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setGender(resultSet.getString("gender"));
                student.setGroupNumber(resultSet.getString("group_number"));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}