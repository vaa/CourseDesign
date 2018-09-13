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
						<th>老师姓名</th>
						<th>题目名称</th>
						<th>课程设计</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var = "item" items="${sessionScope.MyTopic }">
						<tr>
						<td>${item.sc_tea_name }</td>
						<td>${item.sc_topic_name }</td>
						<td>${item.filename }</td>
						<td>
							<a href="#" onclick="modalupdate('${item.sc_topic_name}')">上传课程设计</a>
						</td>
					   </tr>
					   
					</c:forEach>
					
				</tbody>
			</table>
		</div>
			<!--删除操作的模态框-->
	<form action="/CourseDesign/TopicSubmit" enctype="multipart/form-data"  method="post">
		<input type="hidden" name="Topicname" id="Topicname">
		<div class="modal" id="modal_queren">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header"><h1>课程设计提交</h1></div>
					<div class="modal-body" >
						<input type="file" class="form-control" name="file">
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
		function modalupdate(name)
		{
			jQuery("#Topicname").val(name);
			jQuery("#modal_queren").modal();
		}
	</script>
	<script type="text/javascript" src="../js/jquery-3.2.1.min.js" ></script>
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js" ></script>
</html>