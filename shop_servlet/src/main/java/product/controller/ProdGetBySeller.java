package product.controller;

import product.ProdService;
import product.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProdGetBySeller", value = "/prod/GetBySeller")
public class ProdGetBySeller extends HttpServlet {
    //전체 상품 검색하여 /prod/list.jsp로 이동
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session= request.getSession(false);
        String seller=(String)session.getAttribute("id");

        ProdService ps=new ProdService();
        ArrayList<Product> list=ps.getBySeller(seller);
        request.setAttribute("list",list);


        request.setAttribute("path", "/product/list.jsp");
        RequestDispatcher dis=request.getRequestDispatcher("/index.jsp");
        dis.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
