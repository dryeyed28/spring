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
			
			System.out.println("1.���");
			System.out.println("2.�˻�");
			System.out.println("3.����");
			System.out.println("4.����");
			System.out.println("5.��ü���");
			System.out.println("6.����");
			i = sc.nextInt();
			switch (i) {
			case 1: 
				System.out.println("���̵� �Է��ϼ��� :");
				id = sc.next();
				System.out.println("��й�ȣ �Է��ϼ��� :");
				pwd = sc.next();
				System.out.println("�̸��� �Է��ϼ��� :");
				name = sc.next();
				System.out.println("�̸����� �Է��ϼ��� :");
				email = sc.next();
				service.join(new Member(id, pwd, name, email));
				break;
			case 2:
				System.out.println("���̵� �Է��ϼ��� :");
				id = sc.next();
				Member m = service.getMember(id);
				
				System.out.println(m);
				break;
				
			case 3:
				System.out.println("������ id�� �Է��ϼ��� :");
				id = sc.next();
				System.out.println("������ ��й�ȣ�� �Է��ϼ��� :");
				pwd = sc.next();
				System.out.println("������ �̸��� �Է��ϼ��� :");
				name = sc.next();
				System.out.println("������ �̸����� �Է��ϼ��� :");
				email = sc.next();
				Member m2 = new Member(id,pwd,name,email);
				service.editMember(m2);
				break;
				
			case 4:
				System.out.println("������ id�� �Է��ϼ��� :");
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
					System.out.println("�߸� �Է��߾�� �ٽ� �Է��ϼ��� ");
		}
	}
	
}
}
