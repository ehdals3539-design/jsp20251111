package com.saeyan.controlle.Action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.ato.MemberVO;
import com.saeyan.dao.MemberDAO;

public class FruitControltAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        MemberDAO mdao = MemberDAO.getInstance();
        List<MemberVO> list = mdao.selectAllMembers();   // ✅ 회원 전체 조회

        request.setAttribute("memberList", list);        // ✅ JSP로 전달
        request.getRequestDispatcher("/Fruit/fruitControl.jsp").forward(request, response);
    }
}
