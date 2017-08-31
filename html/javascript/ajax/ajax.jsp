<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Editor</title>
</head>
<body>
	name    <input id="sname"/><br/>
	password<input id="spass" type="password"/><br/>
	<button onclick="login()">submit</button>
	<hr/>
	info<div id="info"></div>
</body>
<script type="text/javascript">
var xmlHttpRequest;

function login(){
	var sname=document.getElementById("sname").value;
	var spass=document.getElementById("spass").value;
	var url="<%=request.getContextPath()%>/LoginServlet?stuname="+sname+"&stupass="+spass+"&"+Math.random();
	if(window.ActiveXObject){
		//IE
		xmlHttpRequest =  new ActiveXObject("Microsoft.XMLHttp");
	}else if(window.XMLHttpRequest){
		//other browser
		xmlHttpRequest = new XMLHttpRequest();
	}
	//doGet(url);
	doPost(url);
}

function doGet(url){
	xmlHttpRequest.onreadystatechange=loginback;
	xmlHttpRequest.open("GET",url,true);
	xmlHttpRequest.send(null);
}

function doPost(url){
	xmlHttpRequest.onreadystatechange=loginback;
	xmlHttpRequest.open("POST",url,true);
	xmlHttpRequest.send(null);
}

function loginback(){
	if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
		var returnValue=xmlHttpRequest.responseText;
		var divInfo=document.getElementById("info");
		if(returnValue=="Sorry")
			divInfo.innerHTML="<font color='red'>err</font>";
		else
			divInfo.innerHTML="<font color='green'>"+returnValue+"</font>";
	}
}
</script>
</html>