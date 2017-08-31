<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
<title>HttpSession</title>
</head>
<body>

<%
	session.setAttribute("info", "login success");  //设置属性
						
	out.println(session.getAttribute("info"));		//获取属性
	session.removeAttribute("info");				//删除属性
	out.println(session.getAttribute("info"));
	out.println(session.isNew());					//判断用户是否新用户
	out.println(session.getId());					//获取session ID
	session.invalidate();							//让session失效,之后操作session报异常

	//response.sendRedirect("Member.jsp");
	//response.setHeader("Refresh","5;URL=Login.jsp"); //重定向
%>

</body>
</html>