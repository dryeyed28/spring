package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import model.Bus;
import model.School;

public class TestDI {
	public static void main(String[] args) {
		Resource r = new ClassPathResource("beans.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		
		School sc = (School) factory.getBean("school");
		ArrayList<String> list = sc.getStuName();
		ArrayList<Bus> list1 = sc.getBusList();
		for (String name : list) {
			System.out.println(name);
		}
		for (Bus bus : list1) {
			System.out.println("버스종류는 " + bus.getModel() + " " + bus.getCount() + "인승");
		}
		
		HashMap<String,Bus> map = sc.getBusMap();
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String key = it.next();
			Bus bus = map.get(key);
			System.out.println(key + " " + bus.getModel() + " " + bus.getCount());
		}
		
	}
}
