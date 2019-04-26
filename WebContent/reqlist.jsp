<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
}
.labelp{
	display:inline-block;}

html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}
.division{
	padding: 25px;
}

.tab {
	border: 25px;
	padding: 10px;
}
</style>
<script type="text/javascript">
	function clicker(){
		var searchbar = document.getElementById("getthis").value;
		
			$.ajax({
				url : "Requisitions",
				data : { search : searchbar },
				type : "post",
				success : function(data){
					if(data["sess"]!=null){
						window.location = "index.jsp";
					}
					else{
						alert(data);
						var box = document.getElementById("box");
						box.innerHTML="";
						var table = document.createElement("TABLE");
						table.innerHTML="";
						table.border=1;
						var head = document.createElement("TR");
						var i = 0;
						var iter = ['Req_id' , 'Req_name', 'Location' , 'Status','Experience','Apply'];
						var iter2 = ['reqId','reqName','location','status','experience']
						for(i = 0;i<6;i++){
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
						var cn = document.createElement("TD");
						var btn = document.createElement("BUTTON");
						var ntn = document.createTextNode("Apply");
						btn.appendChild(ntn);
						btn.setAttribute("onclick","javascript: getRec(this);");
						cn.appendChild(btn);
						tr.appendChild(cn);
						table.appendChild(tr);
						
					});
					table.className = "table";
				box.appendChild(table);
				box.className="bordered";
					}
				}});
		
	}
</script>
<script type="text/javascript">
	function getRec(btn){
		var $row=btn.parentNode.parentNode;
		var cell = $row.firstChild.innerHTML;
		document.cookie = "reqid="+cell;
		$("#main").load('recApply.jsp');
		
	}
</script>
<script type="text/javascript">
	function apply(btn){
		var box = btn.parentNode.firstChild.children[1].innerHTML;
		alert(box);
	}
</script>
</head>
<body id="main">
	<div class="vcenter">
		<div class="container">
			<div class="row">
				<div class="col-sm-3"></div>
				<div class="col-sm-6">
					<div class="row">
						<div class="col-sm-8">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-search"></i></span> <input id="getthis"
									type="text" class="form-control" name="email"
									placeholder="Search...">
							</div>
						</div>
						<div class="col-sm-4">
							<button type="button" class="btn btn-default btn-sm"
								onclick="clicker();">
								<span class="glyphicon glyphicon-search"></span> Search
							</button>
						</div>
					</div>


				</div>
				<div class="col-sm-3"></div>
			</div>
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-8">
					<div id="box"></div>
				</div>
				<div class="col-sm-2"></div>
			</div>
		</div>
	</div>
</body>
</html>