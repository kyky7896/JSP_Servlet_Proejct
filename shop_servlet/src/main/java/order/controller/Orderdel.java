package order.controller;

import order.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Orderdel", value = "/order/del")
public class Orderdel extends HttpServlet {

    //장바구니 목록에서 항목 선택 뒤 삭제버튼 누르면 요청발생. 주문 번호로 삭제한 뒤 장바구니로 이동
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num=Integer.parseInt(request.getParameter("num"));

        OrderService os=new OrderService();
        //장바구니는 ispay=false이기 때문에
        os.delOrder(num,false);

        response.sendRedirect(request.getContextPath()+"/order/list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
