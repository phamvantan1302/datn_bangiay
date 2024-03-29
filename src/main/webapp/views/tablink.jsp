<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" pageEncoding="utf-8" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
</head>
<style>
    .tabs{
        display:flex;
    }
    .tablinks {
        border: none;
        outline: none;
        cursor: pointer;
        width: 100%;
        padding: 1rem;
        font-size: 13px;
        text-transform: uppercase;
        font-weight:600;
        transition: 0.2s ease;
    }
    .tablinks:hover{
        background:blue;
        color:#fff;
    }
    /* Tab active */
    .tablinks.active {
        background:blue;
        color:#fff;
    }

    /* tab content */
    .tabcontent {
        display: none;
    }
    /* Text*/
    .tabcontent p {
        color: #333;
        font-size: 16px;
    }
    /* tab content active */
    .tabcontent.active {
        display: block;
    }
</style>
<body ng-app="myApp">
<div class="tabs">
    <button class="tablinks active" data-electronic="allproducts">Tạo Giảm Giá Hoá Đơn</button>
    <button class="tablinks" data-electronic="Microcontrollers">Tạo Giảm Giá Sản Phẩm</button>
    <button class="tablinks" data-electronic="module">Quản Lý Giảm Giá</button>
</div>

<!-- Tab content -->
<div class="wrapper_tabcontent">
    <div id="allproducts" class="tabcontent active">
        <h2 class="text-center">Quản Lý Đợt Giảm Giá</h2>
        <div class="container mt-3" ng-controller="myController" >
            <form cssClass="container" ng-submit="savediscountperiod()">
                <div class="row">
                    <div class="col-6">
                        <label for="">Ngày Bắt Đầu :</label>
                        <input cssClass="form-control" type="date" ></input>
                    </div>

                    <div class="col-6">
                        <label for="">Ngày Kết Thúc :</label>
                        <input cssClass="form-control" type="date" ></input>
                    </div>
                </div>

                <br>
                <div class="row">
                    <div class="col-6">
                        <label for="">Giảm (%) :</label>
                        <input cssClass="form-control" type="number"></input>
                        <sf:errors cssStyle="color: red" path="tenDem"></sf:errors>
                    </div>


                    <div class="col-6">
                        <label for="">Tên Trương Trình :̣</label>
                        <input cssClass="form-control"></input>
                    </div>
                </div>

                <br>

                <div class="row">
                    <div class="col-6">
                        <label for="">Giá Từ</label>
                        <input cssClass="form-control" type="number" ></input>
                    </div>

                    <div class="col-6">
                        <label for="">Đến</label>
                        <input cssClass="form-control" type="number"></input>
                    </div>
                </div>
                <br>
                <div class="row">

                    <div class="col-6">
                        <label for="">Số Lượng</label>
                        <input cssClass="form-control" type="number"></input>
                    </div>
                    <div class="col-6">
                        <label for="">Trạng thái :</label>
                        <input cssClass="form-control" name="trangthai" type="radio" value="1"> Áp Dụng
                        <input cssClass="form-control" name="trangthai" type="radio" value="0"> Chờ Áp Dụng
                    </div>



                </div>
                <br>

                <br>
                <div class="d-flex justify-content-center">
                    <button class="btn btn-primary" style="align-items:center">Thêm</button>
                </div>
            </form>

            <table class="table table-borderted mt-2">
                <thead>
                <tr>
                    <td>STT</td>
                    <td>Code</td>
                    <td>Ngày Bắt Đầu</td>
                    <td>Ngày Kết Thúc</td>
                    <td>Giảm (%)</td>
                    <td>Số tiền bắt đầu</td>
                    <td>Số tiền kết thúc</td>
                    <td>giảm giá theo</td>
                    <td>Mô tả</td>
                    <td colspan="2">Action</td>
                </tr>
                </thead>
                <tbody ng-repeat="discountperiod in discountperiods" >
                <tr>
                    <td>{{}}</td>
                    <td>{{discountperiod.code}}</td>
                    <td>{{discountperiod.startDate}}</td>
                    <td>{{discountperiod.endDate}}</td>
                    <td>{{discountperiod.value}}</td>
                    <td>{{discountperiod.category}}</td>
                    <td>{{discountperiod.starPrice}}</td>
                    <td>{{discountperiod.endPrice}}</td>
                    <td>{{discountperiod.description}}</td>
                    <td><a class="btn btn-info" >Update</a></td>
                    <td> <a class="btn btn-danger" ng-click="deletedDiscountPeriod(discountperiod.id)">Delete</a></td>
                </tr>
                </tbody>
            </table>

        </div>

    <div id="Microcontrollers" class="tabcontent">
        <img src="https://bizweb.dktcdn.net/thumb/large/100/228/168/products/raspberry-pi-4-model-b.jpg?v=1566526980000" width="100%"/>
        <h3>Raspberry Pi 4 Model B 2019</h3>
    </div>

    <div id="module" class="tabcontent">
        <img src="//bizweb.dktcdn.net/thumb/large/100/228/168/products/sp1-96b83938-650f-4f51-8b0a-61ee9f8f9039.jpg?v=1580721383000" width="100%"/>
        <h3>Module Khuếch Đại Âm Thanh Bluetooth Stereo 30W/40W Công Suất Cao XY-P40W</h3>
    </div>
