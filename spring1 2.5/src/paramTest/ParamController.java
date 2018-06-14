package paramTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class ParamController {
	
	@RequestMapping(value = "/test.do")
	public String test(Member m) {
		System.out.println("id:" + m.getId());
		System.out.println("pwd:" + m.getPwd());
		System.out.println("id:" + m.getName());
		return "test";
	}
	
	@RequestMapping(value = "/test2.do")
	public ModelAndView test2(@RequestParam(value = "id") String id,
			@RequestParam(value = "pwd") String pwd,
			@RequestParam(value = "name") String name) {
		System.out.println("id:" + id);
		System.out.println("pwd:" + pwd);
		System.out.println("name:" + name);
		ModelAndView mav = new ModelAndView("test2");
		
		Member m = new Member(id, pwd, name);
		mav.addObject("m", m);
		return mav;
	}
}
