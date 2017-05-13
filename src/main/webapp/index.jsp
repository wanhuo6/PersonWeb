<%--
  Created by IntelliJ IDEA.
  User: ahuo
  Date: 17-5-10
  Time: 上午10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录</title>
  </head>
  <body>
  <h1>阿火俱乐部</h1>

  <form action="/GetLogin" method="post">
    <table>
      <tr>
        <td>用户名：</td>
        <td><input type="text" name="username"></td>
      </tr>

      <tr>
        <td>密码：</td>
        <td><input type="password" name="pass"></td>
      </tr>

      <tr>
        <td><input type="submit" value="登录"> </td>
        <td><a href="html/register.html">没有账号？点我注册</a></td>
      </tr>
    </table>
  </form>
  </body>
</html>
