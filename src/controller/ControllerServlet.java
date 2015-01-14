package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Category;
import service.IService;
import service.IServiceFactory;
import service.ServiceFactory;

public class ControllerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String path = req.getServletPath();
		path = path.substring(0, path.indexOf("."));
		if ("/toproductList".equals(path)) {
			try{
				IServiceFactory sFactory = new ServiceFactory(); 
				IService ps =sFactory.createProductService(); 

				List productList = ps.getList();
 				req.setAttribute("productList", productList);
 				
 				getServletContext().getRequestDispatcher("/productList").forward(req, resp);
 				
 			} catch (Exception e){
 				req.setAttribute("message", e.getMessage());
 				
 				getServletContext().getRequestDispatcher("/error").forward(req, resp);
 			}			
		} else if ("/toproductDetailServlet".equals(path)) {
			try{
				
				IServiceFactory sFactory = new ServiceFactory(); 
				IService cs =sFactory.createCategoryService(); 

				
				String s=null;
				s=req.getQueryString();
				String[] ss = s.split("=");
				List productDetailsList = cs.getList(ss[ss.length-1]);
				req.setAttribute("productDetailsList", productDetailsList);
				getServletContext().getRequestDispatcher("/productDetail").forward(req, resp);
			} catch(Exception e){
				
			}
		} else {
			resp.sendError(resp.SC_NOT_FOUND);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
