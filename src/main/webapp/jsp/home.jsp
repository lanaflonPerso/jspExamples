<%--
  Created by IntelliJ IDEA.
  User: vlad
  Date: 16.07.18
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<span style="color: ${cookie.color.value}">Hello</span>
<form method="post" action="/home">
    <label for="color">
        <select name="color" id="color">
            <option value="red">Красный</option>
            <option value="black">Черный</option>
            <option value="white">Белый</option>
        </select>
        <input type="submit" value="Color send">
    </label>

</form>
</body>
</html>
