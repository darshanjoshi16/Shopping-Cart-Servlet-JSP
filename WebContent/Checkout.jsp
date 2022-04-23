<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Check Out Page</title>
<style>
	td,th{
		text-align: center;
		padding : 5px 20px;
	}
</style>
</head>
<body>
	<h1> Thank you 
		<%= session.getAttribute("user") %>
	</h1>
	<hr>
	<h2>Here is your Summary : </h2>
	<hr>
	<table>
		<tr>
			<th>Item Name </th>
			<th> Price</th>
			<th>Quantity </th>
		</tr>
		<% 
			int count = Integer.parseInt(session.getAttribute("ProductCount").toString());
			String items[] = (String[])session.getAttribute("ProductName");
			int price[] = (int[])session.getAttribute("ProductPrice");
			int quntity[]  = (int[])session.getAttribute("ProductQuantity");
			
			for(int i=0;i<count;i++){
				out.write("<tr>");
				out.write("<td>"+items[i]+ "</td>");
				out.write("<td>" + price[i] + "</td>");
				out.write("<td>"+ quntity[i] + "</td>");
				out.write("</tr>");
			
			}
		%>
	</table>
	<hr>
	<h2>Total Amount :- 
		<%= session.getAttribute("Total") %>
	</h2>
</body>
</html>
