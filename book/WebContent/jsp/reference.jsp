<%@include file="../header.html"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table border="1">
<tr>
	<th></th>
	<th>city名</th>

</tr>
<c:forEach var="list" items="${list}" >
	<tr>
		<td>${list.city_id}</td>
		<td>${list.city }</td>

	</tr>
</c:forEach>
</table>


<%@include file="../footer.html"%>
