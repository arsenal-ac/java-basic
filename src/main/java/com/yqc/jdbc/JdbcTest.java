package com.yqc.jdbc;

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
