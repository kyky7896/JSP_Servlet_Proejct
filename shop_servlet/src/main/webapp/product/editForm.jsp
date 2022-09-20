<%--
  Created by IntelliJ IDEA.
  User: oiio6
  Date: 2022-07-15
  Time: 오후 5:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>

</head>
<body>

<%--판매자만 수정가능하게 함. --%>
<form action="${pageContext.request.contextPath}/prod/editForm?num=${p.num}" method="post">
<table class="table">
    <tr>
        <td rowspan="6" size="height:400px"><img src="../imgs/${fn:split(p.img1 ,',')[0]}" style="height:400px"></td>
    </tr>

    <tr>
        <th>이름</th>
        <td><input type="text" name="name" value="${p.name}"></td>
    </tr>

    <tr>
        <th>정보</th>
        <td><input type="text" name="info" value="${p.info}"></td>

    </tr>
    <tr>
        <th>가격</th>
        <td><input type="number" name="price" value="${p.price}"></td>
    </tr>

    <tr>
        <th >현재수량</th>
        <td ><input type="number" name="amount" value="${p.amount}"></td>
    </tr>
    <tr>
        <th>판매자</th>
        <td><input type="text" name="seller" value="${p.seller}" readonly></td>
    </tr>
    <tr>
        <td>
            <c:forTokens delims="," items="${p.img1}" var="img1">
                <img src="../imgs/${img1}" style="height: 400px">
            </c:forTokens>
        </td>
    </tr>
</table>
<c:if test="${sessionScope.id==p.seller and sessionScope.mem == true}">
    <button type="submit" class="btn btn-dark mr-1"> 수정하기 </button>
    <button type="button" class="btn btn-dark mr-1" value="back" onclick="history.go(-1)"> 뒤로가기 </button>
</c:if>
</form>

</body>
</html>
