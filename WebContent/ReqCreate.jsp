<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	function newreq(){
		if(document.getElementById("reqname").value=="" ||document.getElementById("expiry").value==""||document.getElementById("status").value==""||document.getElementById("loc").value==""||document.getElementById("exp").value==""||document.getElementById("skills").value==""){
			alert("Enter all fields");
			return false;
		}
		var multiskills = $('#skills').val();
		$.ajax({
			url : "Requisition",
			type : "post",
			dataType : "json",
			data : { name : document.getElementById("reqname").value,
					 expiry : document.getElementById("expiry").value,
					 status : document.getElementById("status").value,
					 loc : document.getElementById("loc").value,
					 exp : document.getElementById("exp").value,
					 skills : multiskills
					},
			success : function(data){
				if(data["sess"]!=null){
					window.location = "index.jsp";
				}
				else{
					if(data["created"]=="true"){
						$("#main").load('reqsuccess.html');
					}
					else{
						$("#main").load('reqfail.html');
					}
				}
			}
		});
	}
</script>
</head>
<style>
/* .container{
		border-style: ridge;
		border-radius: 12px;
		max-width : 500px;
		margin: 0;
    	position: absolute;
	    top: 50%;
	    left: 50%;
	    margin-right: -50%;
	    transform: translate(-50%, -50%);
	    padding :20px;
	} */
label {
	font-style: Arial;
}

label+input {
	margin: 10px;
}

label+select {
	margin: 10px;
}

.vcenter {
	min-height: 100%; /* Fallback for browsers do NOT support vh unit */
	min-height: 100vh; /* These two lines are counted as one      */
	display: flex;
	align-items: center;
}

.bordered {
	border-style: groove;
	background-color: #c2d6d6;
	padding: 50px;
	margin: 50px;
}

html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}
</style>


<body id="main">
	<div class="vcenter">
		<div class="container">
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-8 bordered">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="control-label col-sm-2">Requisition Name :
							</label>
							<div class="col-sm-10">
								<input class="form-control" type="text"
									placeholder="Requisition Name" id="reqname" />
							</div>
						</div>
						<div class="form-group">
							<label class="form-label  col-sm-2">Expiry : </label>
							<div class="col-sm-10">
								<input class="form-control" type="date" placeholder="expiry"
									id="expiry" />
							</div>
						</div>
						<div class="form-group">
							<label class="form-label  col-sm-2">Status :</label>
							<div class="col-sm-10">
								<select class="form-control" id="status">
									<option value="Open">Open</option>
									<option value="closed">Closed</option>
									<option value="Filled">Filled</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="form-label  col-sm-2">Location : </label>
							<div class="col-sm-10">
								<input class="form-control" type="text" placeholder="Location"
									id="loc" />
							</div>
						</div>
						<div class="form-group">
							<label class="form-label  col-sm-2">Experience : </label>
							<div class="col-sm-10">
								<input class="form-control" type="text" placeholder="Location"
									id="exp" />
							</div>
						</div>
						<div class="form-group">
							<label class="form-label  col-sm-2">Skills :</label>
							<div class="col-sm-10">
								<select multiple class="form-control" id="skills">
									<option value="Java">Java</option>
									<option value="UI">UI</option>
									<option value="Database">Database</option>
									<option value="Web Development">Web Development</option>
								</select>
							</div>
						</div>
					</form>
					<div class="row">
						<div class="col-sm-5"></div>
						<div class="col-sm-2">
							<button type="button" class="btn btn-primary btn-md"
								onclick="saverprof()">Save</button>
						</div>
						<div class="col-sm-5"></div>
					</div>
					<div class="col-sm-2"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>