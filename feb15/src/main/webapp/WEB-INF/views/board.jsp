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
<title>게시판</title>
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
<script type="text/javascript">
	function writeCheck(){
		let title = document.querySelector("#exampleFormControlInput1");
		let content = document.querySelector("#content");
		if (title.value.length < 2) {
			alert("제목은 두글자 이상 적어주세요.");
			title.focus();
			return false;
		}
		if (content.value.length < 2) {
			alert("내용은 두글자 이상 적어주세요.");
			content.focus();
			return false;
		}
	}
	function detail(no){
/*  		swal({ // 이거는 그냥 이쁘게 꾸미는 거다. icon에 success, info, error, warning을 사용 가능
			title:"굿잡브르",
			text:"번호는 "+no,
			icon:"warning",
			button:"바튼" // title, text, icon, button
		});  */
		// 모달 바로보기
		let detailModal = new bootstrap.Modal('#detail', {}); // {} - 괄호안에는 옵션이 들어간다.
		//$('#modalTitle').text(no);
		//$('#modalContent').text("변경된된 내용입니다.");
	     //detailModal.show();
 		$.ajax({
			url:"/restDetail",
			type:"post",
			dataType:"json",
			data:{"no":no},
			success:function(data){ // 지금은 text으로 하고 나중에 json 으로 변경한다.
				//alert(data.board_title);
				$('#modalTitle').text(data.board_title);
				$('#modalContent').html(data.board_content);
			   	detailModal.show();
			},
			error:function(error){
				swal({
					title:"문제 발생",
					text: "뭔가 잘못되고 있습니디.",
					icon: "error",
					button:"닫기"
				});
			}
		});//ajax end
	}// detail end

// 전자정부 페이징 이동하는 스크립트
function linkPage(pageNo){
			location.href = "./board?pageNo="+pageNo;
		}
	
</script>
<body id="page-top">
	<!-- Navigation-->
	<%@ include file="menu.jsp" %>
	
	<!-- Services-->
	<section class="page-section" id="services">
		<div class="container">
			<div class="text-center">
				<h2 class="section-heading text-uppercase mt-5">게시판</h2>
			</div>
			<div class="row text-center">
				<table class="table table-hover">
					<thead>
							<tr>
								<th>글번호</th>
								<th>글제목</th>
								<th>글쓴이</th>
								<th>날짜</th>
								<th>조회수</th>
							</tr>
					</thead>
						<tbody>
							<c:forEach items="${list }" var="e">
								<tr>
									<td onclick="detail(${e.board_no})">${e.board_no }</td>
									<td class="title" ><a href="./detail?no=${e.board_no }">${e.board_title }&nbsp;
									<c:if test="${e.comment gt 0 }">
									<span class="badge text-bg-danger">${e.comment }</span>
									</c:if>
									</a></td>
									<td>${e.mname }</td>
									<td>${e.board_date }</td>
									<td>${e.board_count }</td>
								</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- 페이징 들어갈 자리 -->
			<div>
				<ui:pagination paginationInfo = "${paginationInfo}" type="image" jsFunction="linkPage"/>
			</div>
			<c:if test="${sessionScope.mid ne null }">
				<button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#write">글쓰기</button>
			</c:if>
			</div>
		</div>
	</section>
	<!-- 글쓰기 모달 만들기 -->
	<div class="modal" id="write">
		<div class="modal-dialog modal-xl">
			<div class="modal-content">
				<div class="modal-header">
					<!-- <h3 class="modal-title">글쓰기 창 입니다.</h3> -->
					<button type="button" class="btn-close" data-bs-dismiss="modal" data-bs-target="#wrtie"></button>
				</div>
				<div class="modal-body">
					<div class="mt-2">
						<form action="./write" method="post" onsubmit="return writeCheck()" name="frm">
							<input type="text" name="title" class="form-control mb-2" id="exampleFormControlInput1" placeholder="제목을 적어주세요" required="required" >
							<textarea name="content" id="summernote" class="form-control mb-2 vh-500" required="required"></textarea>
							<button type="submit" class="btn btn-info" style="float: right">작성</button>
						</form>
					</div>
				</div>
				</div>
				</div>
				</div>
	<div class="modal" id="detail">
		<div class="modal-dialog modal-xl">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class = "modal-title" id = "modalTitle">상세보기</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>
				<div class="modal-body">
					<div class="mt-2" id = "modalContent">
						제목<br>
						본문내용
					</div>
				</div>
				<div class="modal-footer">
					상세보기 모달 닫기
					<!-- 2024-02-19 / RESTAPI / RESTFULL-->
				</div>
			</div>
		</div>
	</div>

 	<footer class="footer py-4 fixed-bottom">
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
					<a class="link-dark text-decoration-none" href="#!">기부금 안내</a>
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
	
	<script type="text/javascript">
	$(function(){
		$('#summernote').summernote({
			lang:'ko-KR',
			height:600,
			fontNames : ['D2Coding', 'Arial Black', 'Comic Sans MS', 'Courier New'],
			toolbar: [
			    // [groupName, [list of button]]
			    ['style', ['bold', 'italic', 'underline', 'clear']],
			    /* ['font', ['strikethrough', 'superscript', 'subscript']], */
			    ['fontname', ['fontname','fontsize', 'color']],
			    ['para', ['ul', 'ol', 'paragraph']],
			    /* ['height', ['height']] */
			    ['table', ['table','link', 'picture', 'video']]
			  ]
		});	
	});
	</script>
</body>
</html>
