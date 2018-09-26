
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Edit Institute</title>

    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/style2.css" rel="stylesheet">
    <link rel="stylesheet"  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
  </head>
 
  <body>
    <div class="container-fluid bg"  >
      <div class="row">

        <div class="col-md-9 ">
          <!--form start-->
          <form class="form-containerr" method="post" action="${pageContext.request.contextPath }/updateCourse">
            <h1>Edit Form</h1>
              <div class="form-group">
                <label class="text-black" >Course</label>
                <input type="text" class="form-control" required="required" name="course" value="${byidCourse.course }">
              </div>
              <div class="form-group">
                <label class="text-black">Book</label>
                <input type="text" class="form-control" required="required" name="book" value="${byidCourse.book }">
              </div>
              <input type="hidden" name="i_id" value="${byidCourse.i_id }">
         <input type="hidden" name="id" value="${byidCourse.id }"> 


   
    


              <input type="submit" class="btn btn-success " value="Update" >
          </form>
          <!--form end-->

        </div>
        <div class="col-md-3"> <br><br>
        


</div>
      </div>
    </div>
    <script src="bootstrap/js/engine.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>

 
  </body>
</html>