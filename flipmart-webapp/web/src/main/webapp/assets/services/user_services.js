'use strict';

angular.module('myApp').factory('UserService', ['$http', '$q', '$location', 'sessionService', function ($http, $q, $location, sessionService) {

        var SERVICE_URI = '/flipmart-webapp-web/user';

        var factory = {
            fetchAllUsers: fetchAllUsers,
            createUser: createUser,
            deleteUser: deleteUser,
            validateUser: validateUser,
            logoutUser: logoutUser,
            islogged: islogged,
            loggedUser: loggedUser,
            userDetails: userDetails,
            getCity: getCity
        };

        return factory;

        function fetchAllUsers() {
            var deferred = $q.defer();
            $http.get(SERVICE_URI)
                    .then(
                            function (response) {
                                deferred.resolve(response.data);
                            },
                            function (errResponse) {
                                console.error('Error while fetching Users');
                                deferred.reject(errResponse);
                            }
                    );
            return deferred.promise;
        }

        function createUser(user) {
            var deferred = $q.defer();
            $http.post('/flipmart-webapp-web/user', user)
                    .then(
                            function (response) {
                                deferred.resolve(response.data);
                            },
                            function (errResponse) {
                                console.error('Error while creating User');
                                deferred.reject(errResponse);
                            }
                    );
            return deferred.promise;
        }
        function getCity(pin) {
            var deferred = $q.defer();
            console.log('request for city');
//            $http.post('/flipmart-webapp-web/pincode', pin)
//                    .then(
//                            function (response) {
//                                console.error('city get',response);
//                                
//                            },
//                            function (errResponse) {
//                                console.error('Error while login User');
//                                deferred.reject(errResponse);
//                            }
//                    );
            return deferred.promise;
        }
        function userDetails(userId) {
            console.log('user details');
            var deferred = $q.defer();
            $http.post('/flipmart-webapp-web/userdetails', 1)
                    .then(
                            function (response) {
                                console.log('logged user details ', response);
                                deferred.reject(response);
                            },
                            function (errResponse) {
                                console.error('Error while login User');
                                deferred.reject(errResponse);
                            }
                    );
            return deferred.promise;
        }

        function validateUser(user) {

            var deferred = $q.defer();
            $http.post('/flipmart-webapp-web/validate', user)
                    .then(function (response) {
                                console.log("Response");
                                console.log(response.data);
                                deferred.reject(response);
                            },
                            sessionService.set('user', user.email),
                            console.log('user logged ', user)                                                        
//                            },
//                            function (errResponse) {
//                                console.error('Error while login User');
//                                deferred.reject(errResponse);
//                            }
                    );
            return deferred.promise;
        }


        function logoutUser() {
            sessionService.destroy('user');
            // $location.path('/path');
        }

        function loggedUser() {
            return sessionService.get('user');
        }

        function islogged() {
            console.log('checking...');
            if (sessionService.get('user'))
                return true;
        }

        function deleteUser(id) {
            var deferred = $q.defer();
            $http.delete('' + id)
                    .then(
                            function (response) {
                                deferred.resolve(response.data);
                            },
                            function (errResponse) {
                                console.error('Error while deleting User');
                                deferred.reject(errResponse);
                            }
                    );
            return deferred.promise;
        }

    }]);
