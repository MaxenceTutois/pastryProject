<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maxen
  Date: 24/01/2023
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pastries</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous"/>
</head>
<body>
<header>
    <h1>List of pastries</h1>
</header>
<main class="container">
    <c:forEach items="${pastries}" var="pastry">
        <div class="row">
            <div class="col-md-1">${pastry.id}</div>
            <div class="col-md-3">${pastry.name}</div>
            <div class="col-md-6">${pastry.description}</div>
            <div class="col-md-2">
                <form id="${pastry.id}" method="post" action="${pageContext.request.contextPath}/pastry-list">
                    <input type="submit" class="btn btn-primary"/>
                </form>
            </div>
        </div>
    </c:forEach>
</main>
</body>
</html>
