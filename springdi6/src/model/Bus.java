package model;

public class Bus {
	private String model;
	private int count;
	
	public Bus(String model, int count) {
		super();
		this.model = model;
		this.count = count;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "Bus [model=" + model + ", count=" + count + "]";
	}
	
	
}
