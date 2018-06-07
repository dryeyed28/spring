package memberdi;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TestMemberService {
	
	public static void main(String[] args) {
		
		Resource r = new ClassPathResource("beans.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		MemberService service = (MemberService) factory.getBean("memberService");
		
		service.addMemberVO(new MemberVo("java", "�տ���", "111", "����"));
		service.addMemberVO(new MemberVo("oracle", "�迬��", "222", "����"));
		service.addMemberVO(new MemberVo("JSP", "ȫ��", "333", "����"));
		service.addMemberVO(new MemberVo("Ajax", "��û��", "444", "����"));
		service.addMemberVO(new MemberVo("Spring", "������", "555", "����"));
		service.printAll();
		
	}
}
