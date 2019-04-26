<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var cook = document.cookie;
		var cookiearr = cook.split(";");
		for(var i=0; i<cookiearr.length; i++){
			var name=cookiearr[i].split("=")[0];
			if(name=="reqid"){
				var reqid = cookiearr[i].split("=")[1];
				$.ajax({
					url : "RequisitionView",
					type : "post",
					data : { reqid : reqid},
					success : function(data){
						if(data["sess"]!=null){
							window.location = "index.jsp";
						}
						else{
						var iter2 = ["reqId","reqName","createdAt","expiry","status","location","experience","skills","createdBy"];
						document.getElementById("reqid").innerHTML=data.reqId;
						document.getElementById("reqname").innerHTML=data.reqName;
						document.getElementById("createdat").innerHTML=data.createdAt;
						document.getElementById("expiry").innerHTML=data.expiry;
						document.getElementById("status").innerHTML=data.status;
						document.getElementById("loc").innerHTML=data.location;
						document.getElementById("exp").innerHTML=data.experience;
						document.getElementById("skills").innerHTML=data.skills;
						document.getElementById("createdby").innerHTML=data.createdBy;
						}
					}
				});
			}
		}
	});
</script>
<script type="text/javascript">
	function applier(){
		$.ajax({
			url : "Application",
			type : "post",
			data : {
				reqid : document.getElementById("reqid").innerHTML
			},
			success :function(data){
				if(data["sess"]!=null){
					window.location = "index.jsp";
				}
				else{
					var d = document.getElementById("thedisplay");
					d.innerHTML=data.msg;
					
				}
			}
		});
	}
</script>
<style type="text/css">
.grid-container{
	display : grid;
	grid-template-columns : auto auto auto;
	grid-template-rows : 80px auto;
}
.grid-container2{
	display : grid;
	grid-template-columns : auto auto auto;
	grid-template-rows : auto auto;
}
.grid-item {
  background-color: rgba(255, 255, 255, 0.8);
  padding: 20px;
  text-align: center;
}
.bordered {
	border-style: groove;
	background-color: #c2d6d6;
	padding: 25px 10px 25px 10px;
}
.bordered2 {
	border-style: groove;
	padding: 25px 10px 25px 10px;
}
</style>
</head>
<body>
<div class="grid-container">
<div class="grid-item"></div>
<div class="grid-item"></div>
<div class="grid-item"></div>
<div class="grid-item"></div>
<div class="grid-item">
	<div class="grid-container2 bordered" id="thedisplay">
		<div class="grid-item bordered2">
			<label>Requisition ID :</label><p id="reqid"></p>
		</div>
		<div class="grid-item bordered2">
			<label>Requisition Name :</label><p id="reqname"></p>
		</div>
		<div class="grid-item bordered2">
			<label>Created At :</label><p id="createdat"></p>
		</div>
		<div class="grid-item bordered2">
			<label>Expiry :</label><p id="expiry"></p>
		</div>
		<div class="grid-item bordered2">
			<label>Status :</label><p id="status"></p>
		</div>
		<div class="grid-item bordered2">
			<label>Location :</label><p id="loc"></p>
		</div>
		<div class="grid-item bordered2">
			<label>Experience :</label><p id="exp"></p>
		</div>
		<div class="grid-item bordered2">
			<label>Skills :</label><p id="skills"></p>
		</div>
		<div class="grid-item bordered2">
			<label>Created By :</label><p id="createdby"></p>
		</div>
		<div class="grid-item"></div>
		<div class="grid-item"><button onclick="applier();">Apply</button></div>
		<div class="grid-item"></div>
	</div>
</div>
<div class="grid-item"></div>
</div>

</body>
</html>