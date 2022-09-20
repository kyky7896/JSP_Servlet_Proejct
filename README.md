# JSP_Servlet_Proejct
(개인_side) JSP_Servlet 을 이용한 쇼핑몰 프로젝트(2022.07.13~2022.07.18까지 진행, 추가 수정예정)
  
<br>

## 사용 기술셋 : Java(JSP-Servlet), Mysql, CSS3, HTML5, Bootstrap, JavaScript

<br>

## ERD
  <img src="https://user-images.githubusercontent.com/77670592/191177947-727a7596-78dd-4f10-bfc3-6bba0ff606c6.png" width="600" height="500">

<br>

## 기능
- 공통 : 제품목록, 회원가입, 로그인, 로그아웃, 내정보수정, 탈퇴
- Member : 장바구니, 나의주문목록
- Admin : 상품CRUD, 내제품목록, 
  
  <br>

  ## 공통 

  <details>
  <summary> <h3>회원가입 : 아이디 중복체크, 비밀번호 일치확인, 주소api</h3> </summary>
  <div markdown="1">

  ![JSP_회원가입로그인](https://user-images.githubusercontent.com/77670592/191183496-d3d4e709-3025-4471-bd13-ed2261652db0.gif)

  </div>
  </details>

  <details>
  <summary> <h3>로그인 : 아이디 불일치, 비밀번호 불일치시 로그인 불가</h3> </summary>
  <div markdown="1">
  
  ![JSP_로그인불일치](https://user-images.githubusercontent.com/77670592/191184225-721f9492-d142-4946-8a4a-07fd90e742c5.gif)
  </div>
  </details>

  <h3>로그아웃</h3>
  <h3>탈퇴</h3>

  <details>
  <summary> <h3>내정보수정 </h3> </summary>
  <div markdown="1">
  
  ![JSP_회원정보수정](https://user-images.githubusercontent.com/77670592/191184618-1a2d1bd6-3d8d-4f17-9d35-31900cd2a057.gif)
  
  </div>
  </details>

  ## Member
  
  <details>
  <summary> <h3>제품목록 : 가격범위 검색, 제품 이름으로 검색가능 </h3> </summary>
  <div markdown="1">
  
  ![JSP_제품목록](https://user-images.githubusercontent.com/77670592/191188159-0082d88c-620e-4a3f-a580-6965e562969f.gif)
  
  </div>
  </details>
  
  <details>
  <summary> <h3> 장바구니</h3> </summary>
  <div markdown="1">
  
  - 장바구니 추가시 결제수량 조절가능(수정), 삭제, 주문하기 

  ![JSP_장바구니 주문](https://user-images.githubusercontent.com/77670592/191188945-d7e8446b-8520-4469-8221-5490de50a532.gif)
  
  </div>
  </details>
  
  <details>
  <summary> <h3> 주문목록 </h3> </summary>
  <div markdown="1">
 
  - 주문시 현재수량에서 주문갯수만큼 줄어듬.
  - 주문시 주문목록에서 삭제만 가능. 
  
  ![JSP_주문삭제](https://user-images.githubusercontent.com/77670592/191190589-db725ac0-134c-436d-961f-15b30e4b5bee.gif)
  
  </div>
  </details>
  <br>
  <br>
  <br>
  
  ## Admin
  
  <details>
  <summary> <h3> 제품등록, 수정, 삭제 </h3> </summary>
  <div markdown="1">
  
  - 제품 CRUD가능
  
  ![JSP_제품CRUD](https://user-images.githubusercontent.com/77670592/191191866-d969d98e-ad16-4246-a4ea-bf54f95d69bc.gif)
  
  </div>
  </details>
  
  <details>
  <summary> <h3> 내제품 보기 </h3> </summary>
  <div markdown="1">
  
  - 제품 CRUD가능
  
  ![JSP_내제품](https://user-images.githubusercontent.com/77670592/191192684-88afaea7-9acc-4c9a-9619-22d6b4e10f67.gif)
  
  </div>
  </details>
  
