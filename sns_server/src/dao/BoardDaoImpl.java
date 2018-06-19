package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;

import model.Article;

public class BoardDaoImpl implements BoardDao {
	
	private Connection conn;
	private PreparedStatement pstmt = null;
	private DataSource dataSource;
	
	
	public BoardDaoImpl(DataSource dataSource) {
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

	public void insert(Article a) {
		con();
		String sql = "insert into sns_board values(sns_board_seq.nextval, ?, ?)";
		try { 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a.getWriter_id());
			pstmt.setString(2, a.getContent());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			discon();
		}
	}

	public void update(Article a) {
		con();
		String sql = "update sns_board set content=? where num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a.getContent());
			pstmt.setInt(2, a.getNum());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			discon();
		}
	}

	public void delete(int num) {
		con();
		String sql = "delete snd_board where num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			discon();
		}
	}

	public ArrayList select(ArrayList idList) {
		con();
		ResultSet rs = null;
		ArrayList<Article> data = new ArrayList<Article>();
		String sql = "select * from sns_board where writer_id in)";
		int i;
		for (i = 0; i < idList.size() - 1; i++) {
			sql += "'" + idList.get(i) + "',";
		}
		sql += "'" + idList.get(i) + "') order by num";
		
		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Article a = new Article();
				a.setNum(rs.getInt(1));
				a.setWriter_id(rs.getString(2));
				a.setContent(rs.getString(3));
				data.add(a);
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			discon();
		}
		return data;
	}

}
