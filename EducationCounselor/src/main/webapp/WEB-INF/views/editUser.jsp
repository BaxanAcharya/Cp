<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit ${byidUser.username }</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6">


				<h1>Enter Password to update</h1>
				<hr>
			
				<form action="${pageContext.request.contextPath}/editUserb" method="POST">
					<div class="form-group">
						<label>FirstName:</label> <input type="text" class="form-control"
							name="firstname" value="${byidUser.firstname }" required="required">
					</div>

					<div class="form-group">
						<label>lastName:</label> <input type="text" class="form-control"
							name="lastname" value="${byidUser.lastname }" required="required">
					</div>

					<div class="form-group">
						<label>UserName:</label> <input type="text" class="form-control"
							name="username" value="${byidUser.username }" required="required">
					</div>
					
									

					
					<div class="form-group">
						<label>UserType</label> <input type="text"
							class="form-control" name="usertype" value="${byidUser.usertype }" required="required">
					</div>
						<div class="form-group">
						<label>Password:</label> <input type="text" class="form-control"
							name="password"  required="required">
					</div>
					<input type="hidden" name="image" value="${byidUser.image }">
					<input type="hidden" name="id" value="${byidUser.id }">
					<button type="submit" class="btn btn-default">Update</button>
				</form>


			</div>
			
			<div class="col-md-6">
			Image Update:
			<br>
			<img src="${pageContext.request.contextPath}/resources/images/${byidUser.image }" alt="5454533" class="img-fluid"/>
							<form action="${pageContext.request.contextPath}/editUserImg" method="POST" enctype="multipart/form-data">
					<div class="form-group">
						 <input type="hidden" class="form-control"
							name="firstname" value="${byidUser.firstname }" required="required">
					</div>

					<div class="form-group">
						 <input type="hidden" class="form-control"
							name="lastname" value="${byidUser.lastname }" required="required">
					</div>

					<div class="form-group">
						 <input type="hidden" class="form-control"
							name="username" value="${byidUser.username }" required="required">
					</div>

					
					<div class="form-group">
						 <input type="hidden"
							class="form-control" name="usertype" value="${byidUser.usertype }" required="required" placeholeholder="">
					</div>
					<label class="btn btn-primary btn-file">
    Browse Image<input type="file" style="display: none;" name="file[]">
</label>
					<input type="hidden" name="id" value="${byidUser.id }">
					<input type="hidden" name="password" value="${byidUser.password }">
					<button type="submit" class="btn btn-default">Update Image</button>
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
    <div class="footer-copyright text-center py-3">© 2018 Copyright:
      <a href=""> Education Counselor</a>
    </div>
    <!-- Copyright -->

  </footer>
  <!-- Footer -->
</body>
</html>