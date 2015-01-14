package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Product;
import dbhelper.DBHelper;

public class ProductService implements IService {

	@Override
	public List getList() {
		List productList = new ArrayList();
		String sql = "select * from product";
		ResultSet rs = DBHelper.executeQuery(sql);

		try {
			while (rs.next()) {
				Product product = new Product();

				product.setAuthor(rs.getString("author"));
				product.setBasePrice(rs.getString("basePrice"));
				product.setCategory(rs.getString("categoryid"));
				product.setDescription(rs.getString("description"));
				product.setImages(rs.getString("images"));
				product.setName(rs.getString("name"));
				product.setPages(rs.getString("pages"));
				product.setProductID(rs.getString("productid"));
				product.setPublish(rs.getString("publish"));
				productList.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelper.free(rs);
		}

		return productList;
	}

	@Override
	public List getList(String s) {
		// TODO Auto-generated method stub
		return null;
	}

}
