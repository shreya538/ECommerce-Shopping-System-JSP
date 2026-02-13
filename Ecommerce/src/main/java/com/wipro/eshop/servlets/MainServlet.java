package com.wipro.eshop.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import com.wipro.eshop.bean.EShopBean;
import com.wipro.eshop.service.Administrator;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String addRecord(HttpServletRequest request) {

        try {

            EShopBean bean = new EShopBean();

            bean.setCustomerName(request.getParameter("customerName"));
            bean.setProductName(request.getParameter("productName"));

            String date = request.getParameter("orderDate");
            Date d = new SimpleDateFormat("yyyy-MM-dd").parse(date);



            bean.setOrderDate(d);

            bean.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            bean.setPrice(Double.parseDouble(request.getParameter("price")));
            bean.setRemarks(request.getParameter("remarks"));

            return new Administrator().addRecord(bean);

        } catch (Exception e) {
            return "FAIL";
        }
    }

    public EShopBean viewRecord(HttpServletRequest request) {

        try {

            String customerName = request.getParameter("customerName");

            String date = request.getParameter("orderDate");

            Date d = new SimpleDateFormat("yyyy-MM-dd").parse(date);



            return new Administrator().viewRecord(customerName, d);

        } catch (Exception e) {
            return null;
        }
    }

    public List<EShopBean> viewAllRecords(HttpServletRequest request) {

        return new Administrator().viewAllRecords();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String operation = req.getParameter("operation");

        if (operation.equals("newRecord")) {

            String result = addRecord(req);

            if (!result.equals("FAIL") &&
                !result.equals("ALREADY EXISTS") &&
                !result.equals("INVALID CUSTOMER NAME") &&
                !result.equals("INVALID ORDER DETAILS")) {

                resp.sendRedirect("success.html");
            } 
            else if (result.equals("ALREADY EXISTS") ||
                     result.equals("INVALID CUSTOMER NAME") ||
                     result.equals("INVALID ORDER DETAILS")) {

                resp.setContentType("text/html");
                resp.getWriter().println("<h2>" + result + "</h2>");
            } 
            else {
                resp.sendRedirect("error.html");
            }
        }

        else if (operation.equals("viewRecord")) {

            EShopBean bean = viewRecord(req);

            if (bean == null) {

                req.setAttribute("msg", "No matching records exists! Please try again!");

                RequestDispatcher rd = req.getRequestDispatcher("displayOrder.jsp");

                rd.forward(req, resp);

            } else {

                req.setAttribute("order", bean);

                RequestDispatcher rd = req.getRequestDispatcher("displayOrder.jsp");

                rd.forward(req, resp);
            }
        }

        else if (operation.equals("viewAllRecords")) {

            List<EShopBean> list = viewAllRecords(req);

            if (list.isEmpty()) {

                req.setAttribute("msg", "No records available!");

                RequestDispatcher rd = req.getRequestDispatcher("displayAllOrders.jsp");

                rd.forward(req, resp);

            } else {

                req.setAttribute("list", list);

                RequestDispatcher rd = req.getRequestDispatcher("displayAllOrders.jsp");

                rd.forward(req, resp);
            }
        }
    }
}
