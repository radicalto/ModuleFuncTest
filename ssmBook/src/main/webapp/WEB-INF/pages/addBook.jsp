<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加书籍</title>
</head>
<body>
<center><h3>添加书籍</h3></center>
<form action="doAddBook" method="post">
<table align="center">
<tr><td>编号:</td><td><input type="text" name="no"/></td></tr>
<tr><td>书名:</td><td><input type="text" name="name"/></td></tr>
<tr><td>价格:</td><td><input type="text" name="price"/></td></tr>
<tr><td>出版社:</td><td><input type="text" name="publish"/></td></tr>
<tr><td colspan="2" align="center"><input type="submit" value="添加"/></td></tr>
</table>

</form>
</body>
</html>
