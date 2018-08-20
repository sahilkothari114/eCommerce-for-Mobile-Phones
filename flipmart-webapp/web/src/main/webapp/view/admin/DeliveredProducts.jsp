<!doctype html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <link rel="apple-touch-icon" sizes="76x76" href="assets/images/admin/apple-icon.png" />
        <link rel="icon" type="image/png" href="assets/images/admin/favicon.png" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>Material Dashboard by Creative Tim</title>
        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />
        <!-- Bootstrap core CSS     -->
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
        <!--  Material Dashboard CSS    -->
        <link href="assets/css/material-dashboard.css?v=1.2.0" rel="stylesheet" />
        <!--  CSS for Demo Purpose, don't include it in your project     -->
        <link href="assets/css/demo.css" rel="stylesheet" />
        <!--     Fonts and icons     -->
        <link href="assets/css/font-awesome.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons' rel='stylesheet' type='text/css'>

        <!--Pagination-->
        <style>

            .pagination {
                list-style: none;
                display: inline-block;
                padding: 0;
                margin-top: 5px;
            }
            .pagination li {
                display: inline;
                text-align: center;
            }
            .pagination li a {
                float: left;
                display: block;
                font-size: 14px;
                text-decoration: none;
                padding: 5px 12px;  
                margin-left: -1px;
                border: 1px solid transparent;
                line-height: 1.5;
            }
            .pagination a.active {
                cursor: default;
            }
            .pagination a:active {
                outline: none;
            }
            .modal-3 li a {
                margin-left: 3px;
                padding: 0;
                width: 30px;
                height: 30px;
                line-height: 30px;
                -moz-border-radius: 100%;
                -webkit-border-radius: 100%;
                border-radius: 100%;
            }
            .modal-3 li a:hover {
                background-color:#8e24aa;
            }
            .modal-3 a.active, .modal-3 a:active {
                background-color:#ab47bc;
            }



        </style>
        <script src="assets/js/jquery.min.js"></script>
        <script>
            $(function () {
                $("#sidebarclass").load("/flipmart-webapp-web/sidebar");
                $("#headerclass").load("/flipmart-webapp-web/adminHeader");

            });
        </script> 


        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/css/jquery.dataTables_themeroller.css" rel="stylesheet">


    </head>

    <body>

        <div class="wrapper">
            <div id="sidebarclass">		</div>
            <div class="main-panel">
                <div id="headerclass">		   </div>
                <div class="content">
                    <div class="container-fluid">
                        <div class="row">                        
                            <div class="col-md-12">
                                <div class="card">
                                    <div class="card-header" data-background-color="purple">
                                        <h4 class="title">Delivered Orders</h4>
                                        <!--<p class="category">Here is a subtitle for this table</p>-->
                                    </div>
                                    <div class="card-content table-responsive">
                                        <table id="dataTable" class="table table-hover">
                                            <thead>                                            
                                            <th>Delivered Order</th>
                                            <th>Date</th>
                                            <th>City</th>                                            
                                            <th>Product</th>
                                            <th>Quantity</th>
                                            </thead>
                                            <tbody>
                                                <tr>                                                
                                                    <td>lololo</td>
                                                    <td>1/04/2018</td>
                                                    <td>Ahmedabad</td>                                                
                                                    <td>Gujarat</td>
                                                    <td>2</td>  
                                                    <td><a href="ViewSingleEventNgo.html"><button type="button" name="btnview" value="View Event" class="btn btn-info" style="border-radius:10px; margin-top: 1px;">View</button></a></td>
                                                </tr>
                                                <tr>                                                
                                                    <td>hahaha</td>
                                                    <td>1/04/2018</td>
                                                    <td>Ahmedabad</td>                                                
                                                    <td>Gujarat</td>
                                                    <td>8</td> 
                                                    <td><a href="ViewSingleEventNgo.html"><button type="button" name="btnview" value="View Event" class="btn btn-info" style="border-radius:10px; margin-top: 1px;">View</button></a></td>												
                                                </tr>
                                                <tr>                                                
                                                    <td>spspsp</td>
                                                    <td>1/04/2019</td>
                                                    <td>Ahmedabad</td>                                                
                                                    <td>Gujarat</td>
                                                    <td>5</td> 
                                                    <td><a href="ViewSingleEventNgo.html"><button type="button" name="btnview" value="View Event" class="btn btn-info" style="border-radius:10px; margin-top: 1px;">View</button></a></td>												
                                                </tr>                                            
                                                <tr>                                                
                                                    <td>abcabc</td>
                                                    <td>1/04/2018</td>
                                                    <td>Ahmedabad</td>                                                
                                                    <td>Gujarat</td>
                                                    <td>2</td>   
                                                    <td><a href="ViewSingleEventNgo.html"><button type="button" name="btnview" value="View Event" class="btn btn-info" style="border-radius:10px; margin-top: 1px;">View</button></a></td>												
                                                </tr>
                                                <tr>                                                
                                                    <td>abcabc</td>
                                                    <td>1/04/2018</td>
                                                    <td>Ahmedabad</td>                                                
                                                    <td>Gujarat</td>
                                                    <td>3</td>    
                                                    <td><a href="ViewSingleEventNgo.html"><button type="button" name="btnview" value="View Event" class="btn btn-info" style="border-radius:10px; margin-top: 1px;">View</button></a></td>												
                                                </tr>                                            
                                            </tbody>
                                        </table>
                                    </div>
                                </div>                            
                            </div>
                        </div>
                    </div>

                </div>

            </div>
        </div>

        <script>

            $(function () {

                $('#dataTable').dataTable({
                    // "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                    //"pageLength": 1
                });

                $('#chk-all').click(function () {
                    if ($(this).is(':checked')) {
                        $('#responsiveTable').find('.chk-row').each(function () {
                            $(this).prop('checked', true);
                            $(this).parent().parent().parent().addClass('selected');
                        });
                    } else {
                        $('#responsiveTable').find('.chk-row').each(function () {
                            $(this).prop('checked', false);
                            $(this).parent().parent().parent().removeClass('selected');
                        });
                    }
                });
            });

        </script>
    </body>
    <!--   Core JS Files   -->
    <script src="assets/js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="assets/js/material.min.js" type="text/javascript"></script>
    <!--  Charts Plugin -->
    <script src="assets/js/chartist.min.js"></script>
    <!--  Dynamic Elements plugin -->
    <script src="assets/js/arrive.min.js"></script>
    <!--  PerfectScrollbar Library -->
    <script src="assets/js/perfect-scrollbar.jquery.min.js"></script>
    <!--  Notifications Plugin    -->
    <script src="assets/js/bootstrap-notify.js"></script>
    <!-- Material Dashboard javascript methods -->
    <script src="assets/js/material-dashboard.js?v=1.2.0"></script>
    <!-- Material Dashboard DEMO methods, don't include it in your project! -->
    <script src="assets/js/demo.js"></script>

    <script src="assets/js/bootstrap.min.js"></script>
    <script src='assets/js/jquery.dataTables.min.js'></script>


</html>