<%--
  Created by IntelliJ IDEA.
  User: maxen
  Date: 24/01/2023
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<form action="/delete-pastry" method="post">
  <label for="idPastry">Pastry Id</label>
  <input id="idPastry" type="number" name="idPastry">
  <button>Delete</button>
</form>
</body>
</html>
