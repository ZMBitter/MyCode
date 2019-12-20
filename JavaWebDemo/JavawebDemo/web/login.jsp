<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>

    <style type="text/css">
        *{
            margin: 0 auto;
            padding: 0px;
        }

        #container{
            width: 500px;
            height: 500px;
            border: 1px solid gainsboro;
            margin-top: 20px;
        }

        input{
            width: 300px;
            height:40px;
            border-radius: 5px;
            border: 1px solid #8c8c8c;
        }

        #login{
            background-color: blue;
            font-size: 18px;
            color: white;
        }
        #myForm{
            text-align: center;
        }

        #title{
            font-size: 25px;
            font-weight: bold;
        }

        #tip{
            width: 100%;
            height: 50px;
            background-color: #dff0d8;
            margin-top: 30px;
            text-align: center;
            line-height: 50px;
            font-size: 15px;
            color: red;
            font-family: Centaur;
        }
    </style>

    <script src="js/jquery-3.3.1.js"></script>

    <script type="text/javascript">
        //切换验证码
        function refreshCode() {
            //获取验证码对象
            var vcode = document.getElementById("vcode");
            vcode.src="${pageContext.request.contextPath}/checkCodeServlet?time="+new Date().getTime();
        }
    </script>
</head>
<body>

    <div id="container">
        <div id="myForm">
            <form action="${pageContext.request.contextPath}/loginServlet" method="post">
                <span id="title">用户登陆</span><br><br>
                <p>
                    <span>用户名：</span> <input type="text" name="username">
                </p><br><br>
                <p>
                    <span>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</span><input type="password" name="password">
                </p><br><br>
                <p>
                    <span>验证码：</span>
                    <input type="text" name="checkCode" ><br>
                    <a href="javascript:refreshCode();">
                        <img src="${pageContext.request.contextPath}/checkCodeServlet" id="vcode" title="看不清?点击换一张">
                    </a>
                </p><br><br>
                <p>
                    <input type="submit" value="登陆" id="login">
                </p>
            </form>
        </div>
        <div id="tip">${login_msg}</div>
    </div>
</body>
</html>
