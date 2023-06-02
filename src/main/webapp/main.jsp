<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理端</title>
    <link rel="stylesheet" href="css/system.css" type="text/css">
</head>
<body>
<c:set  var="jstlDate"  value="<%=new Date() %>"></c:set>
欢迎 ${user.username} 来到防疫志愿者后台管理页面,当前登录时间：
<fmt:formatDate value="${jstlDate}" pattern="yyyy-MM-dd HH:mm:ss" />
<div>
    <nav id="menu">
        <a href="#" class="selected">首页</a>
        <a href="${pageContext.request.contextPath}/selectAllServlet?action=list">查询所有志愿者信息</a>
        <a href="insert.jsp">添加志愿者</a>
        <a href="login.jsp">退出登录</a>
        <a href="http://localhost:63342/Volunteer/src/main/webapp/blog/finalwork.html?_ijt=hd4p0003pd75k069sbshhge0vm">了解更多</a>
    </nav>
</div>
</body>
</html>