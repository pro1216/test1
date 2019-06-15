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

<form action="../servlet/login-change" metohd="post">

新しいパスワード  <input type="password" name="password1">
<br>もう一度<input type="password" name="password2">
<input type="submit" value="変更">
</form>

</body>
</html>