<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ja">
<head>
<meta charset=UTF-8>
<link rel="stylesheet" href="../css/index.css">
<title>検索</title>
</head>
<body>
	<%
		if (session.getAttribute("user") == null) {
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		}
	%>
	<ul class="menue">


				<li><a class="active" href="../jsp/login-change.jsp">パスワードの変更</a></li>
				<li><a href="../servlet/log-off">ログオフ</a></li>


	</ul>
	<p>${user.userFirstName }${user.userLastName }様こんにちは</p>
	<form action="../servlet/search" method="get">
		<div>
			<c:if test="${error != null }">

				<p>${error.errorMns }</p>
			</c:if>
			<input type="text" name="keyword"> <input type="submit"
				value="検索">
			<p>
				<a href="../servlet/reference">国一覧</a>
			</p>
			<p>
				<a href="../jsp/add.jsp">国追加</a>
			</p>
		</div>
	</form>
</body>
</html>
