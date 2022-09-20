package product.controller;

import product.ProdService;
import product.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProdEdit", value = "/prod/editForm")
public class ProdEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num=Integer.parseInt(request.getParameter("num"));
        ProdService ps=new ProdService();
        Product p=ps.getByNum(num);


        System.out.println("p값 "+p);
        request.setAttribute("p",p);
        request.setAttribute("path", "/product/editForm.jsp");
        RequestDispatcher dis=request.getRequestDispatcher("/index.jsp");
        dis.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //받아오는거
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        ProdService ps=new ProdService();
        int num=Integer.parseInt(request.getParameter("num"));
        String name=request.getParameter("name");
        String info=request.getParameter("info");
        int price=Integer.parseInt(request.getParameter("price"));
        int amount=Integer.parseInt(request.getParameter("amount"));

        ps.editProduct(new Product(num,name,info,price,amount,"",""));

        request.setAttribute("path", "/product/list.jsp");
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }
}
