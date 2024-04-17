package daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.CartDao;
import model.Cart;
import util.DBUtils;

public class CartDaoImpl implements CartDao{
	
	private Connection conn;
	private PreparedStatement pstm;
	private Statement stm;
	private ResultSet rs;

	@Override
	public List<Cart> queryAll() {
		List<Cart> carts = new ArrayList<>();
		try {
			conn=DBUtils.getConnection();
			stm = conn.createStatement();
			String sql="select c.id,bid,uid,num,time,name,imgUrl,price,nickname from cart c,book b,user u "
					+ "where c.bid = b.id and c.uid = u.id ";
			rs=stm.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				int bid = rs.getInt("bid");
				int uid = rs.getInt("uid");
				int num = rs.getInt("num");
				Date time = rs.getDate("time");
				String name = rs.getString("name");
				String imgUrl = rs.getString("imgUrl");
				float price = rs.getFloat("price");
				String nickname = rs.getString("nickname");
				carts.add(new Cart(id, bid, uid, num, time, name, imgUrl, price,nickname));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return carts;
	}

	@Override
	public List<Cart> queryByUid(int uid) {
		List<Cart> carts = new ArrayList<>();
		try {
			conn=DBUtils.getConnection();
			String sql="select c.id,bid,uid,num,time,name,imgUrl,price from cart c,book b "
					+ "where c.bid = b.id and c.uid = ? ";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, uid);
			rs = pstm.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				int bid = rs.getInt("bid");
				int uid2 = rs.getInt("uid");
				int num = rs.getInt("num");
				Date time = rs.getDate("time");
				String name = rs.getString("name");
				String imgUrl = rs.getString("imgUrl");
				float price = rs.getFloat("price");
				carts.add(new Cart(id, bid, uid2, num, time, name, imgUrl, price));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return carts;
	}

	@Override
	public boolean add(Cart cart) {
		try {
			conn = DBUtils.getConnection();
			String sql="insert into cart(bid,uid,num,time) values(?,?,?,?)";
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, cart.getBid());
			pstm.setInt(2, cart.getUid());
			pstm.setInt(3, cart.getNum());
			pstm.setDate(4, cart.getTime());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	try {
		return pstm.executeUpdate()>0;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
	}

	@Override
	public boolean update(boolean add, int id) {
		try {
			conn = DBUtils.getConnection();
			String sql="";
			if(add) {
				sql="update cart set num = num + 1 where id = ?";
			}else {
				sql="update cart set num = num - 1 where id = ?";
			}
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	try {
		return pstm.executeUpdate()>0;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
	}

	@Override
	public int total(int uid) {
		int total = 0;
		try {
			conn=DBUtils.getConnection();
			String sql="select sum(num*price) total from cart c,book b where c.bid = b.id and c.uid = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, uid);
			rs=pstm.executeQuery();
			while(rs.next()) {
				total = rs.getInt("total");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}

	@Override
	public boolean del(int id) {
		try {
			conn = DBUtils.getConnection();
			String sql="delete from cart where id = ?";
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	try {
		return pstm.executeUpdate()>0;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
	}

	@Override
	public int getNumById(int id) {
		int num = 0;
		try {
			conn=DBUtils.getConnection();
			String sql="select num from cart where id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			while(rs.next()) {
				num = rs.getInt("num");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
}
