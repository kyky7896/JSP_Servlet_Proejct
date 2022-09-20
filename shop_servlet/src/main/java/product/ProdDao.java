package product;

import conn.MysqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdDao {

    private MysqlConnect dbconn;

    public ProdDao(){
        dbconn = MysqlConnect.getInstance();

    }
    //상품 등록
    public void insert(Product p){
        Connection conn = dbconn.getConn();

        String sql = "insert into product(name, info, price, amount, seller, img1) values(?,?,?,?,?,?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, p.getName());
            pstmt.setString(2, p.getInfo());
            pstmt.setInt(3, p.getPrice());
            pstmt.setInt(4, p.getAmount());
            pstmt.setString(5, p.getSeller());
            pstmt.setString(6,p.getImg1());

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



    //내 등록 상품 목록. 구매자쪽의 판매자로 상품 검색
    public ArrayList<Product> selectBySeller(String seller){

        ArrayList<Product> list = new ArrayList<Product>();
        ResultSet rs = null;
        Connection conn = dbconn.getConn();

        String sql = "select * from product where seller=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, seller);
            System.out.println("selectBySeller"+pstmt);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),rs.getString(6),rs.getString(7)));
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
        return list;
    }
    //수정(상품 이름, 설명, 가격, 수량)
    public void update(Product p){
        Connection conn = dbconn.getConn();
        String sql = "update product set name=?,info=?,price=?,amount=? where num=?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, p.getName());
            pstmt.setString(2, p.getInfo());
            pstmt.setInt(3, p.getPrice());
            pstmt.setInt(4,p.getAmount());
            pstmt.setInt(5,p.getNum());

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

    public void updateAmount(int num, int amount) {// amount:추가될양. +입고 / -출고
        Connection conn = dbconn.getConn();
        String sql = "update product set amount=amount+? where num=?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, amount);
            pstmt.setInt(2, num);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    //삭제
    public void delete(int num){
        Connection conn = dbconn.getConn();
        String sql = "delete from product where num=?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);

            int cnt = pstmt.executeUpdate();
            if (cnt > 0) {
                System.out.println("삭제 성공");
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

    }
    //상품 번호로 검색
    public Product selectByNum(int num){
        Product p=null;
        ResultSet rs = null;
        Connection conn = dbconn.getConn();

        String sql = "select * from product where num=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                p=new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),rs.getString(6),rs.getString(7));
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
        return p;
    }
    //상품 명으로 검색
    public ArrayList<Product> selectByName(String name){
        ArrayList<Product> list = new ArrayList<Product>();
        ResultSet rs = null;
        Connection conn = dbconn.getConn();

        String sql = "select * from product where name like ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, "%"+name+"%");
            System.out.println(pstmt);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),rs.getString(6),rs.getString(7)));
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
        System.out.println("prodDao.selbyname"+list);
        return list;
    } //like문자열 패턴 검색

    //가격대로 검색
    public ArrayList<Product> selectByPrice(int price1,int price2){
        ArrayList<Product> list = new ArrayList<Product>();
        ResultSet rs = null;
        Connection conn = dbconn.getConn();

        String sql = "select * from product where price between ? and ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, price1);
            pstmt.setInt(2,price2);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),rs.getString(6),rs.getString(7)));
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
        return list;
    } //between a and b
    //전체검색
    public ArrayList<Product> selectAll(){
        ArrayList<Product> list = new ArrayList<Product>();
        ResultSet rs = null;
        Connection conn = dbconn.getConn();

        String sql = "select * from product";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),rs.getString(6),rs.getString(7)));
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
        return list;
    }

    //가장 최근에 등록된 상품번호의 +1
    public int makeNum() {
        ResultSet rs = null;
        Connection conn = dbconn.getConn();
        String sql = "select MAX(num)+1 from product";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();// 검색한 결과를 ResultSet으로 반환
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return -1;
    }
}
