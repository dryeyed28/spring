package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemController {
	Service service;
	
	public void setService(Service service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/form.do")
	public String form() {
		return "form";
	}
	
	@RequestMapping(value = "member/insert.do")
	public String insert(Member m) {
		service.join(m);
		return "login";
	}
	
	@RequestMapping(value = "/login.do")
	public ModelAndView login(Member m, HttpSession session, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		boolean str = service.login(m.getId(), m.getPwd());
		if(str) {
			session = req.getSession();
			session.setAttribute("id", m.getId());
			mav.setViewName("result");
		} else {
			mav.addObject("msg", str);
			mav.setViewName("login");
		}
		return mav;
	}
	
	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session, HttpServletRequest req) {
		session = req.getSession(false);
		session.removeAttribute("id");
		session.invalidate();
		return "login";
	}
	
	@RequestMapping(value = "/editMember.do")
	public ModelAndView editForm(HttpSession session, HttpServletRequest req) {
		session = req.getSession(false);
		String id = (String) session.getAttribute("id");
		Member m = service.getMember(id);
		ModelAndView mav = new ModelAndView("editForm");
		mav.addObject("m", m);
		return mav;
	}
	
	@RequestMapping(value = "/edit.do")
	public String edit(Member m) {
		service.editMember(m);
		return "login";
	}
	
	@RequestMapping(value = "/del.do")
	public String del(HttpSession session, HttpServletRequest req) {
		session = req.getSession(false);
		String id = (String) session.getAttribute("id");
		service.delMember(id);
		return "redirect:/logout.do";
	}
	
	
}
