package com.wipro.eshop.dao;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import com.wipro.eshop.bean.EShopBean;
import com.wipro.eshop.util.DBUtil;

public class EShopDAO {

    public String generateOrderID(String customerName, Date orderDate) {

        try {

            Connection con = DBUtil.getDBConnection();

            String query = "SELECT ESHOP_SEQ.NEXTVAL FROM DUAL";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            int seq = 0;

            if (rs.next()) {
                seq = rs.getInt(1);
            }

            DateFormat f = new SimpleDateFormat("yyyyMMdd");

            String datePart = f.format(orderDate);

            String namePart = customerName.substring(0, 2).toUpperCase();

            return datePart + namePart + seq;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public String createRecord(EShopBean bean) {

        try {

            Connection con = DBUtil.getDBConnection();

            String query = "INSERT INTO ESHOP_TB VALUES(?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, bean.getOrderId());
            ps.setString(2, bean.getCustomerName());
            ps.setString(3, bean.getProductName());
            ps.setDate(4, new java.sql.Date(bean.getOrderDate().getTime()));
            ps.setInt(5, bean.getQuantity());
            ps.setDouble(6, bean.getPrice());
            ps.setString(7, bean.getRemarks());

            int result = ps.executeUpdate();

            if (result > 0)
                return bean.getOrderId();
            else
                return "FAIL";

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "FAIL";
    }

    public EShopBean fetchRecord(String customerName, Date orderDate) {

        try {

            Connection con = DBUtil.getDBConnection();

            String query = "SELECT * FROM ESHOP_TB WHERE CUSTOMERNAME=? AND TRUNC(ORDER_DATE)=TRUNC(?)";


            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, customerName);
            ps.setDate(2, new java.sql.Date(orderDate.getTime()));

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                EShopBean bean = new EShopBean();

                bean.setOrderId(rs.getString(1));
                bean.setCustomerName(rs.getString(2));
                bean.setProductName(rs.getString(3));
                bean.setOrderDate(rs.getDate(4));
                bean.setQuantity(rs.getInt(5));
                bean.setPrice(rs.getDouble(6));
                bean.setRemarks(rs.getString(7));

                return bean;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean recordExists(String customerName, Date orderDate) {

        EShopBean bean = fetchRecord(customerName, orderDate);

        if (bean != null)
            return true;
        else
            return false;
    }

    public List<EShopBean> fetchAllRecords() {

        List<EShopBean> list = new ArrayList<>();

        try {

            Connection con = DBUtil.getDBConnection();

            String query = "SELECT * FROM ESHOP_TB";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                EShopBean bean = new EShopBean();

                bean.setOrderId(rs.getString(1));
                bean.setCustomerName(rs.getString(2));
                bean.setProductName(rs.getString(3));
                bean.setOrderDate(rs.getDate(4));
                bean.setQuantity(rs.getInt(5));
                bean.setPrice(rs.getDouble(6));
                bean.setRemarks(rs.getString(7));

                list.add(bean);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
