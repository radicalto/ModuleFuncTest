<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>书籍列表</title>
<style>
table tr td{
text-align:center;
line-height: 25px;
vertical-align:middle;
}
</style>
</head>
<body>
<center><h3>书籍列表</h3></center>
<center><a href="toAddBook">添加</a></center>
<table align="center" border="2" width="80%">
<tr><td>编号</td><td>书名</td><td>价格</td><td>出版社</td><td>操作</td></tr>
<c:forEach var="book" items="${requestScope.bookList}">
<tr><td>${book.no}</td><td>${book.name}</td>
<td>${book.price}</td><td>${book.publish}</td>
<td>
<a href="toUpdateBook?no=${book.no}">修改</a>
<a href="doDeleteBook?no=${book.no}">删除</a>
</td></tr>
</c:forEach>
</table>

<%-- 分页导航 --%>
<div style="text-align: center">
 <a href="/toBooks?pageNum=1">首页</a>
 <%-- 上一页按钮 --%>
 <c:if test="${requestScope.currentPage > 1}">
  <a href="/toBooks?pageNum=${requestScope.currentPage - 1}">上一页</a>
 </c:if>
 <%-- 显示当前页数和总页数 --%>
 <c:forEach var="i" begin="1" end="${requestScope.totalPages}">
  <c:set var="color" value="${i == currentPage ? 'red' : 'black'}"/>
  <a href="/toBooks?pageNum=${i}" style="color: ${color}">${i}</a>
 </c:forEach>
 当前页：${requestScope.currentPage} / 总页数：${requestScope.totalPages}

 <%-- 下一页按钮 --%>
 <c:if test="${requestScope.currentPage < requestScope.totalPages}">
  <a href="/toBooks?pageNum=${requestScope.currentPage + 1}">下一页</a>
 </c:if>
 <a href="/toBooks?pageNum=${requestScope.totalPages}">尾页</a>
</div>

</body>
</html>
