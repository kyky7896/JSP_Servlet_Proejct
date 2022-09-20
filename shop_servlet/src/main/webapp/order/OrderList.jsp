<%--
  Created by IntelliJ IDEA.
  User: oiio6
  Date: 2022-07-17
  Time: 오전 4:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
  <script>
    const del=(num)=>{
      let con=confirm("정말 삭제하시겠습니까?");
      if(con==false){
        return;
      }

      location.href='${pageContext.request.contextPath}/orders/delete?num='+num
    }
  </script>
</head>
<body>
<h3>주문완료 페이지</h3>

<table class="table">
  <tr>
    <th>주문번호</th>
    <th>제품번호</th>
    <th>수량</th>
    <th>결제금액</th>
    <th>결제일</th>
    <th>주문자</th>
    <th>주소</th>
    <th>주문삭제만 가능</th>
  </tr>
  <c:if test="${not empty sessionScope.id and sessionScope.mem == false}">
    <c:forEach items="${list}" var="list">
      <tr>
        <td>${list.num}</td>
        <td><a href="${pageContext.request.contextPath}/prod/detail?num=${list.prod_num}">${list.prod_num}</a></td>
        <td>${list.amount}</td>
        <td>${list.payment}</td>
        <td>${list.w_date}</td>
        <td>${list.consumer}</td>
        <td>${list.addr}</td>
        <td><input type="button" class="form-control-sm" value="삭제" onclick="del(${list.num})"></td>
      </tr>
    </c:forEach>
  </c:if>
</table>
</body>
</html>
