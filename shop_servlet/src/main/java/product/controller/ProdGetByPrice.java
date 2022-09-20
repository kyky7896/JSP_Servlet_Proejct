package product.controller;

import product.ProdService;
import product.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProdGetByPrice", value = "/prod/GetByPrice")
public class ProdGetByPrice extends HttpServlet {

    //가격으로 검색한 결과(배열)을 request에 담아 /prod/List.jsp에서 출력
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int price1=Integer.parseInt(request.getParameter("price1"));
        int price2=Integer.parseInt(request.getParameter("price2"));

        ProdService ps=new ProdService();
        ArrayList<Product> list=ps.getByPrice(price1,price2);

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
