package HelloPac;

public class Gobook extends Overr {
	public int cnt;
	
	public Gobook(String name) {
		this.name = name;
		race = "gobook";
		age = 0;
		power = 50;
		energy = 150;
		cnt = 0;
		System.out.println("꼬북이가 만들어졌습니다.");
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
