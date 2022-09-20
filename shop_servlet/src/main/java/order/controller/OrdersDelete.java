package order.controller;

import order.Order;
import order.OrderService;
import product.ProdService;
import product.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OrdersDelete", value = "/orders/delete")
public class OrdersDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num=Integer.parseInt(request.getParameter("num"));
        OrderService os=new OrderService();
        //삭제하기전 주문했던 수량만큼 판매수량 늘려줘야함.
        ProdService ps=new ProdService(); //product 객체 받아오기 준비
        
        Order o=os.getByNum(num); //주문번호로 검색해서 주문객체 받아옴
        int orderNum=o.getProd_num();
        Product p=ps.getByNum(orderNum); //주문객체의 product_num과 같은 상품객체

        //상품수량이 주문수량보다 적든 많든 환불개념이기에 더해줌
        ps.editAmount(p.getNum(),+o.getAmount());

        //삭제해줌
        os.delOrder(num,true);

        

        response.sendRedirect(request.getContextPath()+"/order/orders");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }
}
