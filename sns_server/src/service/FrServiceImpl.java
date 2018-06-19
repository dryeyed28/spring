package service;

import java.util.ArrayList;

import dao.FrDao;

public class FrServiceImpl implements FrService {

	private FrDao dao;
	
	
	
	public FrDao getDao() {
		return dao;
	}

	public void setDao(FrDao dao) {
		this.dao = dao;
	}

	public boolean getFr(String id, String fr_id) {
		return dao.getFr(id, fr_id);
	}

	public ArrayList getFr_sgList(int sg, String id) {
		return dao.getFr_sgList(sg, id);
	}

	public void reqFr(String id, String fr_id) {
		dao.reqFr(id, fr_id);
	}

	public void addFr(String id, String fr_id) {
		dao.addFr(id, fr_id);
	}

	public ArrayList getFrIdList(String id) {
		return dao.getFrIdList(id);
	}

	public ArrayList getFrList(String id) {
		return dao.getFrList(id);
	}

	public void delFr(String id, String fr_id) {
		dao.delFr(id, fr_id);
	}

}
