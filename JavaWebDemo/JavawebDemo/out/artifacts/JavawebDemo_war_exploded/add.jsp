<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
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
<div>
    <jsp:include page="head.jsp"></jsp:include>
</div>

<div id="container">
    <h3 style="margin: 10px 0px;text-align: center">添加用户信息</h3>
    <form id="myForm" action="${pageContext.request.contextPath}/addCustomServlet" method="post">
        <div class="form-group">
            <label for="name" class="control-label">姓名：</label>
            <input type="text" class="form-control" id="name" placeholder="请输入姓名" name="name">
        </div>

        <div class="form-group">
            <label class="control-label">性别:</label>
            <label class="radio-inline"><input type="radio" name="gender" value="男">男</label>
            <label class="radio-inline"><input type="radio" name="gender" value="女">女</label>
        </div>

        <div class="form-group">
            <label for="age" class="control-label">年龄：</label>
            <input type="text" class="form-control" id="age" placeholder="请输入年龄。例如：21" name="age">
        </div>

        <div class="form-group">
            <label for="address" class="control-label">籍贯：</label>
            <input type="text" class="form-control" id="address" placeholder="请输入籍贯省份。例如：陕西" name="address">
        </div>

        <div class="form-group">
            <label for="qq" class="control-label">QQ：</label>
            <input type="text" class="form-control" id="qq" placeholder="请输入QQ" name="qq">
        </div>

        <div class="form-group">
            <label for="email" class="control-label">邮箱：</label>
            <input type="text" class="form-control" id="email" placeholder="xxxx@example.com" name="email">
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