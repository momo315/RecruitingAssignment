<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<style>
			#log {width: 300px;
				    height: 100px;
				    
				
				    position: absolute;
				    top:0;
				    bottom: 0;
				    left: 0;
				    right: 0;
				
				    margin: auto;
				}
				.vcenter {
				    margin: 0;
				    position: absolute;
				    top: 50%;
				    -ms-transform: translateY(-50%);
				    transform: translateY(-50%);
				}
				body{
				height: 100%;
				}
				.bordered{
				border-style: groove;
				background-color: #c2d6d6;
				}
		</style>
		<script type="text/javascript">
			function clicker(){
				$.ajax({
					url : "Login",
					type : "post",
					data : { user : document.getElementById("user").value,
						 pass : document.getElementById("pass").value},
						 success : function(data){
							 document.write(data);
						 }
				});
			}
		</script>
	<!--	
	<script>
			$(document).ready(function(){
				$("#sign").click(function(){
					$.ajax({
						url : "Login",
						type : "post",
						data : { user : document.getElementById("user").value,
								 pass : document.getElementById("pass").value},
						success : function(data){
							$(document).html(data);
						}
					});
				});
				});
		</script>
		-->
		<link rel="stylesheet" type="text/css" href="background.css" />
	</head>
	<body >
		<div class="container ">
		<div class = "vcenter">
			<div class="row">
			<div class="col-sm-4"></div>
				<div class="col-sm-4 bordered">
				<p id="msg"><%if(request.getAttribute("msg")!=null)out.println(request.getAttribute("msg")); %> </p>
				
					<div class="input-group">
	    				<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
						<input type ="text" id = "user" name="user" class="form-control" placeholder="E-mail" />
					</div>
					<div class="input-group">
    					<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
    					<input type="password" id = "pass" class="form-control" name = "pass" placeholder="password"/>
    				</div>
					   <button onclick="clicker()">Sign In</button>
				       <button onclick="location.href='SignUp.jsp'">Sign Up</button> 
				</div>
				<div class="col-sm-4"></div>
			</div>
			</div>
		</div>
	</body>
</html>