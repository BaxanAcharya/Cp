<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/resources/admin_resources/main/assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="${pageContext.request.contextPath}/resources/admin_resources/main/assets/img/favicon.png">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Update Profile ${getUser.username }</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

<link  rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style2.css">

    <!-- Bootstrap core CSS     -->
    <link href="${pageContext.request.contextPath}/resources/admin_resources/main/assets/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="assets/css/animate.min.css" rel="stylesheet"/>

    <!--  Paper Dashboard core CSS    -->
    <link href="${pageContext.request.contextPath}/resources/admin_resources/main/assets/css/paper-dashboard.css" rel="stylesheet"/>

    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="${pageContext.request.contextPath}/resources/admin_resources/main/assets/css/demo.css" rel="stylesheet" />

    <!--  Fonts and icons     -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="${pageContext.request.contextPath}/resources/admin_resources/main/assets/css/themify-icons.css" rel="stylesheet">

</head>
<body>

<div class="wrapper">
	<div class="sidebar" data-background-color="white" data-active-color="danger">

    <!--
		Tip 1: you can change the color of the sidebar's background using: data-background-color="white | black"
		Tip 2: you can change the color of the active button using the data-active-color="primary | info | success | warning | danger"
	-->

    	<div class="sidebar-wrapper">
            <div class="logo">
                <a class="simpletext" href="adminDashborad" ><img src="${pageContext.request.contextPath}/resources/images/coat-of-arms-1438001_1920.jpg" alt="" class="img img-responsive" style=" height:50px; width:100px; "></a>
            </div>

<label class="welcome"> <b> Welcome : ${getUser.username }</b></label>

           <ul class="nav">
                <li>
                    <a href="adminDashborad">
                        <i class="ti-panel"></i>
                        <p>Dashboard</p>
                    </a>
                </li>
                <li class="active">
                    <a href="userProfile">
                        <i class="ti-user"></i>
                        <p>User Profile</p>
                    </a>
                </li>
                <li >
                    <a href="allinstitute">
                        <i class="ti-view-list-alt"></i>
                        <p>Institute Table List</p>
                    </a>
                </li>
                <li>
                    <a href="user">
                        <i class="ti-view-list-alt"></i>
                        <p>User Table List</p>
                    </a>
                </li>
                <li>
                    <a href="addinstitute">
                        <i class="ti-pencil-alt2"></i>
                        <p>Institute</p>
                    </a>
                </li>
                <li>
                    <a href="mapsas">
                        <i class="ti-map"></i>
                        <p>Maps</p>
                    </a>
                </li>
                                <li>
                    <a href="adduser">
                        <i class="ti-pencil-alt2"></i>
                        <p>Add User</p>
                    </a>
                </li>
                                  <li  >
                    <a href="forum">
                        <i class=""></i>
                        <p>Forum</p>
                    </a>
                </li>
				<li >
                    <a href="${pageContext.request.contextPath}/logout">
                        <i class="ti-export"></i>
                        <p>Logout</p>
                    </a>
                </li>
            </ul>
    	</div>
    </div>

    <div class="main-panel">
		<nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar bar1"></span>
                        <span class="icon-bar bar2"></span>
                        <span class="icon-bar bar3"></span>
                    </button>
                    <a class="navbar-brand" href="#">User Profile</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
