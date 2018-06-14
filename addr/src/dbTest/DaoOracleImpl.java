package dbTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
		return null;
	}

	public Person selectName(String name) {
		return null;
	}

	public void update(Person p) {
		
	}

	public void delete(String name) {
		
	}

}
