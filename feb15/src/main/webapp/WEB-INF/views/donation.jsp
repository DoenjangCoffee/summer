<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>기부안내</title>
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
<link href="css/board.css" rel="stylesheet" />
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<!-- summer note -->
<script src="/js/summernote/summernote-lite.js"></script>
<script src="/js/summernote/lang/summernote-ko-KR.js"></script>
<script src="/js/summernote/summernote-bs4.min.js"></script>
<link href="/css/summernote/summernote-lite.css" rel="stylesheet">
<link href="/css/summernote/summernote-bs4.min.css" rel="stylesheet">
</head>

<body id="page-top">
	<!-- Navigation-->
	<%@ include file="menu.jsp" %>
	
        <!-- Header-->
        <header class="masthead d-flex align-items-center">
            <div class="container px-4 px-lg-5 text-center">
                <h1 class="mb-1">Stylish Portfolio</h1>
                <h3 class="mb-5"><em>A Free Bootstrap Theme by Start Bootstrap</em></h3>
                <a class="btn btn-primary btn-xl" href="#about">Find Out More</a>
            </div>
        </header>
        
        <section class="content-section bg-light" id="about">	
            <div class="container px-4 px-lg-5 text-center">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-lg-10">
                        <h2>Stylish Portfolio is the perfect theme for your next project!</h2>
                        <p class="lead mb-5">
                            This theme features a flexible, UX friendly sidebar menu and stock photos from our friends at
                            <a href="https://unsplash.com/">Unsplash</a>
                            !
                        </p>
                        <a class="btn btn-dark btn-xl" href="#services">What We Offer</a>
                    </div>
                </div>
            </div>
        </section>
	
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
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>
