<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工管理系统</title>
<%
/* 拿到当前项目路径 */
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<script type="text/javascript"
	src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
<link
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<form>
		<div class="form-group">
			<label class="control-label">账号</label> 
		</div>
		<div>
			<input type="text" class="form-control" name="userId" id = "id_input" placeholder="15090130">
			<span></span>
		</div>
		<div class="form-group">
			<label class="control-label">密码</label> 
		</div>
		<div>
			<input type="password" class="form-control" name="password" id = "pwd_input">
			<span></span>
		</div>
		<a href= "">没有账号？注册</a>
		<button type="submit" class="btn btn-default" id="login_btn">登录</button>
	</form>
	
	<script type="text/javascript">
		$("#login_btn").click(function(){
			$.ajax({
				url:"${APP_PATH}/user/login",
			    type:"post",
			    data:$(form).serialize(),
			    success:function(result){
			    	if(result.code == 100){
			    		window.location.href="${APP_PATH }/index.jsp";
			    	}
			    }
			});
		});
	</script>
	
</body>
</html>