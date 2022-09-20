<%--
  Created by IntelliJ IDEA.
  User: oiio6
  Date: 2022-07-13
  Time: 오후 3:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="col-md-7 col-lg-8">
    <h4 class="mb-3">상품 등록</h4>
    <form class="needs-validation" method="post" action="${pageContext.request.contextPath}/prod/add" enctype="multipart/form-data">
        <div class="row g-3">
            <div class="col-sm-12">
                <label for="name" class="form-label">상품 이름 </label>
                <input type="text" class="form-control" id="name" name="name" placeholder="상품 이름을 입력하세요">
                <div class="invalid-feedback">
                    상품이름이 입력되지 않았습니다.
                </div>
            </div>

            <div class="col-12">
                <label for="seller" class="form-label">판매자</label>
                <div class="input-group has-validation">
                    <span class="input-group-text">@</span>
                    <input type="text" class="form-control" id="seller" name="seller" placeholder="판매자 이름" value="${sessionScope.id}" readonly>
                    <div class="invalid-feedback">
                        판매자 이름이 입력되지 않았습니다.
                    </div>
                </div>
            </div>

            <div class="col-6">
                <label for="price" class="form-label">가격</label>
                <input type="number" class="form-control" id="price" name="price" placeholder="가격을 입력하세요">
                <div class="invalid-feedback">
                    가격이 입력되지 않았습니다.
                </div>
            </div>

            <div class="col-6">
                <label for="amount" class="form-label">수량</label>
                <input type="number" class="form-control" id="amount" name="amount" placeholder="수량을 입력하세요">
                <div class="invalid-feedback">
                    수량이 입력되지 않았습니다
                </div>
            </div>

            <div class="col-12">
                <label for="info" class="form-label">상세 내용</label>
                <textarea class="form-control" id="info" name="info" placeholder="상세내용을 입력하세요"></textarea>
                <div class="invalid-feedback">
                    상세 내용이 입력되지 않았습니다
                </div>
            </div>

            <div class="my-3">
                <label for="img1" class="form-label">이미지1</label>
                <input type="file" class="form-control" id="img1" name="img1">
                <label for="img2" class="form-label">이미지2</label>
                <input type="file" class="form-control" id="img2" name="img2">
                <label for="img3" class="form-label">이미지3</label>
                <input type="file" class="form-control" id="img3" name="img3">
            </div>


            <button class="w-100 btn btn-primary btn-lg" type="submit">상품 등록하기</button>
        </div>
    </form>
</div>
</body>
</html>
