package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AddrDao {

	public Connection conn = null;
	public PreparedStatement pstmt = null;
	public Statement stmt = null;
	public String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
	public String jdbc_url = "jdbc:oracle:thin:@localhost:1521:orcl";
	ResultSet rs = null;
	
	private static AddrDao sd = new AddrDao();
	
	private AddrDao() {
	}
	
	public static AddrDao getDao() {
		return sd;
	}
	
	public boolean con() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "kitri", "kitri");
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	public void discon() {
		try {
			if (stmt != null)
				stmt.close();
			if (pstmt != null)
				pstmt.close();
			if (rs != null)
				rs.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void insert(Member p) {
		con();
		String sql = "insert into addr values(addr_seq.nextval,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getName());
			pstmt.setString(2, p.getTel());
			pstmt.setString(3, p.getAddress());
			pstmt.setInt(4, p.getPostal());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			discon();
		}
	}
	
	public ArrayList<Member> getAll() {
		// TODO Auto-generated method stub
		con();
		ArrayList<Member> list = new ArrayList<Member>();
		String sql = "select * from addr order by num";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int num = rs.getInt(1);
				String Name = rs.getString(2);
				String Tel = rs.getString(3);
				String Address = rs.getString(4);
				int Postal = rs.getInt(5);
				Member m = new Member(num, Name, Tel, Address,Postal);
				list.add(m);
				}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		} finally {
			discon();
		}
		return list;
	}
	
	
	public Member getMember(int num) {
		// TODO Auto-generated method stub
		con();
		String sql = "select * from addr where num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int bno = rs.getInt(1);
				String name = rs.getString(2);
				String tel = rs.getString(3);
				String address = rs.getString(4);
				int Postal = rs.getInt(5);
				Member m = new Member (bno, name, tel,address,Postal);
				return m;
			
				}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		} finally {
			discon();
		}
		return null;
	}

	
	public void edit(Member p) {
		// TODO Auto-generated method stub
		con();
		System.out.println(p);
		String sql = "update addr set name=?, tel=?, address=?,Postal=? where num=?";
		try {
			pstmt = conn.prepareStatement(sql);		
			pstmt.setString(1, p.getName());
			pstmt.setString(2, p.getTel());
			pstmt.setString(3, p.getAddress());
			pstmt.setInt(4, p.getPostal());
			pstmt.setInt(5, p.getNum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			discon();
		}
		
	}

	
	public void delete(int num) {
		// TODO Auto-generated method stub
		con();
		String sql = "delete addr where num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
			
		} finally {
			discon();
		}
	}

}