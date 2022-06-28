<%@page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@page import= "co.jp.netwisdom.dto.UserInfoHobbyDto" %>
<%@page import= "co.jp.netwisdom.dto.HobbyDto" %>

<html>
<head>
<title>课后练习题</title>

</head>


<body>
	<form action = "userSearch" >
		姓名:<input id="username" name="username"/><br/>
		性别:<input type="radio" name="sex" checked  id="sex1" value="0"/>男<input type="radio"  name="sex" id="sex2"  value="1"/>女<br/>
		专业:<select id="major" name="major">
			<option value=""></option>
			<option value="0">软件工程</option>
			<option value="1" >英语</option>
			<option value="2">数学</option>
		</select><br>
		<input type="submit" value="检索"/>
		<br/>
		<br/>
		<br/>
		检索一览
		<hr/>
		<table border="1" align="center" width="90%">
			<tr>
				<td>姓名</td>
				<td>密码</td>
				<td>性别</td>
				<td>爱好</td>
				<td>专业</td>
				<td>简介</td>
			</tr>
			<% List<UserInfoHobbyDto> dtos = (List<UserInfoHobbyDto>)request.getAttribute("dtos");%>
			<%if(dtos != null){%>
				<% for(UserInfoHobbyDto dto : dtos){ %>
				<tr>
					<td><a href = "userUpdateInit"><%= dto.getUsername() %></a></td>
					<td><%= dto.getPassword() %></td>
					<td>
						<%if("0".equals(dto.getSex())){%>
							男
						<%}else{%>
							女
						<%}%>  
					
					</td>
					<td>						
						<%= dto.getHobbys() %>		
					</td>
					<td>
						<%if("0".equals(dto.getMajor())){%>
							软件工程
						<%}%>
						<%if("1".equals(dto.getMajor())){%>
							英语
						<%}%>
						<%if("2".equals(dto.getMajor())){%>
							数学
						<%}%>
					</td>
					<td><%= dto.getIntro() %></td>
				</tr>
				<% } %>
			<% } %>
			
					
			
		</table>
		
	</form>
</body>
</html>