package com.acme.domain;
import java.util.Arrays;

import com.acme.utils.MyDate;

public class Order {
	private MyDate orderDate;
	private double orderAmount = 0.00;
	private String customer;
	private Product product;
	private int quantity;
	public static double taxRate = 0.05;
	
	private static Rushable rushable;
	
	public Order(MyDate d, double amt, String c, Product p, int q){
		setOrderDate(d);
		orderAmount=amt;
		customer=c;
		product=p;
		quantity=q;
	}
	
	public char jobSize(){
		char size;
		if(this.quantity <= 25)
			size = 'S';
		else if(this.quantity <= 75)
			size = 'M';
		else if(this.quantity <= 150)
			size = 'L';
		else
			size = 'X';
		
		return size;
	}
	
	public double computeTotal() {
		double total = this.orderAmount;
		switch(this.jobSize()){
			case 'M':
				total = total * 0.01;
				break;
			case 'L':
				total = total * 0.02;
				break;
			case 'X':
				total = total * 0.03;
				break;
		}
		
		if (total < 1500){
			total = total + this.computeTax();
		}
		
		return total;
	}
	
	public double computeTax() {
		System.out.println("The tax for this order is: " + orderAmount	* Order.taxRate);
		return this.orderAmount * Order.taxRate;
	}

	
	public static void setTaxRate(double newRate) {
		taxRate = newRate;
	}
	
	public static void computeTaxOn(double anAmount){
		System.out.println("The tax for " + anAmount + " is: " + anAmount * Order.taxRate);
	}
	
	public String toString(){
		return quantity + " ea. " + product + " for " + customer; 
	}

	public MyDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(MyDate orderDate) {
		if (isHoliday(orderDate)) {
			 System.out.println("Order date, " + orderDate + ", cannot be set to a holiday!");
		} else {
			this.orderDate = orderDate;
		}
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if(quantity <= 0){
			System.out.println("Attempting to set the quantity to a value less than or equal to zero");
			return;
		}
		this.quantity = quantity;
	}

	public static double getTaxRate() {
		return taxRate;
	}

	public static Rushable getRushable() {
		return rushable;
	}

	public static void setRushable(Rushable rushable) {
		Order.rushable = rushable;
	}
	
	public boolean isPriorityOrder(){
		boolean priorityOrder = false;
		if( rushable != null ) {
			priorityOrder = rushable.isRushable(orderDate, orderAmount, true);
		}
		return priorityOrder;
	}
	
	private boolean isHoliday(MyDate proposedDate) {
		boolean result = false;
		for (MyDate holiday : MyDate.getHolidays()) {
			if( holiday.equals(proposedDate) ) {
				result = true;
			}
		}
		return result;
	}
	
	
}
