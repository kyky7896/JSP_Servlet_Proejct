package order;

import java.sql.Date;

public class Order {
	private int num;
	private int prod_num;
	private int amount;
	private int payment;
	private Date w_date;
	private String consumer;
	private String addr;
	private boolean ispay;
	private int price;

	public Order() {

	}


	public Order(int num, int prod_num, int amount, int payment, Date w_date, String consumer, String addr, boolean ispay, int price) {
		this.num = num;
		this.prod_num = prod_num;
		this.amount = amount;
		this.payment = amount*price;
		this.w_date = w_date;
		this.consumer = consumer;
		this.addr = addr;
		this.ispay = ispay;
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getProd_num() {
		return prod_num;
	}

	public void setProd_num(int prod_num) {
		this.prod_num = prod_num;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public Date getW_date() {
		return w_date;
	}

	public void setW_date(Date w_date) {
		this.w_date = w_date;
	}

	public String getConsumer() {
		return consumer;
	}

	public void setConsumer(String consumer) {
		this.consumer = consumer;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public boolean isIspay() {
		return ispay;
	}

	public void setIspay(boolean ispay) {
		this.ispay = ispay;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


}


