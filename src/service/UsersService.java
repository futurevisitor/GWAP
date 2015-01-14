package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Users;
import dbhelper.DBHelper;

public class UsersService implements IService{
	

	@Override
	public List getList() {

		List usersList = new ArrayList();
		String sql = "select * from users";
		ResultSet rs = DBHelper.executeQuery(sql);

		try {
			while (rs.next()) {
				Users user = new Users();
				user.setUserId(rs.getString("userid"));
				user.setPassword(rs.getString("password"));
				usersList.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelper.free(rs);
		}

		return usersList;
	}

	@Override
	public List getList(String s) {
		// TODO Auto-generated method stub
		return null;
	}
}
