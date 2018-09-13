<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
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
			textarea{
			    margin-left:100px;
			    margin-top:30px;
			    height:300px;
			    width:400px;
			}
			.modal-footer{
			   display:flex;
			   flex-direction:row-reverse
			}
		</style>
	</head>
	<body>
		<div id="tea">
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>小组</th>
						<th>所选题目</th>
						<th>上传时间</th>
						<th>课程设计</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="item" items="${sessionScope.view_all_stu }">
					<tr>
						<td>第${item.sc_group}组</td>
						<td>${item.sc_topic_name}</td>
						<td>${item.topic_date}</td>
						<td>${item.filename}</td>
						<td>
							<form action="/CourseDesign/Find_Group_Stu" method="post">
		              		<input type="hidden"  name="sc_group" id="sc_group" value="${item.sc_group}">
		              		<input type="hidden"  name="sc_topic_name" id="sc_topic_name" value="${item.sc_topic_name}">
		              		<button type="submit" class="btn btn-sm btn-danger">评分</button>   
		               </form> 
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</body>

	<script type="text/javascript" src="../js/jquery-3.2.1.min.js" ></script>
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js" ></script>
 	<script type="text/javascript">
	</script> 
	
</html>