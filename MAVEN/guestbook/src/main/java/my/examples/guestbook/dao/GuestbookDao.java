package my.examples.guestbook.dao;

import my.examples.guestbook.servlet.Guestbook;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class GuestbookDao {
    private String dbUrl = "jdbc:mariadb://localhost:3306/Test_db";
    private String dbId = "siyoon";
    private String dbPassword = "1234";
    public List<Guestbook> getGuestbookList(){
        List<Guestbook> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = DbUtil.connect(dbUrl, dbId, dbPassword);
            String sql = "select id, name, content, regdate from guestbook order by id desc";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Guestbook guestbook = new Guestbook();
                guestbook.setId(rs.getLong(1));
                guestbook.setName(rs.getString(2));
                guestbook.setContent(rs.getString(3));
                Date dbDate = rs.getDate(4); // java.sql.Date
                java.util.Date date = new java.util.Date(dbDate.getTime()); // java.util.Date로 변환
                LocalDateTime ldt = date.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime();
                guestbook.setRegate(ldt);

                guestbook.setRegate(ldt);
                list.add(guestbook);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            DbUtil.close(conn, ps, rs);
        }
        return list;
    }
    public int addGuestbook(Guestbook guestbook){
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DbUtil.connect(dbUrl, dbId, dbPassword);
            String sql = "insert into guestbook (id, name, content, regdate)\n" +
                    "values (null, ?, ?, now())";
            ps = conn.prepareStatement(sql);
            ps.setString(1, guestbook.getName());
            ps.setString(2, guestbook.getContent());
            count = ps.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            DbUtil.close(conn, ps);
        }
        return count;
    }
    public int deleteGuestbook(Long id){
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DbUtil.connect(dbUrl, dbId, dbPassword);
            String sql = "delete from guestbook where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            count = ps.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            DbUtil.close(conn, ps);
        }
        return count;
    }
}