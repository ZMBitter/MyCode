<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户修改信息</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.3.1.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js" rel="stylesheet"></script>

    <style type="text/css">
        body{
            padding: 0;
            margin: 0px auto;
        }
        #container{
            width: 500px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<div id="container">
    <h3 style="margin: 10px 0px;text-align: center">修改用户信息</h3>
    <form id="myForm" action="${pageContext.request.contextPath}/updateCustomServlet" method="post">
        <div class="form-group">
            <%--隐藏域，提交客户Id--%>
            <input type="hidden" value="${customer.id}" name="id">
            <label for="name" class="control-label">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" value="${customer.name}" readonly="readonly">
        </div>

        <div class="form-group">
            <label class="control-label">性别:</label>
            <c:if test="${customer.gender == '男'}">
                <label class="radio-inline"><input type="radio" name="gender" value="男" checked>男</label>
                <label class="radio-inline"><input type="radio" name="gender" value="女">女</label>
            </c:if>

            <c:if test="${customer.gender == '女'}">
                <label class="radio-inline"><input type="radio" name="gender" value="男">男</label>
                <label class="radio-inline"><input type="radio" name="gender" value="女" checked>女</label>
            </c:if>
        </div>

        <div class="form-group">
            <label for="age" class="control-label">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" value="${customer.age}">
        </div>

        <div class="form-group">
            <label for="address" class="control-label">籍贯：</label>
            <input type="text" class="form-control" id="address" name="address" value="${customer.address}">
        </div>

        <div class="form-group">
            <label for="qq" class="control-label">QQ：</label>
            <input type="text" class="form-control" id="qq" name="qq" value="${customer.qq}">
        </div>

        <div class="form-group">
            <label for="email" class="control-label">邮箱：</label>
            <input type="text" class="form-control" id="email" name="email" value="${customer.email}">
        </div>

        <div class="form-group" style="text-align: center;margin-top: 10px">
            <button type="submit" class="btn btn-primary btn-mid active">提交</button>
            <button type="reset" class="btn btn-danger btn-mid active">重置</button>
            <a href="${pageContext.request.contextPath}/show.jsp" class="btn btn-default btn-mid active" role="button">返回</a>
        </div>
    </form>
</div>
</body>
</html>
