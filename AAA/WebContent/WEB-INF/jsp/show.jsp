<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<button type="button" onclick="add()">添加员工</button>
<button type="button" onclick="add()">退出</button>
<form action="selectlikename">
	搜索:<input type="text" name="name1">
<input type="submit" value="提交">
</form>
<table class="table table-bordered">
<tr>
	<td>编号</td>
	<td>序号</td>
	<td>性别</td>
	<td>名字</td>
	<td>密码</td>
</tr>
<c:forEach begin="0" end="${list.size()-1 }" var="i">
<tr>
	<td>${i+1}</td>
	<td>${list[i].ID }</td>
	<td>${list[i].SEX }</td>
	<td>${list[i].USERNAME }</td>
	<td>${list[i].PASSWORD }</td>
	<td><a href="update?id=${list[i].ID }&service=update">✎</a>
	<a href="delete?id=${list[i].ID }&service=delete">X</a>
	</td>
</tr>
</c:forEach>


</table>


<script type="text/javascript">

function add() {
	location.href="http://localhost:8080/AAA/add?service=add";
}


</script>

</body>
</html>