<li>
                            <a href="course" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="ti-panel"></i>
								<p>Add Course</p>
                            </a>
                        </li>
                        <li class="dropdown">
                              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="ti-bell"></i>
                                    <p class="notification">5</p>
									<p>Notifications</p>
									<b class="caret"></b>
                              </a>
                              <ul class="dropdown-menu">
                                <li><a href="#">Notification 1</a></li>
                                <li><a href="#">Notification 2</a></li>
                                <li><a href="#">Notification 3</a></li>
                                <li><a href="#">Notification 4</a></li>
                                <li><a href="#">Another notification</a></li>
                              </ul>
                        </li>
						 <li >
                    <a href="allcourse">
                        <i class="ti-view-list-alt"></i>
                        <p>Courses Table List</p>
                    </a>
                </li>
                    </ul>

                </div>
            </div>
        </nav>


        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-4 col-md-5">
                        <div class="card card-user">
                            <div class="image">
                                <img src="${pageContext.request.contextPath}/resources/images/${getUser.image  }" alt="..."/>
                            </div>
                            <div class="content">
                                <div class="author">
                                  <img class="avatar border-white" src="${pageContext.request.contextPath}/resources/images/${getUser.image  }" alt="..."/>
                                  <h4 class="title">${getUser.firstname }  ${getUser.lastname }<br />
                                     <a href="#"><small>@${getUser.username }</small></a>
                                  </h4>
                                </div>
                                
                                
                                <form method="post" action="editUserImg" enctype="multipart/form-data">
                                    <div class="row">
                                        <div class="col-md-5">
                                            <div class="form-group">
                                               
                                                <input type="hidden" class="form-control border-input"   value="${getUser.firstname }" name="firstname">
                                            </div>
                                        </div>
                                        <div class="col-md-5">
                                            <div class="form-group">
                                                
                                                <input type="hidden" class="form-control border-input"  value="${getUser.lastname }" name="lastname">
                                            </div>
                                        </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                
                                                <input type="hidden" class="form-control border-input" value="${getUser.count }" name="count">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        
                                        </div>
                                        <div class="col-md-12">
                                            <div class="form-group">
                                               
                                                <input type="hidden" class="form-control border-input"  value="${getUser.username }" name="username">
													   
                                        </div>
                                    </div>


                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                               
                                                <input type="hidden" class="form-control border-input"  name="password" value="${getUser.password }">
                                            </div>
                                        </div>
                                        <input type="hidden" value="${getUser.id }" name="id"/>
                                         <input type="hidden" value="${getUser.usertype }" name="usertype"/>
							
                                    </div>
<b>Update Image Here:</b>
<label class="btn btn-primary btn-file" >
    Browse Image<input type="file" style="display: none;" name="file[]">
