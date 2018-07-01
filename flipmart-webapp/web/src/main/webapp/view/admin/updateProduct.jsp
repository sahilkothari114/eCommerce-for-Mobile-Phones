<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png" />
  <link rel="icon" type="image/png" href="../assets/img/favicon.png" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>Update Product</title>
  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
  <meta name="viewport" content="width=device-width" />
  <!-- Bootstrap core CSS     -->
  <link href="../assets/css/bootstrap.min.css" rel="stylesheet" />
  <!--  Material Dashboard CSS    -->
  <link href="../assets/css/material-dashboard.css?v=1.2.0" rel="stylesheet" />
  <!--  CSS for Demo Purpose, don't include it in your project     -->
  <link href="../assets/css/demo.css" rel="stylesheet" />
  <!--     Fonts and icons     -->
  <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
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
  <script src="../assets/js/jquery.min.js"> </script>
  <script>
  $(function(){
    $("#sidebarclass").load("sidebar.html");
    $("#headerclass").load("header.html");
    $("#footerclass").load("footer.html");

  });
</script>


<link href="../pagination/demo/Content/bootstrap.min.css" rel="stylesheet">
<link href="../pagination/demo/css/jquery.dataTables_themeroller.css" rel="stylesheet">


</head>

<body>

  <div class="wrapper">
    <div id="sidebarclass">

    </div>
    <div class="main-panel">
      <div id="headerclass">

      </div>
      <div class="content" style="margin-top:5px;">
        <div class="container-fluid">
          <div class="row">
            <div class="col-md-12">
              <div class="card">
                <div class="card-header" data-background-color="purple">
                  <h2 class="title"><center>Update Product</center></h2>
                  <!--<p class="category">Here is a subtitle for this table</p>-->
                </div><br>
                <div class="card-content">
                  <form action="#" method="POST">
                    <div class="row">
                      <div class="col-md-12">
                        <div class="form-group label-floating">
                          <label class="control-label">Manufaturer Name</label>
                          <input type="text" disabled name="txtProductName" onblur="return allLetter(txtProductName);" class="form-control" value="Nokia" required/>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group label-floating">
                          <label class="control-label">Product Model Number</label>
                          <input type="text" name="txtModelNumber" onblur="return allLetter(txtModelNumber);" class="form-control" value="1100" required/>
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="form-group label-floating">
                          <label class="control-label">Product Name</label>
                          <input type="text" name="txtProductName" onblur="return allLetter(txtProductName);" class="form-control" value="Nokia 1100" required/>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group label-floating">
                          <label class="control-label">Operating System</label>
                          <input type="text" name="txtOperatingSystem" onblur="return allLetter(txtOperatingSystem);" class="form-control" value="Android 8.0" required/>
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="form-group label-floating">
                          <label class="control-label">RAM</label>
                          <input type="text" name="txtRAM" onblur="return allLetter(txtRAM);" class="form-control" value="2 GB" required/>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group label-floating">
                          <label class="control-label">Camera</label>
                          <input type="text" name="txtCamera" onblur="return allLetter(txtCamera);" class="form-control" value="13 MP" required/>
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="form-group label-floating">
                          <label class="control-label">Processor</label>
                          <input type="text" name="txtProcessor" onblur="return allLetter(txtProcessor);" class="form-control" value="Snapdragon 630" required/>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-12">
                        <div class="form-group label-floating">
                          <label class="control-label">Picture URL</label>
                          <input type="text" name="txtPicture" onblur="return allLetter(txtPicture);" class="form-control" value="imgur.com" required/>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-12">
                        <div class="form-group label-floating">
                          <label class="control-label">Additional Features</label>
                          <input type="textarea" name="txtAdditionalFeatures" onblur="return allLetter(txtAdditionalFeatures);" class="form-control" value="NA" required/>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-12">
                        <div class="form-group label-floating">
                          <label class="control-label">Price</label>
                          <input type="text" name="txtPrice" onblur="return allLetter(txtPrice);" class="form-control" value="5000.00" required/>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-12">
                        <div class="form-group label-floating">
                          <label class="control-label">Color Quantity</label>
                          <input type="text" name="txtColorQuantity" onblur="return allLetter(txtColorQuantity);" class="form-control" required/>
                        </div>
                      </div>
                    </div>
                    <div class="container">
                      <div class="row">
                        <div class="col-md-4">
                          <div class="form-group label-floating">
                            <label class="control-label">Color</label>
                            <select class="form-control" name="drpColor" style="float:left;" required>
                              <option value="101">Black</option>
                              <option value="102">White</option>
                              <option value="103">Silver</option>
                            </select>
                          </div>
                        </div>
                        <div class="col-md-4">
                          <div class="form-group label-floating">
                            <label class="control-label">Quantity</label>
                            <input type="text" name="txtQuantity" onblur="return allLetter(txtQuantity);" class="form-control" required/>
                          </div>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col-md-4">
                          <div class="form-group label-floating">
                            <label class="control-label">Color</label>
                            <select class="form-control" name="drpColor" style="float:left;" required>
                              <option value="101">Black</option>
                              <option value="102">White</option>
                              <option value="103">Silver</option>
                            </select>
                          </div>
                        </div>
                        <div class="col-md-4">
                          <div class="form-group label-floating">
                            <label class="control-label">Quantity</label>
                            <input type="text" name="txtQuantity" onblur="return allLetter(txtQuantity);" class="form-control" required/>
                          </div>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col-md-4">
                          <div class="form-group label-floating">
                            <label class="control-label">Color</label>
                            <select class="form-control" name="drpColor" style="float:left;" required>
                              <option value="101">Black</option>
                              <option value="102">White</option>
                              <option value="103">Silver</option>
                            </select>
                          </div>
                        </div>
                        <div class="col-md-4">
                          <div class="form-group label-floating">
                            <label class="control-label">Quantity</label>
                            <input type="text" name="txtQuantity" onblur="return allLetter(txtQuantity);" class="form-control" required/>
                          </div>
                        </div>
                      </div>
                    </div>
                    <center>
                      <input type="submit" value="Update" class="btn btn-primary pull-right"></center>
                      <div class="clearfix"></div>
                    </form>
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
        }
        else {
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
  <script src="../assets/js/jquery-3.2.1.min.js" type="text/javascript"></script>
  <script src="../assets/js/bootstrap.min.js" type="text/javascript"></script>
  <script src="../assets/js/material.min.js" type="text/javascript"></script>
  <!--  Charts Plugin -->
  <script src="../assets/js/chartist.min.js"></script>
  <!--  Dynamic Elements plugin -->
  <script src="../assets/js/arrive.min.js"></script>
  <!--  PerfectScrollbar Library -->
  <script src="../assets/js/perfect-scrollbar.jquery.min.js"></script>
  <!--  Notifications Plugin    -->
  <script src="../assets/js/bootstrap-notify.js"></script>
  <!--  Google Maps Plugin    -->
  <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
  <!-- Material Dashboard javascript methods -->
  <script src="../assets/js/material-dashboard.js?v=1.2.0"></script>
  <!-- Material Dashboard DEMO methods, don't include it in your project! -->
  <script src="../assets/js/demo.js"></script>

  <script src="../pagination/demo/Scripts/bootstrap.min.js"></script>
  <script src='../pagination/demo/js/jquery.dataTables.min.js'></script>


  </html>
