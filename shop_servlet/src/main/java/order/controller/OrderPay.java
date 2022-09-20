package order.controller;

import member.Member;
import member.MemberService;
import order.Order;
import order.OrderService;
import product.ProdService;
import product.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "OrderPay", value = "/order/pay")
public class OrderPay extends HttpServlet {

    //주문번호 받아서 pay만 true로 변경. 상품목록으로 이동
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num=Integer.parseInt(request.getParameter("num"));

        OrderService os=new OrderService();
        Order o=os.getByNum(num);
        
        //세션의 id를 가로챈다음
        HttpSession session=request.getSession(false);
        String id=(String)session.getAttribute("id");

        MemberService ms=new MemberService();
        //멤버의 정보를 꺼냄
        Member m=ms.getMember(id);
        

        System.out.println("OrderPay"+o);
        request.setAttribute("o",o);
        //멤버의 정보도 보냄
        request.setAttribute("m",m);
        request.setAttribute("path", "/order/addOrder.jsp");
        RequestDispatcher dis = request.getRequestDispatcher("/index.jsp");
        dis.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        int num=Integer.parseInt(request.getParameter("num"));
        String addr=request.getParameter("addr");

        HttpSession session=request.getSession(false);
        String id=(String)session.getAttribute("id");

        //주문
        OrderService os=new OrderService();
        os.editPay(num,addr);
        System.out.println("num, addr, ispay=true로 수정완료");


        String Ordermsg="";
        //주문 완료된 객체를 받아옴
        Order o=os.getByNum(num);

        //주문한 수량만큼 product개수 차감
        ProdService ps=new ProdService();
            //order의 prod_num을 받아와서 product의 정보를 가져옴
            int orderNum=o.getProd_num();
            Product p=ps.getByNum(orderNum);
            //상품수량>=주문수량 이면 주문 수량을 뺌.
            if(p.getAmount()>=o.getAmount()){
                ps.editAmount(p.getNum(),-o.getAmount());
            }else{
                Ordermsg="출고취소!!";
            }

        Ordermsg="!!!!!!!!!!!!주문완료!!!!!!!!!!!!";

        response.sendRedirect(request.getContextPath()+"/order/orders");
    }
}
