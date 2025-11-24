package com.saeyan.controlle.Action;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

import com.saeyan.dao.MemberDAO;
import com.saeyan.ato.MemberVO;

public class FruitEditAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String userId = request.getParameter("userId");

        MemberDAO mdao = MemberDAO.getInstance();
        MemberVO mvo = mdao.getMember(userId);

        request.setAttribute("mvo", mvo);
        request.getRequestDispatcher("/Fruit/fruitEdit.jsp").forward(request, response);
    }
}
