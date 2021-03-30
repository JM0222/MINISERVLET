package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.PbookDao;
import com.servlet.PbookDaoImpl;
import com.servlet.PbookVo;



@WebServlet("/book")
public class PbookServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String action = req.getParameter("a");
		
		if ("form".equals(action)) { // a = form 이면
			// View 처리를 위한 RequestDispatcher 를 확인
			// 자신이 처리하는 요청, 응답 객체를 서블릿 or jsp 로넘겨주기
			RequestDispatcher rd = 
					getServletContext().getRequestDispatcher("/WEB-INF/views/form.jsp");
			rd.forward(req, resp);
			} else if ("delete".equals(action)) {
				Long no = Long.valueOf(req.getParameter("no"));
				
				PbookDao dao = new PbookDaoImpl();
				dao.delete(no);
				
				resp.sendRedirect(req.getContextPath() + "/book");
			} else if ("search".equals(action)) {
				String keyword = req.getParameter("keyword");
				PbookDao dao = new PbookDaoImpl();
				List<PbookVo> list = dao.searchUser(keyword);
				req.setAttribute("list", list);
				RequestDispatcher rd = 
						getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp");
				rd.forward(req, resp);
				
			}
			else {
				// 리스트를 불러와 req에 attribute로 추가
				PbookDao dao = new PbookDaoImpl();
				// 전달해줄 객체
				List<PbookVo> list = dao.getList();
//				System.out.println(list);
				// 요청 객체에 속성으로 추가
				//                 이름   객체
				req.setAttribute("list", list); // 전달받은 서블릿은 요청으로 부터 이 속성 이용가능
				// Dispatcher
				RequestDispatcher rd = 
						getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp");
				rd.forward(req, resp);
			}	
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String action = req.getParameter("action");
		
		if ("insert".equals(action)) { // action이 insert -> 삽입
			String name = req.getParameter("name");
			String hp = req.getParameter("hp");
			String tel = req.getParameter("tel");
			
			PbookVo vo = new PbookVo();
			vo.setName(name);
			vo.setHp(hp);
			vo.setTel(tel);
			PbookDao dao = new PbookDaoImpl();
			dao.insert(vo);
			// 리스트페이지 리다이렉트
			resp.sendRedirect(req.getContextPath() + "/book");
		} else {
			doGet(req, resp);
		}
		
	}
	
}
