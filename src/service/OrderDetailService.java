package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.OrderDetail;
import dbhelper.DBHelper;

public class OrderDetailService implements IService {

	@Override
	public List getList() {return null;}

	@Override
	public List getList(String s) {
		// TODO Auto-generated method stub
		List OrderDetailList = new ArrayList();
		String[] ss = s.split(",");
		System.out.print(ss[0]);
		String sql = "select orders.userid,contactinfo.zip,contactinfo.street1,contactinfo.cellphone,contactinfo.homephone,contactinfo.email,contactinfo.officephone from orders,contactinfo where orders.userid=? and orders.userid = contactinfo.userid";
		ResultSet rs = DBHelper.executeQuery(sql, ss[1]);
		try {
			OrderDetail detail = new OrderDetail();
			while (rs.next()) {
			detail.setUserId(rs.getString(1));
			detail.setZip(rs.getString("contactinfo.zip"));
			detail.setStreet1(rs.getString("contactinfo.street1"));
			detail.setCellphone(rs.getString("contactinfo.cellphone"));
			detail.setEmail(rs.getString("contactinfo.email"));
			detail.setHomephone(rs.getString("contactinfo.homephone"));
			detail.setOfficephone(rs.getString("contactinfo.officephone"));
			}
			sql = "select payway.paystyle from orders,payway where orders.paywayid=? and orders.paywayid = payway.paywayid";
			
			rs = DBHelper.executeQuery(sql,ss[2]);
			while (rs.next()) {
			detail.setPaystyle(rs.getString(1));
			}
			sql = "select orderline.lineid, product.name, product.basePrice,"
					+ " orderline.amount from orders,orderline,product where orders.orderid=? "
					+ "and orders.orderid = orderline.orderid "
					+ "and orderline.productid = product.productid";
	
			rs = DBHelper.executeQuery(sql, ss[0]);
			while (rs.next()) {
			detail.setAmount(rs.getString("orderline.amount"));
			detail.setName(rs.getString("product.name"));
			detail.setBasePrice(rs.getString("product.basePrice"));
			detail.setLineid(rs.getString("orderline.lineid"));
			double price = Double.parseDouble(detail.getAmount())
					* Double.parseDouble(detail.getBasePrice());
			detail.setTotalPrice(String.valueOf(price));
			}
			OrderDetailList.add(detail);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelper.free(rs);
		}

		return OrderDetailList;
	}

}
