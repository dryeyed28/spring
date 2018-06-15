package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;

public class BoardDaoImpl implements BoardDao {
	private Connection conn;
	private PreparedStatement pstmt = null;
	private DataSource dataSource;
	
	public BoardDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void con() {
		conn = DataSourceUtils.getConnection(dataSource);
	}
	
	public void discon() {
		DataSourceUtils.releaseConnection(conn, dataSource);
	}

	public void insert(Article a) {
		con();
		String sql = "insert into board values(seq_board.nextval, ?, ?, sysdate, ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a.getPwd());
			pstmt.setString(2, a.getWriter());
			pstmt.setString(3, a.getContent());
			pstmt.executeUpdate();
			discon();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public Article select(int num) {
		con();
		String sql = "select * from board where num=?";
		ResultSet rs = null;
		Article m = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				m = new Article(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5));
			}
			discon();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return m;
	}

	public ArrayList<Article> selectAll() {
		con();
		ArrayList<Article> list = new ArrayList<Article>();
		String sql = "select * from board order by num";
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Article(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5)));
			}
			discon();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void update(Article a) {
		System.out.println("dao num:" + a.getNum());
		con();
		String sql = "update board set pwd=?, w_date=sysdate, content=? where num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a.getPwd());
			pstmt.setString(2, a.getContent());
			pstmt.setInt(3, a.getNum());
			pstmt.executeUpdate();
			discon();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int num) {
		con();
		String sql = "delete board where num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			discon();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

}
