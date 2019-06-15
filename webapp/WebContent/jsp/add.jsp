<%@page import="Bean.ErrorBean"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ja">
<head>
<meta charset=UTF-8>
<link rel="stylesheet" href="../css/login.css">
<title>オリジナル</title>
</head>
<body>
<%
if(session.getAttribute("user")== null){
	request.getRequestDispatcher("login.jsp")
	.forward(request, response);
}
%>

<c:if test="${error != null }">

<p>${error.errorMns }</p>
</c:if>

<form action="../servlet/add" method="post">

国名、市名   <input type="text" name="city">
<br>読み<input type="text" name="cityName">
<br>人口<input type="text" name="population">
<br>
<br>
<input type="submit" value="追加">
</form>

<br>
<a href="index.jsp">戻る</a>