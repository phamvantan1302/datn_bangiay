<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vn">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>home</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link href="css/cssOfMy.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-success" style="color: #1e7898">
    <div class="container-sm">
        <div class="container" id="navbarNav" style="text-align: center">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" style="color: white" href="/admin/hien-thi">Trang chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" style="color: white" href="/admin/gioithieu">Giới thiệu</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" style="color: white" href="/admin/lienhe">Liên hệ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" style="color: white;text-align: end" href="/admin/hienthi">Giỏ Hàng</a>
                </li>
            </ul>
        </div>
    </div>
</nav>