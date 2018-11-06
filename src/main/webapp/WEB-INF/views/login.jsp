<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/11/2
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
</head>
<body>
<div>
    <form id="zc" action="/user/login" method="post">
        用户名：<input type="text" required id="name" name="name">
        密码：<input type="password" required id="pw" name="pw">
        <input type="submit" value="登陆">
        <input type="button" value="注册" onclick="location.href='/user/register/'">
    </form>
</div>
</body>
<script>
    if('${status}'!=''){
        if('${status}'==0){
            alert('登陆成功，即将跳转至用户详情页！');
            location.href='userInfo';
        }else if('${status}'==1){
            alert('该账户不存在');
        }else if ('${status}'==2) {
            alert('密码错误');
        }
    }
</script>
</html>
