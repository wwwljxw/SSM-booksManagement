<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>SSM书籍管理系统</title>
    <style type="text/css">
        a {
            text-decoration: none;
            color: black;
            font-size: 16px;
        }
        h4 {
            width: 180px;
            height: 38px;
            margin: 30px auto;
            text-align: center;
            line-height: 38px;
            background: deepskyblue;
            border-radius: 4px;
        }
    </style>
</head>
<body>

<h4><a href="${pageContext.request.contextPath}/system/login">登录（已完成）</a></h4>
<h4><a href="${pageContext.request.contextPath}/system/alterPwd">修改密码</a></h4>
<h4><a href="${pageContext.request.contextPath}/system/addReader">添加读者（已完成）</a></h4>
<h4><a href="${pageContext.request.contextPath}/system/register">用户注册（已完成）</a></h4>
<h4><a href="${pageContext.request.contextPath}/system/readerIndex">读者管理（已完成）</a></h4>
<h4><a href="${pageContext.request.contextPath}/system/addBook">添加书籍（已完成）</a></h4>
<h4><a href="${pageContext.request.contextPath}/system/bookType">书籍分类管理（已完成）</a></h4>
<h4><a href="${pageContext.request.contextPath}/system/index">书籍管理（已完成）</a></h4>
<h4><a href="${pageContext.request.contextPath}/system/frontIndex">读者借阅书籍</a></h4>
<h4><a href="${pageContext.request.contextPath}/system/listDisBackAdmin">借阅2</a></h4>
<h4><a href="${pageContext.request.contextPath}/system/listDisBack">借阅3</a></h4>
</body>
</html>