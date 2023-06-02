<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/system.css" type="text/css">
    <title>修改</title>
</head>
<body>
<h3>修改志愿者信息</h3>
<input type="submit" value="返回"  onclick="window.location.href='selectAll.jsp'">
<div>
    <nav id="menu">
        <a href="main.jsp" class="selected">首页</a>
        <a href="${pageContext.request.contextPath}/selectAllServlet?action=list">查询所有志愿者信息</a>
        <a href="insert.jsp">添加志愿者</a>
        <a href="login.jsp">退出登录</a>
        <a href="http://localhost:63342/Volunteer/src/main/webapp/blog/finalwork.html?_ijt=hd4p0003pd75k069sbshhge0vm">了解更多</a>
    </nav>
</div>
<hr>
<div>
    <form action="updateServlet" name="vtId" id="vtId"  method="post" style="margin: auto;width: 220px" >

       <%-- id:<input type="hidden" name="id" value="${volunteer.vtId}"><br>--%>
       id: <input name="vtId" type="text" value="${volunteer.vtId}" required></br>
        学号：<input name="vtSno" type="text" value="${volunteer.vtSno}" required><br>
        姓名：<input name="vtName" type="text" value="${volunteer.vtName}" required><br>
        值班场地：<input name="vtRegion" type="text" value="${volunteer.vtRegion}" required><br>
        开始时间：<input name="vtStartTime" type="text" value="${volunteer.vtStartTime}" required><br>
        值班时长：<input name="vtDuration" type="text" value="${volunteer.vtDuration}" required><br>
        是否请假：<input name="vtStatus" type="text" value="${volunteer.vtStatus}" required><br>
        <input type="submit" value="提交">
    </form>
</div>

<!-- 引入jQuery类库 -->
<script src="js/jquery-3.6.1.js"></script>
<!-- 引入validator插件 -->
<script src="js/jquery.validate.js"></script>
<script>
    $("#insert").validate({
        rules:{//配置表单项校验的规则
            vtId:{
                required: true
            },
            vtSno:{
                required: true

            },
            vtName:{
                required:true

            },
            vtRegion:{
                required:true

            },
            vtStartTime:{
                required:true

            },
            vtDuration:{
                required:true

            },
            vtStatus:{
                required:true,

            },
        },
        messages:{//配置对应的表单项校验失败后的错误提示信息
            vtId:{
                required: "id不能为空",
            },
            vtSno:{
                required: "学号不能为空",
            },
            vtName:{
                required:"姓名不能为空",
            },
            vtRegion:{
                required:"值班范围不能为空"
            },
            vtStartTime:{
                required:"值班开始时间不能为空",
            },
            vtDuration:{
                required:"值班时长不能为空"
            },
            vtStatus:{
                required:"是否请假不能为空",
            }
        }
    })
</script>
</body>
</html>
