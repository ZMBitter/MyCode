<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>展示用户信息</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.3.1.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js" rel="stylesheet"></script>
<body>

<div>
    <jsp:include page="head.jsp"></jsp:include>
</div>
<div class="container">

    <h2 style="text-align: center;margin: 20px">展示用户信息</h2>

    <div style="float: left">
        <form class="form-inline" action="${pageContext.request.contextPath}/findCustomByPageServlet" method="post">
            <div class="form-group">
                <label for="username">用户名：</label>
                <input type="text" class="form-control" id="username" placeholder="请输入用户名" name="name" value="${condition.name[0]}">
            </div>
            <div class="form-group">
                <label for="gender">性别：</label>
                <input type="text" class="form-control" id="gender" placeholder="男/女" name="gender" value="${condition.gender[0]}">
            </div>
            <div class="form-group">
                <label for="address">籍贯：</label>
                <input type="text" class="form-control" id="address" placeholder="请输入籍贯" name="address" value="${condition.address[0]}">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <!--过滤条件文本框，批量删除、新增按钮-->
    <div style="float: right;margin: 5px">
        <a type="button" class="btn btn-danger btn-mid" href="javascript:void(0)" id="delBatch">
            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>  删除选中</a>
        <a type="button" class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">
            <span class="glyphicon glyphicon-pencil btn-mid" aria-hidden="true"></span>  添加用户</a>
    </div>

    <%--添加表单以提交数据--%>
    <form action="${pageContext.request.contextPath}/deleBatchServlet" method="post" id="myform">
        <table class="table table-bordered table-hover" border="1px">
            <thead>
            <tr class="text-center">
                <td>
                    <input type="checkbox" class="allchks">
                </td>
                <td><strong>编号</strong></td>
                <td><strong>用户名</strong></td>
                <td><strong>性别</strong></td>
                <td><strong>年龄</strong></td>
                <td><strong>籍贯</strong></td>
                <td><strong>QQ</strong></td>
                <td><strong>邮箱</strong></td>
                <td><strong>操作</strong></td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pageBean.list}" varStatus="s" var="list">
                <tr class="text-center">
                    <td>
                        <input type="checkbox" class="chk" name="customId" value="${list.id}">
                    </td>
                    <td>${s.count}</td>
                    <td>${list.name}</td>
                    <td>${list.gender}</td>
                    <td>${list.age}</td>
                    <td>${list.address}</td>
                    <td>${list.qq}</td>
                    <td>${list.email}</td>
                    <td>
                        <a type="button" class="btn btn-danger btn-sm" href="javascript:deleById(${list.id})">
                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>  删除</a>
                        <a type="button" class="btn btn-primary btn-sm"  href="${pageContext.request.contextPath}/customByIdServlet?id=${list.id}">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>  修改</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>

</div>

<div style="margin-left: 600px">
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <c:if test="${pageBean.curPage<=1}">
                <li class="disabled">
                    <a href="${pageContext.request.contextPath}/findCustomByPageServlet?curPage=1&rows=5&name=${condition.name[0]}&gender=${condition.gender[0]}&address=${condition.address[0]}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
            </c:if>

            <c:if test="${pageBean.curPage>1}">
                <li>
                    <a href="${pageContext.request.contextPath}/findCustomByPageServlet?curPage=${pageBean.curPage-1}&rows=5&name=${condition.name[0]}&gender=${condition.gender[0]}&address=${condition.address[0]}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
            </c:if>
            <c:forEach begin="1" end="${pageBean.totalPage}" var="i">
                <c:if test="${pageBean.curPage == i}">
                    <li class="active">
                        <a href="${pageContext.request.contextPath}/findCustomByPageServlet?curPage=${i}&rows=5&name=${condition.name[0]}&gender=${condition.gender[0]}&address=${condition.address[0]}">${i}</a>
                    </li>
                </c:if>

                <c:if test="${pageBean.curPage != i}">
                    <li >
                        <a href="${pageContext.request.contextPath}/findCustomByPageServlet?curPage=${i}&rows=5&name=${condition.name[0]}&gender=${condition.gender[0]}&address=${condition.address[0]}">${i}</a>
                    </li>
                </c:if>
            </c:forEach>
            <c:if test="${pageBean.curPage<pageBean.totalPage}">
                <li>
                    <a href="${pageContext.request.contextPath}/findCustomByPageServlet?curPage=${pageBean.curPage+1}&rows=5&name=${condition.name[0]}&gender=${condition.gender[0]}&address=${condition.address[0]}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </c:if>

            <c:if test="${pageBean.curPage>pageBean.totalPage}">
                <li class="disabled">
                    <a href="${pageContext.request.contextPath}/findCustomByPageServlet?curPage=${pageBean.totalPage}&rows=5&name=${condition.name[0]}&gender=${condition.gender[0]}&address=${condition.address[0]}" aria-label="Next" disabled="true">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </c:if>

           &emsp;<span style="font-size: 18px;font-weight: 500">共${pageBean.totalCount}条数据，共${pageBean.totalPage}页，当前是第${pageBean.curPage}页</span>
        </ul>
    </nav>
</div>

</div>
</body>

<script type="text/javascript">

    // 全选与全不选
    $(".allchks").click(function () {
        $(".chk").prop("checked",$(this).prop("checked"));
    });

   // 根据客户Id删除客户信息（单个删除）
  function deleById(id) {
      if(confirm("你确定要删除此用户吗？")){
          location.href="${pageContext.request.contextPath}/deleCustomServlet?id="+id;
      }
  }

  //批量删除(删除选中)
    window.onload=function (ev) {
        document.getElementById("delBatch").onclick=function () {
            if(confirm("你确定要删除这些用户的信息吗?")){
                //提交表单数据
                document.getElementById("myform").submit();
            }
        }
    }

</script>
</html>