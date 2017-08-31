<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
  <title>PageScope1</title>
</head>
<body>

<h2>pageContext</h2>
<%	
	pageContext.setAttribute("Name","mike");  	
	pageContext.setAttribute("Password","browser");
%>
<jsp:forward page="PageScope2.jsp"/>

</body>
</html>