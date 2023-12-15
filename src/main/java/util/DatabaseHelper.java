package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseHelper {
    private Connection conn = null;
    final static String HOST = "10.100.164.43";
    final static String DB_NAME = "JavaWeb";
    final static String USER_NAME = "root";
    final static String PASSWORD = "123456";

    public DatabaseHelper() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }
    private void open() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://" + HOST + "/" + DB_NAME, USER_NAME, PASSWORD);
    }
    private void close() throws SQLException {
        conn.close();
    }

    public ResultSet query(String sql, Object ... args) throws SQLException {
        open();

        var stmt = conn.prepareStatement(sql);
        for (int i = 0; i < args.length; ++i) {
            stmt.setObject(i+1, args[i]);
        }

        var result = stmt.executeQuery();

        close();
        return result;
    }

    public void update(String sql, Object ... args) throws SQLException {
        open();

        var stmt = conn.prepareStatement(sql);
        for (int i = 0; i < args.length; ++i) {
            stmt.setObject(i+1, args[i]);
        }

        stmt.executeUpdate();

        close();
    }

}
