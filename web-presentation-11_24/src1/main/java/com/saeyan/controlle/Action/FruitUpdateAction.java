package com.saeyan.controlle.Action;

import javax.servlet.http.*;
import java.io.IOException;

import com.saeyan.dao.MemberDAO;
import com.saeyan.ato.MemberVO;

public class FruitUpdateAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        request.setCharacterEncoding("UTF-8");

        MemberVO mvo = new MemberVO();
        mvo.setUserId(request.getParameter("userId"));
        mvo.setName(request.getParameter("name"));
        mvo.setUserpw(request.getParameter("userpw"));
        mvo.setPhone(request.getParameter("phone"));
        mvo.setEmail(request.getParameter("email"));
        mvo.setAddress(request.getParameter("address"));

        MemberDAO mdao = MemberDAO.getInstance();
        mdao.updateMember(mvo);

        response.setContentType("text/html; charset=UTF-8");
        java.io.PrintWriter out = response.getWriter();
        out.println("<script>alert('수정이 완료되었습니다.'); location.href='FruitServilet?command=fruit_Control';</script>");
        out.flush();
    }
}
