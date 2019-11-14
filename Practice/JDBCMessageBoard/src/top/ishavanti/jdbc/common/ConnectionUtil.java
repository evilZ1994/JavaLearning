package top.ishavanti.jdbc.common;

import java.sql.*;

/**
 * 数据库操作公共类
 */
public final class ConnectionUtil {

    private static String url = "jdbc:mysql://localhost:3306/message_board?useSSL=false";

    private static String user = "root";

    private static String password = "cdhzxb2019";

    private ConnectionUtil() {}

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("找不到驱动程序类，加载驱动失败");
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.err.println("创建数据库连接失败");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 释放数据库资源
     */
    public static void release(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
