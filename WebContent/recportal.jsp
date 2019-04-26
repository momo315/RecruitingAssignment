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
			//to be filled with a default page
		}
	</script>
	<script type="text/javascript">
	function requisition(){
		$("#main").load('ReqCreate.jsp');
	}
	function getReqs(){
		$("#main").load('viewRec.jsp');
	}</script>
</head>
<body onload="loader()">
	<div id = "top">
	</div>
	<header>
		
		<button  class ="btn active" id="Requisition" onclick="requisition()">Create Requisition</button>
		<button  class ="btn " id="ViewRecs" onclick="getReqs()">View Requisition</button>
	</header>
	<div id="main"  >
	</div>

</body>
</html>