var app = angular.module('myApp', []);
app.controller('userHomeController',['$scope', '$http','UserService', function($scope, $http,UserService) {
    $scope.txt="Home Page";
    $scope.logout=function(){
        UserService.logout();
    };
}]);