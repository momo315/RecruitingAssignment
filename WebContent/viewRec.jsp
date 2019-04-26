<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<script type="text/javascript">
		$(document).ready(function(){
			$.ajax({
				url : "RequisitionsRec",
				type : "post",
				dataType : "json",
				success : function(data){
					if(data["sess"]!=null){
						window.location = "index.jsp";
					}
					else{
						var table = document.getElementById("tab");
						table.innerHTML="";
						table.border=1;
						var head = document.createElement("TR");
						var i = 0;
						var iter = ['Req_id' , 'Req_name', 'Location' , 'Status','Experience','Apply'];
						var iter2 = ['reqId','reqName','location','status','experience']
						for(i = 0;i<5;i++){
							var td= document.createElement("TH");
							var text = document.createTextNode(iter[i]);
							td.appendChild(text);
							head.appendChild(td);
						}
						table.appendChild(head);
					data.forEach(function(item){
						var tr = document.createElement("TR");
						iter2.forEach(function(t){
							var c = document.createElement("TD");
							var tn = document.createTextNode(item[t]);
							c.appendChild(tn);
							tr.appendChild(c);
						});
						
						table.appendChild(tr);
						
					});
				}
				}
			});
		});
	</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<table id="tab" class="table"></table>
			</div>
			<div class="col-sm-2"></div>
		</div>
	</div>
</body>
</html>