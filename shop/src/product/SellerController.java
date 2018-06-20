package product;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SellerController {
	private Service service;

	public void setService(Service service) {
		this.service = service;
	}

	@RequestMapping(value = "/seller/list.do")
	ModelAndView list(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		String s_id = (String) session.getAttribute("id");
		ModelAndView mav = new ModelAndView("seller/list");
		ArrayList<Product> products = service.getProductsById(s_id);
		mav.addObject("products", products);
		return mav;
	}

	@RequestMapping(value = "/seller/addForm.do")
	String addForm() {
		return "seller/addForm";
	}

	@RequestMapping(value = "/seller/add.do")
	String add(Product p, HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		String s_id = (String) session.getAttribute("id");
		p.setS_id(s_id);
		p.setNum(service.makeNum());
		String img = p.getNum() + p.getFile().getOriginalFilename();
		String path = "C:\\spring2\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\product_img\\";
		
		File f = new File(path, img);
		try {
			p.getFile().transferTo(f);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.setImg("/product_img/" + img);
		service.add(p);
		// System.out.println(p);
		return "redirect:/seller/list.do";
	}

	@RequestMapping(value = "/seller/detail.do")
	ModelAndView detail(@RequestParam(value = "num") int num,
			HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		int type = (Integer) session.getAttribute("memberType");
		ModelAndView mav = new ModelAndView();
		Product p = service.getProduct(num);
		mav.addObject("p", p);
		if (type == 1) {
			mav.setViewName("/seller/detail");
		} else {
			mav.setViewName("/order/detail");
		}
		return mav;
	}

	@RequestMapping(value = "/seller/edit.do")
	String edit(Product p) {
		if (!p.getFile().isEmpty()) {
			String img = p.getNum() + p.getFile().getOriginalFilename();
			String path = "C:\\spring2\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\product_img\\";
			int idx = p.getImg().lastIndexOf("\\");//마지막 슬레쉬의 위치를 찾고 
			if (idx == -1) {
				idx = p.getImg().lastIndexOf("/");
			}
			String fileName = p.getImg().substring(idx + 1);//파일명만 가지고 오고 
			File f0 = new File(path, fileName);
			f0.delete();
			File f = new File(path, img);
			try {
				p.getFile().transferTo(f);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			p.setImg("/product_img/" + img);
		}
		service.editProduct(p);
		return "redirect:/seller/list.do";
	}

	@RequestMapping(value = "/seller/del.do")
	String del(Product p) {
		String path = "C:\\spring2\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\product_img\\";
		int idx = p.getImg().lastIndexOf("\\");
		if (idx == -1) {
			idx = p.getImg().lastIndexOf("/");
		}
		String fileName = p.getImg().substring(idx + 1);
		File f0 = new File(path, fileName);
		f0.delete();
		service.delProduct(p.getNum());
		return "redirect:/seller/list.do";
	}

	@RequestMapping(value = "/order/list.do")
	ModelAndView oList() {
		ModelAndView mav = new ModelAndView("order/list");
		ArrayList<Product> products = service.getProductAll();
		mav.addObject("products", products);
		return mav;
	}
}
