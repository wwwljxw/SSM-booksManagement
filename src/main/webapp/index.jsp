<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>SSM书籍管理系统</title>
    <style type="text/css">
        a {
            text-decoration: none;
            color: black;
            font-size: 18px;
        }
        h2 {
            width: 180px;
            height: 38px;
            margin: 100px auto;
            text-align: center;
            line-height: 38px;
            background: deepskyblue;
            border-radius: 4px;
        }
    </style>
</head>
<body>

<h2>
    <a href="${pageContext.request.contextPath}/system/addBook">添加书籍</a>
</h2>
<h2><a href="${pageContext.request.contextPath}/system/addReader">添加读者</a></h2>
<h2><a href="${pageContext.request.contextPath}/system/login">书籍分类管理</a></h2>
</body>
</html>