package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;

public class OracleDao implements Dao {
	private Connection conn;
	private PreparedStatement pstmt = null;
	private DataSource dataSource;

	public OracleDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(Member m) {
		con();
		String sql = "insert into board values(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getMsg());
			pstmt.executeUpdate();
			pstmt.close();
			discon();
		} catch (SQLException e) {
			e.printStackTrace();
			//discon();
		}
	}

	public Member select(String id) {
		con();
		Member m = null;
		ResultSet rs = null;
		String sql = "select * from board where id=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				m = new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
			pstmt.close();
			discon();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}

	public void update(Member m) {
		con();
		String sql = "update board set pwd=?, name=?, msg=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getPwd());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getMsg());
			pstmt.setString(4, m.getId());
			pstmt.executeUpdate();
			pstmt.cancel();
			discon();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(String id) {
		con();
		String sql = "delete member where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			discon();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void con() {
		conn = DataSourceUtils.getConnection(dataSource);
	}
	
	public void discon() {
		DataSourceUtils.releaseConnection(conn, dataSource);
	}

}
