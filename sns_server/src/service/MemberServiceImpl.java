package service;

import dao.SnsDao;
import model.Member;

public class MemberServiceImpl implements MemberService {

	public SnsDao dao;
	
	public SnsDao getDao() {
		return dao;
	}

	public void setDao(SnsDao dao) {
		this.dao = dao;
	}

	public int insert(Member m) {
		return dao.insert(m);
	}

	public int update(Member m) {
		return dao.update(m);
	}

	public int delete(String id) {
		return dao.delete(id);
	}

	public Member select(String id) {
		return dao.select(id);
	}

	public boolean login(String id, String pwd) {
		return dao.login(id, pwd);
	}

	public boolean idCheck(String id) {
		return dao.idCheck(id);
	}

}
