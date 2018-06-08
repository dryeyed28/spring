package jdbcTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class DaoImpl implements Dao {
	private Connection conn;
	private PreparedStatement pstmt = null;
	private DataSource dataSource;
	
	public DaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void con() {
		conn = DataSourceUtils.getConnction(dataSource);
	}
	
	public void discon() {
		DataSourceUtils.releaseConnection(conn, dataSource);
	}
	
	@Override
	public void insert(Member m) {
		con();
		String sql = "insert into member values(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  m.getId());
			pstmt.setString(2,  m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getEmail());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		discon();
	}

	@Override
	public Member select(String id) {
		con();
		String sql = "select * from member where id=?";
		ResultSet rs = null;
		Member m = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				m = new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
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
		String sql = "update member set pwd=?, email=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  m.getPwd());
			pstmt.setString(2,  m.getEmail());
			pstmt.setString(3,  m.getId());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		discon();
	}

	@Override
	public void delete(String id) {
		con();
		String sql = "delete member where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		discon();
	}

	@Override
	public ArrayList<Member> selectAll() {
		con();
		String sql = "select * from member";
		ArrayList<Member> data = new ArrayList<Member>();
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				data.add(new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		discon();
		return data;
	}

}
