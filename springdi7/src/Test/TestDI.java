package Test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import model.Residence;

public class TestDI {

		public static void main(String[] args) {
			Resource r = new ClassPathResource("applicationContext.xml");
			BeanFactory factory = new XmlBeanFactory(r);
			Residence r1 = (Residence) factory.getBean("hotel");
			r1.reside();
			Residence r2 = (Residence) factory.getBean("dormitory");
			r2.reside();
			Residence r3 = (Residence) factory.getBean("house");
			r3.reside();
		}
}
