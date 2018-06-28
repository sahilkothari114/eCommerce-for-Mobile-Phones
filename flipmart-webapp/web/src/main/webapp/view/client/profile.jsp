<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from www.themesground.com/flipmart-demo/HTML/shopping-cart.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 22 May 2018 08:29:30 GMT -->
<head>
	<!-- Meta -->
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<meta name="keywords" content="MediaCenter, Template, eCommerce">
	<meta name="robots" content="all">

	<title>Flipmart</title>

	<!-- Bootstrap Core CSS -->
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">

	<!-- Customizable CSS -->
	<link rel="stylesheet" href="assets/css/main.css">
	<link rel="stylesheet" href="assets/css/blue.css">
	<link rel="stylesheet" href="assets/css/owl.carousel.css">
	<link rel="stylesheet" href="assets/css/owl.transitions.css">
	<link rel="stylesheet" href="assets/css/animate.min.css">
	<link rel="stylesheet" href="assets/css/rateit.css">
	<link rel="stylesheet" href="assets/css/bootstrap-select.min.css">
	<link rel="stylesheet" href="assets/css/style.css">



<script
	src="assets/js/angular.min.js"></script>
<script
	src="assets/js/jquery-1.11.1.min.js"></script>
	<!-- Icons/Glyphs -->
	<link rel="stylesheet" href="assets/css/font-awesome.css">

	<!-- Fonts --> 
	<link href='http://fonts.googleapis.com/css?family=Roboto:300,400,500,700' rel='stylesheet' type='text/css'>
	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,600,600italic,700,700italic,800' rel='stylesheet' type='text/css'>
	<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>


