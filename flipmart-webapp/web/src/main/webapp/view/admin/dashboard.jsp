<!doctype html>
<html lang="en" ng-controller="dashboardController">

<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="assets/images/admin/apple-icon.png" />
    <link rel="icon" type="image/png" href="assets/images/admin/favicon.png" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />
    <title>Admin Dashboard</title>
    <!-- Bootstrap core CSS     -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
    <!--  Material Dashboard CSS    -->
    <link href="assets/css/material-dashboard.css?v=1.2.0" rel="stylesheet" />
    <!--     Fonts and icons     -->
    <link href="assets/css/font-awesome.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons' rel='stylesheet' type='text/css'>

</head>

<body>
<div class="wrapper">
    <div id="sidebarclass">

    </div>
    <div class="main-panel">
        <div id="headerclass">

        </div>
        <div class="content" ng-controller="StatisticsCtrl">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <div class="card card-stats">
                            <div class="card-header" data-background-color="orange">
                                <i class="material-icons">commute</i>
                            </div>
                            <div class="card-content">
                                <p class="category">Orders Delivered</p>
                                <h3 class="title" ng-bind="ordersDelivered"></h3>
                            </div>
                            <div class="card-footer">
                                <div class="stats">
                                    Orders Successfully Delivered
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <div class="card card-stats">
                            <div class="card-header" data-background-color="green">
                                <i class="material-icons">local_atm</i>
                            </div>
                            <div class="card-content">
                                <p class="category">Monthly Sales</p>
                                <h3 class="title" ng-bind="monthlySales"></h3>
                            </div>
                            <div class="card-footer">
                                <div class="stats">
                                    Monthly Sales
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <div class="card card-stats">
                            <div class="card-header" data-background-color="red">
                                <i class="material-icons">people</i>
                            </div>
                            <div class="card-content">
                                <p class="category">No. of Users</p>
                                <h3 class="title" ng-bind="noOfUsers"></h3>
                            </div>
                            <div class="card-footer">
                                <div class="stats">
                                    Registered Users
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <div class="card card-stats">
                            <div class="card-header" data-background-color="blue">
                                <i class="fa fa-facebook"></i>
                            </div>
                            <div class="card-content">
                                <p class="category">No. of Products</p>
                                <h3 class="title" ng-bind="noOfProducts"></h3>
                            </div>
                            <div class="card-footer">
                                <div class="stats">
                                    Total Products
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<!--   Core JS Files   -->
<script src="assets/js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script>
    $(function(){
        $("#sidebarclass").load("/flipmart-webapp-web/sidebar");
        $("#headerclass").load("/flipmart-webapp-web/adminHeader");

    });
</script>
<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
<script src="assets/js/material.min.js" type="text/javascript"></script>

<!-- Angular Scripts -->
<script src="assets/js/angular.min.js"></script>
<script src="assets/controllers/dashboard.controller.js" type="text/javascript"></script>
<script src="assets/js/perfect-scrollbar.jquery.min.js"></script>
<script src="assets/js/bootstrap-notify.js"></script>
<script src="assets/js/material-dashboard.js?v=1.2.0"></script>
<script src="assets/js/angular-route.min.js" type="text/javascript"></script>
</html>