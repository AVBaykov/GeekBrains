package Lesson_6.Server;

import java.sql.*;

public class AuthService {

    public static String getNickLoginAndPass(String login, String pass) {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:main.db")) {

            String sql = String.format("SELECT nickname FROM users\n" +
                    "WHERE login = '%s'\n" +
                    "AND password = '%s'", login, pass);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                return rs.getString(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
