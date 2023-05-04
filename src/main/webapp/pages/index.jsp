<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Report App</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body>



	<div class="container">

		<h3 class="pb-3 pt-3">Report Application</h3>

		<form:form action="search" modelAttribute="search" method="POST">
			<table>
				<tr>
					<td>Plan Name:</td>
					<td><form:select path="planName">
							<form:option value="">-Select-</form:option>
							<form:options items = "${names}"/>
						</form:select></td>

					<td>Plan Status:</td>
					<td><form:select path="PlanStatus">
							<form:option value="">-Select-</form:option>
							<form:options items = "${status}"/>
						</form:select></td>

					<td>Gender:</td>
					<td><form:select path="gender">
							<form:option value="">-Select-</form:option>
							<form:option value="Male">Male</form:option>
							<form:option value="Fe-Male">Fe-Male</form:option>

						</form:select></td>

				</tr>
				
				<tr >
				<td class="pb-3 pt-3">Start Date</td>
				<td>
				<form:input type="Date"  path="planStartDate"></form:input>
				</td>
				
				<td >End Date</td>
				<td>
				<form:input type="Date" path="planEndDate"></form:input>
				</td>
				</tr>
				
				<tr>
				<td class="btn btn-info"><a href="/">Reset</a></td>
				<td>
				<input type="submit" value="search" class="btn btn-primary"/>
				</td>
				</tr>

			</table>
			
		</form:form>
		
		<hr/>
		
		<table class ="table table-striped table-hover">
		<thead>
		<tr>
		<th>S.No</th>
		<th>Holder Name</th>
		<th>Gender</th>
		<th>Plan Name</th>
		<th>plan Status</th>
		<th>Start Date</th>
		<th>End Date</th>
		</tr>
		</thead>
		
		<tbody>
		
		<c:forEach items="${result}" var ="result" varStatus="index">
		<tr>
		
		<td>${index.count}</td>
		<td>${result.citizenName}</td>
		<td>${result.gender}</td>
		<td>${result.planName}</td>
		<td>${result.planStatus}</td>
		<td>${result.planStartDate}</td>
		<td>${result.planEndDate}</td>
		</tr>
		</c:forEach>
		<tr>
		<c:if test="${empty result}">
		<td colspan="7" style="text-align: center">No Record Found</td>
		
		</c:if>
		
		</tr>
				
			</tbody>
		
		</table>	
		<hr/>
		Export: <a href="excel" >Excel</a>  <a href="pdf">Pdf</a>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>

</body>
</html>