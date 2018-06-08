package jdbcTest;

import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String id;
		String pwd;
		String name;
		String email;
		
		boolean flag = true;
		int i = 0;
		
		BeanFactory ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
		Service service = (Service) ctx.getBean("service");
		
		while (flag) {
			
			System.out.println("1.등록");
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
				System.out.println("비밀번호 입력하세요 :");
				pwd = sc.next();
				System.out.println("이름을 입력하세요 :");
				name = sc.next();
				System.out.println("이메일을 입력하세요 :");
				email = sc.next();
				service.join(new Member(id, pwd, name, email));
				break;
			case 2:
				System.out.println("아이디를 입력하세요 :");
				id = sc.next();
				Member m = service.getMember(id);
				
				System.out.println(m);
				break;
				
			case 3:
				System.out.println("수정할 id를 입력하세요 :");
				id = sc.next();
				System.out.println("수정할 비밀번호를 입력하세요 :");
				pwd = sc.next();
				System.out.println("수정할 이름을 입력하세요 :");
				name = sc.next();
				System.out.println("수정할 이메일을 입력하세요 :");
				email = sc.next();
				Member m2 = new Member(id,pwd,name,email);
				service.editMember(m2);
				break;
				
			case 4:
				System.out.println("삭제할 id를 입력하세요 :");
				id = sc.next();
				service.delMember(id);
				break;
				
			case 5:
				System.out.println(service.getMembers());
				break;
			case 6:
				flag=false;
				break;
				
				default:
					System.out.println("잘못 입력했어요 다시 입력하세요 ");
		}
	}
	
}
}
