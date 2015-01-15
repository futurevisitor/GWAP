package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.IService;
import service.IServiceFactory;
import service.ServiceFactory;

public class ControllerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String path = req.getServletPath();

		path = path.substring(0, path.indexOf("."));
		if ("/userManage".equals(path)) {
			try {
				IServiceFactory sFactory = new ServiceFactory();
				IService usersService = sFactory.createUsersService();
				List usersList = usersService.getList();
				req.setAttribute("usersList", usersList);

				getServletContext().getRequestDispatcher("/userManage")
						.forward(req, resp);
			} catch (Exception e) {

			}

		} else if ("/userModify".equals(path)) {
			try {
				String s = req.getParameter("id");
				IServiceFactory sFactory = new ServiceFactory();
				IService infoService = sFactory.createContactInfoService();

				List infoList = infoService.getList(s);
				req.setAttribute("infoList", infoList);

				getServletContext().getRequestDispatcher("/userModify")
						.forward(req, resp);
			} catch (Exception e) {

			}

		} else if ("/toproductList".equals(path)) {
			try {
				IServiceFactory sFactory = new ServiceFactory();
				IService ps = sFactory.createProductService();

				List productList = ps.getList();
				req.setAttribute("productList", productList);

				getServletContext().getRequestDispatcher("/productList")
						.forward(req, resp);

			} catch (Exception e) {
				req.setAttribute("message", e.getMessage());

				getServletContext().getRequestDispatcher("/error").forward(req,
						resp);
			}
		} else if ("/toproductDetailServlet".equals(path)) {
			try {

				IServiceFactory sFactory = new ServiceFactory();
				IService cs = sFactory.createCategoryService();

				String s = null;
				s = req.getQueryString();
				String[] ss = s.split("=");
				List productDetailsList = cs.getList(ss[ss.length - 1]);
				req.setAttribute("productDetailsList", productDetailsList);
				getServletContext().getRequestDispatcher("/productDetail")
						.forward(req, resp);
			} catch (Exception e) {

			}
		} else if ("/orderList".equals(path)) {
			try {

				IServiceFactory sFactory = new ServiceFactory();
				IService ord = sFactory.createOrderListService();
				List orderList = ord.getList();

				req.setAttribute("orderList", orderList);
				getServletContext().getRequestDispatcher("/orderList").forward(
						req, resp);

			} catch (Exception e) {
				req.setAttribute("message", e.getMessage());
				getServletContext().getRequestDispatcher("/error").forward(req,
						resp);
			}

		} else if ("/orderDetail".equals(path)) {
			try {
				String s = req.getParameter("id");
				IServiceFactory sFactory = new ServiceFactory();
				IService ord = sFactory.createOrderDetailService();

				List orderDetail = ord.getList(s);

				req.setAttribute("orderDetail", orderDetail);
				getServletContext().getRequestDispatcher("/orderDetail")
						.forward(req, resp);

			} catch (Exception e) {
				req.setAttribute("message", e.getMessage());
				getServletContext().getRequestDispatcher("/error").forward(req,
						resp);
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
