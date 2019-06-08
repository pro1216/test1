<%@page contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html lang="ja">
<head>
<meta charset=UTF-8>
<link rel="stylesheet" href="../css/login.css">
<title>ログイン</title>
</head>
<body>
<form action="../servlet/login" metohd="post">

新しいパスワード  <input type="password" name="password1">
<br>もう一度<input type="password" name="password2">
<input type="submit" value="ログイン">
</form>

</body>
</html>