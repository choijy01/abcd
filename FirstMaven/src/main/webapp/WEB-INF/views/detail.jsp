<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<table width="400" border="1">
			<tr>
				<td>회원아이디</td>
				<td>${user.id}</td>
			</tr>
			<tr>
				<td>회원비밀번호</td>
				<td>${user.pass}</td>
			</tr>
			<tr>
				<td>회원성명</td>
				<td>${user.name}</td>
			</tr>
			<tr>
				<td>회원주소</td>
				<td>${user.addr}</td>
			</tr>
			<tr>
				<td>회원메모</td>
				<td>${user.memo}</td>
			</tr>
		</table>
	</div>
</body>
</html>