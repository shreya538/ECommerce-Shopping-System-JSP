<%@ page import="java.util.List, com.wipro.eshop.bean.EShopBean" %>

<html>
<body>

<%
Object obj = request.getAttribute("list");

if (obj instanceof List<?>) {

    List<?> temp = (List<?>) obj;

    for (Object o : temp) {

        EShopBean bean = (EShopBean) o;
%>

<hr>
Order ID: <%= bean.getOrderId() %><br>
Customer: <%= bean.getCustomerName() %><br>
Product: <%= bean.getProductName() %><br>
Price: <%= bean.getPrice() %><br>

<%
    }

} else {
%>

<h3>No records available!</h3>

<%
}
%>

</body>
</html>
