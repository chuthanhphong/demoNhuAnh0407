<%--
  Created by IntelliJ IDEA.
  User: Windboy
  Date: 04/07/2021
  Time: 9:12 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="Customer" method="post">
    <input type="hidden" value="create" name="action">
    <input type="text" name="id">
    <input type="text" name="name">
    <input type="text" name="age">
    <button>Create</button>
</form>
</body>
</html>
