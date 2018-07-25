angular.module("dashboardApp", []).controller("StatisticsCtrl", function($scope, $http) {
    var onPageLoadSuccess = function(response) {
        $scope.ordersDelivered = response.data.ordersDelivered;
        $scope.monthlySales = response.data.monthlySales;
        $scope.noOfUsers = response.data.noOfUsers;
        $scope.noOfProducts = response.data.noOfProducts;
    }
    var onPageLoadError = function(response) {
        //Display Error Message or route to server not available page
    }
    function pageLoad() {
        $http.get("../../assets/controllers/DummyData/dashboardPageLoad.json").then(onPageLoadSuccess, onPageLoadError);
    }

    pageLoad();
});