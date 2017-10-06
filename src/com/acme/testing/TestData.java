package com.acme.testing;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class TestData {
	private static void print(Object o) {
		System.out.println(o);
	}

	public static void main(String[] args) {
		//LocalDate now = new LocalDate(); //ILEGAL
		/*
		LocalDate now = LocalDate.now();
		print(now);
		
		LocalDate hireDate = LocalDate.of(2008, Month.APRIL, 21);
		print(hireDate);
		
		LocalDate aWeekFromNow = now.plusWeeks(1);
		print(aWeekFromNow);
		
		LocalDate aWeekAgo = now.minusWeeks(1);
		print(aWeekAgo);
		
		System.out.println(hireDate.isBefore(now));
		*/
		
		/*
		LocalTime now = LocalTime.now();
		print(now);
		
		LocalTime timeHired = LocalTime.of(18, 20);
		print(timeHired);
		
		print(now.plusHours(1));
		print(now.minusHours(1));
		print(now.isAfter(timeHired));
		*/
		
		/*
		LocalDateTime now = LocalDateTime.now();
		print(now);
		LocalDateTime timeHired = LocalDateTime.of(2008, Month.APRIL, 10, 7, 30);
		print(timeHired);
		
		print(now.isBefore(timeHired));
		
		
		Period period = Period.of(3, 5, 12);
		now = now.minus(period);
		now = now.plus(period);
		print(now);
		*/
		
		LocalDate now = LocalDate.now();
		print(now);
		
		LocalDate hireDate = LocalDate.of(2008, Month.APRIL, 21);
		print(hireDate);
		
		print(Period.between(hireDate, now));
		
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		print(now.format(dtf));
		
		//DateTimeFormatter patternFormatter = DateTimeFormatter.ofPattern("yyyy/dd/M");
		DateTimeFormatter patternFormatter = DateTimeFormatter.ofPattern("dd 'in the year of' yyyy");
		print(now.format(patternFormatter));		
	}

}
