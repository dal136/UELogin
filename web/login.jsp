<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 
<head>
    <meta charset="utf-8">
    <title>Login</title>
    <style>
    	h1 {
    		width:50%;
    		margin: 10% auto 5% auto;
    		text-align:center;
    	}
		.parent {
			margin: auto;
			width: 50%;
			text-align:center;
		} 
		.col {
			margin: 10px;
		}
	</style>
</head>
 
<body>
	<h1>咪咕动漫-次元ue</h1>
    <form class="parent" action="LoginServlet" method="post">
    	<div class="col">
        	<input type="text" name="username" placeholder="用户名">
        </div>
        <div class="col">
        	<input type="password" name="password" placeholder="密码">
        </div>
        <div class="col">
        	<input type="submit" value="登录">
        </div>
    </form>
</body>
     
</html>
<script type="text/javascript">
    var errori ='<%=request.getParameter("error")%>';
    if(errori=='yes')
    {
        alert("用户名或密码错误!");
    }
</script>