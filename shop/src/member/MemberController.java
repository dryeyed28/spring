package member;

import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	
	private Service service;
	
	public void setService(Service service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/member/form.do")
	void form() {
		
	}
	
	@RequestMapping(value = "/member/join.do")
	String add(Member m) {
		service.join(m);
		return "redirect:/member/loginForm.do";
	}
	@RequestMapping(value = "/member/loginForm.do")
	void loginForm() {
		
	}
	
	
	
	@RequestMapping(value = "/member/login.do")
	String login(Member m, HttpServletRequest req) {
		boolean flag = service.login(m.getId(), m.getPwd());
		Member m2 = null;
		int type = 0;
		HttpSession session = null;
		if (flag) {
			session = req.getSession();
			session.setAttribute("id", m.getId());
			m2 = service.getMember(m.getId());
			type = m2.getType();
			session.setAttribute("memberType",  type);
			if (type ==1) {
				return "redirect:/seller/list.do";
			} else if (type==2) {
				return "redirect:/order/list.do";
			} else {
				return "member/loginForm";
			}
		} else {
			return "member/loginForm";
		}
	}
	
	@RequestMapping(value = "/member/editForm.do")
	ModelAndView editForm(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		String id = (String) session.getAttribute("id");
		Member m = service.getMember(id);
		ModelAndView mav = new ModelAndView("member/editForm");
		mav.addObject("m", m);
		return mav;
	}
	
	@RequestMapping(value = "/member/edit.do")
	String edit(Member m) {
		service.editMember(m);
		return "member/result";
	}
	
	@RequestMapping(value = "/member/logout.do")
	String logout(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		session.removeAttribute("id");
		session.invalidate();
		return "member/loginForm";
	}
	
	@RequestMapping(value = "/member/out.do")
	String out(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		String id = (String) session.getAttribute("id");
		service.remMember(id);
		session.removeAttribute("id");
		session.invalidate();
		return "member/loginForm";
	}
}
