package dao;

import model.Member;

public interface SnsDao {
	int insert(Member m);
	int update(Member m);
	int delete(String id);
	Member select(String id);
	boolean login(String id, String pwd);
	boolean idCheck(String id);
}
