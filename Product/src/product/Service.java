package product;

import java.util.ArrayList;

public interface Service {
	public void join(Product m);
	public Product getMember(int p_id);
	public void editMember(Product m);
	public void edlMember(int id);
	ArrayList<Product> getMembers();
}
