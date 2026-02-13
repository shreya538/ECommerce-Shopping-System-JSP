<html>
<body>
<h3>Add Order</h3>

<form action="MainServlet" method="post">

<input type="hidden" name="operation" value="newRecord">

Customer Name: <input type="text" name="customerName"><br>
Product Name: <input type="text" name="productName"><br>
Order Date:<input type="date" name="orderDate">
<br>
Quantity: <input type="number" name="quantity"><br>
Price: <input type="number" name="price"><br>
Remarks: <input type="text" name="remarks"><br>
<input type="submit" value="Add Order">

</form>
</body>
</html>
