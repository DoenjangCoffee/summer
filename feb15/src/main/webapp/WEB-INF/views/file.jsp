<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>File UpLoad</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<link rel="shortcut icon" type="image/x-icon" href="assets/favicon.ico" />
<link rel="apple-touch-icon" sizes="57x57" href="assets//apple-icon-57x57.png">
<link rel="apple-touch-icon" sizes="60x60" href="assets//apple-icon-60x60.png">
<link rel="apple-touch-icon" sizes="72x72" href="assets//apple-icon-72x72.png">
<link rel="apple-touch-icon" sizes="76x76" href="assets//apple-icon-76x76.png">
<link rel="apple-touch-icon" sizes="114x114" href="assets//apple-icon-114x114.png">
<link rel="apple-touch-icon" sizes="120x120" href="assets//apple-icon-120x120.png">
<link rel="apple-touch-icon" sizes="144x144" href="assets//apple-icon-144x144.png">
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
<!-- jQuery -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<!-- Sweet 팝업창 이쁘게 만들어주는거 -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script type="text/javascript">
	function fileCheck(){
		var fileVal = $("#file1").val(); // 파일이름 가져오기
		if (fileVal == "") {
			alert('파일을 선택해주세요.');
			return false;
		}else{
			var ext = fileVal.split('.').pop().toLowerCase(); // 확장자 분리
			//아래 확장자가 있는지 체크
			if ($.inArray(ext,['jpg','jpeg','gif','png'] == -1)) {
				alert("JPG, gif, JPEG, png 파일만 업로드 할 수 있습니다.");
			}
		}
	}
</script>
</head>
<body>
	<%@ include file="menu.jsp" %>
	
	
	<!-- 파일 업로드 -->
	<section class="page-selection" id="file">
		<div class="d-flex justify-content-center">
			<div class="text-center">
				<form action="./file" method="post" enctype="multipart/form-data" onsubmit="fileCheck()">
				<div class= "input=group mb-3">
					<input type="file" accept="image/png, image/gif" name="file1" class="form-control" id="inputGroupFile02" placeholder="추가해주시요" aria-label="Username" aria-describedby="basic-addon1">
					<button type="submit" class="btn btn-outline-primary mt-3">전송하기</button>
				</div>
				</form>
			</div>
		</div>
	</section>












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
