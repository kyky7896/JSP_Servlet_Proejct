package order.controller;

import order.Order;
import order.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Orders", value = "/order/orders")
public class Orders extends HttpServlet {
    
    //주문 완료 리스트
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        String id=(String)session.getAttribute("id");

        OrderService os=new OrderService();
        //consumer가 현재 로그인한 아이디이고 ispay가 true(주문완료)인 list를 받아옴
        ArrayList<Order> list=os.myOrderList(id);

        request.setAttribute("list", list);
        request.setAttribute("path", "/order/OrderList.jsp");

        RequestDispatcher dis=request.getRequestDispatcher("/index.jsp");
        dis.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
