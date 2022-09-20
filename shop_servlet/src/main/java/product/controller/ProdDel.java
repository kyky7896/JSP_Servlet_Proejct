package product.controller;

import product.ProdService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProdDel", value = "/prod/del")
public class ProdDel extends HttpServlet {
    //삭제 완료(번호기준),
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num=Integer.parseInt(request.getParameter("num"));

        ProdService ps=new ProdService();
        ps.delProduct(num);

        response.sendRedirect(request.getContextPath()+"/prod/list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
