package com.saeyan.controlle.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.MemberDAO;

public class FruitFindPwAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userId = request.getParameter("userId");
        String email = request.getParameter("email");
        
        MemberDAO mdao = MemberDAO.getInstance();
        String userPw = mdao.findPwByIdAndEmail(userId, email);
        
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        if (userPw != null) {
            out.println("<script>");
            out.println("alert('회원님의 비밀번호는 " + userPw + " 입니다.');");
            out.println("location.href='FruitServilet?command=fruit_login';");
            out.println("</script>");
        } else {
            out.println("<script>");
            out.println("alert('일치하는 회원이 없습니다.');");
            out.println("history.back();");
            out.println("</script>");
        }
        out.flush();
    }
}
