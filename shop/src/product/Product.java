package product;

import org.springframework.web.multipart.MultipartFile;

public class Product {
	
	private int num;
	private String name;
	private int quantity;
	private int price;
	private String img;
	private String content;
	private String s_id;
	private MultipartFile file;
	
	public Product() {}

	public Product(int num, String name, int quantity, int price, String img, String content, String s_id,
			MultipartFile file) {
		super();
		this.num = num;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.img = img;
		this.content = content;
		this.s_id = s_id;
		this.file = file;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Product [num=" + num + ", name=" + name + ", quantity=" + quantity + ", price=" + price + ", img=" + img
				+ ", content=" + content + ", s_id=" + s_id + ", file=" + file + "]";
	}
	
	
}
