package dbTest;

import java.util.List;

public interface Dao {
	void insert(Person p);
	
	List selectAll();
	
	Person selectName(String name);
	
	void update(Person p);
	
	void delete(String name);
}
