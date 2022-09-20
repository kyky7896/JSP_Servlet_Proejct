package order.controller;

import member.Member;
import member.MemberService;
import order.Order;
import order.OrderService;
import org.json.simple.JSONObject;
import product.ProdService;
import product.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OrderEdit", value = "/order/edit")
public class OrderEdit extends HttpServlet {

   //장바구니 amount만 수정
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderService os=new OrderService();
        int num = Integer.parseInt(request.getParameter("num"));
        int amount=Integer.parseInt(request.getParameter("amount"));

        os.editOrder(new Order(num,0,amount,0,null,null,null,false,0));


        response.sendRedirect(request.getContextPath()+"/order/list");

    }

    //수정완료. 장바구니로 이동
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
