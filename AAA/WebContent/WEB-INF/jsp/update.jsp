<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>修改信息</title>
</head>
<body>
<form action="alter">
<table class="table table-bordered">
	<tr>
		<c:if test="${!empty user }">
			<td>编号</td>
		</c:if>
			<td>性别</td>
			<td>姓名</td>
			<td>密码</td>
			<td>操作</td>
	</tr>
	<tr>
		<c:if test="${!empty user }">
			<td><input type="text" name="id" value="${user.ID }"></td>
		</c:if>
			<td><input type="text" name="sex" value="${user.SEX }"></td>
			<td><input type="text" name="name" value="${user.USERNAME }"></td>
			<td><input type="text" name="password" value="${user.PASSWORD }"></td>
			<td><input type="hidden" name="service" value="alter"></td>
			<td><input type="submit" value="提交"></td>
		
	</tr>

</form>

</table>
</body>
</html>