<%@page import="com.internal.model.userProfile,javax.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		alert("works");
		$.ajax({
			url : "Profile",
			type : "GET",
			dataType : "json",
			success : function(data){
				if(data["sess"]!=null){
					window.location = "index.jsp";
				}
				else{
				document.getElementById("name").innerHTML +=data["fname"]+" "+data["lname"] ;
				document.getElementById("user").innerHTML +=data["username"];
				document.getElementById("empid").innerHTML +=data["empid"];
				document.getElementById("gender").innerHTML +=data["gender"];
				}
			}
		});
	});
</script>
<script type="text/javascript">
	function getres(){
		$.ajax({
			url : "Resume",
			type : "get",
			
	        success :function(data){
	        	var fileURL =  "data:application/pdf;base64,"+data;
	            window.open(fileURL);
	        }
		});
	}
</script>
</head>
<body  >
<p id="name">Name : </p>
<p id="user">E-Mail : </p>
<p id="empid">Employee id : </p>
<p id="gender">Gender : </p>
<p>Resume : <button onclick="getres()">View</button>

</body>
</html>