var app = angular.module('myApp', []);
app.controller('UserController',['$scope', 'UserService', function($scope, UserService) {
        
    var self = this;
    self.user={firstName:'',lastName:'',email:'',password:'',pincode: {
                pincode: '',
                city: {
                    cityName: '',
                    state: {
                        stateName: ''
                    }
                }

            },streetAddress:'',contactNo:'',active:true};
      
    self.submit = submit;  
    
     function submit() {
       
            console.log('Saving New User', self.user);
            createUser(self.user);
    }
    
     function createUser(user){
        UserService.createUser(user)
            .then(
            console.log('created ',user),
            function(errResponse){
                console.error('Error while creating User');
            }
        );
    }
        
//    $scope.createUser = function () {
//        
//
//
//        var user = {
//            firstName: $scope.signup.FirstName,
//            lastName: $scope.signup.LastName,
//            email: $scope.signup.email,
//            password: $scope.signup.password,
//            pincode: {
//                pincode: $scope.signup.pin,
//                city: {
//                    cityName: $scope.signup.city,
//                    state: {
//                        stateName: $scope.signup.state
//                    }
//                }
//
//            },
//            streetAddress: $scope.signup.street,
//            contactNo: $scope.signup.contact,
//            active: true
//        };
//
//        $http.post('/flipmart-webapp-web/user', user).then(function (response) {
//            console.log(response);
//        });
//    };
//
//    $scope.loginUser = function () {
//        var loginUser = {
//            email: $scope.login.email,
//            password: $scope.login.password
//        };
//
//        $http.post('/flipmart-webapp-web/validate', loginUser).then(function (response) {
//            console.log(response);
//        });
//    };

}]);