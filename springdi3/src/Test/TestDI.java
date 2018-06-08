package Test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import model.Car;
import model.Friend;
import model.Owner;

public class TestDI {
	
	public static void main(String[] args) {
		Resource r = new ClassPathResource("beans.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		
		Car car = (Car) factory.getBean("car");
		System.out.println(car.getModel());
		Friend friend = (Friend) factory.getBean("friend");
		System.out.println("이름은 " + friend.getName() + " 나이는 " + friend.getAge());
		Owner owner = (Owner) factory.getBean("owner");
		System.out.println(owner.getName() + " " + owner.getCar().getModel());
	}
}
