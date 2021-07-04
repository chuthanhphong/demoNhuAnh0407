<%--
  Created by IntelliJ IDEA.
  User: Windboy
  Date: 04/07/2021
  Time: 8:36 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<center>
    <h1>List Customer</h1>
    <a href="/Customer?action=create">Create a Customer</a>
    <c:forEach items="${customers}" var="cus">
        <h3>${cus.name}| ${cus.age}</h3>



    </c:forEach>
</center>
</body>
</html>
