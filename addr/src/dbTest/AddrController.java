package dbTest;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public class AddrController {
	private Service service;

	public AddrController(Service service) {
		super();
		this.service = service;
	}
	
	@RequestMapping(value = "/form.do")
	public String form() {
		return "form";
	}
	
	@RequestMapping(value = "/list.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		ArrayList<Person> data = (ArrayList<Person>) service.getAll();
		mav.addObject("data", data);
		mav.setViewName("list");
		return mav;
	}
	
	@RequestMapping(value = "/insert.do")
	public String insert(Person p) {
		service.add(p);
		return "redirect:/list.do";
	}
	
	@RequestMapping(value = "/editForm.do")
	public ModelAndView editForm(@RequestParam(value = "name") String name) {
		Person p = service.search(name);
		ModelAndView mav = new ModelAndView("editForm");
		mav.addObject("person", p);
		return mav;
	}
	
	@RequestMapping(value = "/edit.do");
	public String edit(Person p) {
		service.edit(p);
		return "redirect:/list.do";
	}
	
	@RequestMapping(value = "/del.do")
	public String del(@RequestParam(value="name") String name) {
		service.remove(name);
		return "redirect:/list.do";
	}
}
