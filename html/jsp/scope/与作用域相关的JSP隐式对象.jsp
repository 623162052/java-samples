<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		if(pageContext.getAttribute("a")==null)
			pageContext.setAttribute("a",new Integer(1));
		else
			pageContext.setAttribute("a",new Integer(	(Integer)(pageContext.getAttribute("a")) + 1	));

		if(session.getAttribute("b")==null)
			session.setAttribute("b",new Integer(1));
		else
		session.setAttribute("b",new Integer(((Integer)session.getAttribute("b")).intValue() + 1));
		//session.setAttribute("b",new Integer(	(Integer)(session.getAttribute("b")) + 1	));
		
		if(application.getAttribute("c")==null)
			application.setAttribute("c",new Integer(1));
		else
			application.setAttribute("c",new Integer(	(Integer)(application.getAttribute("c")) + 1	));
		
	%>

	<%
		out.print("pageContext\t" + pageContext.getAttribute("a") + "<br />");
		
		out.print("session\t" + session.getAttribute("b") + "\t");
		out.print("session ID:" + session.getId() + "<br />");
		out.print("application\t" + application.getAttribute("c") + "<br />");	
	
	%>
</body>
</html>