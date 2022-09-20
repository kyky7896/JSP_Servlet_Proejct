<%--
  Created by IntelliJ IDEA.
  User: oiio6
  Date: 2022-07-13
  Time: 오후 2:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>

<%-- 가운데 container 부분 --%>
<div class="container" id="wrap">
    <%--  가운데 - 위쪽  --%>
    <div class="row">
        <div class="col-md-11">
        <form class="form-signin" action="${pageContext.request.contextPath}/member/Login" method="post">
            <div class="text-center mb-4">
                <h1 class="h3 mb-3 font-weight-normal">로그인</h1>
            </div>

            <div class="form-label-group">
                <p>ID</p>
                <input type="id" id="id" name="id" class="form-control" placeholder="아이디">
            </div>
            <div class="form-label-group">
                <p>Password</p>
                <input type="password" id="pwd" name="pwd" class="form-control" placeholder="패스워드" >
            </div>

            <button class="btn btn-lg btn-primary" type="submit">로그인</button>
            <button class="btn btn-lg btn-primary" type="button" onclick="location.href='${pageContext.request.contextPath}/member/Join'">회원가입</button>

        </form>
        </div>
    </div>
        <%--  가운데 - 왼쪽  --%>
    <div class="row">
        <div class="col-md-3">
        </div>
        <%--  가운데 - 오른쪽  --%>
        <div class="col-md-8">
        </div>
    </div>
        <%--  가운데 - 아래  --%>
    <div class="row">
        <div class="col-md-11">
        </div>
    </div>
</div>

</body>
</html>
