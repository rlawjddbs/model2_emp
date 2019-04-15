<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- SmartMenu 시작 -->
<link
	href="http://localhost:8080/jsp_prj/common/smartmenu/css/sm-core-css.css"
	rel="stylesheet" type="text/css" />

<link
	href="http://localhost:8080/jsp_prj/common/smartmenu/css/sm-simple/sm-simple.css"
	rel="stylesheet" type="text/css" />

<!-- jQuery -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> -->

<!-- SmartMenus jQuery plugin -->
<script type="text/javascript"
	src="http://localhost:8080/jsp_prj/common/smartmenu/jquery.smartmenus.min.js"></script>

<!-- SmartMenus jQuery init -->
<script type="text/javascript">
	$(function() {
		$('#main-menu').smartmenus({
			subMenusSubOffsetX : 1,
			subMenusSubOffsetY : -8
		});
	});
</script>

<nav id="main-nav">
	<!-- Sample menu definition -->
	<ul id="main-menu" class="sm sm-simple">
		<li><a href="#void">홈으로</a></li>
		<li><a href="#void">일정관리</a>
			<ul>
				<li><a href="http://localhost:8080/jsp_prj/diary/diary.jsp">캘린더</a></li>
				<li><a href="http://localhost:8080/jsp_prj/diary/list.jsp">게시판</a></li>
				<li><a href="http://sist.co.kr">쌍용교육센터</a></li>
				<li><a href="#void">1조</a>
					<ul>
						<li><a href="http://youtube.com">이재찬</a></li>
						<li><a href="http://comic.naver.com">김민정</a></li>
						<li><a href="http://google.com">김정운</a></li>
						<li><a href="http://naver.com">정택성</a></li>
					</ul></li>
			</ul></li>
		<li><a href="http://localhost:8080/jsp_prj/day0320/file_list.jsp">다운로드</a></li>
		<li><a
			href="http://localhost:8080/jsp_prj/day0320/upload_form.jsp">당신도 김본좌</a></li>
			<li><a href="http://localhost:8080/jsp_prj/xml0326/jtbc_rss.jsp">JTBC 뉴스</a></li>
	</ul>
</nav>
<!-- SmartMenu 끝 -->