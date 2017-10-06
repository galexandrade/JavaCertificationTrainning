package com.acme.testing;

import java.util.Arrays;

import com.acme.utils.MyDate;

public class TestArray {
	//the array must be the last one
	public static void lotOfInts(char... manyInts /*, char a*/){
		for(char i: manyInts){
			System.out.println(i);
		}
	}
	
	
	public static void main(String[] args) {
		int[] intArray = new int[10];		
		int[] intArray2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		//int[] i;
		//i = {1, 2}; //ILLEGAL
		
		/*ARRAY COPPY*/
		int[] array = {1,2,3};
		int[] temp = array;		
		array = new int[4];
		
		//1 - array from
		//2 - index starting
		//3 - array to
		//4 - index starting
		//5 - how far
		System.arraycopy(temp, 0, array, 0, temp.length);
		
		MyDate[] dates = new MyDate[3];
		//System.out.println(dates[0]);
		
		//String[][] multArray = new String[5][2];
		String[] multArray[] = {{"1", "a"}, {"2", "b"}};
		multArray[0][0] = "Alex";
		multArray[0][1] = "123123";
		multArray[1][0] = "Ana Luísa";
		multArray[1][1] = "456456";
		
		System.out.println(multArray[1][0]);
		
		
		//Can't be any gab
		//int[][][] moreStuff = new int[3][][3];
		
		int[][][] moreStuff = new int[3][3][];
		moreStuff[0][2] = new int[2]; // Line A
		moreStuff[0][2][0] = 0;
		moreStuff[0][2][1] = 1;
		
		//moreStuff[0][1][0] = 0; //Illegal
		
		//SORTING
		char[] letters = {'d', 'a', 'c', 'b'};
		Arrays.sort(letters);
		
		int cLocation;
		//If not exists, it is = (array.length + 1) * -1
		cLocation = Arrays.binarySearch(letters, 'e');
		System.out.println(cLocation);
		
		Arrays.fill(letters, 'z');
		System.out.println(letters[0]);		
		
		lotOfInts('a', 'b');
	}
}
