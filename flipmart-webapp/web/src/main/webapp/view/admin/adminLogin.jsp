<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html lang="en" ng-app="adminLoginApp" ng-controller="adminCtrl">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <link rel="apple-touch-icon" sizes="76x76" href="assets/images/admin/apple-icon.png">
        <link rel="icon" type="image/png" href="assets/images/admin/favicon.png">

        <title>Login - Flipmart Admin</title>

        <!--     Fonts and icons     -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
        <!-- CSS Files -->
        <link rel="stylesheet" href="assets/css/font-awesome.css" />
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
        <link href="assets/css/material-kit.css" rel="stylesheet"/>

    </head>

    <body class="signup-page">

        <div id="headerclass"></div>

        <div class="main main-raised">
            <div class="section section-full-screen section-signup" style="background-image: url('assets/images/admin/phones.png'); background-size: cover; background-position: top center; min-height: 700px;">
               
                <div class="container" style="margin-top:50px;">
                    <div class="row">
                        <div class="col-md-4 col-md-offset-4">
                            <div class="card card-signup">
                                <form class="form">
                                    <div class="header header-primary text-center">
                                        <h4>Login</h4>
                                    </div>
                                    <div class="content">
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">email</i>
                                            </span>
                                            <input type="email" ng-model="email" class="form-control" placeholder="Email Id" name="txtemail" required ng-model-instant/>
                                            <!--{{emailID}}-->
                                        </div>

                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">password</i>
                                            </span>
                                            <input type="password" ng-model="password" placeholder="Password" class="form-control" name="txtpassword" required/>
                                            <!--{{password}}-->
                                        </div>
                                    </div>


                                    <div class="footer text-center">
                                        <input type="submit" class="btn btn-primary" name="btnlogin" value="Login" ng-click="Login()">
                                    </div>

                                </form>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>


    </body>

    <!--   Core JS Files   -->
    <script src="assets/js/jquery.min.js" type="text/javascript"></script>
    <script src="assets/js/bootstrap.min.js"></script>

    <script src="assets/js/angular.min.js"></script>
    <script src="assets/controllers/adminLogin.controller.js"></script>

    <script>
                                            $(function(){
                                            $("#headerclass").load("/flipmart-webapp-web/view/admin/header.jsp");
                                            $("#footerclass").load("footer.html");
                                            });
                                            
    </script>
    
    <script src="assets/js/material.min.js"></script>
    <!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
    <script src="assets/js/nouislider.min.js" type="text/javascript"></script>
    <!--  Plugin for the Datepicker, full documentation here: http://www.eyecon.ro/bootstrap-datepicker/ -->
    <script src="assets/js/bootstrap-datepicker.js" type="text/javascript"></script>
    <!-- Control Center for Material Kit: activating the ripples, parallax effects, scripts from the example pages etc -->
    <script src="assets/js/material-kit.js" type="text/javascript"></script>
    <script src="assets/js/angular-route.min.js" type="text/javascript"></script>

</html>