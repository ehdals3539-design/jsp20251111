package com.saeyan.controlle.Action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.MemberDAO;
import com.saeyan.ato.MemberVO;

public class FruitJoinAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String userId = request.getParameter("userId");
        String userpw = request.getParameter("userpw");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        // 1) 빈값 체크
        if (name == null || name.trim().equals("") ||
            userId == null || userId.trim().equals("") ||
            userpw == null || userpw.trim().equals("") ||
            phone == null || phone.trim().equals("") ||
            email == null || email.trim().equals("") ||
            address == null || address.trim().equals("")) {

            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().println("<script>alert('모든 값을 입력해주세요.'); history.back();</script>");
            return;
        }

        MemberDAO mdao = MemberDAO.getInstance();

        // 2) 아이디 중복 체크
        int result = mdao.confirmId(userId);

        if (result == 1) {
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().println("<script>alert('회원가입 실패: 이미 존재하는 아이디입니다.'); history.back();</script>");
            return;
        }

        // 3) 회원정보 저장
        MemberVO mvo = new MemberVO();
        mvo.setName(name);
        mvo.setUserId(userId);
        mvo.setUserpw(userpw);
        mvo.setPhone(phone);
        mvo.setEmail(email);
        mvo.setAddress(address);

        mdao.insertMember(mvo);

        // 4) 성공 후 로그인창 이동
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().println("<script>alert('회원가입이 완료되었습니다.'); location.href='FruitServilet?command=fruit_login';</script>");
    }
}
