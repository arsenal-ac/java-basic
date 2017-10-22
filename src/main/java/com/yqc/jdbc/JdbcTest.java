package com.yqc.jdbc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author yangqc
 * @Date 2017/7/23
 */
public class JdbcTest {

    static String seq;

    static {
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < 4999; i++) {
            sb.append("c");
        }
        seq = sb.toString();
    }

    /**
     * 获取数据库链接
     *
     * @return
     */
    private static Connection getConnection() {
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://192.168.10.15:1433;DatabaseName=kettle_test";
        String username = "sa";
        String password = "mssql@2017";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    private static void insert(List<ModelClass> list, String tableName) {
        Connection conn = getConnection();
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int i = 0;
        String sql = String.format("insert into %s (id,name,address,time) values(?,?,?,?)", tableName);
        System.out.println(sql);
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            for (ModelClass modelClass : list) {
                pstmt.setInt(1, modelClass.getId());
                pstmt.setString(2, modelClass.getName());
                pstmt.setString(3, modelClass.getAddress());
                pstmt.setDate(4, new java.sql.Date(modelClass.getTime().getTime()));
                pstmt.addBatch();
                i++;
                if (i / 500 == 0) {
                    pstmt.executeBatch();
                    pstmt.clearBatch();//积攒的清楚掉
//                        System.out.println("提交");
                }
            }
            pstmt.executeBatch();
            pstmt.close();
            conn.commit();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static List<ModelClass> getAll(String tableName) {
        Connection conn = getConnection();
        String sql = String.format("select * from %s", tableName);
        PreparedStatement ps;
        List<ModelClass> resultList = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int col = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Object value;
                ModelClass modelClass = new ModelClass();
                for (int i = 1; i <= col; i++) {
                    String columnName = rs.getMetaData().getColumnName(i);
                    String methodName = "set" + firstCharToUpperCase(columnName);
                    Method method = modelClass.getClass().getMethod(methodName, modelClass.getClass().getDeclaredField(columnName).getType());
                    if (columnName.equals("time")) {
                        value = rs.getDate(i);
                        method.invoke(modelClass, (Date) value);
                    } else if (columnName.equals("id")) {
                        value = rs.getInt(i);
                        method.invoke(modelClass, (Integer) value);
                    } else {
                        value = rs.getString(i);
                        method.invoke(modelClass, (String) value);
                    }
                }
                resultList.add(modelClass);
            }
        } catch (SQLException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public static String firstCharToUpperCase(String str) {
        char[] chars = str.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }

    public static String generateSeq() {
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < 49998; i++) {
            sb.append("c");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String table = "t_user";
        List<ModelClass> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            ModelClass modelClass = new ModelClass();
            modelClass.setId(i);
            modelClass.setAddress("address" + i);
            modelClass.setTime(new java.util.Date());
            modelClass.setName(seq);
            list.add(modelClass);
        }
        insert(list, table);
    }
}
