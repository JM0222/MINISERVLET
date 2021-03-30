<%@page import="com.servlet.PbookVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Phonebook Servlet</h1>
	<form action = "<%= request.getContextPath() %>/book">
		<input type = "hidden" name="a" value="search"/>
		<input type="text" name = "keyword" />
		<input type="submit" value = "search"/>
	</form>
	
	<% // 컨드롤러에서 속성으로 추가해준 리스트 객체를 꺼내와야한다
	// DownCasting 필요
	List<PbookVo> list = (List<PbookVo>)request.getAttribute("list");
	
	for (PbookVo vo: list){
		
	%>
	<table border=1>
		<tr>
			<th>id</th>
			<td><%= vo.getId() %></td>
		</tr>
		<tr>
			<th>name</th>
			<td><%= vo.getName() %></td>
		</tr>
		<tr>
			<th>hp</th>
			<td><%= vo.getHp() %></td>
		</tr>
		<tr>
			<th>tel</th>
			<td><%= vo.getTel() %></td>
		</tr>
		<tr>
			<td colspan = "2">
				<form action = "<%= request.getContextPath() %>/book">
					<input type="hidden" name = "a" value = "delete"/>
					<input type="hidden" name = "no" value="<%= vo.getId() %>"/>
					<input type="submit" value = "DELETE"/>
				</form>
			</tr>
	</table>	
	<%
	}
	%>
	<p>
		<a href = "<%= request.getContextPath() %>/book?a=form">ADD Pbook</a>
	</p>
</body>
</html>