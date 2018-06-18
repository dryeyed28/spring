package member;

import java.util.ArrayList;

public interface Service {
	void addMember(Member m);
	Member getMember(String id);
	String login(Member m);
	void editMember(Member m);
	void delMember(String id);

}
