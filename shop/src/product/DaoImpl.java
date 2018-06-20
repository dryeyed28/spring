package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;

public class DaoImpl implements Dao {
	private Connection conn;
	private PreparedStatement pstmt = null;
	private DataSource dataSource;

	public DaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void con() {
		// TODO Auto-generated method stub
		conn = DataSourceUtils.getConnection(dataSource);
	}

	public void discon() {
		// TODO Auto-generated method stub
		DataSourceUtils.releaseConnection(conn, dataSource);
	}

	public void insert(Product p) {
		// TODO Auto-generated method stub
		con();

		String sql = "insert into shop_product values"
				+ "(?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p.getNum());
			pstmt.setString(2, p.getName());
			pstmt.setInt(3, p.getQuantity());
			pstmt.setInt(4, p.getPrice());
			pstmt.setString(5, p.getImg());
			pstmt.setString(6, p.getContent());
			pstmt.setString(7, p.getS_id());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		discon();
	}

	public ArrayList<Product> selectAllById(String s_id) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		ArrayList<Product> products = new ArrayList<Product>();
		con();

		String sql = "select * from shop_product where s_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				products.add(new Product(rs.getInt(1), rs.getString(2), rs
						.getInt(3), rs.getInt(4), rs.getString(5), rs
						.getString(6), rs.getString(7), null));
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		discon();
		return products;
	}

	public Product select(int num) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		Product product = null;
		con();

		String sql = "select * from shop_product where num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				product = new Product(rs.getInt(1), rs.getString(2),
						rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), null);
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		discon();
		return product;
	}

	public void update(Product p) {
		// TODO Auto-generated method stub
		con();

		String sql = "update shop_product set name=?, quantity=?,"
				+ " price=?, img=?, content=? where num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getName());
			pstmt.setInt(2, p.getQuantity());
			pstmt.setInt(3, p.getPrice());
			pstmt.setString(4, p.getImg());
			pstmt.setString(5, p.getContent());
			pstmt.setInt(6, p.getNum());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		discon();
	}

	public void delete(int num) {
		// TODO Auto-generated method stub
		String sql = "delete shop_product where num=?";
		con();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int selectNum() {
		// TODO Auto-generated method stub
		String sql = "select seq_shop_product.nextval from dual";
		ResultSet rs = null;
		int num = 0;
		con();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				num = rs.getInt(1);
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		discon();
		return num;
	}

	public ArrayList<Product> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<Product> products = new ArrayList<Product>();
		ResultSet rs = null;
		String sql = "select * from shop_product";
		con();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				products.add(new Product(rs.getInt(1), rs.getString(2), rs
						.getInt(3), rs.getInt(4), rs.getString(5), rs
						.getString(6), rs.getString(7), null));
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		discon();
		return products;
	}

	public void updateQuantity(int q, int num) {
		// TODO Auto-generated method stub
		con();

		String sql = "update shop_product set quantity=quantity-? "
				+ "where num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, q);
			pstmt.setInt(2, num);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		discon();
	}

}
