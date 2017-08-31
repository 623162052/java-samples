<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String data = request.getParameter("first_editor");
	System.out.println(data);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<script charset="utf-8" src="../kindeditor.js"></script>
<script charset="utf-8" src="../zh_CN.js"></script>
<script type="text/javascript">
		
	//创建一个editor
	 var editor;
     KindEditor.ready(function(K) {
         editor = K.create('#first_editor', {
        	//设置显示的图标
        	 items : [
				'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
				'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright',
				'|', 'emoticons', 'image', 'link'],
			 //上传
			 uploadJson : './upload_json.jsp',
	         fileManagerJson : './file_manager_json.jsp',
	         allowFileManager : true
         });
 	});
	
	//获取值
	function getValue(){
		editor.sync();	//同步数据
		var html = document.getElementById('first_editor').value;
		alert(html);
	}

</script>

<title>Editor</title>
</head>
<body>
	<div>
		<%=data %>
	</div>
	<form action="index.jsp">
		<textarea id="first_editor" name="first_editor" style="width:700px;height:300px;"></textarea>
	
		<input type="button" value="getValue" onclick="getValue()" />
		<input type="submit" value="submit" />
	</form>

</body>
</html>