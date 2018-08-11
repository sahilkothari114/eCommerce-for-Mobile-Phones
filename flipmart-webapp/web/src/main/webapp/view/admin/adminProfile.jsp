<!doctype html>
<html lang="en" ng-app="adminProfileApp">

<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="../../assets/images/admin/apple-icon.png" />
    <link rel="icon" type="image/png" href="../../assets/images/admin/favicon.png" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>Admin Profile</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />
    <!-- Bootstrap core CSS     -->
    <link href="../../assets/css/bootstrap.min.css" rel="stylesheet" />
    <!--  Material Dashboard CSS    -->
    <link href="../../assets/css/material-dashboard.css?v=1.2.0" rel="stylesheet" />
    <!--  CSS for Demo Purpose, don't include it in your project     
    <link href="../assets/css/demo.css" rel="stylesheet" /> -->
    <!--     Fonts and icons     -->
    <link href="../../assets/css/font-awesome.css" rel="stylesheet">
    <link href="../../assets/css/date-picker.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons' rel='stylesheet' type='text/css'>



<script type="text/javascript">
function allLetter(txteventname)
{
	var letters=/^[A-Za-z]+$/;
	if(txteventname.value.match(letters))
	{
		return true;
	}
	else
	{		
		txteventname.value="";
		txteventname.focus();
		alert('Event Name must have Alphabetic characters only');
		return false;
	}
}
</script>

<script type="text/javascript">
	$(document).ready(function(){
	$("#test20").keyup(function() {
	    var val = $("#test20").val();
	    if (parseInt(val) < 0 || isNaN(val)) {
	        alert("Please Enter Only Numeric Values in Days");
	        $("#test20").val("");
	        $("#test20").focus();
	    }
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function(){
	$("#test21").keyup(function() {
	    var val = $("#test21").val();
	    if (parseInt(val) < 0 || isNaN(val)) {
	        alert("Please Enter Only Numeric Values in Volunteer Size");
	        $("#test21").val("");
	        $("#test21").focus();
	    }
		});
	});
</script>


</head>

<body>
    <div class="wrapper">
        <div id="sidebarclass">
		
		</div>
        <div class="main-panel">
            <div id="headerclass">
			
			</div>
           <div class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-8">
                            <div class="card">
                                <div class="card-header" data-background-color="purple">
                                    <h4 class="title">Edit Profile</h4>
                                    <p class="category">Complete your profile</p>
                                </div>
                                <div class="card-content">
                                    <form>
                                        <div class="row">
                                            
                                            <div class="col-md-4">
                                                <div class="form-group label-floating">
                                                    <label class="control-label">Email address</label>
                                                    <input type="email" class="form-control" value="mipalak96@gmail.com">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group label-floating">
                                                    <label class="control-label">First Name</label>
                                                    <input type="text" class="form-control" value="Palak">
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group label-floating">
                                                    <label class="control-label">Last Name</label>
                                                    <input type="text" class="form-control" value="Mittal">
                                                </div>
                                            </div>
                                        </div>
										
										 <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group label-floating">
                                                    <label class="control-label">Pincode</label>
                                                    <input type="text" class="form-control" value="395007">
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group label-floating">
                                                    <label class="control-label">Street Address</label>
                                                    <input type="text" class="form-control" value="Vesu">
                                                </div>
                                            </div>
                                        </div>
                                       
										
										<div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group label-floating">
                                                    <label class="control-label">Contact No.</label>
                                                    <input type="text" class="form-control" value="+91 9876556789">
                                                </div>
                                            </div>
                                        </div>
                                       
                                        
                                        <button type="submit" class="btn btn-primary pull-right">Update Profile</button>
                                        <div class="clearfix"></div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card card-profile">
                                <div class="card-avatar">
                                    <a href="#pablo">
                                        <img class="img" src="../../assets/images/admin/userProfilePic.png" />
                                    </a>
                                </div>
                                <div class="content">
                                    <h6 class="category text-gray">Manufacturer</h6>
                                    <h4 class="card-title">Palak Mittal</h4>
                                  
									    <p class="card-content">
                                       Vesu, 395007</p>
									    <p class="card-content">+91 9876556789
                                       </p>
									     <p class="card-content">
                                      mipalak96@gmail.com</p>
									    
									   
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
                
                   
            <div id="footerclass">
			
			</div>
        </div>
    </div>
</body>

<script src="../../assets/js/jquery.min.js" type="text/javascript"> </script>
<!--   Core JS Files   -->
<script src="../../assets/js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="../../assets/js/bootstrap.min.js" type="text/javascript"></script>
<script src="../../assets/js/material.min.js" type="text/javascript"></script>
<script src="../../assets/js/angular.min.js"></script>
<script src="../../assets/controllers/adminProfile.controller.js" type="text/javascript"></script>
<script>
    $(function(){
        $("#sidebarclass").load("sidebar.jsp");
        $("#headerclass").load("header.jsp");
        $("#footerclass").load("footer.jsp");

    });
</script>


<!--  Charts Plugin -->
<script src="../../assets/js/chartist.min.js"></script>
<!--  Dynamic Elements plugin -->
<script src="../../assets/js/arrive.min.js"></script>
<!--  PerfectScrollbar Library -->
<script src="../../assets/js/perfect-scrollbar.jquery.min.js"></script>
<!--  Notifications Plugin    -->
<script src="../../assets/js/bootstrap-notify.js"></script>
<!-- Material Dashboard javascript methods -->
<script src="../../assets/js/material-dashboard.js?v=1.2.0"></script>

</html>