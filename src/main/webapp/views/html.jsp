<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" pageEncoding="utf-8" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<style>
    form{
        text-align: center;
    }
</style>
<body ng-app="myApp">
<h2 class="text-center">Quản Lý Đợt Giảm Giá</h2>
<div ng-controller="myController" >
    <form cssClass="container" ng-submit="savediscountperiod()">
        <div>
            <label>Ngày Bắt Đầu:</label>
            <input type="date" cssClass="form-control" ng-model="newdiscountperiod.startDate" ><br>
        </div>

        <div>
            <label>Ngày Kết Thúc :</label>
            <input type="date" cssClass="form-control" ng-model="newdiscountperiod.endDate" ><br>
        </div>

        <div>
            <label>% giảm :</label>
            <input type="number" cssClass="form-control" ng-model="newdiscountperiod.value"  min="1" >
        </div>
        <div >
            <label class="form-label">Hình thức Giảm Giá:</label>
            <select  ng-model="newdiscountperiod.discountType">
                <option value="SanPham">Sản Phẩm</option>
                <option value="HoaDon">Hoá Đơn</option>
            </select>
        </div>
        <div>
            <label>Mô tả :</label>
            <input type="text" cssClass="form-control" ng-model="newdiscountperiod.description" ><br>
        </div>


        <div class="d-flex justify-content-center">
            <button class="btn btn-primary mt-3 "> Thêm mới</button>
        </div>
    </form>
    <table class="table table-borderted mt-2">
        <thead>
        <tr>
            <td>STT</td>
            <td>Code</td>
            <td>Ngày Bắt Đầu</td>
            <td>Ngày Kết Thúc</td>
            <td>Value</td>
            <td>Hình Thức</td>
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
            <td>{{discountperiod.discountType}}</td>
            <td>{{discountperiod.description}}</td>
            <td><a class="btn btn-info" >Update</a></td>
            <td> <a class="btn btn-danger" ng-click="deletedDiscountPeriod(discountperiod.id)">Delete</a></td>
        </tr>
        </tbody>
    </table>
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

</script>
</html>