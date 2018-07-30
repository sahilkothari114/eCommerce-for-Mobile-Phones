angular.module("adminProfileApp", []).controller("ProfileDetailsCtrl", function($scope, $http) {
    var onPageLoadSuccess = function (response) {
        $scope.data = response.data;
        PageLoadData();
    };

    var onPageLoadError = function (response) {
        //Error by routing to error page
    };
    var profilePageLoad = function() {
        $http.get("../../assets/controllers/DummyData/adminProfileData.json").then(onPageLoadSuccess, onPageLoadError);
    };

    var PageLoadData = function loadData() {
        $scope.email = $scope.data.email;
        $scope.firstName = $scope.data.firstName;
        $scope.lastName = $scope.data.lastName;
        $scope.pincode = $scope.data.pincode;
        $scope.streetAddress = $scope.data.streetAddress;
        $scope.contactNo = $scope.data.contactNo;
        $scope.side_email = $scope.data.email;
        $scope.side_firstName = $scope.data.firstName;
        $scope.side_lastName = $scope.data.lastName;
        $scope.side_pincode = $scope.data.pincode;
        $scope.side_streetAddress = $scope.data.streetAddress;
        $scope.side_contactNo = $scope.data.contactNo;
        $scope.side_city = $scope.data.city;
        $scope.side_state = $scope.data.state;
    };

    var GetPageData = function getData() {
        $scope.data.email = scope.email;
        $scope.data.firstName = $scope.firstName;
        $scope.data.lastName = $scope.lastName;
        $scope.data.pincode = $scope.pincode;
        $scope.data.streetAddress = $scope.streetAddress;
        $scope.data.contactNo = $scope.contactNo;
    };

    var onUpdateProfileSuccess = function(response) {
        $scope.data = response.data;
        PageLoadData();
    };

    var onUpdateProfileError = function(response) {
        //Error Message
    };

    $scope.UpdateProfile = function() {
        GetPageData();
        $http.put("Put URL here", $scope.data).then(onUpdateProfileSuccess, onUpdateProfileError);
    };

    profilePageLoad();
});