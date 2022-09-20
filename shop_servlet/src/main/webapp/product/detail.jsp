<%--
  Created by IntelliJ IDEA.
  User: oiio6
  Date: 2022-07-13
  Time: 오후 3:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <script>
        const del=()=>{
            let del=confirm("정말 삭제하시겠습니까?");
            if(del==false){
                return;
            }
            location.href='${pageContext.request.contextPath}/prod/del?num=${p.num}'
        }

        const Orderadd=()=>{
            //amount값을 가져오기
            let ord_amount=document.getElementById("ord_amount");

            alert(${p.num}+"번호 / "+ord_amount.value+"개수 / "+${p.price});

                //가상의 form을 만들어서
                let f=document.createElement('form');
                //가상의 input(p_num, p_price, amount을 만듬)
                let prod_num;
                prod_num=document.createElement('input');
                prod_num.setAttribute('type','hidden');
                prod_num.setAttribute('name','prod_num');
                prod_num.setAttribute('value',${p.num});

                let amount;
                amount=document.createElement('input');
                amount.setAttribute('type','hidden');
                amount.setAttribute('name','amount');
                amount.setAttribute('value',ord_amount.value);

                let prod_price;
                prod_price=document.createElement("input");
                prod_price.setAttribute("type","hidden");
                prod_price.setAttribute("name","p_price");
                prod_price.setAttribute("value",${p.price});


                f.appendChild(prod_num);
                f.appendChild(amount);
                f.appendChild(prod_price)
                f.setAttribute('method','post');
                f.setAttribute('action','${pageContext.request.contextPath}/order/add');
                document.body.appendChild(f);
                f.submit();
        }
    </script>
</head>
<body>
<%--로그인한 판매자만 수정가능하게 --%>
<c:if test="${sessionScope.id==p.seller and sessionScope.mem == true}">
    <div class="row">
        <button type="button" class="btn btn-primary-sm" onclick="location.href='${pageContext.request.contextPath}/prod/editForm?num=${p.num}'">수정하기</button>
        <button type="button" class="btn btn-primary-sm" onclick="del()">삭제하기</button>
    </div>
</c:if>
    <table class="table">
        <tr>
            <td rowspan="7" style="height:400px; width:300px"><img src="../imgs/${fn:split(p.img1 ,',')[0]}" style="height:400px"></td>
        </tr>

        <tr>
            <th>이름</th>
            <td>${p.name}</td>
        </tr>

        <tr>
            <th>정보</th>
            <td>${p.info}</td>

        </tr>
        <tr>
            <th>가격</th>
            <td>${p.price}</td>
        </tr>

        <tr>
            <th>현재수량</th>
            <td>${p.amount}</td>
        </tr>
        <tr>
            <th>판매자</th>
            <td>${p.seller}</td>
        </tr>

        <tr>
            <%-- 구매자만 장바구니 접근 가능함 --%>
            <c:if test="${not empty sessionScope.id and sessionScope.mem == false}">
            <th>원하는 수량입력</th>
            <td><input type="number" name="ord_amount" id="ord_amount"></td>
            <td><a onclick="Orderadd()">장바구니 담기</a></td>
            <%--         ${pageContext.request.contextPath}/order/add       --%>
            </c:if>
        </tr>

        <tr>
            <td>
            <c:forTokens delims="," items="${p.img1}" var="img1">
                <img src="../imgs/${img1}">
            </c:forTokens>
            </td>
        </tr>
    </table>
<

</body>
</html>
