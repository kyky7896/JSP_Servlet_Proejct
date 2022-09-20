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
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script type="text/javascript">
        const Dcheck=()=>{
            let id=f1.id.value;

            //비동기 객체 생성
            const xhttp=new XMLHttpRequest();

            //2. 요청 객체 오픈. 요청 설정. 서버 페이지 경로
            xhttp.open("POST", "${pageContext.request.contextPath}/member/IdCheck", true);
            xhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded;charset=utf-8');
            let param="id="+id; //key=value의 형태로 보내줘야함.
            console.log(id)
            console.log(param)

            xhttp.send(param);

            //핸들러 등록 : 요청에 대한 응답이 왔을때 자동 호출될 함수 등록
            xhttp.onload=function (){
                //응답 처리 내용
                if(xhttp.status==200) {
                    let resVal = xhttp.responseText; // 텍스트 응답
                    console.log("resVal "+resVal);
                    let obj=JSON.parse(resVal); //응답 값을 JSON으로 파싱하기 {id:aaa}
                    let msg="사용 불가능한 아이디";
                    if(obj.flag){ //true면
                        msg="사용 가능한 아이디 입니다.";
                    }else{
                        msg="사용 불가능한 아이디 입니다.";
                        id.value="";
                    }
                    let dcheck = document.getElementById("dcheck");
                    dcheck.innerText = msg;
                }else{
                    alert(xhttp.status);
                }

            }


        }

        function passConfirm() {
            /* 비밀번호, 비밀번호 확인 입력창에 입력된 값을 비교해서 같다면 비밀번호 일치, 그렇지 않으면 불일치 라는 텍스트 출력.*/
            /* document : 현재 문서를 의미함. 작성되고 있는 문서를 뜻함. */
            /* getElementByID('아이디') : 아이디에 적힌 값을 가진 id의 value를 get을 해서 password 변수 넣기 */
            var password = document.getElementById('pwd');					//비밀번호
            var passwordConfirm = document.getElementById('pwd2');	//비밀번호 확인 값
            var confirmMsg = document.getElementById('confirmMsg');				//확인 메세지
            var correctColor = "#00ff00";	//맞았을 때 출력되는 색깔.
            var wrongColor ="#ff0000";	//틀렸을 때 출력되는 색깔

            if(password.value===passwordConfirm.value){//password 변수의 값과 passwordConfirm 변수의 값과 동일하다.
                confirmMsg.style.color = correctColor;/* span 태그의 ID(confirmMsg) 사용  */
                confirmMsg.innerHTML ="비밀번호 일치";/* innerHTML : HTML 내부에 추가적인 내용을 넣을 때 사용하는 것. */
            }else{
                confirmMsg.style.color = wrongColor;
                confirmMsg.innerHTML ="비밀번호 불일치";
            }
        }

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


<%-- 가운데 container 부분 --%>
<div class="container" id="wrap">
    <%--   위쪽부분     --%>
    <div class="row">
        <div class="col-md-11">
        <form class="form-signin" id="f1" action="${pageContext.request.contextPath}/member/Join" method="post">
            <div class="text-center mb-4">
                <h1 class="h3 mb-3 font-weight-normal">회원가입</h1>

            <div class="form-label-group">
                <label for="id">아이디 :</label>
                    <input type="text" id="id" name="id" class="form-control" placeholder="아이디를 입력하세요." required>
                    <input type="button" class="btn btn-sm" value="중복 체크" onclick="Dcheck()">
                    <div class="row" id="dcheck"></div>

            </div>

            <div class="form-label-group">
                <label for="pwd">비밀번호:</label>
                <input type="password" id="pwd" name="pwd" class="form-control" placeholder="비밀번호를 입력하세요" required>
            </div>

            <div class="form-label-group">
                <%--  자바스크립트 비밀번호 확인기능 넣기  --%>
                <p> <label for="pwd2">비밀번호 확인: </label>
                    <input type="password" id="pwd2" name="pwd" class="form-control" placeholder="같은 비밀번호를 입력하세요" onkeyup="passConfirm()" required>
                    <div id="confirmMsg"></div>
                </p>
            </div>

            <div class="form-label-group">
                <p>구매자 이신가요? <input type="radio" id="consumer" name="mem_type" value="false" class="form-control-sm">
                    판매자 이신가요? <input type="radio" id="seller" name="mem_type" value="true" class="form-control-sm"></p>
            </div>

            <div class="form-label-group">
                <%--  자바스크립트 전화번호 --%>
                <label for="tel">휴대폰 번호 : </label>
                    <input type="tel" id="tel" name="tel" class="form-control" placeholder="전화번호" required>
            </div>

            <div class="form-label-group">
                <%--  주소 다음 api 받아서 넣기  --%>
                <label for="addr">주소 : </label>
                <input type="text" id="addrPost" name="addrPost" class="form-control" placeholder="주소를 입력하세요" readonly onclick="findAddr()">
                <input type="text" id="addr" name="addr" class="form-control" placeholder="주소를 입력하세요" required >

            </div>

            <button class="btn btn-lg btn-primary" type="submit">회원가입</button>
            </div>
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
