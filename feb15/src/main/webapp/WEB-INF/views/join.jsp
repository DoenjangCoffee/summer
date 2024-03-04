<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>회원가입</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<link rel="shortcut icon" type="image/x-icon" href="assets/favicon.ico" />
<link rel="apple-touch-icon" sizes="57x57" href="assets//apple-icon-57x57.png">
<link rel="apple-touch-icon" sizes="60x60" href="assets//apple-icon-60x60.png">
<link rel="apple-touch-icon" sizes="72x72" href="assets//apple-icon-72x72.png">
<link rel="apple-touch-icon" sizes="76x76" href="assets//apple-icon-76x76.png">
<link rel="apple-touch-icon" sizes="114x114" href="assets//apple-icon-114x114.png">
<link rel="apple-touch-icon" sizes="120x120" href="assets//apple-icon-120x120.png">
<link rel="apple-touch-icon" sizes="144x144"href="assets//apple-icon-144x144.png">
<link rel="apple-touch-icon" sizes="152x152" href="assets//apple-icon-152x152.png">
<link rel="apple-touch-icon" sizes="180x180" href="assets//apple-icon-180x180.png">
<link rel="icon" type="image/png" sizes="192x192" href="assets//android-icon-192x192.png">
<link rel="icon" type="image/png" sizes="32x32" href="assets//favicon-32x32.png">
<link rel="icon" type="image/png" sizes="96x96" href="assets//favicon-96x96.png">
<link rel="icon" type="image/png" sizes="16x16" href="assets//favicon-16x16.png">
<link rel="manifest" href="/manifest.json">
<meta name="msapplication-TileColor" content="#ffffff">
<meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
<meta name="theme-color" content="#ffffff">
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
<link href="css/notice.css" rel="stylesheet" />
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script type="text/javascript">
   
function idCheck(){
   var id = document.getElementById("id").value;
   if (id.search(/\W|\s/g) > -1) {
      alert("아이디에 공백 또는 특수문자를 포함 할 수 없습니다.");
   }else{
      $(function(){
         $.ajax({
         url:"/idCheck",
         dataType:"text",
         tyep:"get",
         data:{"id":id},
         success:function(result){
            if (result == 1) {
               alert("이미 존재하는 아이디 입니다.");               
            } else {
               alert("사용 가능한 아이디 입니다.");
               
            }
         },
         error:function(error){
            alert("관리자에게 문의하세요");
         }
      }); // ajax end
            
   });// jquery end
   }
   //const checkId=id.replaceAll(/[\s]/g,"");
}

function nickCheck(){
   const nickName = document.getElementById("nickname").value;
   if (nickName.search(/[^a-zA-Z-ㄱ-ㅎ가-힣-0-9]|\s/g) > -1) {
      alert("닉네임에 공백 또는 특수문자를 포함 할 수 없습니다.");
   }else{
      $(function(){
         $.ajax({
            url:"/nickCheck",
            dataType:"text",
            type:"post",
            data:{"nick":nickName},
            success:function(result){
               if (result == 1) {
                  alert("이미 존재하는 닉네임입니다.");
               } else {
                  alert("사용 가능한 닉네임입니다.");
               }
            },
            error:function(error){
               alert("관리자에게 문의하세요");
            }
         });//ajax end
      });//jquery end
   }
}

function checkForm(){
   const InputId = document.getElementById("id").value.trim();
   const InputPassword = document.getElementById("password").value.trim();
   const InputPassword2 = document.getElementById("password2").value.trim();
   const InputNickName = document.getElementById("nickname").value.trim();
   const InputEmail = document.getElementById("email").value.trim();
   
   const id = InputId.length >=2;
   const password = InputPassword.length >= 2;
   const password2 = InputPassword2.length >=2;
   const nickname = InputNickName.length >=2;
   const email = InputEmail.length >=2;
   
   const allForm = id && password && password2 && nickname && email;
   
   document.getElementById("join").disabled = !allForm;
}

</script>
</head>
<body id="page-top">
   <!-- Navigation-->
   <%@ include file="menu.jsp" %>
   
   <section>
      <h1>회원가입</h1>
      <div class ="container bg-success">
         <div class="row justify-content-md-center m-3 p-3 ">
            <label class="col-2 fw-bold fs-4">아이디</label>
            <input class="form-control col" type="text" id="id" name="id" onkeyup="checkForm()">
            &nbsp;<button type="button" class="btn btn-danger col-2 fw-bold" onclick="idCheck()">중복검사</button>
         </div>
         <div class="row justify-content-md-center m-3 p-3">
            <span class="fw-bold align-middel col-2 fs-4">비밀번호</span>
            <input class="form-control col" type="password" id="password" onkeyup="checkForm()">
         <div class = "row justify-content-md-center m-1 p-1">
            <span class="fw-bold align-middel col-2 fs-4" >확인</span>
            <input class="form-control col" type="password" id="password2" onkeyup="checkForm()">
         </div>
         <div class="row justify-content-md-center m-3 p-3">
            <label class="col-2 fw-bold fs-4">닉네임</label>
            <input class="form-control col" type="text" id="nickname" onkeyup="checkForm()">
            &nbsp;<button type="button" class="btn btn-danger col-2 fw-bold" onclick="nickCheck()">중복검사</button>
            <label>닉네임은 한글, 영어[대소문자] 10자 이내(특수문자,공백 불가)</label>
         </div>
         <div class="row justify-content-md-center m-3 p-3">
         <label class="col-2 fw-bold fs-4">이메일</label>
         <input class="form-control col" type="text" id="email" onkeyup="checkForm()">@
            <select class="form-select col " id="domain-list">
              <option value="naver.com">naver.com</option>
              <option value="google.com">google.com</option>
              <option value="hanmail.net">hanmail.net</option>
              <option value="nate.com">nate.com</option>
              <option value="kakao.com">kakao.com</option>
            </select>
         </div>   
         <button type="button" class="btn btn-dark btn-lg p-2 m-2 float-end" id="join" disabled>가입하기</button>
      </div>
   </div>   
   </section>
    <footer class="footer py-4">
      <div class="container">
         <div class="row align-items-center">
            <div class="col-lg-4 text-lg-start">Copyright &copy; M Company 2024</div>
            <div class="col-lg-4 my-3 my-lg-0">
               <a class="btn btn-dark btn-social mx-2" href="https://twitter.com/?lang=ko"aria-label="Twitter"><i class="fab fa-twitter"></i></a>
               <a class="btn btn-dark btn-social mx-2" href="#!" aria-label="Facebook"><i class="fab fa-facebook-f"></i></a>
               <a class="btn btn-dark btn-social mx-2" href="#!" aria-label="LinkedIn"><i class="fab fa-linkedin-in"></i></a>
            </div>
            <div class="col-lg-4 text-lg-end">
               <a class="link-dark text-decoration-none me-3" href="#!">이용약관</a> 
               <a class="link-dark text-decoration-none" href="/donation">기부금 안내</a>
            </div>
         </div>
      </div>
   </footer>
   <!-- Bootstrap core JS-->
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
   
   <!-- Core theme JS-->
   <script src="js/scripts.js"></script>
   <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>

</body>
</html>