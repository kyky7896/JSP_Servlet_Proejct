<%--
  Created by IntelliJ IDEA.
  User: oiio6
  Date: 2022-07-15
  Time: 오후 12:05
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
<c:if test="${not empty sessionScope.id and sessionScope.mem == true}">
    <div class="col-md-12">
        <button type="button" class="btn btn-primary-sm" onclick="location.href='${pageContext.request.contextPath}/prod/add'">글쓰기</button>
        <%--    내상품만 보기    --%>
        <input type="button" class="btn btn-primary-sm" onclick="location.href='${pageContext.request.contextPath}/prod/GetBySeller'" value="내 상품만 보기">
    </div>
</c:if>

<div class="row">
    <!-- 이미지 데이터가 있는 만큼 반복처리 -->
    <c:forEach items="${list}" var="list">
    <%--  하나의 이미지 표시  --%>
    <div class="col-md-4">
        <div class="thumbnail">
            <a href="${pageContext.request.contextPath}/prod/detail?num=${list.num}">
                <img src="../imgs/${fn:split(list.img1 ,',')[0]}" alt="${list.name}" style="width:100%">
                <div class="caption">
                    <a href="${pageContext.request.contextPath}/prod/detail?num=${list.num}">    ${list.name}    </a>
                </div>
            </a>
        </div>
    </div>
    </c:forEach>
</div>

<div class="col-md-10">
    <form action="${pageContext.request.contextPath}/prod/GetByName" method="post">
        제품명 검색 : <input type="text" name="name" >
        <input type="submit" class="btn btn-dark mr-1" value="제품명 검색" >
    </form>
</div>

<div class="col-md-10">
    <form action="${pageContext.request.contextPath}/prod/GetByPrice" method="post">
        가격 범위로 검색 :
        <input type="text" name="price1" class="form-control-sm"> ~ <input type="text" name="price2" class="form-control-sm">
        <input type="submit" class="btn btn-dark mr-1" value="가격범위로 검색">
    </form>
</div>

</body>
</html>
