package com.saeyan.controlle.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FruitHomeAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 이동할 JSP 페이지 경로를 문자열로 지정함(게시판 목록 화면)
	      String url = "/Fruit/fruitHome.jsp";  
	      
	      request.getRequestDispatcher(url)
	      .forward(request, response);
	}

	

}
