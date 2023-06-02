<%@ page import="static java.lang.Character.getName" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>欢迎登录</title>
  <link href="css/login.css" rel="stylesheet">
</head>
<body>
<div class="form-div">
<h1>登陆界面</h1>
<%
    Object error =request.getAttribute("error");
%>
<form  method="post" name="loginServlet" action="loginServlet">
    <table>
        <tr>
            <td>用户名</td>
            <td class="inputs">
                <input name="username" type="text" id="username">
                <br>
            </td>
        </tr>

        <tr>
            <td>密码</td>
            <td class="inputs">
                <input name="password" type="password" id="password">
                <br>
            </td>
        </tr>

        <tr>
            <td>验证码</td>
            <td class="inputs">
                <input name="checkCode" type="text" id="checkCode">
                <img id="checkCodeImg" src="checkCodeServlet">
                <a href="login.jsp" id="changeImg">看不清？</a>
            </td>
        </tr>
        <tr>
            <td>记住我:</td>
            <td><input id="remember" name="remember" type="checkbox"></td>
        </tr>
    </table>
    <span ><font color="#a52a2a"><%=(error==null?"":error)%></font></span>
    <div class="reg-content">
        <span>没有帐号？</span> <a href="register.html">注册</a>
    </div>
    <div class="buttons">
        <input value="登录" type="submit" class="reg_btn">
        <input value="重置" type="reset" class="reg_btn">
    </div>
</form>
</div>
</body>
</html>
