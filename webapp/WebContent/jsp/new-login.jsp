<%@page import="Bean.ErrorBean"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ja">
<head>
<meta charset=UTF-8>
<link rel="stylesheet" href="../css/new-login.css">
<title>ログイン</title>
</head>
<body>
<c:if test="${error != null }">
<div class="error">${error.errorMns }</div>
<br>
</c:if>

<form action="../servlet/new-login" method="post">
苗字         <input type="text" name="userLastName"><p>
名前         <input type="text" name="userFirstName"><p>
住所         <input type="text" name="address"><p>
ログインid   <input type="text" name="loginid"><p>
パスワード   <input type="password" name="password"><p>

<input type="submit" value="新規登録">
</form>
<br>
<br>
<a href="../jsp/login.jsp">ログイン画面へ</a>
