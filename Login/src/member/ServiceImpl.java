package member;

public class ServiceImpl implements Service {

	private Dao dao;
	
	public ServiceImpl(Dao dao) {
		this.dao = dao;
	}
	
	public void join(Member m) {
		dao.insert(m);
	}
	
	public void addMember(Member m) {
		dao.insert(m);
	}

	public Member getMember(String id) {
		return dao.select(id);
	}

	public String login(Member m) {
		String result = null;
		Member m2 = dao.select(m.getId());
		if(m2==null) {
			result = "incorrect id";
		} else if(!m2.getPwd().equals(m.getPwd())) {
			result = "incorrect pwd";
		}
		return result;
	}

	public void editMember(Member m) {
		dao.update(m);
	}

	public void delMember(String id) {
		dao.delete(id);
	}
	

}
