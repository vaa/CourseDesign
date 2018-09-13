<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>管理课题信息</title>
		<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css" />
		
		<style type="text/css">
			*{
				padding: 0px;
				margin: 0px;
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
						<th>老师姓名</th>
						<th>课程题目</th>
						<th>课题描述</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${sessionScope.Topic }">
					<tr>
						<td>${item.en_tea_name }</td>
						<td>${item.en_topic_name}</td>
						<td>${item.en_topic_content}</td>
					</tr>
					
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
	<script type="text/javascript">
		function modalupdate(name1,name2,name3)
		{
			jQuery("#tea_name1").html(name1);
			jQuery("#sub_name").html(name2);
			jQuery("#tea1").val(name1);
			jQuery("#Topic").val(name2);
			jQuery("#modal_queren").modal();
		}
	</script>
	<script type="text/javascript" src="../js/jquery-3.2.1.min.js" ></script>
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js" ></script>
</html>