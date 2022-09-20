package member.controller;

import member.Member;
import member.MemberService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Memdetail", value = "/member/Memdetail")
public class Memdetail extends HttpServlet {
    
    // 로그인한 id로 검색한 member객체를 requeest에 담아서 /member/addOrder.jsp 로 이동
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //세션을 가지고 오기 : 세션 기존에 있던걸 가지고오고 없으면 error를 띄우게해라
        HttpSession session=request.getSession(false);
        //세션의 id를 담기
        String id=(String)session.getAttribute("id");

        MemberService ms=new MemberService();
        //id로 검색한 멤버의 정보를 가져오기
        Member m =ms.getMember(id);
        //setAttribute로 담아서 요청하기
        request.setAttribute("m",m);

        request.setAttribute("path", "/member/detail.jsp");
        RequestDispatcher dis=request.getRequestDispatcher("/index.jsp");
        dis.forward(request,response);

    }

    // /member/addOrder.jsp 페이지에서 수정 버튼 누르면 post로 요청
    // 수정완료
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String id=request.getParameter("id");
        String pwd=request.getParameter("pwd");
        String mem=request.getParameter("mem_type");

        //default는 false
        Boolean mem_type = false;
        if(mem.equals("구매자")){
            mem_type=false;
        } else if (mem.equals("판매자")) {
            mem_type=true;
        }
        String tel=request.getParameter("tel");
        String addr=request.getParameter("addr");
        MemberService ms=new MemberService();
        ms.editMember(new Member(id,pwd, mem_type,tel,addr));

        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }
}
