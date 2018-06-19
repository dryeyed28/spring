package service;

import java.util.ArrayList;

import dao.BoardDao;
import model.Article;

public class BoardServiceImpl implements BoardService {

	private BoardDao dao;
	
	
	public BoardDao getDao() {
		return dao;
	}

	public void setDao(BoardDao dao) {
		this.dao = dao;
	}

	public void insert(Article a) {
		dao.insert(a);
	}

	public void update(Article a) {
		dao.update(a);
	}

	public void delete(int num) {
		dao.delete(num);
	}

	public ArrayList select(ArrayList idList) {
		return dao.select(idList);
	}

}
