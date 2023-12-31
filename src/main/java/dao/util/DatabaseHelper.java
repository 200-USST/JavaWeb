package dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {
    private Connection conn = null;
    final static String HOST = "10.100.164.43";
    final static String DB_NAME = "JavaWeb";
    final static String USER_NAME = "root";
    final static String PASSWORD = "123456";

    public DatabaseHelper() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void open() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + HOST + "/" + DB_NAME, USER_NAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void close() {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<List<Object>> query(String sql, Object ... args) {
        try {
            open();

            var stmt = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; ++i) {
                stmt.setObject(i + 1, args[i]);
            }

            var res = stmt.executeQuery();
            var meta = res.getMetaData();

            List<List<Object>> result = new ArrayList<>();
            while (res.next()) {
                List<Object> row = new ArrayList<>();
                for (int i = 1; i <= meta.getColumnCount(); ++i) {
                    row.add(res.getObject(i));
                }
                result.add(row);
            }

            close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(String sql, Object ... args) {
        try {
            open();

            var stmt = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; ++i) {
                stmt.setObject(i + 1, args[i]);
            }

            stmt.executeUpdate();

            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
