package my.examples.board.dao;

import my.examples.board.servlet.BoardArticle;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BoardDao {
    private String dbUrl = "jdbc:mariadb://localhost:3306/Test_db";
    private String dbId = "siyoon";
    private String dbPassword = "1234";
    private List<BoardArticle> boardList;

    public List<BoardArticle> getBoardList(){

        boardList = new ArrayList<>();
        Connection conn = DBUtil.connect(dbUrl,dbId,dbPassword);
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM board";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                BoardArticle boardArticle = new BoardArticle();
                boardArticle.setName(rs.getString(1));
                boardArticle.setTitle(rs.getString(2));
                boardArticle.setContent(rs.getString(3));
                boardArticle.setCid(rs.getLong(4));

                java.util.Date date = new java.util.Date(rs.getDate(5).getTime()); // java.util.Date로 변환
                LocalDateTime ldt = date.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime();

                boardArticle.setDate(ldt);

                boardList.add(boardArticle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,rs);
        }
        return boardList;
    }

    public int addBoardArticle(BoardArticle boardArticle){
        int count=0;

        Connection conn = DBUtil.connect(dbUrl,dbId,dbPassword);
        PreparedStatement ps = null;
        String sql = "INSERT INTO board (name, title, content, date) VALUES (?, ?, ?, ?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, boardArticle.getName());
            ps.setString(2, boardArticle.getTitle());
            ps.setString(3, boardArticle.getContent());

            LocalDateTime ldt = boardArticle.getDate();
            java.sql.Date date = java.sql.Date.valueOf(ldt.toLocalDate());

            ps.setDate(4, date);

            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps);
        }
        return count;
    }
    public int deleteBoardARticle(int cid){
        int count =0;
        Connection conn = DBUtil.connect(dbUrl,dbId,dbPassword);
        PreparedStatement ps = null;
        String sql = "DELETE FROM board WHERE cid=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setLong(1,cid);

            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }
}
