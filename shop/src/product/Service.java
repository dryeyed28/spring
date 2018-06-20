package product;

import java.util.ArrayList;

public interface Service {
	void add(Product p);
	ArrayList<Product> getProductsById(String s_id);
	Product getProduct(int num);
	void editProduct(Product p);
	void delProduct(int num);
	int makeNum();
	ArrayList<Product> getProductAll();
	Product editQuantity(int q, int num);
}
