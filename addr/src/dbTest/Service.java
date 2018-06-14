package dbTest;

import java.util.List;

public interface Service {
	void add(Person p);
	
	void edit(Person p);
	
	void remove(String name);
	
	Person search(String name);
	
	List getAll();
}
