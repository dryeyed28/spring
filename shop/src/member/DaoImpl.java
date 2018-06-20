package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;

public class DaoImpl implements Dao {
	
	private Connection conn;
	private PreparedStatement pstmt = null;
	private DataSource dataSource;
	
	
	public DaoImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	public void con() {
		conn = DataSourceUtils.getConnection(dataSource);
	}
	
	public void discon() {
		try {
			DataSourceUtils.releaseConnection(conn, dataSource);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public void insert(Member m) {
		con();
		String sql = "insert into shop_member values(?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getAddr());
			pstmt.setInt(6, m.getType());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		discon();
	}

	@Override
	public Member select(String id) {
		con();
		String sql = "select * from shop_member where id=?";
		ResultSet rs = null;
		Member m = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				m = new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		discon();
		return m;
	}

	@Override
	public void update(Member m) {
		con();
		String sql = "update shop_member set pwd=?, email=?, addr=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getPwd());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getAddr());
			pstmt.setString(4, m.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		discon();
	}

	@Override
	public void delete(String id) {
		con();
		String sql = "delete shop_member where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		discon();
	}

}
