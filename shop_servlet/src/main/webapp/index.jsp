<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
    <script>
        var msg='${msg}';
        if(msg != null && msg != ''){
            alert(msg);
            location.href='${pageContext.request.contextPath}/member/Login';
        }


    </script>
</head>
<body>

<%-- bootstrap header --%>
<header class="p-3 bg-dark text-white">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="${pageContext.request.contextPath}/index.jsp" class="nav-link px-2 text-secondary">Home</a></li>

                <%--    구매자. 판매자 아니더라도 볼수있는 목록   --%>
                <li><a href="#" class="nav-link px-2 text-white">준비중....</a></li>
                <li><a href="#" class="nav-link px-2 text-white">준비중....</a></li>
                <%--    구매자일때     --%>
                <c:if test="${not empty sessionScope.id and sessionScope.mem == false}">
                <li><a href="${pageContext.request.contextPath}/prod/list" class="nav-link px-2 text-white">제품목록</a></li>
                <li><a href="${pageContext.request.contextPath}/order/list" class="nav-link px-2 text-white">장바구니</a></li>
                <li><a href="${pageContext.request.contextPath}/order/orders" class="nav-link px-2 text-white">나의 주문목록</a></li>
                </c:if>
                <%--    판매자일때    --%>
                <c:if test="${not empty sessionScope.id and sessionScope.mem == true}">
                    <li><a href="${pageContext.request.contextPath}/prod/add" class="nav-link px-2 text-white">상품등록</a></li>
                    <li><a href="${pageContext.request.contextPath}/prod/list" class="nav-link px-2 text-white">제품목록</a></li>
                    <li><a href="${pageContext.request.contextPath }/prod/GetBySeller" class="nav-link px-2 text-white">내 상품목록</a></li>
                </c:if>
            </ul>


            <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
                <input type="search" class="form-control form-control-dark text-white bg-dark" placeholder="Search..." aria-label="Search">
            </form>

            <c:if test="${empty sessionScope.id }">
            <div class="text-end">
                <button type="button" class="btn btn-outline-light me-2" onclick="location.href='${pageContext.request.contextPath}/member/Login'">로그인</button>
                <button type="button" class="btn btn-warning" onclick="location.href='${pageContext.request.contextPath}/member/Join'">회원가입</button>
            </div>
            </c:if>

            <%--     Session이 안비어있으면     --%>
            <c:if test="${not empty sessionScope.id }">
            <div class="text-end">
                <p>${sessionScope.id} 님
                        <c:if test="${sessionScope.mem==false}">
                            (구매자) 로그인 중입니다 </p>
                        </c:if>
                        <c:if test="${sessionScope.mem==true}">
                            (판매자) 로그인 중입니다 </p>
                        </c:if>
                <button type="button" class="btn btn-outline-light mr-1" onclick="location.href='${pageContext.request.contextPath}/member/Memdetail'">내정보확인</button>
                <button type="button" class="btn btn-outline-light me-2" onclick="location.href='${pageContext.request.contextPath}/member/MemLogout'">로그아웃</button>
                <button type="button" class="btn btn-outline-light me-2" onclick="location.href='${pageContext.request.contextPath}/member/MemDelete'">탈퇴</button>
            </div>
            </c:if>
        </div>
    </div>
</header>"


<%-- 가운데 container 부분 --%>
<div class="container" id="wrap">
    <div class="row">
        <div class="col-md-11"></div>
            <%-- 비어있지 않으면 path를 넣은 곳 합하기 --%>
        <c:if test="${not empty path and path!='' }">
            <jsp:include page="${path}"></jsp:include>
        </c:if>

    </div>
    <div class="row">
        <div class="col-md-3">

        </div>
        <div class="col-md-8">

        </div>
    </div>
    <div class="row">
        <div class="col-md-11">

        </div>
    </div>
</div>

<footer class="footer mt-auto py-3 bg-light">
    <div class="container">
        <span class="text-muted">Place sticky footer content here.</span>
    </div>
</footer>

</body>
</html>