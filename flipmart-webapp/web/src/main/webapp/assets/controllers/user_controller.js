//var app = angular.module('myApp', []);
angular.module('myApp').controller('UserController',['$scope', '$window','$http','UserService', function($scope, $window,$http,UserService) {
        
    var self = this;

    $scope.loginUser = function(loginData){
        UserService.validateUser(loginData);
    };
   
        $scope.loggedUser = function () {
            if (UserService.islogged()) {
                var logedUser = UserService.loggedUser();
                //$scope.profile.NewEmail = logedUser;
                console.log('user is loged ', logedUser);
            } else
                console.log('NO one is logged...');
        };
    
    $scope.updateUser = function(){
                                                                                                           
                                                            
            var userData = {
                firstName: $scope.profile.FirstName,
                lastName: $scope.profile.LastName,
                email: $scope.profile.NewEmail,
                password: $scope.profile.NewPassword,
                pincode: {
                    pincode: $scope.profile.NewPincode,
                    city:
                            {
                                city: $scope.profile.NewCity,
                                state: {state: $scope.profile.NewState}
                            }

                },
                streetAddress: $scope.profile.NewAddress,
                contactNo: $scope.profile.NewContact,

            };


            $http.post('/flipmart-webapp-web/signup.action/user', userData).then(function (response) {

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
        

$window.onload = function () {
    $scope.loggedUser();
};
    

}]);