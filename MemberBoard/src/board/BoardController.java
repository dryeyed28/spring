package board;

import org.springframework.stereotype.Controller;

@Controller
public class BoardController {
	Service service;
	
	public void setService(Service service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/form.do")
	public String form() {
		return "form";
	}
	
	@RequestMapping(value ="/insert.do")
	public String insert(Board b) {
		service.insert(b);
		return "result";
	}
	
}
