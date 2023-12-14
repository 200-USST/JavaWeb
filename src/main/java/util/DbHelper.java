package util;

import java.sql.*;
import java.util.*;

// DbHelper类
public class DbHelper {
    private Connection connection = null;
    final static String HOST = "10.100.164.43";
    final static String DB_NAME = "JavaWeb";
    final static String USER_NAME = "root";
    final static String PASSWORD = "123456";

    private void initConn() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + HOST + "/" + DB_NAME, USER_NAME, PASSWORD);
        }
    }

    //
    public static List<Map<String,Object>> Query(String sql, Object... params){
        Connection connection =null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Map<String,Object>> list = new ArrayList<>();

        try {
            connection = getConn();
            statement = connection.prepareStatement(sql);
            setParams(statement,params);//调用方法绑定参数
            resultSet = statement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            while (resultSet.next()) { //逐行读取，next()：移动指针到 下一行，判断是否读到数据，一次读取一行
                Map<String, Object> rowMap = new HashMap<>(); //代表一行
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
//                    getColumnLabel():获取列的别名，如果没有就获取列名
                    rowMap.put(resultSetMetaData.getColumnLabel(i), resultSet.getObject(i) == null ? " " : resultSet.getObject(i));
                }
                list.add(rowMap);//填充list
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(connection, statement, resultSet);//调用关闭方法
        }
        return list;
    }


    // 关闭方法
    private static void closeAll(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //    更新操作
    public static boolean update(String sql, Object... params) {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean result = false;
        try {
            connection = getConn();
            statement = connection.prepareStatement(sql);//预编译
            setParams(statement, params);//调用方法绑定参数
            int n = statement.executeUpdate();
            if (n > 0) {
                result = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeAll(connection, statement, null);
        }
        return result;
    }

    //    设置参数
    private static void setParams(PreparedStatement statement,Object[] params) throws SQLException {
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
        }

    }
}
