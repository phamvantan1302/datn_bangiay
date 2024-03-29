<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ include file="header.jsp" %>
<!-- Content -->

<div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="/imagesp/banner-bg.png" class="d-block w-100" alt="">
        </div>
        <div class="carousel-item">
            <img src="/imagesp/banner-bg.png" class="d-block w-100" alt="">
        </div>
        <div class="carousel-item">
            <img src="/imagesp/banner-bg.png" class="d-block w-100" alt="">
        </div>
    </div>
</div>

<div class="container mt-5">
    <h2 style="text-align: center">Tất cả sản phẩm </h2><br>
    <div class="row">
        <c:forEach items="${listprd.content}" var="ls">
            <div class="col-3">
                <c:forEach items="${ls.image}" var="image">
                    <div class="card" style="width: 18rem;">
                        <img src="/imagesp/${image.name}" class="card-img-top" alt="">
                        <div class="card-body">
                            <p style="text-align: center"> ${ls.product.name}</p>
                            <p style="text-align: center;color: red">${ls.price} VND</p>
                            <p style="text-align: end">Số lượng còn: ${ls.quantity}</p>
                            <div class="row">
                                <div class="col-6" style="text-align: start">
                                    <a href="/admin/addcart/${ls.id}" type="button" class="btn btn-info">Thêm giỏ</a>
                                </div>
                                <div class="col-6" style="text-align: end">
                                    <a href="/admin/detailsp/${ls.id}" type="button" class="btn btn-info">Chi tiết</a>
                                </div>
                            </div>
                        </div>
                    </div><br>
                </c:forEach>
                <br>
            </div>
        </c:forEach><br>
    </div>

    <nav aria-label="Page navigation example" style="margin-left: 600px">
        <ul class="pagination">
            <c:if test="${listprd.totalPages > 1}">
                <c:forEach begin="0" end="${ listprd.totalPages -1}" varStatus="loop">
                    <li class="page-item">
                        <a class="page-link" href="/admin/hien-thi?page=${loop.begin + loop.count - 1}">
                                ${loop.begin + loop.count }
                        </a>
                    </li>
                </c:forEach>
            </c:if>
        </ul>
    </nav>

</div>
<%@ include file="footer.jsp" %>