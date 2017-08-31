<%@ page language="java" pageEncoding="UTF-8"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
  </head>
  
  <body>
    <a href="<%=request.getContextPath()%>/LifeCycleServlet">LifeCycleServlet</a>
    
    <!-- http发送String、Array -->
    <a href="<%=request.getContextPath()%>/HTTPProtocol?str=嗷嗷 & arr=1&arr=2&arr=3">HTTPProtocol</a>
    
    <!-- session -->
    <a href="<%=request.getContextPath()%>/HttpSessionServlet">HttpSession</a>
    
    <a href="<%=request.getContextPath()%>/CookieServlet?UserName=aoaoxiong">CookieServlet</a>
    
	<!-- JNDI -->
	<a href="<%=request.getContextPath()%>/ConnectionJNDI">ConnectionJNDI</a>
	
	<!-- pushlet -->
	<a href="<%=request.getContextPath()%>/TestPushlet">TestPushlet</a>
    
    <br />
    <img src="<%=request.getContextPath()%>/ValidationCodeServlet" />
			
  </body>
</html>
