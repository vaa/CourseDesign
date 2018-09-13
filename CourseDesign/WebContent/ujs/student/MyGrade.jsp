<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>学生成绩信息</title>
		<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css" />
		
		<style type="text/css">
			*{
				padding: 0px;
				margin: 0px;
			}
			textarea
			{
			height=500px;
			width=500px;
			}
			body{
				background:url(../img/BG.jpg) repeat;
			}
			#tea{
				width: 800px;
				margin: auto;
			}
		</style>
	</head>
	<body>
		<div id="tea">
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>学号</th>
						<th>姓名</th>
						<th>课题</th>
						<th>成绩</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var = "item" items="${sessionScope.MyGrade }">
						<tr>
						<td>${item.stu_no}</td>
						<td>${item.stu_name }</td>
						<td>${item.topic_name }</td>
						<td>${item.grade }</td>
					   </tr>
					   
					</c:forEach>
					
				</tbody>
			</table>
		</div>
	</body>
	<script type="text/javascript" src="../js/jquery-3.2.1.min.js" ></script>
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js" ></script>
</html>