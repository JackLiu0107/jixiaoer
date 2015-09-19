<%@ page pageEncoding="utf-8"%>  
<!DOCTYPE html>  
<html>  
<head>  
<meta charset="utf-8">  
<title>上传图片</title>  
<% String url=request.getContextPath(); %>
<% String url1= request.getSession().getServletContext().getRealPath("/");; %>
</head>  
<body>  
<form action="<%=url %>/user/uploaduser" method="post" enctype="multipart/form-data">  
<div><%=url1 %></div>
<input type="file" name="annex" /> <input type="submit" value="Submit" /></form>  
</body>  
</html>  