<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
/* CSS để di chuyển nút Logout sang góc phải */
.logout-button {
	position: absolute;
	top: 20px; /* Khoảng cách từ đỉnh của trang */
	right: 20px; /* Khoảng cách từ phải của trang */
}

button {
	padding: 10px 20px;
	background-color: #007BFF;
	color: white;
	border: none;
	cursor: pointer;
	font-size: 14px;
}

button:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<h1 style="color: blue">This is Admin's home page</h1>
	<!--  Nút logout -->
	<!-- <form action="/WebProg_chieut2/logout" method="post"> -->
		<!-- <button class="logout-button" type="submit">Logout</button> -->
	<!-- </form>  -->
</body>
</html>