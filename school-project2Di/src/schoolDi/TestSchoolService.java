package schoolDi;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TestSchoolService {
	public static void main(String[] args) {
		
		Resource r = new ClassPathResource("beans.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		SchoolService service = (SchoolService) factory.getBean("SchoolService");
		
		Student s = new Student("011", "ũ����Ż", "�Ǳ�", "12");
		service.addPerson(s);
		Teacher t = new Teacher("017", "Ȳ����", "�ͻ�", "����");
		service.addPerson(t);
		Employee e = new Employee("015", "�ÿ���", "����", "�����");
		service.addPerson(e);
		service.printAll();
		Person per = service.findPerson("017");
		if (per!=null)
			System.out.println(per);
		else
			System.out.println("ã�� ������ ����!");
		service.deletePerson("017");
		service.printAll();
		service.updatePerson("019", new Student("010", "����", "����", "13"));
		service.printAll();
	}
}
