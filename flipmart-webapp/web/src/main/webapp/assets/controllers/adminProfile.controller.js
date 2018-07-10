angular.module("adminProfileApp", []).controller("ProfileDetailsCtrl", function($scope, $http) {
    var profilePageLoad = function() {
        $http.get("")
    };

    $scope.profilePageLoad();
});