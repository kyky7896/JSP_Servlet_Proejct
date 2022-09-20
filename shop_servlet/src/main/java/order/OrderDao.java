package order;

import conn.MysqlConnect;
import product.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDao {
	private MysqlConnect dbconn;

	public OrderDao(){
		dbconn = MysqlConnect.getInstance();

	}

	public void insert(Order o) {
		Connection conn = dbconn.getConn();

		String sql = "insert into sh_order(num, prod_num, amount, payment, w_date, consumer, addr, ispay, price) values(?,?,?,?,now(),?,?,?,?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, o.getNum());
			pstmt.setInt(2, o.getProd_num());
			pstmt.setInt(3, o.getAmount());
			pstmt.setInt(4, o.getPayment());
			pstmt.setString(5, o.getConsumer());
			pstmt.setString(6,o.getAddr());
			pstmt.setBoolean(7,o.isIspay());
			pstmt.setInt(8,o.getPrice());

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

	//구매자별 구매목록 검색
	public ArrayList<Order> selectByConsumer(String consumer){

		ArrayList<Order> list = new ArrayList<Order>();
		ResultSet rs = null;
		Connection conn = dbconn.getConn();

		String sql = "select * from sh_order where consumer=? and ispay=true";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, consumer);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5),rs.getString(6),rs.getString(7),rs.getBoolean(8),rs.getInt(9)));
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

	//ispay:true(결제한주문만검색), ispay:false(결제대상. 취소대상 검색)
	public ArrayList<Order> selectByPay(boolean pay,String consumer){
		ArrayList<Order> list = new ArrayList<Order>();
		ResultSet rs = null;
		Connection conn = dbconn.getConn();

		String sql = "select * from sh_order where ispay=? and consumer=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setBoolean(1, pay);
			pstmt.setString(2,consumer);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5),rs.getString(6),rs.getString(7),rs.getBoolean(8),rs.getInt(9)));
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

	//(결제안된것만)주문 번호 기준으로 주문수량 수정
	public void update(Order o) {
		Connection conn = dbconn.getConn();
		String sql = "update sh_order set amount=? where ispay=false and num=?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, o.getAmount());
			pstmt.setInt(2, o.getNum());
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

	//(결제안된것만)결제. ispay와 address, 결제날짜 수정
	public void updatePay(int num,String addr) {
		Connection conn = dbconn.getConn();
		String sql = "update sh_order set ispay=true, addr=?, w_date=now() where num=? and ispay=false";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,addr);
			pstmt.setInt(2,num);
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

	//주문취소
	public void delete(int num,Boolean ispay) {
		Connection conn = dbconn.getConn();
		String sql = "delete from sh_order where num=? and ispay=?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,num);
			pstmt.setBoolean(2,ispay);
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

	//주문 상세 내용
	public Order select(int num) {
		Order o=null;
		ResultSet rs = null;
		Connection conn = dbconn.getConn();

		String sql = "select * from sh_order where num=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1,num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				o=new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5),rs.getString(6),rs.getString(7),rs.getBoolean(8),rs.getInt(9));
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
		return o;
	}
	

}
