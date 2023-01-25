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
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <h1>List of pastries</h1>
                <form class="d-flex" role="search" method="post" action="${pageContext.request.contextPath}/search-pastry">
                    <input name="search" class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success">Search</button>
                </form>
            </div>
        </div>
    </nav>
</header>
<main class="container">
    <c:forEach items="${pastries}" var="pastry">
        <div class="row">
            <div class="col-md-1">${pastry.id}</div>
            <div class="col-md-3"><a href="/pastry-detail?pastryId=${pastry.id}">${pastry.name}</a></div>
            <div class="col-md-6">${pastry.description}</div>
            <div class="col-md-2">
                <form method="post" action="${pageContext.request.contextPath}/delete-pastry">
                    <input type="hidden" value="${pastry.id}" name="idPastry">
                    <button class="btn btn-danger">Delete</button>
                </form>
            </div>
        </div>
    </c:forEach>
</main>
</body>
</html>
