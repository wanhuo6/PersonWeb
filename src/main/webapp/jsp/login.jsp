<%--
  Created by IntelliJ IDEA.
  User: ahuo
  Date: 17-5-13
  Time: 下午1:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<h1>用户注册</h1>
<form action="reg" method="post">
    用户名：<input type="text" name="username"><br>
    密码:<input type="password" name="pass"><br>
    重复密码：<input type="password" name="pass2"><br>
    年龄：<input type="text" name="age"><br>
    性别：男<input type="radio" name="sex" value="男">
    女<input type="radio" name="sex" value="女">
    <br>
    爱好：
    旅游 <input type="checkbox" name="hobby" value="旅游">
    编程 <input type="checkbox" name="hobby" value="编程">
    美食 <input type="checkbox" name="hobby" value="美食">
    <br>
    所在省份：<select name="province">
    <option value="湖北">湖北</option>
    <option value="湖南">湖南</option>
    <option value="河北">河北</option>
    <option value="河南">河南</option>
</select><br>
    个人简介：<textarea rows="6" cols="35" name="info"></textarea>
    <br>
    <input type="submit" value="注册">
</form>

</body>
</html>