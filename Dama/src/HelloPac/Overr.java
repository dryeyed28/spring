package HelloPac;

public abstract class Overr {
	public String race;
	public String name;
	public int age;
	public int power;
	public int energy;
	
	public Overr() {
		System.out.println("Overr Å¬·¡½º");
	}
	
	public abstract void eat();
	public abstract void sleep();
	public abstract void exercise();
	public abstract void aging();
	public abstract void attack();
	
	public void print() {
		System.out.println("age : " + age);
		System.out.println("power : " + power);
		System.out.println("energy : " + energy);		
	}
}
