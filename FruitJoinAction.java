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
        String userpwCheck = request.getParameter("userpw_check");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String nickname = request.getParameter("nickname");
        String idChecked = request.getParameter("idChecked");

        // 1) 빈값 체크
        if (name == null || name.trim().equals("") ||
            userId == null || userId.trim().equals("") ||
            userpw == null || userpw.trim().equals("") ||
            userpwCheck == null || userpwCheck.trim().equals("") ||
            phone == null || phone.trim().equals("") ||
            email == null || email.trim().equals("") ||
            address == null || address.trim().equals("") ||
            nickname == null || nickname.trim().equals("")) {

            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().println("<script>alert('모든 값을 입력해주세요.'); history.back();</script>");
            return;
        }

        // 2) 비밀번호 일치 확인
        if (!userpw.equals(userpwCheck)) {
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().println("<script>alert('비밀번호가 일치하지 않습니다.'); history.back();</script>");
            return;
        }

        // 3) 아이디 중복확인 체크
        if (idChecked == null || !idChecked.equals("true")) {
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().println("<script>alert('아이디 중복확인을 해주세요.'); history.back();</script>");
            return;
        }

        MemberDAO mdao = MemberDAO.getInstance();

        // 4) 회원정보 저장
        MemberVO mvo = new MemberVO();
        mvo.setName(name);
        mvo.setUserId(userId);
        mvo.setUserpw(userpw);
        mvo.setPhone(phone);
        mvo.setEmail(email);
        mvo.setAddress(address);
        mvo.setNickname(nickname);

        mdao.insertMember(mvo);

        // 5) 성공 후 로그인창 이동
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().println("<script>alert('회원가입이 완료되었습니다.'); location.href='FruitServilet?command=fruit_login';</script>");
    }
}
