<%@ page language="java" import="java.util.List,java.util.Map" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>管理小组信息</title>
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
	<c:choose>
		<c:when test="${empty sessionScope.login_stu.stu_group}">
			<h3 style="width:100%;text-align:center">
				<a href="#" onclick="addGroup('${sessionScope.login_stu.stu_no }')">添加小组</a>
			</h3>
		</c:when>
		<c:otherwise>
			<h3 style="width:100%;text-align:center">第${sessionScope.login_stu.stu_group }小组</h3>
	</c:otherwise>
	</c:choose>
	
		<div id="tea">
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>学号</th>
						<th>姓名</th>
						<th>角色</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var = "item" items="${sessionScope.MyGroup }">
						<tr>
						<td>${item.stu_no }</td>
						<td>${item.stu_name }</td>
						<td>${item.stu_role }</td>
						<td>
							<c:choose>
								<c:when test="${item.stu_no==sessionScope.login_stu.stu_no}">
									<form action="/CourseDesign/Delete_Group" method="post">
		              				<input type="hidden"  name="stu_group"  value="${item.stu_group }">
		              				<button type="submit" class="btn btn-sm btn-danger">解散</button>  
								</c:when>
								<c:otherwise>
									<form action="/CourseDesign/Delete_Member" method="post">
		              				<input type="hidden"  name="stu_no"  value="${item.stu_no }">
		              				<button type="submit" class="btn btn-sm btn-danger">删除</button>  
								</c:otherwise>
							</c:choose>
						</td>
					   </tr>
					   
					</c:forEach>
					
				</tbody>
			</table>
			
			<c:if test="${sessionScope.login_stu.stu_role=='组长'}">
				<a href="#" onclick="modalupdate('${sessionScope.login_stu.stu_group }')">添加成员</a>
			</c:if>
			
		</div>
	<form action="/CourseDesign/MemberSubmit" onsubmit="return noCheck()" method="post">
		<input type="hidden" name="group" id="group1">
		<input type="hidden" name="role" id="role1" value="成员">
		<div class="modal" id="modal_update">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header"><h1>添加成员</h1></div>
					<div class="modal-body" >
						<input type="text" name="stu_no" id="stu_no1" class="url" placeholder="输入学生编号">
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-sm btn-danger">确定</button>
						<button type="reset" class="btn btn-sm btn-default" data-dismiss = "modal">取消</button>
					</div>
				</div>
				
			</div>
		</div>
	</form>
	<form action="/CourseDesign/MemberSubmit" method="post">
		<input type="hidden" name="stu_no" id="stu_no2">
		<input type="hidden" name="role" value="组长">
		<div class="modal" id="modal_addGroup">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header"><h1>添加小组</h1></div>
					<div class="modal-body" >
						<input type="text" name="group" class="url" placeholder="输入小组编号">
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
			jQuery("#group1").val(name);
			jQuery("#modal_update").modal();
		}
		function addGroup(name)
		{
			jQuery("#stu_no2").val(name);
			jQuery("#modal_addGroup").modal();
		}
         function noCheck() {
            var x = document.getElementById("stu_no1").value;
            if (x == "${sessionScope.login_stu.stu_no }>") {
                alert("不能添加自己为成员。");
                return false;
            } else {
                return true;
            }
        } 
	</script>
	<script type="text/javascript" src="../js/jquery-3.2.1.min.js" ></script>
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js" ></script>
</html>