package schoolDi;

import java.util.ArrayList;

public class SchoolService {
	
	private ArrayList list = new ArrayList();
	
	public void addPerson(Person p) {
		boolean flag = false;
		for (int i = 0; i < list.size(); i++) {
			Person per = (Person) list.get(i);
			if (p.getTel().equals(per.getTel())) {
				flag = true;
			}
		}
		if (flag == false) {
			list.add(p);
		} else {
			System.out.println("������ ��ȣ �����Ͽ� �߰��Ұ�!");
		}
	}
	
	public void printAll() {
		for (int i = 0; i < list.size(); i++) {
			Person p = (Person) list.get(i);
			System.out.println(p);
			System.out.println("*********");
		}
	}
	
	public Person findPerson(String tel) {
		Person per = null;
		for (int i = 0; i < list.size(); i++) {
			Person p = (Person) list.get(i);
			if (p.getTel().startsWith(tel)) {
				per = p;
				break;
			}
		}
		return per;
	}
	
	public void deletePerson(String tel) {
		for (int i = 0; i < list.size(); i++) {
			Person p = (Person) list.get(i);
			if (p.getTel().startsWith(tel)) {
				list.remove(i);
				break;
			}
		}
	}
	
	public void updatePerson(String tel, Person p) {
		for (int i = 0; i < list.size(); i++) {
			Person per = (Person) list.get(i);
			if (per.getTel().startsWith(tel)) {
				list.set(i, p);
				break;
			}
		}
	}
}
