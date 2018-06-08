package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class House implements Residence {
	private String address;
	private HashMap<String,HomeAppliance> hp;
		
	public House(String address, HashMap<String, HomeAppliance> hp) {
		super();
		this.address = address;
		this.hp = hp;
	}

	@Override
	public void reside() {
		Set<String> set = hp.keySet();
		Iterator<String> it = set.iterator();
		System.out.println(address);
		while(it.hasNext()) {
			String key = it.next();
			HomeAppliance hp1 = hp.get(key);
			System.out.println(hp.toString());
		}
		
	}
	
	
}
