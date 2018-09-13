<%@ page language="java" import="java.util.List,java.util.Map" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>管理小组分数</title>
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
						<th>角色</th>
						<th>成绩</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var = "item" items="${sessionScope.Group }">
						<tr>
						<td>${item.stu_no }</td>
						<td>${item.stu_name }</td>
						<td>${item.stu_role }</td>
						<td>		
							<a href="#" onclick="modalgrade('${item.stu_no }','${item.stu_name }','${sessionScope.topic_name}')">评分</a>
						</td>
					   </tr>	
					  </c:forEach>							
				</tbody>
			</table>
			

			
		</div>
	</body>
	<form action="/CourseDesign/Add_Stu_Grade" method="post">
		<input type="hidden" name="no" id="no">
		<input type="hidden" name="name" id="name">
		<input type="hidden" name="topic" id="topic">
		<div class="modal" id="modal_queren">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header"><h1>添加分数</h1></div>
					<div class="modal-body" >
						<input type="text" name="grade" class="url" placeholder="输入学生分数">
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-sm btn-danger">确定</button>
						<button type="reset" class="btn btn-sm btn-default" data-dismiss = "modal">取消</button>
					</div>
				</div>
				
			</div>
		</div>
	</form>
	</body>
	<script type="text/javascript">
		function modalgrade(no,name,topic)
		{
			jQuery("#no").val(no);
			jQuery("#name").val(name);
			jQuery("#topic").val(topic);
			jQuery("#modal_queren").modal();
		}
	</script>
	<script type="text/javascript" src="../js/jquery-3.2.1.min.js" ></script>
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js" ></script>
</html>