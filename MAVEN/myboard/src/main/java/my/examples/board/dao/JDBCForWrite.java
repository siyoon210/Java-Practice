package my.examples.board.dao;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class JDBCForWrite {
    private List<Map> boardList;

    public List<Map> getBoardList() {
        return boardList;
    }

    public void run(String sql){
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection conn =null;
            try {
                conn = 	DriverManager.getConnection("jdbc:mariadb://localhost:3306/Test_db?characterEncoding=utf8","siyoon","1234");
                System.out.println(sql);
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.executeUpdate(); //실행~

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
