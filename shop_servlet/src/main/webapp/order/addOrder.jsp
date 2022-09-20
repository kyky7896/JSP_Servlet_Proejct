<%--
  Created by IntelliJ IDEA.
  User: oiio6
  Date: 2022-07-14
  Time: 오전 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script>
        function findAddr(){
            new daum.Postcode({
                oncomplete: function(data) {

                    console.log(data);

                    // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
                    // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                    // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                    var roadAddr = data.roadAddress; // 도로명 주소 변수
                    var jibunAddr = data.jibunAddress; // 지번 주소 변수
                    // 우편번호와 주소 정보를 해당 필드에 넣는다.
                    document.getElementById('addrPost').value = data.zonecode;
                    if(roadAddr !== ''){
                        document.getElementById("addr").value = roadAddr;
                    }
                    else if(jibunAddr !== ''){
                        document.getElementById("addr").value = jibunAddr;
                    }
                }
            }).open();
        }
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/order/pay" method="post">
<table class="table">
    <tr>
        <th> 주문 번호 </th>
        <td><input type="number" name="num" value="${o.num}" class="form-control" readonly></td>
    </tr>
    <tr>
        <th> 제품 번호 </th>
        <td><input type="number" name="prod_num" value="${o.prod_num}" class="form-control" readonly></td>
    </tr>
    <tr>
        <th> 제품 수량 </th>
        <td><input type="number" name="amount" value="${o.amount}" class="form-control" readonly></td>
    </tr>
    <tr>
        <th> 제품 가격(개당) </th>
        <td><input type="number" name="price" value="${o.price}" class="form-control" readonly></td>
    </tr>
    <tr>
        <th> 결제 금액 </th>
        <td><input type="number" name="payment" value="${o.payment}" class="form-control" readonly></td>
    </tr>
    <tr>
        <th> 주소 입력 </th>
        <td><input type="text" id="addrPost" name="addrPost" class="form-control" placeholder="주소를 입력하세요" readonly onclick="findAddr()">
            <input type="text" name="addr" id="addr" value="${m.addr}" class="form-control"></td>
    </tr>
    <tr>
        <th> 주문하기 </th>
        <td><input type="submit" class="form-control" value="주문하기"></td>
    </tr>
</table>
</form>

</body>
</html>
