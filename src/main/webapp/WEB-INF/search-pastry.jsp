<%--
  Created by IntelliJ IDEA.
  User: maxen
  Date: 25/01/2023
  Time: 08:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
</head>
<body>
<form action="/search-pastry" method="post">
  <label for="search">Pastry name</label>
  <input id="search" type="text" name="search">
  <button>Search</button>
</form>
</body>
</html>
