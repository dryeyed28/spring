package test.old;

import model.Car;
import model.SportsCar;
import model.Truck;

public class TestOld {
	public static void main(String[] args) {
		Truck t = new Truck();
		t.go();
		
		SportsCar scar = new SportsCar();
		scar.go();
		
		Car car = new Truck();
		car.go();
	}
}
