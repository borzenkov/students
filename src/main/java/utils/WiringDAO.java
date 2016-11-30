package utils;

import entities.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by imac on 29.11.16.
 */
public class WiringDAO {

    private static ConnectionPool connectionPool = ConnectionPool.getInstance();

    public static void wire(int studentId, int lectureId) {
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select count(*) from wiring where lecture_id = ? and student_id = ?");
            statement.setInt(1, lectureId);
            statement.setInt(2, studentId);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int total = resultSet.getInt("total");

            if (total == 0) {
                PreparedStatement statement1 = connection.prepareStatement("insert into wiring (lecture_id, student_id) values (?, ?)");
                statement1.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getVisitsNumber(int studentId) {
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select count(*) as total from wiring where student_id = ?");
            statement.setInt(1, studentId);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("total");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
