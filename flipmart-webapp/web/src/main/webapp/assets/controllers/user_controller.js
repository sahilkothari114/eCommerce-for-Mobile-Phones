var app = angular.module('myApp', []);
app.controller('UserController',['$scope', '$http','UserService', function($scope, $http,UserService) {
        
    var self = this;
    
        $scope.loginUser = function () {
            var loginUser = {
                email: $scope.ctrl.login.email,
                password: $scope.ctrl.login.password
            };

            $http.post('/flipmart-webapp-web/validate', loginUser).then(function (response) {
                console.log(response);
            });
        };
    

    
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
        


    

}]);