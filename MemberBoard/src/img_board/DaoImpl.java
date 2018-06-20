package img_board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;

public class DaoImpl implements Dao {
	private Connection conn;
	private PreparedStatement pstmt;
	private DataSource dataSource;

	public DaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
		conn = DataSourceUtils.getConnection(dataSource);
	}

	@Override
	public void insertImg(Img img) {
		// TODO Auto-generated method stub
		String sql = "insert into img values(seq_img.nextval, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, img.getPath());
			pstmt.setString(2, img.getTitle());
			pstmt.setString(3, img.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void insertArticle(ImgBoard imgBoard) {
		// TODO Auto-generated method stub
		String sql = "insert into img_board values(seq_img_board.nextval, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, imgBoard.getContent());
			pstmt.setString(2, imgBoard.getWriter());
			pstmt.setInt(3, imgBoard.getImg_num());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List getImgs() {
		// TODO Auto-generated method stub
		ResultSet rs;
		ArrayList<Img> data = new ArrayList<Img>();
		String sql = "select * from img";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				data.add(new Img(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4)));
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List getArticles(int img_num) {
		// TODO Auto-generated method stub
		ResultSet rs;
		ArrayList<ImgBoard> data = new ArrayList<ImgBoard>();
		String sql = "select * from img_board where img_num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, img_num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				data.add(new ImgBoard(rs.getInt(1), rs.getString(2), rs
						.getString(3), rs.getInt(4)));
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
