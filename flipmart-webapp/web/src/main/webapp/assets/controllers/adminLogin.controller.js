var app = angular.module('adminLoginApp', ['ngRoute']);

app.config(['$routeProvider', '$locationProvider',
    function ($routeProvider, $locationProvider) {
        $routeProvider.when('/flipmart-webapp-web/adminDashboard', {
            templateUrl: '/flipmart-webapp-web/adminDashboard',
            controller: 'dashboardController'
        }).otherwise({
            redirectTo: '/flipmart-webapp-web/adminLogin'
        });
        $locationProvider.html5Mode({
            enabled: true,
            requireBase: false
        }); //Remove the '#' from URL.
    }
]);

app.controller("adminCtrl", function ($scope, $http ,$window) {

    var onLoginSuccess = function (response) {
        //Put code for routing to Dashboard here using Struts
        if (response.data !== null) {
            console.log("Login Successful" + response.data.email);
             $window.location.href = '/flipmart-webapp-web/adminDashboard';
            //$location.path("/flipmart-webapp-web/adminDashboard");
        }
    };

    var onLoginError = function (response) {
        //Error message
        console.log("Login Failure" + response.status);
    };

    $scope.Login = function () {
        var data = {email: $scope.email, password: $scope.password};
        console.log(data);
        $http.post("/flipmart-webapp-web/validateAdmin", data).then(onLoginSuccess, onLoginError);
    };

    window.setTimeout(function () {
        $(".alert").fadeTo(500, 0).slideUp(500, function () {
            $(this).remove();
        });
    }, 4000);
});