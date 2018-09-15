<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>test</title>
<script type="" src="js/jquery-2.2.3.min.js"></script>
</head>

<body>
	<input type="text" name="username" id="username"/><br />
	<input type="password" name="password" id="password"/><br />
	<input type="button" value="send" onclick="send()"/>
</body>

<script>
function send(){
	var username = $("input[name='username']").val();
	var pass = $("input[name='password']").val();
	var userinfo = {
			username:username,
			password:pass
	}
	$.ajax({
		type:'post',
		url:'/mtest/hello',
		data:userinfo,
		cache:false,
		success:function(data){
			var obj = JSON.parse(data);
			alert(obj.username);
			alert(obj.password);
			//console.log(1111111111);
		}
	});
	
}
</script>
</html>