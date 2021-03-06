<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>User Profile</title>

<link rel="stylesheet" type="text/css" href="../Bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../Bootstrap/css/bootstrap.css">
   <!-- Custom styles for this template -->
    <!-- <link href="../Bootstrap/css/bootstrap.css" rel="stylesheet"> -->
 <link rel="icon" href="../Pics/ru1.jpg" type="image/jpg" sizes="32x32"> 
<!--  <!-- Bootstrap core CSS -->
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script> 

    <!-- Font Awesome -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Bootstrap core CSS -->

<!-- Material Design Bootstrap -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.5.4/css/mdb.min.css" rel="stylesheet">



<!-- MDB core JavaScript -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.5.4/js/mdb.min.js"></script>
 <!-- yo chai text transformation ko  lagi  -->

 <script src="https://cdnjs.cloudflare.com/ajax/libs/animejs/2.0.2/anime.min.js"></script>
    
    
</head>
<body>
<!--Navbar-->
<nav class="navbar navbar-expand-lg navbar-dark primary-color">

    <!-- Navbar brand -->
    <a class="navbar-brand" href="allinstitute"><img src="${pageContext.request.contextPath}/resources/images/coat-of-arms-1438001_1920.jpg" alt="" class="img img-responsive" style=" height:30px; width:80px; "></a>

    <!-- Collapse button -->
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#basicExampleNav" aria-controls="basicExampleNav"
        aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <!-- Collapsible content -->
    <div class="collapse navbar-collapse" id="basicExampleNav">

        <!-- Links -->
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ">
                <a class="nav-link" href="allinstitute">Home
                    
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="addinstitute">Add Institute</a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="forum">Forum</a>
             
            </li>
            
            <li class="nav-item">
                <a class="nav-link" href="user">User</a>
            </li>

            <!-- Dropdown -->
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Current User</a>
                <div class="dropdown-menu dropdown-primary" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item active" href="normalProfile">Profile<span class="sr-only">(current)</span></a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Logout</a>
                </div>
            </li>

        </ul>
        <!-- Links -->

        <form class="form-inline">
            <div class="md-form my-0">
                <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
            </div>
        </form>
    </div>
    <!-- Collapsible content -->

</nav>
<!--/.Navbar-->
    
    <div class="container">
    <div class="row">
    <div class="col-md-6 divsarni">   
     <h2 align="center">Your Photo:</h2>
     <img src="${pageContext.request.contextPath}/resources/images/${thishdbf.image  }" alt="Profile Pic" class="img img-responsive img-thumbnail" style=" height:300px; width:300px; ">
     
  </div>
  <div class="col-md-6">
    <h1 align="center">Enter password to update profile</h1>
    <form action="normaluserProfile" method="post">

					<div class="form-group">
						<label>FirstName:</label> <input type="text" class="form-control"
							name="firstname" value="${nup.firstname }">
					</div>

					<div class="form-group">
						<label>lastName:</label> <input type="text" class="form-control"
							name="lastname" value="">
					</div>

					<div class="form-group">
						<label>UserName:</label> <input type="text" class="form-control"
							name="username" value="">
					</div>

					<div class="form-group">
						<label>Password</label> <input type="password"
						
						
							class="form-control" name="password" value="" required="required">
					</div>
					<input type="hidden" name="id" value="">
					<input type="hidden" name="usertype" value="">
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
    
    
    </div>
    </div>
    </div>
        <!-- Footer -->
<footer class="page-footer font-small special-color-dark pt-4">

    <!-- Footer Elements -->
    <div class="container">

      <!-- Social buttons -->
      <ul class="list-unstyled list-inline text-center">
        <li class="list-inline-item">
          <a class="btn-floating btn-fb mx-1" href="https://www.facebook.com">
            <i class="fa fa-facebook"> </i>
          </a>
        </li>
        <li class="list-inline-item">
          <a class="btn-floating btn-tw mx-1" href="https://www.twitter.com">
            <i class="fa fa-twitter"> </i>
          </a>
        </li>
        <li class="list-inline-item">
          <a class="btn-floating btn-gplus mx-1" href="https://gsuite.google.com">
            <i class="fa fa-google-plus"> </i>
          </a>
        </li>
        <li class="list-inline-item">
          <a class="btn-floating btn-li mx-1" href="https://linkedin.com">
            <i class="fa fa-linkedin"> </i>
          </a>
        </li>
        <li class="list-inline-item">
          <a class="btn-floating btn-dribbble mx-1" href="https://youtube.com">
            <i class="fa fa-youtube" > </i>
          </a>
        </li>
      </ul>
      <!-- Social buttons -->

    </div>
    <!-- Footer Elements -->

    <!-- Copyright -->
    <div class="footer-copyright text-center py-3">� 2018 Copyright:
      <a href=""> Education Counselor</a>
    </div>
    <!-- Copyright -->

  </footer>
  <!-- Footer -->
    </body>
    </html>
    