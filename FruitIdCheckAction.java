package com.saeyan.controlle.Action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.MemberDAO;

public class FruitIdCheckAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String userId = request.getParameter("userId");

        MemberDAO dao = MemberDAO.getInstance();
        int result = dao.confirmId(userId);

        // result: -1 = 사용 가능, 1 = 중복
        request.setAttribute("result", result);

        request.getRequestDispatcher("Fruit/fruitIdCheck.jsp").forward(request, response);
    }
}
