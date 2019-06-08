<%@page import="Bean.ErrorBean"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ja">
<head>
<meta charset=UTF-8>
<link rel="stylesheet" href="../css/login.css">
<title>ログイン</title>
</head>
<body>
<c:if test="${error != null }">

<p>${error.errorMns }</p>
</c:if>

<form action="../servlet/login" method="post">

ログインid   <input type="text" name="loginid">
<br>パスワード<input type="password" name="password">
<input type="submit" value="ログイン">
</form>
<br>
<a href="../jsp/login-change.jsp">ログイン変更画面へ</a>
<br>
<a href="new-login.jsp">新規登録画面へ</a>