<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maxen
  Date: 24/01/2023
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New pastry</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous"/>
</head>
<body>
<header>
    <h1>Add new pastry</h1>
</header>
<main class="container">
    <div class="row">
        <form method="post" action="${pageContext.request.contextPath}/add-pastry">
            <div class="input-group mb-3">
                <input name="name" type="text" class="form-control" placeholder="Name" aria-label="Name"
                       aria-describedby="basic-addon1" required>
            </div>
            <div class="input-group mb-3">
                <input name="description" type="text" class="form-control" placeholder="Description" aria-label="Description"
                       aria-describedby="basic-addon1" required>
            </div>
            <div class="input-group mb-3">
                <input type="submit" class="btn btn-primary"/>
            </div>
        </form>
    </div>
</main>
</body>
</html>
