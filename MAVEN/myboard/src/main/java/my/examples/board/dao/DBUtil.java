package my.examples.board.dao;

import java.sql.*;

public class DBUtil {
    public static Connection connect (String dbUrl, String dbId, String dbPassword) {

        Connection conn = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            try {
                conn = DriverManager.getConnection(dbUrl, dbId, dbPassword);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void close(Connection conn, PreparedStatement ps){
        try {
            ps.close(); //먼저 연것을 나중에 닫는다.
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection conn, PreparedStatement ps, ResultSet rs){

        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(conn,ps);
    }
}
