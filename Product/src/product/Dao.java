package product;

import java.util.ArrayList;

public interface Dao {
	public Product select(int id);
	public void udate(Product m);
	public void delete(int id);
	public void insert(Product m);
	ArrayList<Product> selectAll();
}
