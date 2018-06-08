package model;

public class Owner {
	private String name;
	private Car car;
	
	public Owner(String name, Car car) {
		super();
		this.name = name;
		this.car = car;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Owner [name=" + name + ", car=" + car + "]";
	}
}
