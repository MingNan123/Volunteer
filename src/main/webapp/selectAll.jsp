<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="submit" value="返回"  onclick="window.location.href='main.jsp'">
<table>
<tr>
    <td>id</td>
    <td>学号</td>
    <td>姓名</td>
    <td>值班范围</td>
    <td>值班开始时间</td>
    <td>值班时长</td>
    <td>是否请假</td>
</tr>
<c:forEach items="${volunteers}" var="volunteer">
    <tr align="center">
        <td>${volunteer.vtId}</td>
        <td>${volunteer.vtSno}</td>
        <td>${volunteer.vtName}</td>
        <td>${volunteer.vtRegion}</td>
        <td>${volunteer.vtStartTime}</td>
        <td>${volunteer.vtDuration}</td>
        <td>${volunteer.vtStatus}</td>
        <td><a href="javascript:void(0)" onclick="confirmDel(${volunteer.vtId})">删除</a></td>
        <td><a href="selectByIdServlet?vtId=${volunteer.vtId}" >修改</a></td><%--${pageContext.request.contextPath}/updateServlet?vtId=${volunteer.vtId}--%>
    </tr>
</c:forEach>

</table>
<script src="js/jquery-3.6.1.js"></script>
<script src="js/jquery.validate.js"></script>
<script src="js/axios-0.18.0.js"></script>
<script type="text/javascript">
/*    $(document).ready(function (){
        $("a[action='delete']").click(function (){
            var vtId = $(this).attr("vtId");
            //var url = "${pageContext.request.contextPath}/SysUserController?action=del&userId="+userId;
            if (confirm("是否确定删除？")){
                /!* $.get(url,function (res){
                    if (res){
                      alert("删除成功");
                     // window.location.reload();
                      //当前页面重新请求另外一个地址
                      window.location.href="${pageContext.request.contextPath}/SysUserController";
            }else {
              alert("删除失败")
            }
         });*!/
                var url = "${pageContext.request.contextPath}/deleteServlet";
                $.ajax({
                    url: url,
                    type: "get",
                    data: {"action": "delete", "vtId": vtId},
                    success: function (res) {
                        if (res) {
                            alert("删除成功")
                            window.location.href="${pageContext.request.contextPath}/selectAllServlet";
                        } else {
                            alert("删除失败")
                        }
                    },
                    error: function (res) {
                        alert("删除失败")
                    }
                });
            }
            return false;//制解除
        });
    });*/
function confirmDel(param)
{
    if(window.confirm("确定删除?")){
        document.location="deleteServlet?m=delete&vtId="+param
    }
}
</script>
</body>
</html>
