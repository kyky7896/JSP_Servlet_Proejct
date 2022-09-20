package product.controller;

import product.ProdService;
import product.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProdDetail", value = "/prod/detail")
public class ProdDetail extends HttpServlet {

    //상품번호로 검색을 해서 상품객체를 request에 담아 /prod/detail.jsp로 이동 전체 데이터 출력
    //수정폼 역할도 하므로 (상품이름, 설명, 가격, 수량) 변경할 수 있도록 텍스트 박스에 출력. 수정, 삭제 버튼
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int num=Integer.parseInt(request.getParameter("num"));
       ProdService ps=new ProdService();
       Product p=ps.getByNum(num);


       System.out.println("p값 "+p);
       request.setAttribute("p",p);
       request.setAttribute("path", "/product/detail.jsp");
       RequestDispatcher dis=request.getRequestDispatcher("/index.jsp");
       dis.forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request, response);
    }
}
