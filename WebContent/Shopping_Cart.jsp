<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping Cart</title>
</head>
<body>
	<h1>Welcome <%= request.getAttribute("user") %>  </h1>
	<%
		HttpSession ses =  request.getSession();
		ses.setAttribute("user", request.getAttribute("user"));
	%>
	<form action="Cart" method="post">
		<table>
			<thead>
				<tr>
					<th>Product Number </th>
					<th>Product Name </th>
					<th>Product Price </th>
					<th>Product Quantity</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>Cosmetics</td>
					<td>2500</td>
					<td>
				<input type="number" value=0 name="Product0" min=0 max=10>
					</td>
				</tr>
				<tr>
					<td>2</td>
					<td>HeadPhone Covers</td>
					<td>1800</td>
					<td>
				<input type="number" value=0 name="Product1" min=0 max=10>
					</td>
				</tr>
				<tr>
					<td>3</td>
					<td>AirPods</td>
					<td>3000</td>
					<td>
				<input type="number" value=0 name="Product2" min=0 max=10>
					</td>
				</tr>
				<tr>
					<td>4</td>
					<td>Smart Phone</td>
					<td>25000</td>
					<td>
				<input type="number" value=0 name="Product3" min=0 max=10>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
				<td colspan="4">
					<input type="submit" value="Add to Cart">
				</td>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>
