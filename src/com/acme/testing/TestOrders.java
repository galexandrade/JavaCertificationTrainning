package com.acme.testing;
import java.time.LocalDate;
import java.time.Period;

import com.acme.domain.*;
import com.acme.utils.MyDate;

public class TestOrders {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		MyDate date1 = new MyDate(1,20,2008);
		Solid s1 = new Solid("Anvil", 1668, 0.3, Good.UnitOfMeasureType.CUBIC_METER, false, 500, 0.25, 0.3);
		Order anvil = new Order(date1, 2000.00, "Wile E Coyote", s1, 10);

		MyDate date2 = new MyDate(4,10,2008);
		Solid s2 = new Solid("Acme Balloon", 1401, 15, Good.UnitOfMeasureType.CUBIC_FEET, false, 10, 5, 5);
		Order balloons = new Order(date2, 1000.00, "Bugs Bunny", s2, 125);
		balloons.setQuantity(-1);

		System.out.println(anvil);
		System.out.println(balloons);
		
		System.out.println("The tax Rate is currently: " + Order.taxRate);
		Order.computeTaxOn(3000.00);
		anvil.computeTax();
		balloons.computeTax();
		Order.setTaxRate(0.06);
		
		System.out.println("The tax Rate is currently: " + Order.taxRate);
		Order.computeTaxOn(3000.00);
		anvil.computeTax();
		balloons.computeTax();
		
		System.out.println("The total bill for: " + anvil + " is " +
		anvil.computeTotal());
		System.out.println("The total bill for: " + balloons + " is " +
		balloons.computeTotal());
		
		MyDate date3 = new MyDate(4,10,2008);
		Service s3 = new Service("Road Runner Eradication", 14, false);
		Order birdEradication = new Order(date3, 20000, "Daffy Duck", s3, 1);
		System.out.println("The total bill for: " + birdEradication + " is " + birdEradication.computeTotal());
		*/
		
		/* Lambda expressions */
		Order.setRushable((orderDate, orderAmount, test) -> {
			LocalDate dt = LocalDate.of(orderDate.getYear(), orderDate.getMonth(), orderDate.getDay());
			LocalDate now = LocalDate.now();
			
			Period p = Period.between(dt, now);
			System.out.println(p);
			
			//return orderAmount > 1500;
			return p.toTotalMonths() >= 1;
		});
		
		MyDate date1 = new MyDate(1, 1, 2017);
		Solid s1 = new Solid("Anvil", 1668, 0.3, Good.UnitOfMeasureType.CUBIC_METER, false, 500, 0.25, 0.3);
		Order anvil = new Order(date1, 2000.00, "Wile E Coyote", s1, 10);				
		
		//System.out.println("Anvil isPriorityOrder: " + anvil.isPriorityOrder());
		
		MyDate date2 = new MyDate(6,9,2017);
		Solid s2 = new Solid("Acme Balloon", 1401, 15, Good.UnitOfMeasureType.CUBIC_FEET, false, 10, 5, 5);
		Order balloons = new Order(date2, 1000.00, "Bugs Bunny", s2, 125);
		
		System.out.println("Baloons isPriorityOrder: " + balloons.isPriorityOrder());
	}

}
