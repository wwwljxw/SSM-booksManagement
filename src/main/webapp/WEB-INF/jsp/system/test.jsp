<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>书籍管理 | 个人图书管理系统</title>
    <link rel="shortcut icon"  href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon"/>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/book.css" />

</head>
<body>

<div class="container">
    <div th:include="fragments::header"></div>
    <div class="toolBar" style="margin-bottom: 20px">
        <a th:href="@{/book/add}" class="btn btn-primary">新增书籍</a>
        <a th:href="@{/book/category}" class="btn btn-default">管理分类</a>
        <div class="search-box" style="float: right;display: flex">
            <input type="text" class="form-control" id="search-input" required placeholder="请输入书名或作者搜索">
            <button class="btn btn-primary" id="search-btn">
                <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
            </button>
            <script type="text/javascript">
                document.getElementById('search-btn').onclick = function () {
                    let inputValue = document.getElementById('search-input').value;
                    if (inputValue === '') {
                        alert("请输入关键词再进行搜索");
                    } else {
                        window.location.href = '/book/search/' + inputValue;
                    }
                }
            </script>
        </div>
    </div>
    <div class="table-responsive">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th style="width: 120px">ISBN</th>
                <th style="width: 160px">书名</th>
                <th style="width: 120px">作者</th>
                <th style="width: 120px">出版社</th>
                <th style="width: 100px">分类</th>
                <th style="width: 80px">定价</th>
                <th style="width: 60px">数量</th>
                <th style="width: 100%">描述</th>
                <th style="width: 95px">操作</th>
            </tr>
            </thead>
            <tbody>
<%--            <tr th:each="book:${bookList}">--%>
<%--                <td th:text="${book.isbn}"></td>--%>
<%--                <td th:text="${book.name}"></td>--%>
<%--                <td th:text="${book.author}"></td>--%>
<%--                <td th:text="${book.press}"></td>--%>
<%--                <td th:text="${book.category.name}"></td>--%>
<%--                <td th:text="${book.price}"></td>--%>
<%--                <td th:text="${book.count}"></td>--%>
<%--                <td th:text="${book.introduction}"></td>--%>
<%--                <td>--%>
<%--                    <a class="btn btn-primary btn-xs" th:href="@{/book/update/}+${book.id}">编辑</a>--%>
<%--                    <form th:action="@{/book/delete}" method="post" style="display: inline-block">--%>
<%--                        <input type="hidden" name="bookId" th:value="${book.id}">--%>
<%--                        <button type="submit" class="btn btn-danger btn-xs">删除</button>--%>
<%--                    </form>--%>
<%--                </td>--%>
<%--            </tr>--%>
            </tbody>
        </table>
    </div>
    <!-- 页码，写死，前后最多显示5页 -->
    <div style="text-align: center">
        <nav aria-label="Page navigation"
<%--             th:with="isSearch=${#strings.contains(#httpServletRequest.requestURL,'search')}">--%>
<%--            <ul class="pagination" style="margin: 0"--%>
<%--                th:with="path=${isSearch}?'/book/search/'+${keyword}:'/book/list'--%>
<%--									,isFirstPage=${currentPage==1},isLastPage=${currentPage==totalPages}">--%>
<%--                <!-- 首页 -->--%>
<%--                <li th:class="${isFirstPage}?'disabled':''">--%>
<%--                    <a th:if="${!isFirstPage}" th:href="${path}+'/1'" aria-label="Previous">首页</a>--%>
<%--                    <span th:if="${isFirstPage}" aria-hidden="true">首页</span>--%>
<%--                </li>--%>

<%--                <li th:if="${totalPages}<=5" th:class="${currentPage}==${pageNum}?'active':''"--%>
<%--                    th:each="pageNum:${#numbers.sequence(1, totalPages)}">--%>
<%--                    <a th:href="${path}+'/'+${pageNum}" aria-label="Previous">--%>
<%--                        <span aria-hidden="true" th:text="${pageNum}"></span>--%>
<%--                    </a>--%>
<%--                </li>--%>

<%--                <li th:if="${totalPages}>5 and ${currentPage}<3" th:class="${currentPage}==${pageNum}?'active':''"--%>
<%--                    th:each="pageNum:${#numbers.sequence(1, 5)}">--%>
<%--                    <a th:href="${path}+'/'+${pageNum}" aria-label="Previous">--%>
<%--                        <span aria-hidden="true" th:text="${pageNum}"></span>--%>
<%--                    </a>--%>
<%--                </li>--%>

<%--                <li th:if="${totalPages}>5 and ${currentPage}>=3 and ${totalPages-currentPage}<2"--%>
<%--                    th:class="${currentPage}==${pageNum}?'active':''"--%>
<%--                    th:each="pageNum:${#numbers.sequence(totalPages-4, totalPages)}">--%>
<%--                    <a th:href="${path}+'/'+${pageNum}" aria-label="Previous">--%>
<%--                        <span aria-hidden="true" th:text="${pageNum}"></span>--%>
<%--                    </a>--%>
<%--                </li>--%>

<%--                <li th:if="${totalPages}>5 and ${currentPage}>=3 and ${totalPages-currentPage}>=2"--%>
<%--                    th:class="${currentPage}==${pageNum}?'active':''"--%>
<%--                    th:each="pageNum:${#numbers.sequence(currentPage-2, currentPage+2)}">--%>
<%--                    <a th:href="${path}+'/'+${pageNum}" aria-label="Previous">--%>
<%--                        <span aria-hidden="true" th:text="${pageNum}"></span>--%>
<%--                    </a>--%>
<%--                </li>--%>

<%--                <!-- 尾页 -->--%>
<%--                <li th:class="${isLastPage}?'disabled':''">--%>
<%--                    <a th:if="${!isLastPage}" th:href="${path}+'/'+${totalPages}" aria-label="Next">尾页</a>--%>
<%--                    <span th:if="${isLastPage}" aria-hidden="true">尾页</span>--%>
<%--                </li>--%>
            </ul>
        </nav>
    </div>
</div>

<script th:src="@{/static/plugins/jquery/jquery.min.js}"></script>
<script th:src="@{/static/plugins/bootstrap/js/bootstrap.min.js}"></script>
</body>
</html>
