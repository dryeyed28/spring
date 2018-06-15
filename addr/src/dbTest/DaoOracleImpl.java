package dbTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;

public class DaoOracleImpl implements Dao {
	private Connection conn;
	private PreparedStatement pstmt;
	private DataSource dataSource;
	
	
	
	public DaoOracleImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
		conn = DataSourceUtils.getConnection(dataSource);
	}

	public void insert(Person p) {
		try {
			String sql = "insert into member values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getName());
			pstmt.setString(2, p.getTel());
			pstmt.setString(3, p.getAddress());
			int cnt = pstmt.executeUpdate();
			if(cnt == 0) {
				System.out.println("처리되지 않았다.");
			} else {
				System.out.println("정상처리 되었다.");
			}
			pstmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public List selectAll() {
		String sql = "select * from member";
		ResultSet rs = null;
		ArrayList<Person> data = new ArrayList<Person>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				data.add(new Person(rs.getString(1), rs.getString(2), rs.getString(3)));
			}
			pstmt.close();
			rs.close();
			return data;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Person selectName(String name) {
		String sql = "select * from member where name=?";
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Person(rs.getString(1), rs.getString(2), rs.getString(3));
			}
			pstmt.close();
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void update(Person p) {
		String sql = "update member set tel=?, address=? where name=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getTel());
			pstmt.setString(2,  p.getAddress());
			pstmt.setString(3,  p.getName());
			int cnt = pstmt.executeUpdate();
			if (cnt == 0) {
				System.out.println("처리되지 않았다.");
			} else {
				System.out.println("정상처리 되었다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(String name) {
		String sql = "delete member where name=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  name);
			int cnt = pstmt.executeUpdate();
			if (cnt == 0) {
				System.out.println("처리되지 않았다.");
			} else {
				System.out.println("정상처리 되었다.");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
