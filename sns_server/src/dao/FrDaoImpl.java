package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;

import model.FrInfo;
import model.Member;

public class FrDaoImpl implements FrDao {
	
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
		DataSourceUtils.releaseConnection(conn, dataSource);
	}

	public boolean getFr(String id, String fr_id) {
		con();
		ResultSet rs = null;
		String sql = "select * from friend_" + id + " where fr_id=?";
		try {
			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, fr_id);
			rs = pstmt.executeQuery();
			if(rs.next() ) {
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
		return true;
	}

	public ArrayList getFrIdList(String id) {
		con();
		ResultSet rs = null;
		ArrayList<String> idList = new ArrayList<String>();
		String sql = "select fr_id from friend_" + id;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String str = rs.getString(1);
				idList.add(str);
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			discon();
		}
		return idList;
	}
	
	public ArrayList getFr_sgList(int sg, String id) {
		ArrayList<String> idList = getFrIdList(id);
		con();
		ResultSet rs = null;
		ArrayList<Member> data = new ArrayList<Member>();
		String sql = "select * from sns_member where sg=? and id<>? " +
					 "and id not in(";
		if (idList!=null && idList.size() != 0) {
			int i;
			for (i = 0; i < idList.size() - 1; i++) {
				sql += "'" + idList.get(i) + "', ";
			}
			sql += "'" + idList.get(i) + "')";
		} else {
			sql = "select * from sns_member where sg=? and id<>?";
		}
		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sg);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Member m = new Member();
				m.setId(rs.getString(1));
				m.setPwd(rs.getString(2));
				m.setName(rs.getString(3));
				m.setSg(rs.getInt(4));
				m.setAddress(rs.getString(5));
				m.setTel(rs.getString(6));
				data.add(m);
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

	public void reqFr(String id, String fr_id) {
		con();
		String sql = "insert into friend_" + id
				+ "(num, fr_id, info1) values(friend_" + id
				+ "_seq.nextval,?,'my')";
		String sql2 = "insert into friend_" + fr_id
				+ "(num,fr_id,info1) values(friend_" + fr_id
				+ "_seq.nextval,?,'no')";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fr_id);
			pstmt.executeUpdate();
			pstmt.close();
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			discon();
		}
	}

	public void addFr(String id, String fr_id) {
		con();
		String sql = "update friend_" + id +
				" set info1='yes' where fr_id=?";
		String sql2 = "update friend_" + fr_id +
				" set info1='yes' where fr_id=?";
		System.out.println(sql);
		System.out.println(sql2);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fr_id);
			pstmt.executeUpdate();
			pstmt.close();
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			discon();
		}
	}

	public ArrayList getFrList(String id) {
		con();
		ResultSet rs = null;
		ArrayList<FrInfo> fList = new ArrayList<FrInfo>();
		String sql = "select * from friend_" + id;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				FrInfo f = new FrInfo();
				f.setNum(rs.getInt(1));
				f.setFr_id(rs.getString(2));
				f.setInfo1(rs.getString(3));
				fList.add(f);
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			discon();
		}
		return fList;
	}
	
	public void delFr(String id, String fr_id) {
		con();
		String sql = "delete friend_" + id + " where fr_id=?";
		String sql2 = "delete friend_" + fr_id + " where fr_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fr_id);
			pstmt.executeUpdate();
			pstmt.close();
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			discon();
		}
	}
	
	public ArrayList getFrYesIdList(String id) {
		con();
		ResultSet rs = null;
		ArrayList<String> idList = new ArrayList<String>();
		String sql = "select fr_id from friend_" + id +
				" where info1 = 'yes'";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String str = rs.getString(1);
				idList.add(str);
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			discon();
		}
		return idList;
	}
	
	

}
