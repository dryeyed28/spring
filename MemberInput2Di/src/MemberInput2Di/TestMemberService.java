package MemberInput2Di;

import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TestMemberService {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String id;
		String name;
		String tel;
		String addr;
		boolean flag = true;
		int i = 0;
		
		Resource r = new ClassPathResource("beans.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		MemberService service = (MemberService) factory.getBean("memberService");
		
		while(flag) {
			
			System.out.println("1.등로");
			System.out.println("2.검색");
			System.out.println("3.수정");
			System.out.println("4.삭제");
			System.out.println("5.전체출력");
			System.out.println("6.종료");
			i = sc.nextInt();
			switch (i) {
			case 1:
				System.out.println("아이디를 입력하세요 :");
				id = sc.next();
				System.out.println("이름을 입력하세요 :");
				name = sc.next();
				System.out.println("전화번호를 입력하세요 :");
				tel = sc.next();
				System.out.println("주소를 입력하세요 :");
				addr = sc.next();
				service.addMemberVO(new MemberVO(id, name, tel, addr));
				break;
			
			case 2: 
				System.out.println("아이디를 입력하세요 :");
				id = sc.next();
				MemberVO m = service.findMemberVO(id);
				
				System.out.println(m);
				break;
			
			case 3:
				System.out.println("수정할 id를 입력하세요 : ");
				id = sc.next();
				System.out.println("수정할 이름을 입력하세요 :");
				name = sc.next();
				System.out.println("수정할 전화번호를 입력하세요 :");
				tel = sc.next();
				System.out.println("수정할 주소를 입력하세요 :");
				addr = sc.next();
				MemberVO m2 = new MemberVO(id,name,tel,addr);
				service.updateMemberVO(m2);
				break;
				
			case 4:
				System.out.println("삭제할 id를 입력하세요 : ");
				id = sc.next();
				service.deleteMemberVO(id);
				break;
				
			case 5:
				service.printAll();
				break;
			
			case 6:
				flag = false;
				break;
				
				default:
					System.out.println("잘못 입력했어요 다시 입력하세요 ");
			}
		}
	}
}
