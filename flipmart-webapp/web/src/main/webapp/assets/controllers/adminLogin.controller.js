
angular.module("adminLoginApp",[]).controller("adminCtrl", function ($scope, $http) {

    var onLoginSuccess = function(response) {
        //Put code for routing to Dashboard here using Struts
        console.log("Login Successful" + response.data.email);
    };

    var onLoginError = function(response) {
        //Error message
        console.log("Login Failure" + response.status);
    };

    $scope.Login = function() {
        var data = {email:$scope.email, password: $scope.password};
        console.log(data);
        $http.post("/flipmart-webapp-web/validateAdmin", data).then(onLoginSuccess, onLoginError);
    };

    window.setTimeout(function() {
        $(".alert").fadeTo(500, 0).slideUp(500, function(){
            $(this).remove();
        });
    }, 4000);
});