package dbTest;


public class Person{
	private String name;
	private String tel;
	private String address;

	public Person() {
	}

	public Person(String name, String tel, String address) {
		this.name = name;
		this.tel = tel;
		this.address = address;
	}

	void print() {
		System.out.println("name:" + name);
		System.out.println("tel:" + tel);
		System.out.println("address:" + address);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Person) {
			Person obj_p = (Person) obj;
			if (obj_p.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", tel=" + tel + ", address=" + address
				+ "]";
	}

}
