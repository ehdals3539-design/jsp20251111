package com.saeyan.controlle.Action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FruitJoinFormAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 회원가입 화면으로 이동
        request.getRequestDispatcher("Fruit/fruitJoin.jsp").forward(request, response);
    }
}
