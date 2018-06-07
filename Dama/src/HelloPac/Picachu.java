package HelloPac;

public class Picachu extends Overr {
	public int cnt;
	public Picachu(String name) {
		this.name = name;
		race = "Picachu";
		age = 0;
		power = 100;
		energy = 300;
		cnt = 0;
		System.out.println("피카추가 만들어졌습니다.");
	}
	
	@Override
	public void eat() {
		energy += 10;
		cnt++;
		aging();
	}
	
	@Override
	public void sleep() {
		energy += 15;
		cnt++;
		aging();
	}
	
	@Override
	public void exercise() {
		energy -= 10;
		power += 20;
	}

	@Override
	public void aging() {
		if (cnt>=3) {
			age++;
			cnt = 0;
		}
	}

	@Override
	public void attack() {
		energy -= 25;
		power += 15;
		
	}
}
