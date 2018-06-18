package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public class MemController {
	Service service;
	
	public void setService(Service service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/form.do")
	public String form() {
		return "form";
	}
	
	@RequestMapping(value = "/insert.do")
	public String insert(Member m) {
		service.addMember(m);
		return "loginForm";
	}
	
	@RequestMapping(value = "/check.do")
	public ModelAndView check(@RequestParam(value = "id") String id) {
		Member m = service.getMember(id);
		ModelAndView mav = new ModelAndView("check");
		String str = "";
		if (m == null) {
			str = "��밡���� ���̵�";
		} else {
			str = "��� �Ұ����� ���̵�";
		}
		mav.addObject("str", str);
		return mav;
	}
	
	@RequestMapping(value = "/login.do")
	public ModelAndView login(Member m, HttpSession session, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		String str = service.login(m);
		if (str == null) {
			session = req.getSession();
			session.setAttribute("id", m.getId());
			mav.setViewName("login");
		} else {
			mav.addObject("msg", str);
			mav.setViewName("loginForm");
		}
		return mav;
	}
	
	@RequestMapping(value = "/logou.do")
	public String logout(HttpSession session, HttpServletRequest req) {
		session = req.getSession(false);
		session.removeAttribute("id");
		session.invalidate();
		return "loginForm";
	}
}