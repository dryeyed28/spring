package HelloPac;

import java.util.Scanner;

public class ExcMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Overr o = null;
		System.out.println("������ �����Ͻÿ�.");
		System.out.println("1. ��ī��\n2. �̻��ؾ�\n3. ���α�");
		int x = sc.nextInt();
		System.out.println("�̸��� �Է��Ͻÿ�.");
		String name = sc.next();
		
		if(x == 1) {
			o = new Picachu(name);
		} else if (x == 2) {
			
		} else if(x == 3) {
			o = new Gobook(name);
		}
		boolean flag = true;
		
		while(flag) {
			System.out.println("�޴�");
			System.out.println("1. ��Ա�\n2. ���ڱ�\n3. ��ϱ�\n4. ����\��5. ����");
			x = sc.nextInt();
			switch(x) {
			case 1:
				o.eat():
				o.print();
				break;
			case 2:
				o.sleep();
				o.print();
				break;
			case 3:
				o.exercise();
				o.print();
				if(o.energy<=0) {
					System.out.println("��������");
					flag = false;
				}
				break;
			case 4:
				o.attack()
				o.print();
				if(o.energy<=0) {
					System.out.println("��������");
					flag = false;
				}
				break;
			case 5:
				System.out.println("��������");
				flag = false;
			}
		}
		
	}
}