</div>
</body>
<script>

    var app = angular.module('myApp', []);



    app.controller('myController', function($scope, $http) {
        // Cuộc gọi API để lấy danh sách sản phẩm
        $scope.discountperiods = [];
        $scope.newdiscountperiod = {};
        $scope.index = 0

        $http.get('http://localhost:8080/admin/DiscountPeriods')
            .then(function(response) {
                // Log dữ liệu phản hồi vào console (nếu cần)
                console.log('Dữ liệu phản hồi:', response.data);

                // Lưu danh sách sản phẩm vào $scope
                $scope.discountperiods = response.data;
            })
            .catch(function(error) {
                // Xử lý lỗi nếu có
                console.error('Lỗi:', error);
            });
        // Save new
        $scope.savediscountperiod = function() {
            $http.post('http://localhost:8080/admin/DiscountPeriod', $scope.newdiscountperiod)
                .then(function(response) {
                    // Handle success
                    $scope.discountperiods.push(response.data);
                })
                .catch(function(error) {
                    console.error('Error saving book:', error);

                });
            $scope.newdiscountperiod= {};
        };

        $scope.deletedDiscountPeriod = function(DiscountPeriodId) {
            $http.delete('http://localhost:8080/admin/DiscountPeriod/' + DiscountPeriodId)
                .then(function() {
                    // Handle success
                    $scope.removeFromList(DiscountPeriodId);
                })
                .catch(function(error) {
                    console.error('Error deleting book:', error);
                });
        };
        $scope.removeFromList = function(DiscountPeriodId) {
            $scope.discountperiods = $scope.discountperiods.filter(discountperiods => discountperiods.id !== DiscountPeriodId);
        };

    });

    var tabLinks = document.querySelectorAll(".tablinks");
    var tabContent =document.querySelectorAll(".tabcontent");

    tabLinks.forEach(function(el) {
        el.addEventListener("click", openTabs);
    });


    function openTabs(el) {
        var btn = el.currentTarget; // lắng nghe sự kiện và hiển thị các element
        var electronic = btn.dataset.electronic; // lấy giá trị trong data-electronic

        tabContent.forEach(function(el) {
            el.classList.remove("active");
        }); //lặp qua các tab content để remove class active

        tabLinks.forEach(function(el) {
            el.classList.remove("active");
        }); //lặp qua các tab links để remove class active

        document.querySelector("#" + electronic).classList.add("active");
        // trả về phần tử đầu tiên có id="" được add class active

        btn.classList.add("active");
        // các button mà chúng ta click vào sẽ được add class active
    }

</script>
</html>