package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBase {

    private static ConnectionFactory connectionFactory;

    public DataBase(String dbUrl) {
        connectionFactory = () -> DriverManager.getConnection(dbUrl);
    }

    public void initDB() throws SQLException {
        Connection connection = connectionFactory.getConnection();
        PreparedStatement ps = connection.prepareStatement("CREATE TABLE goods (\n" +
                "    id     INTEGER       PRIMARY KEY AUTOINCREMENT\n" +
                "                         NOT NULL,\n" +
                "    prodid INTEGER       NOT NULL\n" +
                "                         UNIQUE,\n" +
                "    title  VARCHAR (100) NOT NULL,\n" +
                "    cost   INTEGER       NOT NULL\n" +
                ");");
        ps.execute();
    }

    public void populateDB() throws SQLException {
        Connection connection = connectionFactory.getConnection();
        connection.prepareStatement("DELETE FROM goods").execute();
        PreparedStatement ps = connection.prepareStatement("INSERT INTO goods (prodid, title, cost) VALUES (?,?,?)");
        connection.setAutoCommit(false);
        for (int i = 0; i < 10000; i++) {
            ps.setInt(1, i);
            ps.setString(2, "товар" + i);
            ps.setInt(3, i*10);
            ps.addBatch();
        }
        ps.executeBatch();
        connection.commit();
    }
}
