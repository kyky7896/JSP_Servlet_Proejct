package member.controller;

import member.MemberService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MemDelete", value = "/member/MemDelete")
public class MemDelete extends HttpServlet {

    //탈퇴
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        String id=(String) session.getAttribute("id");
        MemberService ms=new MemberService();
        ms.delMember(id); //db삭제
        session.invalidate(); //세션 무효화

        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
