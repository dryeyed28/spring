package member;

public class ServiceImpl implements Service {

	private Dao dao;
		
	public ServiceImpl(Dao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public void join(Member m) {
		dao.insert(m);
	}

	@Override
	public Member getMember(String id) {
		return dao.select(id);
	}

	@Override
	public void editMember(Member m) {
		dao.update(m);
	}

	@Override
	public void remMember(String id) {
		dao.delete(id);
	}

	@Override
	public boolean login(String id, String pwd) {
		Member m = dao.select(id);
		if (m == null || !m.getPwd().equals(pwd)) {
			return false;
		} else {
			return true;
		}
	}

}
