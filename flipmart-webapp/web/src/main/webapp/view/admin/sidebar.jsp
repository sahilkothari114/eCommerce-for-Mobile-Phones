<div class="sidebar" data-color="purple" data-image="../../assets/images/admin/sidebar-1.jpg">
            <!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | blue | green | orange | red"

        Tip 2: you can also add an image using data-image tag
    -->
            <div class="logo">
                <a href="#" class="simple-text">
                    Admin Name
                </a>
            </div>
            <div class="sidebar-wrapper">
                <ul class="nav">
                    <li>
                        <a href="dashboard.jsp">
                            <i class="material-icons">dashboard</i>
                            <p>Dashboard</p>
                        </a>
                    </li>
                    
					<li>
                        <a href="user.jsp">
                            <i class="material-icons">person</i>
                            <p>Admin Profile</p>
                        </a>
                    </li>
					
					<li>
                        <a href="addManufacturer.jsp">
                            <i class="material-icons">person</i>
                            <p>Add Manufacture</p>
                        </a>
                    </li>
                    
					<li>
                        <a href="addCity.jsp">
                            <i class="material-icons">person</i>
                            <p>Add City</p>
                        </a>
                    </li>
					
                   
                    <li class="dropdown">								
						<i style="margin-left:30px;" class="material-icons">content_paste</i>
	                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Manage Orders
						<b class="caret"></b>
						</a>
											
	                    <ul class="dropdown-menu dropdown-menu-right">
	                        <li><a href="PendingOrders.jsp">Pending Orders</a></li>
							<li><a href="DispatchOrders.jsp">Dispatch Orders</a></li>
							<li><a href="DeliveredProducts.jsp">Delivered Orders</a></li>
		                </ul>
	                </li>
					<li class="dropdown">								
						<i style="margin-left:30px;" class="material-icons">content_paste</i>
	                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Manage Products
						<b class="caret"></b>
						</a>
											
	                    <ul class="dropdown-menu dropdown-menu-right">
                            <li><a href="productsOverview.jsp">Products Overview</a></li>
	                        <li><a href="addProduct.jsp">Add Product</a></li>
		                </ul>
	                </li>
					
					
                    
                </ul>
            </div>
        </div>
