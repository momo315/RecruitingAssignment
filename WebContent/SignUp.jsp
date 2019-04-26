<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<style>
			#signup {width: 500px;
				    height: 100px;
				    
				
				    position: absolute;
				    top:0;
				    bottom: 0;
				    left: 0;
				    right: 0;
				
				    margin: auto;
				}
		</style>
		<link rel="stylesheet" type="text/css" href="background.css" />
		<script type="text/javascript">
			function signup(){
				var mailc = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
				var idc = /^[I|D|C]{1}[0-9]{6}$/i;
				if(document.getElementById("user").value == "" || document.getElementById("pass").value =="" || document.getElementById("cpass").value =="" || document.getElementById("empid").value =="" || document.getElementById("res").value =="" || document.getElementById("fname").value =="" || document.getElementById("lname").value ==""){
					alert("please enter all details");
					return false;
				}
				if(! (mailc.test(document.getElementById("user").value))){
					alert("invalid email");
					return false;
				}
				if(!idc.test(document.getElementById("empid").value)){
					alert("invalid Employee ID");
					return false;
				}
				return true;
			}
		</script>
	</head>
	<body>
		<div id="signup">
			<form action="Registration" method="post" enctype="multipart/form-data" onsubmit="return signup()">
				<pre>Email            : <input type="text" id="user" name="user" /></pre>
				<pre>Password         : <input type="password" id="pass" name="pass"/></pre>
				<pre>Confirm Password : <input type="password" id="cpass" name="cpass"/></pre>
				<pre>Emp ID           : <input type="text" id="empid" name="empid"/></pre>
				<pre>Gender           : <input type="radio" name="gender" id="male" value="Male" checked />Male <input type="radio" name="gender" id="female" value="Female" />Female </pre>
				<pre>User Type        : <input type="radio" name="usertype" id="can" value="Candidate"  checked />Candidate <input type="radio" name="usertype" id="rec" value="Recruiter" />Recruiter <input type="radio" name="usertype" id="adm" value="Admin" />Admin </pre>
				<pre>First Name       : <input type="text" id="fname" name="fname"/></pre>
				<pre>Last Name        : <input type="text" id="lname" name="lname"/></pre>
				<pre>Resume           : <input type="file"  name="sume" id="sume" accept="application/pdf"/></pre>
				<pre>           <input type="submit" value="Sign Up" ></pre>
			</form>
			</div>
	</body>
</html> 