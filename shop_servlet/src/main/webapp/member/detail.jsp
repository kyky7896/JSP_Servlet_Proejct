<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: oiio6
  Date: 2022-07-13
  Time: 오후 2:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>z
    <title>Title</title>
</head>
<body>

<%-- 가운데 container 부분 --%>
<div class="container" id="wrap">
    <%--   위쪽부분     --%>
    <div class="row">
        <div class="col-md-11">
            <form class="form-signin" action="${pageContext.request.contextPath}/member/Memdetail" method="post">
                <div class="text-center mb-4">
                    <h1 class="h3 mb-3 font-weight-normal">회원정보</h1>
                </div>

                <div class="form-label-group">
                    <p>아이디</p>
                    <input type="text" id="id" name="id" class="form-control" value="${m.id}" readonly>
                </div>

                <div class="form-label-group">
                    <p>비밀번호 변경</p>
                    <input type="password" id="pwd" name="pwd" class="form-control" value="${m.pwd}">
                </div>

                <div class="form-label-group">
                    <p>멤버 타입</p>
                    <c:if test="${m.mem_type == false}">
                    <p><input type="text" name="mem_type" class="form-control" value="구매자" readonly></p>
                    </c:if>
                    <c:if test="${m.mem_type == true}">
                        <p><input type="text" name="mem_type" class="form-control" value="판매자" readonly></p>
                    </c:if>
                </div>

                <div class="form-label-group">
                    <%--  자바스크립트 전화번호 --%>
                    <p>휴대폰 번호</p>
                    <input type="tel" id="tel" name="tel" class="form-control" value="${m.tel}">
                </div>

                <div class="form-label-group">
                    <%--  주소 다음 api 받아서 넣기  --%>
                    <p>주소</p>
                    <input type="text" id="addr" name="addr" class="form-control" value="${m.addr}">
                </div>

                <button class="btn btn-lg btn-primary" type="submit">회원정보 수정</button>
            </form>
        </div>
    </div>
    <%--  가운데  --%>
    <div class="row">
        <%--  가운데-왼  --%>
        <div class="col-md-3">
        </div>
        <%--  가운데-오  --%>
        <div class="col-md-8">
        </div>
    </div>
    <%--  아래  --%>
    <div class="row">
        <div class="col-md-11">
        </div>
    </div>
</div>

</body>
</html>
