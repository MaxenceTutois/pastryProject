<%--
  Created by IntelliJ IDEA.
  User: maxen
  Date: 24/01/2023
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous"/>
</head>
<body>
<header></header>
<main class="container">
    <c:if test="${pastry != null}">
    <h2 class="card-title">${pastry.name}</h2>
    <p class="card-text">${pastry.description}</p>
    </c:if>
</main>
</body>
</html>
