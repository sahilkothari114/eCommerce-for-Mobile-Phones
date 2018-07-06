
angular.module("adminLoginApp",[]).controller("LoginCtrl", function ($scope, $http) {

    var onLoginSuccess = function(data, status, headers, config) {
        //Put code for routing to Dashboard here
        console.log("Login Successful" + data.email);
    }

    var onLoginError = function(data, status, headers, config) {
        //Error message
        console.log("Login Failure" + status);
    }

    $scope.Login = function() {
        var data = {};
        data.loginDetails = {email:$scope.emailID, password: $scope.password};
        console.log(data);
        var promise = $http.get("Put GET URL", data);
        promise.success(onLoginSuccess);
        promise.error(onLoginError);
    };

    window.setTimeout(function() {
        $(".alert").fadeTo(500, 0).slideUp(500, function(){
            $(this).remove();
        });
    }, 4000);
});