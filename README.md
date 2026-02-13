---E-Commerce Shopping System
        

-->The E-Commerce Shopping System is a web-based application developed using Java (JSP & Servlets), JDBC, and Oracle Database.

->This application allows users to:

- Add new orders
- View a specific order
- View all orders

->Technologies
- Tech Stack
-Java 
-JSP & Servlets
-JDBC
-Oracle Database (XE)
-HTML
-Apache Tomcat Server

-> Project Structure
    com.wipro.eshop
    │
    ├── util
    │   ├── DBUtil.java
    │   └── InvalidInputException.java
    │
    ├── bean
    │   └── EShopBean.java
    │
    ├── dao
    │   └── EShopDAO.java
    │
    ├── service
    │   └── Administrator.java
    │
    └── servlets
        └── MainServlet.java

 -> Features
 
 1. Add Order
Validates:
-Customer name length (minimum 2 characters)
-Quantity > 0
-Price > 0
-Duplicate record check

 2. View Order
Search using:
-Customer Name
-Order Date
-->Displays:
-Order details if found
-Proper message if no record exists

 3.View All Orders
-Displays all records from database
-Shows message if no records available


<img width="512" height="279" alt="image" src="https://github.com/user-attachments/assets/74264d2b-93f1-4beb-8259-df374ac6d1f5" />
<img width="358" height="96" alt="image" src="https://github.com/user-attachments/assets/5f7f9827-1eff-400d-b6c9-6e9ec2871611" />
<img width="338" height="99" alt="image" src="https://github.com/user-attachments/assets/a1422ab7-db7d-4558-a433-b29d8852e38f" />
<img width="532" height="185" alt="image" src="https://github.com/user-attachments/assets/9e59a348-b535-489c-b2e7-13911a4cc808" />
<img width="433" height="235" alt="image" src="https://github.com/user-attachments/assets/0332966a-cdf8-41bd-8ec0-972413a2e806" />
<img width="306" height="103" alt="image" src="https://github.com/user-attachments/assets/0784ba47-60cf-4119-b4ba-d4544b2f3c33" />
<img width="272" height="410" alt="image" src="https://github.com/user-attachments/assets/0c7ad437-7b46-4e7e-b9c7-c4484b79cc12" />










