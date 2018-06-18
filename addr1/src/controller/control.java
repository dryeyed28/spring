package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import service.EventService;

public class control extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public control() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String type = request.getParameter("type");
		String resultView = "addr/";
		EventService service = new EventService();
		
		if(type.equals("insert")) {
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			String address = request.getParameter("address");
			int Postal = Integer.parseInt(request.getParameter("Postal"));
			
			Member vo = new Member(0, name, tel, address, Postal);
			service.insert(vo);
			resultView+="index.jsp";
		}
		
		else if(type.equals("list")) {
			ArrayList<Member> data=service.list();
			request.setAttribute("data", data);
			resultView+="list.jsp";
		}
		
		else if(type.equals("update")) {
			int sno = Integer.parseInt(request.getParameter("num"));
			Member m = service.getMember(sno);
			request.setAttribute("m", m);
			resultView+="update.jsp";
		}
		
		else if(type.equals("edit")) {
			int pno = Integer.parseInt(request.getParameter("num"));
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			String address = request.getParameter("address");
			int Postal = Integer.parseInt(request.getParameter("Postar"));
			Member p = new Member(pno, name, tel, address, Postal);
			service.edit(p);
			resultView+="index.jsp";
		}
		
		else if(type.equals("delete")) {
			int num = Integer.parseInt(request.getParameter("num"));
			service.delete(num);
			resultView="control?type=list";
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(resultView);
		dis.forward(request, response);
	}

}
