<html>
<body>

<%
String msg = (String) request.getAttribute("msg");

if(msg != null){
%>
<h3><%=msg%></h3>
<%
} else {
com.wipro.eshop.bean.EShopBean bean =
(com.wipro.eshop.bean.EShopBean) request.getAttribute("order");
%>

Order ID: <%=bean.getOrderId()%><br>
Customer: <%=bean.getCustomerName()%><br>
Product: <%=bean.getProductName()%><br>
Quantity: <%=bean.getQuantity()%><br>
Price: <%=bean.getPrice()%><br>
Remarks: <%=bean.getRemarks()%><br>

<%
}
%>

</body>
</html>
