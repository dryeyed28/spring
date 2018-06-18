package board;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	private BoardService service;
	
	public BoardController(BoardService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/list.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("board/list");
		ArrayList<Article> data = (ArrayList<Article>) service.getAll();
		mav.addObject("article", data);
		return mav;
	}
	
	@RequestMapping(value ="/write.do")
	public String write(Article b) {
		service.addArticle(b);
		return "redirect:/list.do";
	}
	
	@RequestMapping(value = "/editForm.do")
	public ModelAndView editForm(@RequestParam(value="num")int num) {
		Article m = service.getArticle(num);
		ModelAndView mav = new ModelAndView("board/editForm");
		mav.addObject("m", m);
		
		return mav;
	}
	
	@RequestMapping(value = "/boardedit.do")
	public String edit(Article b) {
		service.editArticle(b);
		return "redirect:/list.do";
	}
	
	@RequestMapping(value = "/boarddel.do")
	public String del(@RequestParam(value="num")int num) {
		service.delArticle(num);
		return "redirect:/list.do";
	}
	
}
