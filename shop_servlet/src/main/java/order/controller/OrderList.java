package order.controller;

import order.Order;
import order.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "OrderList", value = "/order/list")
public class OrderList extends HttpServlet {
    //request.getParameter("ispay") -> true: 결제한 상품목록 출력 => false: 결제안한 상품목록(장바구니)
    //로그인한 구매자의 결제한 주문 목록 출력. 주문번호(클릭시 주문상세페이지), 상품명(클릭 상품 상세페이지), 수량, 결제금액
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //세션에서 id를 꺼내기
        HttpSession session = request.getSession(false);
        String id=(String)session.getAttribute("id");

        OrderService os=new OrderService();

        //id와 idpay가 false인것(결제안됨) 꺼내기
        ArrayList<Order> list;
        list=os.getByPay(false,id);
        System.out.println("OrderList"+list);

        request.setAttribute("list",list);
        request.setAttribute("path", "/order/cart.jsp");
        RequestDispatcher dis=request.getRequestDispatcher("/index.jsp");
        dis.forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
