'use strict';

var App = angular.module('myApp',[]);


App.run(function($rootScope,$location,UserService){
   var routespermission = ['/userprofile'];  //routes that require login 
   $rootScope.$on('$routeChangeStart',function(){
       console.log('>>exit tab: '+routespermission.indexOf($location.path()));
       console.log('>> logged: '+UserService.islogged());
       if(routespermission.indexOf($location.path())!==-1&&!UserService.islogged()){
           $location.path('/login');
       }
   });
});

