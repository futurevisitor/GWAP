package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.ContactInfo;
import pojo.OrderDetail;
import service.IService;
import service.IServiceFactory;
import service.OrderDetailService;
import service.ServiceFactory;

public class orderDetailServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List orderDetailList = (List) req.getAttribute("orderDetail");
		
		resp.setCharacterEncoding("GBK");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("	<head>");
		out.println("		<title>达内电子商务门户</title>");
		out.println("		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=GBK\">");
		out.println("		<meta name=\"description\" content=\"达内电子商务门户\">");
		out.println("		<link href=\"css/tarena.css\" rel=stylesheet>");
		out.println("	</head>");
		out.println("	<body topmargin=\"0\" leftmargin=\"0\" rightmargin=\"0\" bottommargin=\"0\">");

		out.println("<!-- Header Start -->");
		out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"table2\">");
		out.println("			<tr>");
		out.println("				<td align=\"left\" width=\"7%\" background=\"images/top_bg.gif\"><img src=\"images/logo.gif\" width=\"286\" height=\"58\"></td>");
		out.println("				<td width=\"62%\" background=\"images/top_bg.gif\">　</td>");
		out.println("				<td width=\"31%\" background=\"images/top_bg.gif\" align=\"right\"><img src=\"images/top_r.gif\" width=\"352\" height=\"58\" border=\"0\"></td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");

		out.println("			<tr>");
		out.println("				<td background=\"images/dh_bg.gif\" align=\"left\" height=\"12\">");
		out.println("					<table width=\"100\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">");
		out.println("						<tr>");
		out.println("							<td width=\"5%\"></td>");

		out.println("          <td width=\"10%\"><a href=\"productList.jsp\"><img name=\"Image1\" border=\"0\" src=\"images/index.gif\" width=\"90\" height=\"36\"></a></td>");

		out.println("          <td width=\"10%\"><a href=\"userManage.jsp\"><img name=\"Image2\" border=\"0\" src=\"images/reg.gif\" width=\"92\" height=\"36\"></a></td>");

		out.println("          <td width=\"10%\"><a href=\"shoppingCart.jsp\"><img name=\"Image4\" border=\"0\" src=\"images/cart.gif\" width=\"92\" height=\"36\"></a></td>");

		out.println("          <td width=\"10%\"><a href=\"orderList.jsp\"><img name=\"Image5\" border=\"0\" src=\"images/order.gif\" width=\"92\" height=\"36\"></a></td>");

		out.println("          <td width=\"10%\"><a href=\"productList.jsp\"><img name=\"Image6\" border=\"0\" src=\"images/exit.gif\" width=\"92\" height=\"36\"></a></td>");
		out.println("						</tr>");
		out.println("					</table>");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("		<table cellspacing=\"1\" cellpadding=\"3\" align=\"center\" border=\"0\" width=\"98%\">");
		out.println("			<tr>");
		out.println("				<td width=\"65%\"><br>");

		out.println("					>> 欢迎访问 <b>达内电子商务门户</b>");
		out.println("				</td>");
		out.println("				<td width=\"35%\" align=\"right\">");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("<!-- Header End -->");
		out.println("<!-- Body Start -->");
		for (Iterator<OrderDetail> it = orderDetailList.iterator(); it
				.hasNext();) {
			OrderDetail detail = it.next();

			out.println("<table cellspacing=\"1\" cellpadding=\"3\" align=\"center\" class=\"tableBorder2\">");
			out.println("			<tr>");
			out.println("				<td height=\"25\" valign=\"middle\">");
			out.println("					<img src=\"images/Forum_nav.gif\" align=\"absmiddle\">");
			out.println("					<a href=index.jsp>达内电子商务门户</a> → <a href=\"orderList\">定单列表</a>  → <b>定单明细</b>");
			out.println("				</td>");
			out.println("			</tr>");
			out.println("		</table>");
			out.println("		<br>");

			out.println("		<table cellpadding=\"3\" cellspacing=\"1\" align=\"center\" class=\"tableborder1\">");
			out.println("			<tr>");
			out.println("				<td colspan=\"2\" valign=\"middle\" align=\"center\" height=\"25\" background=\"images/bg2.gif\" width=\"8%\">");
			out.println("					<font color=\"#ffffff\">");
			out.println("						<b>用户信息</b>");
			out.println("					</font>");
			out.println("				</td>");
			out.println("			</tr>");

			out.println("			<tr>");
			out.println("				<td class=tablebody2 valign=\"middle\" align=\"right\" width=\"40%\">");
			out.println("					<b>用户名：</b>");
			out.println("				</td>");

			out.println("    			<td class=tablebody1 valign=\"middle\" width=\"60%\"> ");
			out.println(detail.getUserid());

			out.println("    			</td>");
			out.println("			</tr>");
			out.println("			<tr>");
			out.println("				<td class=tablebody2 valign=\"middle\" align=\"right\" width=\"40%\">");
			out.println("					<b>联系地址：</b>");
			out.println("				</td>");

			out.println("    			<td class=tablebody1 valign=\"middle\" width=\"60%\"> ");
			out.println(detail.getStreet1());

			out.println("    			</td>");
			out.println("			</tr>");
			out.println("			<tr>");
			out.println("				<td class=tablebody2 valign=\"middle\" align=\"right\" width=\"40%\">");
			out.println("					<b>邮编：</b>");
			out.println("				</td>");

			out.println("    			<td class=tablebody1 valign=\"middle\" width=\"60%\"> ");
			out.println(detail.getZip());

			out.println("    			</td>");
			out.println("			</tr>");
			out.println("			<tr>");
			out.println("				<td class=tablebody2 valign=\"middle\" align=\"right\" width=\"40%\">");
			out.println("					<b>家庭电话：</b>");
			out.println("				</td>");

			out.println("    			<td class=tablebody1 valign=\"middle\" width=\"60%\"> ");
			out.println(detail.getHomephone());

			out.println("    			</td>");
			out.println("			</tr>");
			out.println("			<tr>");
			out.println("				<td class=tablebody2 valign=\"middle\" align=\"right\" width=\"40%\">");
			out.println("					<b>办公室电话：</b>");
			out.println("				</td>");

			out.println("    			<td class=tablebody1 valign=\"middle\" width=\"60%\"> ");
			out.println(detail.getOfficephone());

			out.println("    			</td>");
			out.println("			</tr>");
			out.println("			<tr>");
			out.println("				<td class=tablebody2 valign=\"middle\" align=\"right\" width=\"40%\">");
			out.println("					<b>手机：</b>");
			out.println("				</td>");

			out.println("    			<td class=tablebody1 valign=\"middle\" width=\"60%\"> ");
			out.println(detail.getCellphone());

			out.println("    			</td>");
			out.println("			</tr>");
			out.println("			<tr>");
			out.println("				<td class=tablebody2 valign=\"middle\" align=\"right\" width=\"40%\">");
			out.println("					<b>Email地址：</b>");
			out.println("				</td>");

			out.println("    			<td class=tablebody1 valign=\"middle\" width=\"60%\"> ");
			out.println(detail.getEmail());

			out.println("    			</td>");
			out.println("			</tr>");

			out.println("		</table>");
			out.println("		<br>");
			out.println("		<table cellpadding=\"3\" cellspacing=\"1\" align=\"center\" class=\"tableborder1\">");
			out.println("			<tr>");
			out.println("				<td colspan=\"2\" valign=\"middle\" align=\"center\" height=\"25\" background=\"images/bg2.gif\" width=\"8%\">");
			out.println("					<font color=\"#ffffff\">");
			out.println("						<b>付款方式</b>");
			out.println("					</font>");
			out.println("				</td>");
			out.println("			</tr>");

			out.println("			<tr>");
			out.println("				<td class=tablebody2 valign=\"middle\" align=\"right\" width=\"40%\">");
			out.println("					");
			out.println("				</td>");

			out.println("    			<td class=tablebody1 valign=\"middle\" width=\"60%\"> ");
			out.println(detail.getPaystyle());

			out.println("    			</td>");
			out.println("			</tr>");

			out.println("		</table>");
			out.println("		<br>");

			out.println("		<table cellpadding=\"3\" cellspacing=\"1\" align=\"center\" class=\"tableborder1\">");
			out.println("		<tr>");
			out.println("				<td colspan=\"5\" valign=\"middle\" align=\"center\" height=\"25\" background=\"images/bg2.gif\" width=\"8%\">");
			out.println("					<font color=\"#ffffff\">");
			out.println("						<b>商品购物清单</b>");
			out.println("					</font>");
			out.println("				</td>");
			out.println("			</tr>");

			out.println("			<tr>");
			out.println("				<td class=tablebody2 valign=\"middle\"  align=\"center\" width=\"3%\">");
			out.println(detail.getLineid());

			out.println("				</td>");

			out.println("    			<td class=tablebody1 valign=\"middle\" width=\"50%\"> ");
			out.println(detail.getName());

			out.println("    			</td>");
			out.println("    			<td class=tablebody2 valign=\"middle\" align=\"center\" width=\"18%\"> ");
			out.println("    			价格：" + detail.getBasePrice());
			out.println("    			</td>");
			out.println("    			<td class=tablebody1 valign=\"middle\" align=\"center\" width=\"14%\"> ");
			out.println("    			数量：" + detail.getAmount());
			out.println("    			</td>");
			out.println("    			<td class=tablebody2 valign=\"middle\" width=\"25%\"> ");
			out.println("    			小计：￥" + detail.getTotalPrice());
			out.println("    			</td>");
			out.println("			</tr>");

			out.println("			<tr>");
			out.println("			<td colspan=\"4\" class=tablebody1 valign=\"middle\" width=\"75%\">");

			out.println("				</td>");
			out.println("			<td class=tablebody1 valign=\"middle\" width=\"25%\"> ");
			out.println("    			合计：<font color=\"red\"><b>￥"+detail.getTotalPrice()+"</b><font>");
			out.println("    			</td>");
			out.println("			</tr>");
			out.println("		</table>");

			out.println("		<br>");
			out.println("		<br>");

			out.println("<!-- Body End -->");
			out.println("<!-- Footer Start -->");
			out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" height=\"28\">");
			out.println("			<tr>");
			out.println("				<td height=\"17\" background=\"images/bot_bg.gif\">");
			out.println("				</td>");
			out.println("			</tr>");
			out.println("		</table>");

			out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">");
			out.println("			<tr>");
			out.println("				<td bgcolor=\"#f1f1f6\" height=\"53\" valign=\"center\">");
			out.println("					<p align=\"center\">");
			out.println("						Copyright &copy;2004 - 2005 <a href=\"http://www.tarena.com.cn\"><b>Tarena</b><font color=\"red\">.com.cn</font></a>");
			out.println("					</p>");
			out.println("				</td>");

			out.println("			</tr>");
			out.println("		</table>");
		}
		out.println("<!-- Footer End -->");
		out.println("	</body>");
		out.println("</html>");
		out.close();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	}

}