</label><br>
                                    <div class="text-center">
                                        <button type="submit" class="btn btn-info btn-fill btn-wd">Update Profile</button>
                                    </div>
                                    <div class="clearfix"></div>
                                </form>
                               
                                
                            </div>
                            <hr>
                            <div class="text-center">
                                <div class="row">
                                    <div class="col-md-3 col-md-offset-1">
                                        <h5>12<br /><small>Files</small></h5>
                                    </div>
                                    <div class="col-md-4">
                                        <h5>2GB<br /><small>Used</small></h5>
                                    </div>
                                    <div class="col-md-3">
                                        <h5>24,6$<br /><small>Spent</small></h5>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Team Members</h4>
                            </div>
                            <div class="content">
                                <ul class="list-unstyled team-members">
                                            <li>
                                                <div class="row">
                                                    <div class="col-xs-3">
                                                        <div class="avatar">
                                                            <img src="${pageContext.request.contextPath}/resources/admin_resources/main/assets/img/faces/face-0.jpg" alt="Circle Image" class="img-circle img-no-padding img-responsive">
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-6">
                                                        DJ Khaled
                                                        <br />
                                                        <span class="text-muted"><small>Offline</small></span>
                                                    </div>

                                                    <div class="col-xs-3 text-right">
                                                        <btn class="btn btn-sm btn-success btn-icon"><i class="fa fa-envelope"></i></btn>
                                                    </div>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="row">
                                                    <div class="col-xs-3">
                                                        <div class="avatar">
                                                            <img src="${pageContext.request.contextPath}/resources/admin_resources/main/assets/img/faces/face-1.jpg" alt="Circle Image" class="img-circle img-no-padding img-responsive">
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-6">
                                                        Creative Tim
                                                        <br />
                                                        <span class="text-muted"><small>Offline</small></span>
                                                    </div>

                                                    <div class="col-xs-3 text-right">
                                                        <btn class="btn btn-sm btn-success btn-icon"><i class="fa fa-envelope"></i></btn>
                                                    </div>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="row">
                                                    <div class="col-xs-3">
                                                        <div class="avatar">
                                                            <img src="${pageContext.request.contextPath}/resources/admin_resources/main/assets/img/faces/face-3.jpg" alt="Circle Image" class="img-circle img-no-padding img-responsive">
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-6">
                                                        Flume
                                                        <br />
                                                        <span class="text-muted"><small>Offline</small></span>
                                                    </div>

                                                    <div class="col-xs-3 text-right">
                                                        <btn class="btn btn-sm btn-success btn-icon"><i class="fa fa-envelope"></i></btn>
                                                    </div>
                                                </div>
                                            </li>
                                        </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-8 col-md-7">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Edit Profile: Enter Password to update profile</h4>
                            </div>
                            <div class="content">
                                <form method="post" action="userProfile">
                                    <div class="row">
                                        <div class="col-md-5">
                                            <div class="form-group">
                                                <label>Firstname:</label>
                                                <input type="text" class="form-control border-input"   value="${getUser.firstname }" name="firstname">
                                            </div>
                                        </div>
                                        <div class="col-md-5">
                                            <div class="form-group">
                                                <label>Lastname:</label>
                                                <input type="text" class="form-control border-input"  value="${getUser.lastname }" name="lastname">
                                            </div>
                                        </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                
                                                <input type="hidden" class="form-control border-input" value="${getUser.count }" name="count">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        
                                        </div>
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>username</label>
                                                <input type="text" class="form-control border-input"  value="${getUser.username }" name="username">
													   <input type="hidden" class="form-control border-input"  value="${getUser.image }" name="image">
													    <input type="hidden" class="form-control border-input"  value="${getUser.password }" name="password">
													   <input type="hidden" class="form-control border-input"  value="${getUser.usertype }" name="usertype">
                                        </div>
                                    </div>


                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>Password:</label>
                                                <input type="password" class="form-control border-input"  value="${getUser.password }" name="password" required="required" >
                                            </div>
                                        </div>
                                        <input type="hidden" value="${getUser.id }" name="id"/>

                                    </div>


                                    <div class="text-center">
                                        <button type="submit" class="btn btn-info btn-fill btn-wd">Update Profile</button>
                                    </div>
                                    <div class="clearfix"></div>
                                </form>
                            </div>
                        </div>
                    </div>


                </div>
            </div>
        </div>


        <footer class="footer">
            <div class="container-fluid">
                <nav class="pull-left">
                    <ul>

                        <li>
                            <a href="http://www.creative-tim.com">
                                Creative Tim
                            </a>
                        </li>
                        <li>
                            <a href="http://blog.creative-tim.com">
                               Blog
                            </a>
                        </li>
                        <li>
                            <a href="http://www.creative-tim.com/license">
                                Licenses
                            </a>
                        </li>
                    </ul>
                </nav>
				<div class="copyright pull-right">
                    &copy; <script>document.write(new Date().getFullYear())</script>, made with <i class="fa fa-heart heart"></i> by <a href="http://www.creative-tim.com">Creative Tim</a>
                </div>
            </div>
        </footer>

    </div>
</div>


</body>

    <!--   Core JS Files   -->
    <script src="${pageContext.request.contextPath}/resources/admin_resources/main/assets/js/jquery.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/resources/admin_resources/main/assets/js/bootstrap.min.js" type="text/javascript"></script>

	<!--  Checkbox, Radio & Switch Plugins -->
	<script src="${pageContext.request.contextPath}/resources/admin_resources/main/assets/js/bootstrap-checkbox-radio.js"></script>

	<!--  Charts Plugin -->
	<script src="${pageContext.request.contextPath}/resources/admin_resources/main/assets/js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="${pageContext.request.contextPath}/resources/admin_resources/main/assets/js/bootstrap-notify.js"></script>

    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>

    <!-- Paper Dashboard Core javascript and methods for Demo purpose -->
	<script src="${pageContext.request.contextPath}/resources/admin_resources/main/assets/js/paper-dashboard.js"></script>

	<!-- Paper Dashboard DEMO methods, don't include it in your project! -->
	<script src="${pageContext.request.contextPath}/resources/admin_resources/main/assets/js/demo.js"></script>

</html>
