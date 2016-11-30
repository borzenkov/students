package utils;

/**
 * Created by imac on 29.11.16.
 */
import entities.Lecture;
import entities.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by vic on 29.11.16.
 */
public class LectureDAO {

    private static ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static List<Lecture> lectures = new LinkedList<>();

    public static void addLecture(Lecture lecture) {
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("insert into lectures (topic, date) values (?, ?)");
            statement.setString(1, lecture.getTopic());
            statement.setString(2, lecture.getDate());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void editLecture(Lecture lecture) {
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("update lectures set topic = ?, date = ? where id = ?");
            statement.setString(1, lecture.getTopic());
            statement.setString(2, lecture.getDate());
            statement.setInt(3, lecture.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Lecture getLecture(int id) {
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from lectures where id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Lecture lecture = new Lecture();
                lecture.setId(resultSet.getInt("id"));
                lecture.setTopic(resultSet.getString("topic"));
                lecture.setDate(resultSet.getString("date"));
                return lecture;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Lecture> getLectures() {
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from lectures");
            ResultSet resultSet = statement.executeQuery();
            lectures.clear();
            while (resultSet.next()) {
                Lecture lecture = new Lecture();
                lecture.setId(resultSet.getInt("id"));
                lecture.setTopic(resultSet.getString("topic"));
                lecture.setDate(resultSet.getString("date"));
                lectures.add(lecture);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lectures;
    }

    public static void deleteLecture(int id) {
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM lectures WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}