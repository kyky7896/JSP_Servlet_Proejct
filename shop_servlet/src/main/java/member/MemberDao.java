package member;

import conn.MysqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDao {
    private MysqlConnect dbconn;

    public MemberDao(){
        dbconn = MysqlConnect.getInstance();

    }

    //memberinsert
    public void insert(Member m){
        Connection conn = dbconn.getConn();

        String sql = "insert into member(id,pwd,mem_type,tel,addr) values(?,?,?,?,?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, m.getId());
            pstmt.setString(2, m.getPwd());
            pstmt.setBoolean(3, m.isMem_type());
            pstmt.setString(4, m.getTel());
            pstmt.setString(5,m.getAddr());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



    }
    public Member select(String id){
        Member m = null;
        ResultSet rs = null;

        Connection conn = dbconn.getConn();
        String sql = "select * from member where id=?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                m=new Member((rs.getString(1)), rs.getString(2), rs.getBoolean(3), rs.getString(4),rs.getString(5));
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
        return m;
    }

    public void update(Member m){
        Connection conn = dbconn.getConn();

        String sql="update member set pwd=?,addr=?,tel=? where id=?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, m.getPwd());
            pstmt.setString(2, m.getAddr());
            pstmt.setString(3, m.getTel());
            pstmt.setString(4,m.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(String id){
        Connection conn = dbconn.getConn();
        String sql = "delete from member where id=?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);

            int cnt = pstmt.executeUpdate();
            if (cnt > 0) {
                System.out.println("delete 완료");
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
        System.out.println("delete 실패");
    }
}
