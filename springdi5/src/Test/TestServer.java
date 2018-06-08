package Test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import model.Manager;

public class TestServer {
	
	public static void main(String[] args) {
		Resource r = new ClassPathResource("beans.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		Manager manager = (Manager) factory.getBean("manager");
		manager.manage();
	}
}
