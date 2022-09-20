package member.controller;

import member.Member;
import member.MemberService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Join", value = "/member/Join")
public class Join extends HttpServlet {
    //join form 실행
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("path", "/member/joinForm.jsp");
        RequestDispatcher dis=request.getRequestDispatcher("/index.jsp");
        dis.forward(request,response);
    }

    //join완료
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String id=request.getParameter("id");
        String pwd=request.getParameter("pwd");
        Boolean mem_type=Boolean.parseBoolean(request.getParameter("mem_type"));
        String tel=request.getParameter("tel");
        String addr=request.getParameter("addr");
        MemberService ms=new MemberService();
        ms.join(new Member(id,pwd,mem_type,tel,addr));

        request.setAttribute("path", "/member/loginForm.jsp");
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }
}
