<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main_v190130.css" />
<style type="text/css">
	#wrap{ margin: 0px auto; width:800px; height:860px;  }
	#header{ mwidth:800px; height:140px; background:#FFF url('http://localhost:8080/jsp_prj/common/images/header_bg.png'); position:relative; }
	#headerTitle{ font-family: HY견고딕, 고딕; font-size: 35px; font-weight:bold; text-align:center; position:absolute; left:300px; top:30px; }
	#container{ width:800px; }
	#footer{ width:800px; height:120px; }
	#footerTitle{ float:right; font-size:15px; padding-top:20px; padding-right: 20px;}
	/* td{ padding:10px; } */
	#subject { padding-top:10px; }
	#subject > a { padding-left:10px; padding-right:10px; color:blue; font-weight:bold; transition-duration:0.3s; }
	#subject > a:hover { text-decoration:none; color:#A3CB38; }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		
	}); // ready
</script>
</head>
<body>
	<div id="wrap">
		<div id="header">
			<div id="headerTitle">SIST Class4</div>
			<div style="padding-top:100px;">
				<c:import url="../common/jsp/main_menu.jsp" />
			</div>
		</div>
		<div id="container">
			<strong>${ param.deptno }</strong>번 부서조회
			<a href="dept.do?cmd=D001">뒤로</a>
			<table border="1" cellspacing="0">
				<tr>
					<th width="40">번호</th>
					<th width="80">사원번호</th>
					<th width="100">사원명</th>
					<th width="80">연봉</th>
					<th width="150">입사일</th>
					<th width="80">직무</th>
				</tr>
				<c:if test="${ empty empList }">
					<tr>
						<td colspan="6" align="center">해당 부서는 사원이 존재하지 않거나,
							부서가 존재하지 않습니다.
						</td>
					</tr>
				</c:if>
				<c:forEach var="emp" items="${ empList }">
					<c:set var="i" value="${ i + 1 }" />
					<tr>
						<td><c:out value="${ i }"></c:out></td>
						<td><c:out value="${ emp.empno }" /></td>
						<td><c:out value="${ emp.ename }" /></td>
						<td><c:out value="${ emp.sal }" /></td>
						<td><c:out value="${ emp.hiredate}" escapeXml="false" /></td>
						<td><c:out value="${ emp.job }" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserve class 4</div>
		</div>
	</div>
</body>
</html>