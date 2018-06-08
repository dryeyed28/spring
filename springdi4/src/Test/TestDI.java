package Test;



import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import model.Student;

public class TestDI {
	
	public static void main(String[] args) {
		Resource r = new ClassPathResource("beans.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		Student student = (Student) factory.getBean("student");
		System.out.println("학생이름:"+student.getName()+" 책제목:" + student.getBook().getTitle() + " 책가격:" + student.getBook().getPrice());
	}
}
