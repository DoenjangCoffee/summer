<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>마이페이지</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<link rel="shortcut icon" type="image/x-icon" href="assets/favicon.ico" />
<link rel="apple-touch-icon" sizes="57x57"
	href="assets//apple-icon-57x57.png">
<link rel="apple-touch-icon" sizes="60x60"
	href="assets//apple-icon-60x60.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="assets//apple-icon-72x72.png">
<link rel="apple-touch-icon" sizes="76x76"
	href="assets//apple-icon-76x76.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="assets//apple-icon-114x114.png">
<link rel="apple-touch-icon" sizes="120x120"
	href="assets//apple-icon-120x120.png">
<link rel="apple-touch-icon" sizes="144x144"
	href="assets//apple-icon-144x144.png">
<link rel="apple-touch-icon" sizes="152x152"
	href="assets//apple-icon-152x152.png">
<link rel="apple-touch-icon" sizes="180x180"
	href="assets//apple-icon-180x180.png">
<link rel="icon" type="image/png" sizes="192x192"
	href="assets//android-icon-192x192.png">
<link rel="icon" type="image/png" sizes="32x32"
	href="assets//favicon-32x32.png">
<link rel="icon" type="image/png" sizes="96x96"
	href="assets//favicon-96x96.png">
<link rel="icon" type="image/png" sizes="16x16"
	href="assets//favicon-16x16.png">
<link rel="manifest" href="/manifest.json">
<meta name="msapplication-TileColor" content="#ffffff">
<meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
<meta name="theme-color" content="#ffffff">
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
<!-- jQuery -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<!-- Sweet 팝업창 이쁘게 만들어주는거 -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script type="text/javascript">

	
	function emailAuth(){
		$.ajax({
			url:'./emailAuth',
			type:'post',
			dataType:'text',
			success:function(result){
			if (result == 1) {
				Swal.fire("인증번호를 발송했습니다.","결과: "+result,"info");
			} else {
				Swal.fire("문제가 발생했습니다.","","error");
				//Toast.fire("통신문제","통신문제가 발생했습니다.","info");
			}
			},//success end
			error:function(request, status, error){
				Swal.fire("Error.","관리자에게 문의하세요"+error,"error");
				
			}//error end
		});//ajax end
	}
</script>
</head>
<body id="page-top">
	<!-- Navigation-->
	<%@ include file="menu.jsp" %>
	
	<!-- login -->
	<section class="page-selection" id="myinfo">
		<div class="d-flex justify-content-center">
			<div class="text-center">
				
				<button onclick="emailAuth()">인증번호 요청하기</button>
					
					<div>
						등록된 e-mail로 인증번호가 발사 됩니다.<br>
						e-mail을 확인 후 인증번호를 입력해주세요.
						<form action="">
							<input type="number" name = "number">
							<button>인증하기</button>
					</form>
				</div>
			</div>	
		</div>
	</section>

	<!-- Footer-->
	<footer class="footer py-4">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-4 text-lg-start">Copyright &copy; Your
					Website 2023</div>
				<div class="col-lg-4 my-3 my-lg-0">
					<a class="btn btn-dark btn-social mx-2" href="#!"
						aria-label="Twitter"><i class="fab fa-twitter"></i></a> <a
						class="btn btn-dark btn-social mx-2" href="#!"
						aria-label="Facebook"><i class="fab fa-facebook-f"></i></a> <a
						class="btn btn-dark btn-social mx-2" href="#!"
						aria-label="LinkedIn"><i class="fab fa-linkedin-in"></i></a>
				</div>
				<div class="col-lg-4 text-lg-end">
					<a class="link-dark text-decoration-none me-3" href="#!">이용약관</a>
					<a class="link-dark text-decoration-none" href="/donation">기부 안내</a>
				</div>
			</div>
		</div>
	</footer>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
	
	<!-- 파라미터로 오는 error가 있다면 에러 화면에 출력하기 -->
	<c:if test="${param.error ne null}">
		<script type="text/javascript">
			Swal.fire("Error", "잘못된 접근이었단다.","error");
		</script>
	</c:if>
	<c:if test="${param.login ne null }">
		<script type="text/javascript">
			Swal.fire("로그인 할 수 없습니다.", "올바른 아아디와 비밀번호를 입력해주세요","error");
		</script>
	</c:if>
	<c:if test="${param.count ne null }">
		<script type="text/javascript">
			let count=${param.count};
			if (count < 5) {
				Swal.fire("로그인 할 수 없습니다.", "올바른 아아디와 비밀번호를 입력","error");
			}else{
				Swal.fire("로그인 불가", "더 이상 로그인 할 수 없습니다.", "warning");
			}
		</script>
	</c:if>
</body>
</html>
