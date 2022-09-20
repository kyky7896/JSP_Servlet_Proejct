<%--
  Created by IntelliJ IDEA.
  User: oiio6
  Date: 2022-07-16
  Time: 오후 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>장바구니 </title>
    <script>
        const edit=(num)=>{
            let ord_amount=document.getElementById("amount_"+num);

            //가상의 form을 만들어서
            let f=document.createElement('form');
            //가상의 input(p_num, p_price, amount을 만듬)
            let prod_num;
            prod_num=document.createElement('input');
            prod_num.setAttribute('type','hidden');
            prod_num.setAttribute('name','num');
            prod_num.setAttribute('value', num);

            let amount;
            amount=document.createElement('input');
            amount.setAttribute('type','hidden');
            amount.setAttribute('name','amount');
            amount.setAttribute('value',ord_amount.value);

            f.appendChild(prod_num);
            f.appendChild(amount);
            f.setAttribute('method','post');
            f.setAttribute('action','${pageContext.request.contextPath}/order/edit');
            document.body.appendChild(f);
            f.submit();

        }

        const del=(num)=>{
            let con=confirm("정말 삭제하시겠습니까?");
            if(con==false){
                return;
            }

            location.href='${pageContext.request.contextPath}/order/del?num='+num
        }
    </script>
</head>
<body>
<h3>장바구니 페이지</h3>

<table class="table">
    <tr>
        <th>주문번호</th>
        <th>수량</th>
        <th>결제금액</th>
        <th>수정/삭제</th>
    </tr>
<c:forEach items="${list}" var="list">
<c:if test="${sessionScope.id==list.consumer and sessionScope.mem == false}">
    <tr>
        <td><input type="number" name="num" id="num" value="${list.num}" readonly></td>
        <td><input type="number" name="amount" id="amount_${list.num}" value="${list.amount}"></td>
        <td><input type="number" name="payment" id="payment_${list.num}" value="${list.payment}" readonly></td>
        <td><input type="button" class="form-control-sm" value="수정" onclick="edit(${list.num})">
            <input type="button" class="form-control-sm" value="삭제" onclick="del(${list.num})">
            <input type="submit" class="form-control-sm" value="주문하기" onclick="location.href='${pageContext.request.contextPath}/order/pay?num=${list.num}'"></td>
    </tr>
</c:if>
</c:forEach>
</table>


</body>
</html>
