<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Lace</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body class="container">
<div><br>
    <h2 style="text-align: center">QUẢN LÝ LACE</h2><br>
    <form action="/pdtt/add_lace" method="post">
        <div class="row">
            <div class="col-6">
                <label class="form-label">Code</label>
                <input type="text" class="form-control" name="code" value="${lace.code}">
            </div>
            <div class="col-6">
                <label class="form-label">name</label>
                <input type="text" class="form-control" name="name" value="${lace.name}">
            </div>
        </div>
        <div class="row">
            <label class="form-label">length</label>
            <input type="text" class="form-control" name="length" value="${lace.length}">
        </div>
        <button class="btn btn-success" type="submit">Add</button>
    </form>
    <table class="table">
        <thead>
        <tr>
            <td>Code</td>
            <td>Name</td>
            <td>Length</td>
            <td>Option</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${lace.content}" var="ls">
            <tr>
                <th>${ls.code}</th>
                <th>${ls.name}</th>
                <th>${ls.length}</th>
                <td>
                    <a class="btn btn-info" href="/pdtt/detail_lace/${ls.id}">Detail</a>
                </td>
                <td>
                    <a class="btn btn-danger" href="/pdtt/delete_lace/${ls.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <nav aria-label="Page navigation example" style="margin-left: 600px">
        <ul class="pagination">
            <c:if test="${lace.totalPages > 1}">
                <c:forEach begin="0" end="${ lace.totalPages -1}" varStatus="loop">
                    <li class="page-item">
                        <a class="page-link" href="/pdtt/hienthi_lace?page=${loop.begin + loop.count - 1}">
                                ${loop.begin + loop.count }
                        </a>
                    </li>
                </c:forEach>
            </c:if>
        </ul>
    </nav>
</div>
</body>