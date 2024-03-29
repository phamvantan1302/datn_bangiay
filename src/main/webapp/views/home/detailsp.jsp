<%@ include file="header.jsp" %>
<div class="col-3">
    <c:forEach items="${sp.image }" var="image">
        <img src="/imagesp/${image.name}" class="card-img-top" alt=""></c:forEach>
</div>
<div class="col-5">
    <h2>Thong tin sp</h2>
    <c:forEach items="${product }" var="product">
        <div class="row">${product.name}</div>
    </c:forEach>
    <div class="row">${sp.price}</div>
    <c:forEach items="${category }" var="category">
        <div class="row">${category.name}</div>
    </c:forEach>
    <c:forEach items="${size }" var="size">
        <div class="row">${size.name}</div>
    </c:forEach>
    <c:forEach items="${material }" var="material">
        <div class="row">${material.name}</div>
    </c:forEach>
    <c:forEach items="${color }" var="color">
        <div class="row">${name}</div>
    </c:forEach>
    <c:forEach items="${brand }" var="brand">
        <div class="row">${brand.name}</div>
    </c:forEach>
    <c:forEach items="${sole }" var="s">
        <div class="row">${s.name}</div>
    </c:forEach>
    <div class="row"></div>
</div>


<%@ include file="footer.jsp" %>