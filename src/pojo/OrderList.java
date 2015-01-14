package pojo;

public class OrderList {
	private int orderid;
	private String name;
	private double cost;
	private String statusname;
	private String paystyle;
	private String userid;
	private String paywayid;

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPaystyle() {
		return paystyle;
	}

	public void setPaystyle(String paystyle) {
		this.paystyle = paystyle;
	}

	public String getStatusname() {
		return statusname;
	}

	public void setStatusname(String statusname) {
		this.statusname = statusname;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPaywayid() {
		return paywayid;
	}

	public void setPaywayid(String paywayid) {
		this.paywayid = paywayid;
	}

}
