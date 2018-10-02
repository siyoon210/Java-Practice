package my.examples.board.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCForContent {
    private Map boardContent = new HashMap();

    public Map getBoardContent() {
        return boardContent;
    }

    public void run(int cid){
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection conn =null;
            try {
                conn = 	DriverManager.getConnection("jdbc:mariadb://localhost:3306/Test_db?characterEncoding=utf8","siyoon","1234");
                String sql = "SELECT * FROM board where cid = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                System.out.println("cid : "+cid);
                ps.setInt(1, cid);
                System.out.println("sql : " +sql);
                ResultSet rs = ps.executeQuery(); //실행~!

                while (true) {
                    if(rs.next()){
                        boardContent.put("name",rs.getString(1));
                        boardContent.put("title",rs.getString(2));
                        boardContent.put("content",rs.getString(3));
                        boardContent.put("cid",rs.getInt(4));
                        continue;
                    }
                    break;
                }
                System.out.println(boardContent.get("name"));
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
