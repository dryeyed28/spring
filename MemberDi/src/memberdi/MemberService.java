package memberdi;

import java.util.ArrayList;

public class MemberService {
	
	private ArrayList<MemberVo> list = new ArrayList<MemberVo>();
	
	public void addMemberVO(MemberVo memberVO) {
		boolean flag = false;
		for (int i = 0; i < list.size(); i++) {
			MemberVo Mem = (MemberVo) list.get(i);
			if (memberVO.equals(Mem.getId()))
				flag = true;
			break;
		}
		if (flag == false)
			list.add(memberVO);
		else
			System.out.println("이미 등록된 아이디 입니다.");
	}
	
	public void printAll() {
		System.out.println(list);
	}
}
