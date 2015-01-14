package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.ContactInfo;
import dbhelper.DBHelper;

public class ContactInfoService implements IService {

	@Override
	public List getList() {
		List contactInfoList = new ArrayList();
		String sql = "select * from contactinfo where userid=?";
		Object[] obj = new Object[]{"admin"};
		ResultSet rs = DBHelper.executeQuery(sql,obj);

		try {
			while (rs.next()) {
				ContactInfo info = new ContactInfo();
				info.setUserId(rs.getString("userid"));
				info.setCountry(rs.getString("country"));
				info.setProvince(rs.getString("province"));
				info.setCity(rs.getString("city"));
				info.setZip(rs.getString("zip"));
				info.setStreet1(rs.getString("street1"));
				info.setStreet2(rs.getString("street2"));
				info.setCellphone(rs.getString("cellphone"));
				info.setEmail(rs.getString("email"));
				info.setHomephone(rs.getString("homephone"));
				info.setOfficephone(rs.getString("officephone"));
				contactInfoList.add(info);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelper.free(rs);
		}

		return contactInfoList;
	}

	@Override
	public List getList(String s) {
		List contactInfoList = new ArrayList();
		String sql = "select * from contactinfo where userid=?";
		Object[] obj = new Object[]{s};
		ResultSet rs = DBHelper.executeQuery(sql,obj);

		try {
			while (rs.next()) {
				ContactInfo info = new ContactInfo();
				info.setUserId(rs.getString("userid"));
				info.setCountry(rs.getString("country"));
				info.setProvince(rs.getString("province"));
				info.setCity(rs.getString("city"));
				info.setZip(rs.getString("zip"));
				info.setStreet1(rs.getString("street1"));
				info.setStreet2(rs.getString("street2"));
				info.setCellphone(rs.getString("cellphone"));
				info.setEmail(rs.getString("email"));
				info.setHomephone(rs.getString("homephone"));
				info.setOfficephone(rs.getString("officephone"));
				contactInfoList.add(info);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelper.free(rs);
		}

		return contactInfoList;
	}
}
