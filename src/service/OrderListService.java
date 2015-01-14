package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.OrderList;
import dbhelper.DBHelper;

public class OrderListService implements IService{
	

	@Override
	public List getList() {

    	List orderList = new ArrayList();
    	String sql = "select * from orders ,orderstatus,payway"+
    	" where orders.statusid = orderstatus.statusid and  orders.paywayid = payway.paywayid ";
		ResultSet rs = DBHelper.executeQuery(sql);
		try {
			while (rs.next()) {
				OrderList  order = new OrderList();

				order.setOrderid(Integer.parseInt(rs.getString("orders.orderid")));
				order.setName(rs.getString("orders.name"));
				order.setCost(Double.parseDouble(rs.getString("orders.cost")));
				order.setStatusname(rs.getString("orderstatus.name"));
				order.setPaystyle(rs.getString("payway.paystyle"));
				order.setUserid(rs.getString("orders.userid"));
				order.setPaywayid(rs.getString("orders.paywayid"));
				
				orderList.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelper.free(rs);
		}

		return orderList;
	}

	@Override
	public List getList(String s) {
		// TODO Auto-generated method stub
		return null;
	}

}
