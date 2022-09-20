package product.controller;

import product.ProdService;
import product.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProdList", value = "/prod/list")
public class ProdList extends HttpServlet {
    // seller로 검색한 결과를 리스트 출력. /prod/list.jsp, img1, name, price, seller출력
    // name에 링크 클릭하면 상세페이지로 이동
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProdService ps = new ProdService();

        ArrayList<Product> list = ps.getAll();
        System.out.println(list);
        request.setAttribute("list", list);


        request.setAttribute("path", "/product/list.jsp");
        RequestDispatcher dis = request.getRequestDispatcher("/index.jsp");
        dis.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
