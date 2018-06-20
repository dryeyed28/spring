package product;

import java.util.ArrayList;

public interface Dao {

	int selectNum();
	void insert(Product p);
	ArrayList<Product> selectAllById(String s_id);
	Product select(int num);
	void update(Product p);
	void delete(int num);
	ArrayList<Product> selectAll();
	void updateQuantity(int q, int num);
}
