package member.controller;

import member.Member;
import member.MemberService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Login", value = "/member/Login")
public class Login extends HttpServlet {
    //로그인 폼 실행
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("path", "/member/loginForm.jsp");
        RequestDispatcher dis=request.getRequestDispatcher("/index.jsp");
        dis.forward(request,response);
    }

    //로그인 처리. 실패하면 로그인폼, 성공하면 구매자(전체 상품 목록), 판매자(자신이 등록한 상품목록)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        HttpSession session= request.getSession();

        String id=request.getParameter("id");
        String pwd=request.getParameter("pwd");
        String path = "/index.jsp";
        String msg="";

        MemberService ms=new MemberService();
        Member m=ms.getMember(id);
        if (m != null) {
            if (m.getId().equals(id) && m.getPwd().equals(pwd)) {
                session.setAttribute("id", id);
                session.setAttribute("mem",m.isMem_type());
            }else {
                msg = "패스워드 불일치";
            }
        }else {
            msg="없는 아이디";
        }

        request.setAttribute("msg",msg);
        RequestDispatcher dis = request.getRequestDispatcher(path);
        dis.forward(request, response);
    }
}
