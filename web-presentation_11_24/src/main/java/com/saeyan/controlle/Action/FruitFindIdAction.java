package com.saeyan.controlle.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.MemberDAO;

public class FruitFindIdAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        
        MemberDAO mdao = MemberDAO.getInstance();
        String userId = mdao.findIdByNameAndEmail(name, email);
        
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        if (userId != null) {
            out.println("<script>");
            out.println("alert('회원님의 아이디는 " + userId + " 입니다.');");
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
