package member.controller;

import member.Member;
import member.MemberService;
import org.json.simple.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MemIdCheck", value = "/member/IdCheck")
public class MemIdCheck extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");

        MemberService ms=new MemberService();
        Member m=ms.getMember(id);
        System.out.println(id);

        boolean flag=false;
        if(m==null){
            flag=true; //id를 쓸수있다
        }

        //json 형태의 객체를 만듬
        JSONObject json = new JSONObject();

        // view페이지 만들지 않아도 됨. (=페이지를 만든것과 똑같은 코드)
        json.put("flag", flag);
        json.put("id", id);

        String j = json.toJSONString();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        System.out.println("json : "+j);
        //웹페이지에서 작성하는 코드
        response.getWriter().append(j);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
