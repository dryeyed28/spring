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
		
		service.addMemberVO(new MemberVo("java", "손연재", "111", "구로"));
		service.addMemberVO(new MemberVo("oracle", "김연아", "222", "군포"));
		service.addMemberVO(new MemberVo("JSP", "홍명보", "333", "파주"));
		service.addMemberVO(new MemberVo("Ajax", "이청용", "444", "영국"));
		service.addMemberVO(new MemberVo("Spring", "박지성", "555", "수원"));
		service.printAll();
		
	}
}
