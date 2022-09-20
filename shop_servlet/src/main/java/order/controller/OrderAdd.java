package order.controller;


import order.Order;
import order.OrderService;
import product.ProdService;
import product.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "OrderAdd", value = "/order/add")
public class OrderAdd extends HttpServlet {

    //장바구니 add
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int prod_num=Integer.parseInt(request.getParameter("prod_num"));
        int amount=Integer.parseInt(request.getParameter("amount"));
        int p_price=Integer.parseInt(request.getParameter("p_price"));

        //세션에서 id를 꺼내기
        HttpSession session = request.getSession(false);
        String id=(String)session.getAttribute("id");

        //장바구니에 넣은 제품과 같은 name을 찾아서 출력하기 위해서 담아주기
        ProdService ps=new ProdService();
        Product p=ps.getByNum(prod_num);

        //장바구니에 넣기(addr제외)
        Order o;
        OrderService os=new OrderService();
        o=new Order(0,prod_num,amount,amount*p_price,null,id,null,false, p.getPrice());
        os.addOrder(o);



        //
        //        //내가 넣은 장바구니 목록(아직 주문안함) 출력기 위해서
        ArrayList<Order> list = os.getByPay(false,id);

        System.out.println("장바구니 list"+list);

        request.setAttribute("list",list);

        request.setAttribute("path", "/order/cart.jsp");
        RequestDispatcher dis=request.getRequestDispatcher("/index.jsp");
        dis.forward(request,response);
    }

    // 구매완료, 상품번호, 수량 결제금액, 구매자 id 파람으로 받아 order테이블에 추가하고 상품목록으로 이동
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
