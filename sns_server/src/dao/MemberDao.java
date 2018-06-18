package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.datasource.DataSourceUtils;

import model.Member;

public class MemberDao implements SnsDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void con() {
		conn = DataSourceUtils.getConnection(dataSource);
	}
	
	public void discon() {
		try {
			DataSourceUtils.releaseConnection(conn, dataSource);
		}
	}
	
	public int insert(Member m) {
		createFRTable(m.getId());
		con();
		int cnt = 0;
		String sql = "insert into sns_member values(?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setInt(4, m.getSg());
			pstmt.setString(5, m.getAddress());
			pstmt.setString(6, m.getTel());
			cnt = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			discon();
		}
		return cnt;
	}

	public void createFRTable(String id) {
		con();
		String sql = "create table friend_"+id+
					 "(num number primary key, fr_id varchar2(20) not null, "+
					 "info1 varchar2(10), info2 varchar2(10))";
		String sql2 = "create sequence friend_"+id+"_seq increment by 1 "+
					  "start with 1 maxvalue 9999 nocache nocycle";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeQuery();
			pstmt.close();
			pstmt = conn.prepareStatement(sql2);
			pstmt.executeQuery();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			discon();
		}
	}
	
	public int update(Member m) {
		con();
		int cnt = 0;
		String sql = "update sns_member set pwd=?, sg=?, address=?, " +
					 "tel=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  m.getPwd());
			pstmt.setInt(2,  m.getSg());
			pstmt.setString(3, m.getAddress());
			pstmt.setString(4, m.getTel());
			pstmt.setString(5, m.getId());
			cnt = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			discon();
		}
		return cnt;
	}

	public int delete(String id) {
		deleteFRTable(id);
		con();
		int cnt = 0;
		String sql = "delete sns_member where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  id);
			cnt = pstmt.executeUpdate();
			pstmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			discon();
		}
		return cnt;
	}

	public void deleteFRTable(String id) {
		con();
		String sql = "drop table friend_"+id;
		String sql2 = "drop sequence friend_"+id+"_seq";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			pstmt.close();
			pstmt = conn.prepareStatement(sql2);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			discon();
		}
	}
	
	public Member select(String id) {
		con();
		ResultSet rs = null;
		Member m = new Member();
		String sql = "select * from sns_member where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				m.setId(rs.getString(1));
				m.setPwd(rs.getString(2));
				m.setName(rs.getString(3));
				m.setSg(rs.getInt(4));
				m.setAddress(rs.getString(5));
				m.setTel(rs.getString(6));
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			discon();
		}
		return m;
	}

	public boolean login(String id, String pwd) {
		con();
		ResultSet rs = null;
		String sql = "select * from sns_member where id=? and pwd=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				pstmt.close();
				return true;
			} else {
				pstmt.close();
				rs.close();
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			discon();
		}
	}

	public boolean idCheck(String id) {
		con();
		ResultSet rs = null;
		String sql = "select * from sns_member where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				pstmt.close();
				rs.close();
				return false;
			} else {
				pstmt.close();
				rs.close();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			discon();
		}
	}

}
