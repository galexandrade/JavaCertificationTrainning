package com.acme.utils;

import com.acme.domain.Order;

public class MyDate {
	private byte day;
	private byte month;
	private short year;
	private static MyDate[] holidays;
	
	public static  int LESS_TRAVELED = 0;
	
	static {
		holidays = new MyDate[6];
		
		holidays[0] = new MyDate(1, 1, 2017);
		holidays[1] = new MyDate(30, 5, 2017);
		holidays[2] = new MyDate(4, 7, 2017);
		holidays[3] = new MyDate(5, 9, 2017);
		holidays[4] = new MyDate(24, 11, 2017);
		holidays[5] = new MyDate(25, 12, 2017);
	}

	
	public MyDate(){
		this.day = (byte)1;
		this.month = (byte)1;
		this.year = (short)1990;
	}
	
	public MyDate(int d, int m, int y){
		this();
		this.setDay(d);
		this.setYear(y);
		this.setMonth(m);
	}
	
	public String toString(){
		return this.getDay() + "/" + this.getMonth() + "/" + this.getYear();
	}
	
	public void setDate(int d, int y, int m){
		if(this.valid(d, m, y)){
			this.setDay(d);
			this.setYear(y);
			this.setMonth(m);
		}
	}
	
	public static void leapYears() {
		for(int year = 1752; year <= 2020; year += 4){
			System.out.println("The year " + year + " is a leap year");
		}
	}
	
	private boolean valid(int day, int month, int year){
		if (day > 31 || day < 1 || month > 12 || month < 1 ){
			System.out.println("Attempting to create a non-valid date " + month + "/" + day + "/" + year);
			return false;
		}
		switch (month){
			case 4: case 6:	case 9: case 11: 
				return (day <= 30);
			case 2: 
				return day <= 28 || ( day == 29 && year % 4 == 0) ;
		}
		
		return true;
	}


	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if (valid(day, month, year)) {
			this.day = (byte)day;
		}

	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = (short)year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = (byte)month;
	}
	
	public boolean equals(Object o){
		boolean isEquals = false;
		
		if((o instanceof MyDate)){
			MyDate tempDate = (MyDate) o;
			return tempDate.day == this.day &&
				   tempDate.month == this.month &&
				   tempDate.year == this.year;
		}
		
		return isEquals;
	}

	public static MyDate[] getHolidays() {
		return holidays;
	}

	public static void setHolidays(MyDate[] holidays) {
		MyDate.holidays = holidays;
	}
	
	public static void listHolidays() {
		System.out.println("the holidays are:");
		/*		
		for (int x = 0; x < holidays.length; x++){
			System.out.println(holidays[x]);
		}
		*/
		
		for(MyDate holiday: holidays){
			System.out.println(holiday);
		}
		
		
	}
}
