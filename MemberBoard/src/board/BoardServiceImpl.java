package board;

import java.util.ArrayList;

public class BoardServiceImpl implements BoardService {
	private BoardDao dao;
		
	public BoardServiceImpl(BoardDao dao) {
		super();
		this.dao = dao;
	}

	public void addArticle(Article a) {
		dao.insert(a);
	}

	public Article getArticle(int num) {
		return dao.select(num);
	}

	public ArrayList<Article> getAll() {
		return dao.selectAll();
	}

	public void editArticle(Article a) {
		dao.update(a);
	}

	public void delArticle(int num) {
		dao.delete(num);
	}

}
