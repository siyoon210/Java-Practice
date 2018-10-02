package my.examples.board.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCForList {
    private List<Map> boardList;

    public List<Map> getBoardList() {
        return boardList;
    }

    public void run(){
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection conn =null;
            try {
                conn = 	DriverManager.getConnection("jdbc:mariadb://localhost:3306/Test_db?characterEncoding=utf8","siyoon","1234");
//                String sql = "SELECT * FROM board where role_id = ?";
                String sql = "SELECT * FROM board";
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery(); //실행~!

                boardList = new ArrayList<>();

                while (true) {
                    if(rs.next()){
                        Map boardContent = new HashMap();

                        boardContent.put("name",rs.getString(1));
                        boardContent.put("title",rs.getString(2));
                        boardContent.put("content",rs.getString(3));
                        boardContent.put("cid",rs.getInt(4));
                        boardList.add(boardContent);
                        continue;
                    }
                    break;
                }
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
