<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>查看员工信息</title>
  </head>
  <body>
  <div>
    <jsp:include page="head.jsp"></jsp:include>
  </div>
  <a href="${pageContext.request.contextPath}/findCustomByPageServlet" style="font-size:2em;font-weight: 500;text-align: center;text-decoration: none;font-color:blue;">查看所有员工信息</a>
  </body>
</html>
