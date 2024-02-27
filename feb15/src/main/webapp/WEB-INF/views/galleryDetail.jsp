<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Gallery 상세보기</title>
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
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script type="text/javascript">
function alterGallery(no){
		Swal.fire({
		        title: ${detail.gno},
		        text: "진짜 삭제 합니다",
		        icon: "warning",
		        showCancelButton: true,
		        confirmButtonColor: "#3085d6",
		        cancelButtonColor: "#d33",
		        confirmButtonText: "Yes"
		   		}).then((result) => {
			        if (result.isConfirmed) {
			        	let vform = $("<form></form>");
			        	vform.attr("name", "vform");
			        	vform.attr("method", "post");
			        	vform.attr("action", "./alterGallery");
			        	vform.append($('<input/>', {type:'hidden', name:'no', value:${detail.gno}}));
			        	vform.appendTo('body');
			        	vform.submit();
			          Swal.fire({
			            title: "Deleted!",
			            text: "진짜 삭제 해버렸어요",
			            icon: "success"
			          });
			        }
		   		});
}
</script>
</head>
<body id="page-top">
	<!-- Navigation-->
	<%@ include file="menu.jsp" %>
<header class="py-5 bg-image-full" style="background-image: url('https://source.unsplash.com/wfh8dDlNFOk/1600x900')">
    <div class="text-center my-5">
    	<div class="text-white my-5 pt-3">${detail.gno }</div>
        <img class="mb-4" src="/upFile/${detail.gfile }" />
            <h1 class="text-white fs-3 fw-bolder">${detail.gtitle }</h1>
            <p class ="text-white text-end pe-3">${detail.gdate }</p>
            <div class="text-end pe-3 mb-1">
            <c:if test="${sessionScope.mid eq detail.mid }">
            <span class="border border-info border-2 p-1"><img alt="삭제" src="./assets/img/alter.png" onclick="alterGallery(${detail.gno})"></span>
            <span class = "border border-info border-2 p-1 ms-1"><img alt="수정" src="./assets/img/editor.png"></span>
            </c:if>
            </div>
            <p class ="text-white text-end pe-3">${detail.mname }</p>
    </div>
</header>
        <!-- Content section-->
        <section class="py-5">
            <div class="container my-5">
                <div class="row justify-content-center">
                    <div class="col-lg-6">
                        <h2>${detail.gcontent }</h2>
                    </div>
                </div>
            </div>
	<button type="button" class="btn btn-info" onclick="history.back(-1)">게시판으로</button>
	<button type="button" class="btn btn-info" onclick="./gallery">게시판으로</button>
        </section>
	<!-- Footer-->
	<footer class="footer py-4">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-4 text-lg-start">Copyright &copy; M.company 2024</div>
				<div class="col-lg-4 my-3 my-lg-0">
					<a class="btn btn-dark btn-social mx-2" href="#!" aria-label="Twitter"><i class="fab fa-twitter"></i></a> 
					<a class="btn btn-dark btn-social mx-2" href="#!" aria-label="Facebook"><i class="fab fa-facebook-f"></i></a> 
					<a class="btn btn-dark btn-social mx-2" href="#!" aria-label="LinkedIn"><i class="fab fa-linkedin-in"></i></a>
				</div>
				<div class="col-lg-4 text-lg-end">
					<a class="link-dark text-decoration-none me-3" href="#!">이용약관</a> 
					<a class="link-dark text-decoration-none" href="donation">기부금 안내</a>
				</div>
			</div>
		</div>
	</footer>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/detail.js"></script>
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>
