package dbTest;

import java.util.List;

public class ServiceImpl implements Service {
	private Dao dao;
	
	
	
	public ServiceImpl(Dao dao) {
		super();
		this.dao = dao;
	}

	public void add(Person p) {
		dao.insert(p);
	}

	public void edit(Person p) {
		dao.update(p);
	}

	public void remove(String name) {
		dao.delete(name);
	}

	public Person search(String name) {
		return dao.selectName(name);
	}

	public List getAll() {
		return dao.selectAll();
	}

}
