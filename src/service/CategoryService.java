package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Category;
import dbhelper.DBHelper;

public class CategoryService implements IService {

	@Override
	public List getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getList(String s) {

		List categoryList = new ArrayList();
		String sql = "select * from category,product where productid=?";	
		if(s.isEmpty()){
			s="1";
		}
		ResultSet rs = DBHelper.executeQuery(sql,s);

		try {
			while (rs.next()) {
				Category category = new Category();
				category.setCategoryID(rs.getString("categoryid"));
				category.setDescription(rs.getString("product.description"));
				category.setName(rs.getString("product.name"));
				category.setAuthor(rs.getString("author"));
				category.setBasePrice(rs.getString("basePrice"));
				category.setImages(rs.getString("images"));
				category.setcateName(rs.getString("category.name"));
				category.setPages(rs.getString("pages"));
				category.setProductid(rs.getString("productid"));
				category.setPublish(rs.getString("publish"));
				categoryList.add(category);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelper.free(rs);
		}

		return categoryList;
	}

}
