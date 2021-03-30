<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p> 가입하려면 아래 항목을 기입하고 <br/>
		버튼을 눌러주세요 ^*^
	</p>
	<form action ="<%= request.getContextPath() %>/book" method ="post">
		<input type = "hidden" name="action" value="insert"/>
		
		
		<label for = "name">이름</label>
		<input type = "text" name = "name"/>
		<br/>
		<label for = "hp">hp</label>
		<input type = "text" name = "hp" />
		<br/>
		<label for = "tel">tel</label>
		<input type = "text" name = "tel" id = "tel" />
		<br/>
		<input type = "submit" value = "등록!"/>
	</form>
	<p>
		<a href = "<%= request.getContextPath() %>/book">LIST</a>
	</p>
</body>
</html>