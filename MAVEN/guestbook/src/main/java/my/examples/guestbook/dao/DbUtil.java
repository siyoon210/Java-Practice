package my.examples.guestbook.dao;


import java.sql.*;

public class DbUtil {
    public static Connection connect(String dbUrl, String dbId, String dbPassword)
            throws RuntimeException{
        Connection conn = null;
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl, dbId, dbPassword);
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
        return conn;
    }
    // insert, update, delete
    public static void close(Connection conn, PreparedStatement ps){
        if(ps != null){
            try {
                ps.close();
            }catch(SQLException ex){
                //
            }
        }
        if(conn != null){
            try {
                conn.close();
            }catch(SQLException ex){
                //
            }
        }
    } // close
    public static void close(Connection conn, PreparedStatement ps, ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            }catch(SQLException ex){
                //
            }
        }
        close(conn, ps);
    } // close
}