</head>
<body class="cnt-home" data-ng-app="myApp" data-ng-controller="profileController">
	<!-- ============================================== HEADER ============================================== -->
	<header class="header-style-1">

		<!-- ============================================== TOP MENU ============================================== -->
		<div class="top-bar animate-dropdown">
			<div class="container">
				<div class="header-top-inner">
					<div class="cnt-account">
						<ul class="list-unstyled">
							<li><a href="#"><i class="icon fa fa-user"></i>My Account</a></li>				
							<li><a href="#"><i class="icon fa fa-shopping-cart"></i>My Cart</a></li>

							<li><a href="#"><i class="icon fa fa-lock"></i>Login / Logout</a></li>
						</ul>
					</div><!-- /.cnt-account -->
					<div class="clearfix"></div>
				</div><!-- /.header-top-inner -->
			</div><!-- /.container -->
		</div><!-- /.header-top -->
		<!-- ============================================== TOP MENU : END ============================================== -->
		<div class="main-header">
			<div class="container">
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-3 logo-holder">
						<!-- ============================================================= LOGO ============================================================= -->
						<div class="logo">
							<a href="home.html">

								<img src="assets/images/logo.png" alt="">

							</a>
						</div><!-- /.logo -->
						<!-- ============================================================= LOGO : END ============================================================= -->				</div><!-- /.logo-holder -->

						<div class="col-xs-12 col-sm-12 col-md-7 top-search-holder">
							<!-- /.contact-row -->
							<!-- ============================================================= SEARCH AREA ============================================================= -->
							<div class="search-area">
								<form>
									<div class="control-group">
										<input class="search-field" placeholder="Search here..."/>
										<a class="search-button" href="#" ></a>    
									</div>
								</form>
							</div><!-- /.search-area -->
							<!-- ============================================================= SEARCH AREA : END ============================================================= -->				</div><!-- /.top-search-holder -->

							<div class="col-xs-12 col-sm-12 col-md-2 animate-dropdown top-cart-row">
								<!-- ============================================================= SHOPPING CART DROPDOWN ============================================================= -->

								<div class="dropdown dropdown-cart">
									<a href="#" class="dropdown-toggle lnk-cart" data-toggle="dropdown">
										<div class="items-cart-inner">
											<div class="basket">
												<i class="glyphicon glyphicon-shopping-cart"></i>
											</div>
											<div class="basket-item-count"><span class="count">2</span></div>
											<div class="total-price-basket">
												<span class="lbl">cart -</span>
												<span class="total-price">
													<span class="sign">$</span><span class="value">600.00</span>
												</span>
											</div>


										</div>
									</a>
									<ul class="dropdown-menu">
										<li>
											<div class="cart-item product-summary">
												<div class="row">
													<div class="col-xs-4">
														<div class="image">
															<a href="detail.html"><img src="assets/images/cart.jpg" alt=""></a>
														</div>
													</div>
													<div class="col-xs-7">

														<h3 class="name"><a href="index8a95.html?page-detail">Simple Product</a></h3>
														<div class="price">$600.00</div>
													</div>
													<div class="col-xs-1 action">
														<a href="#"><i class="fa fa-trash"></i></a>
													</div>
												</div>
											</div><!-- /.cart-item -->
											<div class="clearfix"></div>
											<hr>

											<div class="clearfix cart-total">
												<div class="pull-right">

													<span class="text">Sub Total :</span><span class='price'>$600.00</span>

												</div>
												<div class="clearfix"></div>

												<a href="checkout.html" class="btn btn-upper btn-primary btn-block m-t-20">Checkout</a>	
											</div><!-- /.cart-total-->


										</li>
									</ul><!-- /.dropdown-menu-->
								</div><!-- /.dropdown-cart -->

								<!-- ============================================================= SHOPPING CART DROPDOWN : END============================================================= -->				</div><!-- /.top-cart-row -->
							</div><!-- /.row -->

						</div><!-- /.container -->

					</div><!-- /.main-header -->

				</header>

				<!-- ============================================== HEADER : END ============================================== -->
				<div class="breadcrumb">
					<div class="container">
						<div class="breadcrumb-inner">
							<ul class="list-inline list-unstyled">
								<li><a href="#">Home</a></li>
								<li class='active'>Profile</li>
							</ul>
						</div><!-- /.breadcrumb-inner -->
					</div><!-- /.container -->
				</div><!-- /.breadcrumb -->

				<div class="body-content outer-top-xs">
					<div class="container">
						<div class="row ">
							<div class="shopping-cart">
								<div class="col-md-12 col-sm-12 estimate-ship-tax">
								<form class="profile-form outer-top-xs" role="form" name="ProfileForm">
								
									<table class="table">		
										<tbody>
											<tr>
												<td>
													<div class="form-group">
														<label class="info-title control-label">First Name <span>*</span></label>
														<input type="text" class="form-control unicase-form-control text-input" placeholder="Enter first name "
														name="firstName" data-ng-model="profile.firstName" ng-required="true">
														  <div ng-show="ProfileForm.firstName.$touched && ProfileForm.firstName.$invalid">
															<small>Enter a Valid First Name</small>
														</div>
													</div>
												</td>
												<td>

													<div class="form-group">
														<label class="info-title control-label">Last Name <span>*</span></label>
														<input type="text" class="form-control unicase-form-control text-input" placeholder="Enter Last name "
														name="lastName" data-ng-model="profile.lastName" ng-required="true">
														  <div ng-show="ProfileForm.lastName.$touched && ProfileForm.lastName.$invalid">
															<small>Enter a Valid Last Name</small>
														</div>
													</div>
												</td>
											</tr>
											<tr>
											
												<td>
													<div class="form-group">
													
														<label class="info-title control-label">New Password </label>
														<input type="password" name="NewPassword"
															class="form-control unicase-form-control text-input"
															id="New_Password" data-ng-model="profile.NewPassword" ng-minlength="5" ng-maxlength="15">
															
														<div ng-show="ProfileForm.NewPassword.$touched && ProfileForm.NewPassword.$invalid">
															<small>Enter a Valid type of Password</small>
														</div>
														<small ng-show="ProfileForm.NewPassword.$dirty && ProfileForm.NewPassword.$error.minlength">too short!</small>
														<small ng-show="ProfileForm.NewPassword.$dirty && ProfileForm.NewPassword.$error.maxlength">too long!</small>
													</div>
												</td>
												<td>
													<div class="form-group">
														<label class="info-title control-label">confirm password </label>
														<input type="password" name="NewConfirmPassword"
															class="form-control unicase-form-control text-input"
																id="New_Confirm_Password" data-ng-model="profile.NewConfirmPassword" ng-init="cpassword_error_show = 0" ng-focus="cpassword_error_show = 1"
																ng-change="cpassword_error_show = cpassword_error_show + 1" ng-disabled="ProfileForm.NewPassword.$pristine||(profile.NewPassword.length==0)">
																
														<small ng-show="profile.NewPassword.length > 0 &&profile.NewPassword !== profile.NewConfirmPassword">Password Mismatch</small>
														<small style="color:green;" ng-show="profile.NewPassword.length > 0 && profile.NewPassword === profile.NewConfirmPassword">Password match</small>
													</div>
												</td>
											</tr>
											<tr>
												<td>
													<div class="form-group">
														<label class="info-title control-label">Contact No <span>*</span> </label>
														<input type="text" name="Contact" pattern="[0-9]{10}" class="form-control unicase-form-control text-input" placeholder="9999999999" data-ng-model="profile.NewContact" ng-required="true" ng-minlength="10" ng-maxlength="10">
														<div ng-show="ProfileForm.Contact.$touched && ProfileForm.Contact.$invalid">
															<small>Enter a Valid Contact Number</small>
														</div>
													</div>
												</td>
												<td>
													<div class="form-group">
														<label class="info-title control-label">Email <span>*</span> </label>
														
														
														<input type="email" name="NewEmail"
															class="form-control unicase-form-control text-input"
															id="New_email" data-ng-model="profile.NewEmail" placeholder="abc@gmail.com" ng-pattern="/^[_a-z0-9]+(\.[_a-z0-9]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,4})$/" ng-required="true">
														<div ng-show="ProfileForm.NewEmail.$touched && ProfileForm.NewEmail.$invalid">
															<small>Enter a Valid Email</small>
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<td>
													<div class="form-group">
														<label class="info-title control-label">Postal Code<span>*</span></label>
														
													<input type="text" pattern="[0-9]{6}" name="NewPincode" class="form-control unicase-form-control text-input"
													id="New_pincode" data-ng-model="profile.pincode" placeholder="123456" ng-required="true" ng-minlength="6" ng-maxlength="6">
													<div ng-show="ProfileForm.NewPincode.$touched && ProfileForm.NewPincode.$invalid">
														<small>Enter a Valid Pincode Number</small>
													</div>
													
													</div>
												</td>
												<td>
													<div class="form-group">
														<label class="info-title control-label">City <span>*</span></label>
														<select class="form-control unicase-form-control selectpicker">
															<option>--Select options--</option>
															<option>Mumbai</option>
															<option>Ahmedabad</option>
															<option>Surat </option>
															<option>Kolkata </option>
															<option>Delhi
															</option>
														</select>
													</div>
												</td>
											</tr>
											<tr>
												<td>
													<div class="form-group">
														<label class="info-title control-label">State/Province <span>*</span></label>
														<select class="form-control unicase-form-control selectpicker">
															<option>--Select options--</option>
															<option>TamilNadu</option>
															<option>Kerala</option>
															<option>Andhra Pradesh</option>
															<option>Karnataka</option>
															<option>Madhya Pradesh</option>
														</select>
													</div>
													</td>
													<td>
													<div class="form-group">
														<label class="info-title control-label">Address <span>*</span> </label>
														<textarea type="text" name="NewAddress" data-ng-model="profile.NewAddress" ng-required="true" class="form-control unicase-form-control text-input" placeholder=""></textarea>
									<div ng-show="ProfileForm.NewAddress.$touched && ProfileForm.NewAddress.$invalid">
										<small>Address Can not Be Blank</small>
									</div>
													</div>


												</td>
											</tr>
										</tbody>
									</table>
									</form>
								</div><!-- /.estimate-ship-tax -->

								<div class="col-sm-12 cart-shopping-total">
									<table class="table">
										<tbody>
											<tr>
												<td>
													<div class="cart-checkout-btn col-sm-7">
														<button type="submit" class="btn btn-primary checkout-btn" ng-disabled="ProfileForm.$invalid">UPDATE</button>

													</div>
												</td>
											</tr>
										</tbody><!-- /tbody -->
									</table><!-- /table -->
								</div><!-- /.cart-shopping-total -->			</div><!-- /.shopping-cart -->
							</div> <!-- /.row -->
							<!-- ============================================== BRANDS CAROUSEL ============================================== -->
							<div id="brands-carousel" class="logo-slider wow fadeInUp">

								<div class="logo-slider-inner">	
									<div id="brand-slider" class="owl-carousel brand-slider custom-carousel owl-theme">
										<div class="item m-t-15">
											<a href="#" class="image">
												<img data-echo="assets/images/brands/brand1.png" src="assets/images/blank.gif" alt="">
											</a>	
										</div><!--/.item-->

										<div class="item m-t-10">
											<a href="#" class="image">
												<img data-echo="assets/images/brands/brand2.png" src="assets/images/blank.gif" alt="">
											</a>	
										</div><!--/.item-->

										<div class="item">
											<a href="#" class="image">
												<img data-echo="assets/images/brands/brand3.png" src="assets/images/blank.gif" alt="">
											</a>	
										</div><!--/.item-->

										<div class="item">
											<a href="#" class="image">
												<img data-echo="assets/images/brands/brand4.png" src="assets/images/blank.gif" alt="">
											</a>	
										</div><!--/.item-->

										<div class="item">
											<a href="#" class="image">
												<img data-echo="assets/images/brands/brand5.png" src="assets/images/blank.gif" alt="">
											</a>	
										</div><!--/.item-->

										<div class="item">
											<a href="#" class="image">
												<img data-echo="assets/images/brands/brand6.png" src="assets/images/blank.gif" alt="">
											</a>	
										</div><!--/.item-->

										<div class="item">
											<a href="#" class="image">
												<img data-echo="assets/images/brands/brand2.png" src="assets/images/blank.gif" alt="">
											</a>	
										</div><!--/.item-->

										<div class="item">
											<a href="#" class="image">
												<img data-echo="assets/images/brands/brand4.png" src="assets/images/blank.gif" alt="">
											</a>	
										</div><!--/.item-->

										<div class="item">
											<a href="#" class="image">
												<img data-echo="assets/images/brands/brand1.png" src="assets/images/blank.gif" alt="">
											</a>	
										</div><!--/.item-->

										<div class="item">
											<a href="#" class="image">
												<img data-echo="assets/images/brands/brand5.png" src="assets/images/blank.gif" alt="">
											</a>	
										</div><!--/.item-->
									</div><!-- /.owl-carousel #logo-slider -->
								</div><!-- /.logo-slider-inner -->

							</div><!-- /.logo-slider -->
							<!-- ============================================== BRANDS CAROUSEL : END ============================================== -->	</div><!-- /.container -->
						</div><!-- /.body-content -->

						<!-- ============================================================= FOOTER ============================================================= -->
						<footer id="footer" class="footer color-bg">


							<div class="footer-bottom">
								<div class="container">
									<div class="row">
										<div class="col-xs-12 col-sm-6 col-md-3">
											<div class="module-heading">
												<h4 class="module-title">Contact Us</h4>
											</div><!-- /.module-heading -->

											<div class="module-body">
												<ul class="toggle-footer">
													<li class="media">
														<div class="pull-left">
															<span class="icon fa-stack fa-lg">
																<i class="fa fa-map-marker fa-stack-1x fa-inverse"></i>
															</span>
														</div>
														<div class="media-body">
															<p>ThemesGround, 789 Main rd, Anytown, CA 12345 USA</p>
														</div>
													</li>

													<li class="media">
														<div class="pull-left">
															<span class="icon fa-stack fa-lg">
																<i class="fa fa-mobile fa-stack-1x fa-inverse"></i>
															</span>
														</div>
														<div class="media-body">
															<p>+(888) 123-4567<br>+(888) 456-7890</p>
														</div>
													</li>

													<li class="media">
														<div class="pull-left">
															<span class="icon fa-stack fa-lg">
																<i class="fa fa-envelope fa-stack-1x fa-inverse"></i>
															</span>
														</div>
														<div class="media-body">
															<span><a href="#">flipmart@themesground.com</a></span>
														</div>
													</li>

												</ul>
											</div><!-- /.module-body -->
										</div><!-- /.col -->

										<div class="col-xs-12 col-sm-6 col-md-3">
											<div class="module-heading">
												<h4 class="module-title">Customer Service</h4>
											</div><!-- /.module-heading -->

											<div class="module-body">
												<ul class='list-unstyled'>
													<li class="first"><a href="#" title="Contact us">My Account</a></li>
													<li><a href="#" title="About us">Order History</a></li>
													<li><a href="#" title="faq">FAQ</a></li>
													<li><a href="#" title="Popular Searches">Specials</a></li>
													<li class="last"><a href="#" title="Where is my order?">Help Center</a></li>
												</ul>
											</div><!-- /.module-body -->
										</div><!-- /.col -->

										<div class="col-xs-12 col-sm-6 col-md-3">
											<div class="module-heading">
												<h4 class="module-title">Corporation</h4>
											</div><!-- /.module-heading -->

											<div class="module-body">
												<ul class='list-unstyled'>
													<li class="first"><a title="Your Account" href="#">About us</a></li>
													<li><a title="Information" href="#">Customer Service</a></li>
													<li><a title="Addresses" href="#">Company</a></li>
													<li><a title="Addresses" href="#">Investor Relations</a></li>
													<li class="last"><a title="Orders History" href="#">Advanced Search</a></li>
												</ul>
											</div><!-- /.module-body -->
										</div><!-- /.col -->

										<div class="col-xs-12 col-sm-6 col-md-3">
											<div class="module-heading">
												<h4 class="module-title">Why Choose Us</h4>
											</div><!-- /.module-heading -->

											<div class="module-body">
												<ul class='list-unstyled'>
													<li class="first"><a href="#" title="About us">Shopping Guide</a></li>
													<li><a href="#" title="Blog">Blog</a></li>
													<li><a href="#" title="Company">Company</a></li>
													<li><a href="#" title="Investor Relations">Investor Relations</a></li>
													<li class=" last"><a href="contact-us.html" title="Suppliers">Contact Us</a></li>
												</ul>
											</div><!-- /.module-body -->
										</div>
									</div>
								</div>
							</div>

							<div class="copyright-bar">
								<div class="container">
									<div class="col-xs-12 col-sm-6 no-padding social">
										<ul class="link">
											<li class="fb pull-left"><a target="_blank" rel="nofollow" href="#" title="Facebook"></a></li>
											<li class="tw pull-left"><a target="_blank" rel="nofollow" href="#" title="Twitter"></a></li>
											<li class="googleplus pull-left"><a target="_blank" rel="nofollow" href="#" title="GooglePlus"></a></li>
											<li class="rss pull-left"><a target="_blank" rel="nofollow" href="#" title="RSS"></a></li>
											<li class="pintrest pull-left"><a target="_blank" rel="nofollow" href="#" title="PInterest"></a></li>
											<li class="linkedin pull-left"><a target="_blank" rel="nofollow" href="#" title="Linkedin"></a></li>
											<li class="youtube pull-left"><a target="_blank" rel="nofollow" href="#" title="Youtube"></a></li>
										</ul>
									</div>
									<div class="col-xs-12 col-sm-6 no-padding">
										<div class="clearfix payment-methods">
											<ul>
												<li><img src="assets/images/payments/1.png" alt=""></li>
												<li><img src="assets/images/payments/2.png" alt=""></li>
												<li><img src="assets/images/payments/3.png" alt=""></li>
												<li><img src="assets/images/payments/4.png" alt=""></li>
												<li><img src="assets/images/payments/5.png" alt=""></li>
											</ul>
										</div><!-- /.payment-methods -->
									</div>
								</div>
							</div>
						</footer>
						<!-- ============================================================= FOOTER : END============================================================= -->


						<!-- For demo purposes – can be removed on production -->


						<!-- For demo purposes – can be removed on production : End -->

						<!-- JavaScripts placed at the end of the document so the pages load faster -->
						<script src="assets/js/jquery-1.11.1.min.js"></script>

						<script src="assets/js/bootstrap.min.js"></script>

						<script src="assets/js/bootstrap-hover-dropdown.min.js"></script>
						<script src="assets/js/owl.carousel.min.js"></script>

						<script src="assets/js/echo.min.js"></script>
						<script src="assets/js/jquery.easing-1.3.min.js"></script>
						<script src="assets/js/bootstrap-slider.min.js"></script>
						<script src="assets/js/jquery.rateit.min.js"></script>
						<script type="text/javascript" src="assets/js/lightbox.min.js"></script>
						<script src="assets/js/bootstrap-select.min.js"></script>
						<script src="assets/js/wow.min.js"></script>
						<script src="assets/js/scripts.js"></script>



						<script>
						var app = angular.module('myApp',[]);
						
						app.controller('profileController',function($scope,$http){
							
						});
						</script>

					</body>

					<!-- Mirrored from www.themesground.com/flipmart-demo/HTML/shopping-cart.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 22 May 2018 08:29:30 GMT -->
					</html>
