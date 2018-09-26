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
          <form class="form-containerr" method="post" action="${pageContext.request.contextPath }/updateInstitute">
            <h1>Edit Form</h1>
              <div class="form-group">
                <label class="text-black" >Name</label>
                <input type="text" class="form-control" required="required" name="name" value="${byid.name }">
              </div>
              <div class="form-group">
                <label class="text-black">Address</label>
                <input type="text" class="form-control" required="required" name="address" value="${byid.address }">
              </div>
              <div class="form-group">
                <label class="text-black">Contact</label>
                <input type="text" class="form-control" required="required" name="contact" value="${byid.contact }">
              </div>
              <div class="form-group">
                <label class="text-black">Email</label>
                <input type="text" class="form-control" required="required" name="email" value="${byid.email }">
              </div>
              
              <div class="form-group">
                <label class="text-black">Description</label>
                <input type="text" class="form-control" required="required" name="address" value="${byid.description }">
              </div>
              <div class="form-group">
                
                <input type="hidden" class="form-control" required="required" name="image" value="${byid.image }">
              </div>
              <div class="form-group">
                <label class="text-black">Resource Fee</label>
                <input type="number" class="form-control" required="required" name="fee.resourceFee" value="${byid.fee.resourceFee }">
              </div>
              <div class="form-group">
                <label class="text-black">Lab Fee</label>
                <input type="number" class="form-control"  name="fee.labFee" value="${byid.fee.labFee }">
              </div>
              <div class="form-group">
                <label class="text-black">ECA Fee</label>
                <input type="number" class="form-control"  name="fee.ECA" value="${byid.fee.ECA }">
              </div>
            
            <div class="form-group">
                
                <input type="hidden" class="form-control" required="required" name="id" value="${byid.id }">
              </div>
              <div class="form-group">
                
                <input type="hidden" class="form-control" required="required" name="fee.id" value="${byid.fee.id }">
              </div>
            
              <input type="submit" class="btn btn-success " value="Update" >
          </form>
          <!--form end-->

        </div>
        <div class="col-md-3"> <br><br>
        <img src="${pageContext.request.contextPath }/resources/ins_images/${byid.image}" class="img-responsive"><br> <br>
<p>Image Update:</p>
<form action="${pageContext.request.contextPath }/imageins" method="post" enctype="multipart/form-data">
             <div class="form-group">
               
                <input type="hidden" class="form-control" required="required" name="name" value="${byid.name }">
              </div>
              <input type="hidden" class="form-control" required="required" name="address" value="${byid.description }">
              <div class="form-group">
             
                <input type="hidden" class="form-control" required="required" name="address" value="${byid.address }">
              </div>
              <div class="form-group">
                
                <input type="hidden" class="form-control" required="required" name="contact" value="${byid.contact }">
              </div>
              <div class="form-group">
               
                <input type="hidden" class="form-control" required="required" name="email" value="${byid.email }">
              </div>

              <div class="form-group">
                
                <input type="hidden" class="form-control" required="required" name="fee.resourceFee" value="${byid.fee.resourceFee }">
              </div>
              <div class="form-group">
               
                <input type="hidden" class="form-control" required="required" name="fee.labFee" value="${byid.fee.labFee }">
              </div>
              <div class="form-group">
               
                <input type="hidden" class="form-control" required="required" name="fee.ECA" value="${byid.fee.ECA }">
              </div>
            
            <div class="form-group">
                
                <input type="hidden" class="form-control" required="required" name="id" value="${byid.id }">
              </div>
              <div class="form-group">
                
                <input type="hidden" class="form-control" required="required" name="fee.id" value="${byid.fee.id }">
              </div>
<div class="form-group">

                <label class="btn btn-primary btn-file">
    Browse Image<input type="file" style="display: none;" name="file[]">
</label>
<input type="submit" value="UpdatePhoto" class="btn" />
              </div>
</form>


</div>
      </div>
    </div>
    <script src="bootstrap/js/engine.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>

 
  </body>
</html>