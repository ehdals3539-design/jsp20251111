package com.saeyan.controlle.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FruitPDPAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String url = "/Fruit/fruitPDP.jsp";  
	      
	      request.getRequestDispatcher(url)
	      .forward(request, response);
		
	}

}
