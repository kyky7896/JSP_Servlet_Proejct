package product.controller;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import product.ProdService;
import product.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;

@WebServlet(name = "ProdAdd", value = "/prod/add")
public class ProdAdd extends HttpServlet {

    //상품 등록 페이지. /product/addForm.jsp로 이동
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("path", "/product/addForm.jsp");
        RequestDispatcher dis=request.getRequestDispatcher("/index.jsp");
        dis.forward(request,response);
    }

    //등록 완료. 내 상품 등록 목록으로 이동
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProdService ps=new ProdService();
        int num = ps.makeNum();// 상품번호 생성

        String imgPath=request.getSession().getServletContext().getRealPath("/imgs");
//        String dirName = imgPath +"/"+ num;
//        //만약 path의 dir에 num와 같은 폴더 없으면 만들기
//
//        File dir = new File(dirName);
//        if (!dir.exists()) {
//            dir.mkdir();
//        }

        // cos.jar에 구현된 클래스. 파일업로드 구현한 클래스
        MultipartRequest req=new MultipartRequest(request, imgPath, 100*1024*1024,"utf-8",new DefaultFileRenamePolicy());


        String name=req.getParameter("name");
        String seller=req.getParameter("seller");
        int price=Integer.parseInt(req.getParameter("price"));
        int amount=Integer.parseInt(req.getParameter("amount"));
        String info=req.getParameter("info");


        Enumeration e=req.getFileNames();
        String img1=""; //,로 담기위한 값
        while(e.hasMoreElements()){
            String parameter=(String)e.nextElement();
//            String img1=req.getOriginalFileName("imgs");
//            String fileRealName=req.getFilesystemName("imgs");//실제 서버에 올라간 이름

            String FileName=req.getOriginalFileName(parameter);
            //imgs를 img1에 ,로 담음
            img1+=FileName+",";
        }

        ps.addProduct(new Product(0,name,info,price,amount,seller,img1));


        request.setAttribute("path", "/prod/list");
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }
}
