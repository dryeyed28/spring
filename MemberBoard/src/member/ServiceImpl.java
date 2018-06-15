package member;

import java.util.ArrayList;

public class ServiceImpl implements Service {
	private Dao dao;
	
	public ServiceImpl(Dao dao) {
		this.dao = dao;
	}

	public void join(member.Member m) {
		dao.insert(m);
	}

	public Member getMember(String id) {
		return dao.select(id);
	}

	public void editMember(member.Member m) {
		dao.update(m);
	}

	public void delMember(String id) {
		dao.delete(id);
	}

	public ArrayList<Member> getMembers() {
		return dao.selectAll();
	}

	public boolean login(String id, String pwd) {
		Member m = dao.select(id);
		if (m != null) {
			if (pwd.equals(m.getPwd())) {
				return true;
			}
		}
		return false;
	}

}
