<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.vcenter {
	min-height: 100%; /* Fallback for browsers do NOT support vh unit */
	min-height: 100vh; /* These two lines are counted as one      */
	display: flex;
	align-items: center;
}

.bordered {
	border-style: groove;
	background-color: #c2d6d6;
	padding: 25px 10px 25px 10px;
}

html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}
</style>
<script type="text/javascript">
		$(document).ready(function(){
			$.ajax({
				url : "Profile",
				type : "post",
				success : function(data){
					if(data["sess"]!=null){
						window.location = "index.jsp";
					}
					else{
						document.getElementById("name").innerHTML = data.fname+" "+data.lname;
						document.getElementById("email").innerHTML = data.username;
						document.getElementById("empid").innerHTML = data.empid;
						if(data.address != null )
							document.getElementById("address").value = data.address;
						if(data.phone != null )
							document.getElementById("phno").value = data.phone;
						if(data.bio != null )
							document.getElementById("bio").value = data.bio;
					}
				}
			});
		});
		function saverprof(){
			$.ajax({
				url : "ProfileUpdate",
				type : "post",
				data : { address : document.getElementById("address").value,
						 phno : document.getElementById("phno").value,
						 bio : document.getElementById("bio").value
				},
				success : function(data){
					if(data["sess"]!=null){
						window.location = "index.jsp";
					}
					else{
						if(data.updated == "true"){
							document.getElementById("theone").innerHTML="Successfully Updated";
						}
						else{
							document.getElementById("theone").innerHTML="Update Failed";
						}
					}
				}
			});
		}
	</script>
</head>
<body>
	<div class="vcenter">
		<div class="container">
			<div class="row ">
				<div class="col-sm-2"></div>
				<div class="col-sm-8 bordered" id="theone">
					<div class="form-group">
						<label for="name" class="form-label  col-sm-2">Name : </label>
						<div class="col-sm-10">
							<p class="form-control-static" id="name"></p>
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="form-label  col-sm-2">Email : </label>
						<div class="col-sm-10">
							<p class="form-control-static" id="email"></p>
						</div>
					</div>
					<div class="form-group">
						<label for="empid" class="form-label  col-sm-2">Employee
							ID : </label>
						<div class="col-sm-10">
							<p class="form-control-static" id="empid"></p>
						</div>
					</div>
					<div class="form-group">
						<label for="address" class="form-label  col-sm-2">Address
							: </label>
						<div class="col-sm-10">
							<input class="form-control" type="text" placeholder="Address"
								id="address" />
						</div>
					</div>
					<div class="form-group">
						<label for="phno" class="form-label  col-sm-2">Phone : </label>
						<div class="col-sm-10">
							<input class="form-control" type="text"
								placeholder="Phone number" id="phno" />
						</div>
					</div>
					<div class="form-group">
						<label for="bio" class="form-label  col-sm-2">Bio : </label>
						<div class="col-sm-10">
							<textarea class="form-control" rows="5"
								placeholder="Write a short Bio.." id="bio"></textarea>
						</div>
						<div class="row">
							<br>
						</div>
						<div class="row">
							<div class="col-sm-5"></div>
							<div class="col-sm-2">
								<button type="button" class="btn btn-primary btn-md"
									onclick="saverprof()">Save</button>
							</div>
							<div class="col-sm-5"></div>
						</div>

					</div>
				</div>
				<div class="col-sm-2"></div>
			</div>
		</div>
	</div>
</body>
</html>