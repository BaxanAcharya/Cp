<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/resources/admin_resources/main/assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="${pageContext.request.contextPath}/resources/admin_resources/main/assets/img/favicon.png">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Forum </title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/dataTables.bootstrap.css">
    
    <script  type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/dataTables.bootstrap.js"></script>
  

    <!-- Bootstrap core CSS     -->
    <link href="${pageContext.request.contextPath}/resources/admin_resources/main/assets/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="${pageContext.request.contextPath}/resources/admin_resources/main/assets/css/animate.min.css" rel="stylesheet"/>

    <!--  Paper Dashboard core CSS    -->
    <link href="${pageContext.request.contextPath}/resources/admin_resources/main/assets/css/paper-dashboard.css" rel="stylesheet"/>

    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="assets/css/demo.css" rel="stylesheet" />
<link  rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style2.css">
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

<label class="welcome"> <b> Welcome : ${username }</b></label>

           <ul class="nav">
                <li>
                    <a href="adminDashborad">
                        <i class="ti-panel"></i>
                        <p>Dashboard</p>
                    </a>
                </li>
                <li >
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
                                  <li class="active"  >
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
                    <a class="navbar-brand" href="forum">Forum</a>
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
                <div class="col-md-12">
                <form class="form-containerr" action="fquestion" method="post">
                <div class="form-group">
                <label class="text-black" >Question</label>
                <input type="text" class="form-control" required="required" name="question" >
              </div>
              <input type="submit" class="btn btn-success " value="POST" >
                </form>
                </div>
                    </div>
                    </div>
                    
                    <div class="container"> 
                    <div class="row">
                    <div class="col-md-12">
                     <div >
                    <c:forEach var="qlist" items="${qlist}">
					
                  
                   
                    <div class="row">
                    <div class="col-md-8">
                    <form class="form-containerr" action="forumAnswer" method="post" >
                    <label class="text-black">Asked by:<i>${qlist.username }</i>---- Date:<i> ${qlist.date }</i></label><br>
                     	<label class="text-black">Question:<i>${qlist.question }</i></label><br><br>
                    
                <div class="form-group">
                <label class="text-black" >Reply</label>
                <input type="text" class="form-control" required="required" name="answer" >
                <input class="text-black" type="hidden" value="${qlist.id}" name="fq_id"/>
              </div>
              

              <input type="submit" class="btn btn-success " value="POST" >
            
                </form> <br> <br> <br>
                </div>
                    </div>
                    </c:forEach>
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


<script type="text/javascript">
	function editstudent(id){
		window.location="${pageContext.request.contextPath}/"+id+"/editIns";
	}
	function deletestudent(id){
		var msg=confirm("do you want to delete ? ");
		if(msg==true){
			window.location="${pageContext.request.contextPath}/"+id+"/deleteIns";
		}
	}
	$(document).ready( function () {
	    $('#myTable').DataTable();
	} );
	</script>
	
	
</body>

    <!--   Core JS Files   -->
  <!--  <script src="${pageContext.request.contextPath}/resources/admin_resources/main/assets/js/jquery.min.js" type="text/javascript"></script> --> 
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

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
