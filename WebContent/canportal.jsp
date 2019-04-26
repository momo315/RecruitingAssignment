<%@page import="com.internal.model.userProfile"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<style type="text/css">
		#top{
			background-image: url("images/RCM Careers.png");
			height: 100px;
			background-size: 100% 100%;
			
			
		}
		header {
			display: block;
			background-color: black;
			padding : 10px;
		}
		header button {
			display: inline;
			color : white;
			padding: 14px 16px;
			font-size: 24;
			text-align: center;
			text-decoration: none;
		}
		.active {
			background-color: green;
		}
	
	</style>
	<script >
		function loader(){
			$("#main").load('Profile.jsp')
		}
	</script>
	<script type="text/javascript">
	function profile(){
		$("#main").load('Profile.jsp');
	}
	function search(){
		$("#main").load('reqlist.jsp');
	}
	function profedit(){
		$("#main").load('profileEdit.jsp');
	}
	
	</script>
</head>
<body onload="loader()">
	<div id = "top">
	</div>
	<header>
		<button  class ="btn active" id="Profile" onclick="profile()" >My Profile</button>
		<button class ="btn" id="search" onclick="search()">Job Hunt</button>
		<button class ="btn" id="profedit" onclick="profedit()">Edit Profile</button>
	</header>
	<div id="main"  >
	</div>

</body>
</html>