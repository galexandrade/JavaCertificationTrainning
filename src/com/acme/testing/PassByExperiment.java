package com.acme.testing;

import com.acme.utils.MyDate;

public class PassByExperiment {

	public static void main(String[] args) {
		MyDate date = new MyDate(1,20,2008);
		System.out.println("Before passing an object " + date);
		PassByExperiment.passObject(date);
		System.out.println("After passing an object " + date);
		
		System.out.println("Before passing a primitive " + date.getYear());
		passPrimitive(date.getYear());
		System.out.println("After passing a primitive " + date.getYear());
		
		String x = date.toString();
		System.out.println("Before passing a String " + x);
		passString(x);
		System.out.println("After passing a String " + x);
		
		StringBuilder xb = new StringBuilder(date.toString());
		System.out.println("Before passing a StringBuilder " + xb);
		passStringBuilder(xb);
		System.out.println("After passing a StringBuilder " + xb);

	}
	
	private static void passObject(MyDate d) {
		//Update the main object
		d.setYear(2009);
	}
	
	private static void passPrimitive(int i) {
		i = 2010;
	}
	
	private static void passString(String s) {
		int yearSlash = s.lastIndexOf('/');
		s = s.substring(0, yearSlash + 1);
		s += "2012";
		System.out.println("New date string: " + s);
	}
	
	private static void passStringBuilder(StringBuilder s) {
		int yearSlash = s.lastIndexOf("/");
		s.replace(yearSlash + 1, s.length(), "2012" );
		System.out.println("New date stringbuilder: " + s);
	}
}
