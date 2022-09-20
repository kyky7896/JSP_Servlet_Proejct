package product.controller;

import product.ProdService;
import product.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProdGetByName", value = "/prod/GetByName")
public class ProdGetByName extends HttpServlet {

    //이름으로 검색한 결과(배열)을 request에 담아 /prod/List.jsp에서 출력
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String name=request.getParameter("name");

        ProdService ps=new ProdService();
        ArrayList<Product> list=ps.getByName(name);
        System.out.println("Prodgetname "+list);
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
