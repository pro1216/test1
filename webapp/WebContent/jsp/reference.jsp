<%@page import="Bean.CityBean"%>
<%@page import="Bean.ErrorBean"%>
<%@page import="java.util.*"%>
<%@include file="../header.html"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="../servlet/delete" method="post">
	<%
		if (session.getAttribute("user") == null) {
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		}

	ArrayList<CityBean> list=(ArrayList<CityBean>)session.getAttribute("list");
		if(list.size()==0){
			ErrorBean errorBean=new ErrorBean();
			errorBean.setErrorMns("国が存在しません");
			request.setAttribute("error", errorBean);
			request.getRequestDispatcher("../jsp/index.jsp").
			forward(request, response);
		}
	%>



	<table border="1">
		<tr>
			<th></th>
			<th>番号</th>
			<th>国名、市名</th>
			<th>読み</th>
			<th>人口</th>

		</tr>

		<c:forEach var="list" items="${list}">
			<tr>
				<td><input type="checkbox" name="city_id"
					value="${list.city_id }"></td>
				<td>${list.city_id}</td>
				<td>${list.city }</td>
				<td>${list.cityName }</td>
				<td>${list.population }</td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<c:if test="${error != null }">
			<p>
				<font color="red">${error.errorMns }</font>
		</c:if>
	<p>
		<input type="submit" value="削除">
</form>
<p>
<a href="../jsp/index.jsp">戻る</a>
<%@include file="../footer.html"%>