package com.wipro.eshop.service;

import java.util.Date;
import java.util.List;

import com.wipro.eshop.bean.EShopBean;
import com.wipro.eshop.dao.EShopDAO;
import com.wipro.eshop.util.InvalidInputException;

public class Administrator {

    public String addRecord(EShopBean bean) {

        try {

            if (bean == null || bean.getCustomerName() == null || bean.getOrderDate() == null) {
                throw new InvalidInputException();
            }

            if (bean.getCustomerName().length() < 2) {
                return "INVALID CUSTOMER NAME";
            }

            if (bean.getQuantity() < 1 || bean.getPrice() <= 0) {
                return "INVALID ORDER DETAILS";
            }

            EShopDAO dao = new EShopDAO();

            if (dao.recordExists(bean.getCustomerName(), bean.getOrderDate())) {
                return "ALREADY EXISTS";
            }

            String orderId = dao.generateOrderID(bean.getCustomerName(), bean.getOrderDate());

            bean.setOrderId(orderId);

            return dao.createRecord(bean);

        } catch (Exception e) {
            e.printStackTrace();  
            return "FAIL";
        }

    }

    public EShopBean viewRecord(String customerName, Date orderDate) {
        return new EShopDAO().fetchRecord(customerName, orderDate);
    }

    public List<EShopBean> viewAllRecords() {
        return new EShopDAO().fetchAllRecords();
    }
}
