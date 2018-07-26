//var app = angular.module('myApp', []);
angular.module('myApp').controller('UserController',['$scope', '$window','$http','UserService', function($scope, $window,$http,UserService) {
        
    var self = this;

    $scope.loginUser = function(loginData){
        UserService.validateUser(loginData);
    };
   
       loggedUser = function () {
           
           if (UserService.islogged()) {
                var logedUser = UserService.loggedUser();
               
               console.log('user is loged ', logedUser); 
               return logedUser;
                
            } else{
                console.log('NO one is logged...');
                return null;
            }
        };
    
    $scope.updateUser = function(data){
                                                                                                           
                          console.log('data updated ',data);                                  
//            var userData = {
//                firstName: $scope.profile.FirstName,
//                lastName: $scope.profile.LastName,
//                email: $scope.profile.NewEmail,
//                password: $scope.profile.NewPassword,
//                pincode: {
//                    pincode: $scope.profile.NewPincode,
//                    city:
//                            {
//                                city: $scope.profile.NewCity,
//                                state: {state: $scope.profile.NewState}
//                            }
//
//                },
//                streetAddress: $scope.profile.NewAddress,
//                contactNo: $scope.profile.NewContact,
//
//            };


            $http.post('/flipmart-webapp-web/signup.action/user', data).then(function (response) {

                console.log(response);
            });

        };
   
    

    
    $scope.textChanged=function (){
        var pinTemp={
            pincode:""
        };
        
        var temp=$scope.user.pincode.toString();
        
        console.log('text chnged',($scope.user.pincode),'length ',((temp.length)-9));
        if(((temp.length)-9)===6){
            pinTemp.pincode=$scope.user.pincode;
            console.log("pinTemo ",pinTemp);
            UserService.getCity(pinTemp)
            .then(
            function(response){
                console.error('get data ',response);
            },
            function(errResponse){
                console.error('Error while creating User',errResponse);
            }
        );
        }
    };
   
     function submit() {
       
            console.log('Saving New User', self.user);
            createUser(self.user);
    }
    
     $scope.createUser=function (user){
        UserService.createUser(user)
            .then(
            console.log('created ',user),
            function(errResponse){
                console.error('Error while creating User');
            }
        );
    };
        

  $scope.loadModifyValues= function(){
                   
    var userId=loggedUser();
    
    $scope.userUpadatedData={firstName:'',lastName:'',email:'',password:'',pincode: {
                pincode: '',
                city: {
                    cityName: '',
                    state: {
                        stateName: ''
                    }
                }

            },streetAddress:'',contactNo:'',active:true};
        
        
                      $scope.userUpadatedData.email = userId;

//         UserService.userDetails(userId)
//            .then(
//            function(response){
//                $scope.userUpadatedData.email = userId;
//                console.error('User ',response);
//            },
//            
//            function(errResponse){
//                console.error('Error while retrieving User',errResponse);
//                
//            }
//        );
    
} ;
    

}]);