<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<html>
<head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$("#div2").hide();
    $("#add").click(function(){    
   
        $("#div1").hide(); 
        $("#div2").show();
    });
   
       $("#btn").click(function(){
        $("#submitform").submit(); 
    
        });
        
});

/* 	var varId=$('#id').val();
	   var varName=$('#name').val();
	   var varSalary=$('#salary').val();
	   var varDesignation=$('#designation').val(); 
	   var dat = JSON.stringify({"id" : varId, "name" : varName, "salary" : varSalary, "designation" : varDesignation});

	    $.ajax({
	            url : "save.ajax",
	            type : "POST",
	            data : dat,
	           contentType : "application/json",
	           dataType : "json",
	            success : function(response) {
	                alert(response);
	            },
	            error : function() {
	                alert("opps.....");
	            } 
	        });
	   */
	
</script>

</head>


<body>

  
<div id="div1">

    <a  href="#" id="add">Add Employee</a>
	<a href="viewemp">View Employees</a>
	
</div>

<div id="div2">

   <h1>Add New Employee</h1>
	
	<form  action="save" id="submitform" method="POST">
	
		<table>
			<tr>
				<td>Id :</td>
				<td><input type="text" name="id" value="" /></td>
				
			</tr>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name" value="" /></td>
			</tr>
			<tr>
				<td>Salary :</td>
				<td><input type="text" name="salary" value="" /></td>
			</tr>
			<tr>
				<td>Designation :</td>
				<td><input type="text" name="designation" value="" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="submit" id="btn"/></td>
			</tr>
		</table>
		
	</form>

</div>


</body>
</html>
