package com.task1;

import java.util.Scanner;

public class Task1 {
	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		Task1 task= new Task1();
		System.out.println("Enter first Integer");
		int first=sc.nextInt();
		System.out.println("Enter second Integer");
		int second=sc.nextInt();
		System.out.println("Enter floating point number");
		float f=sc.nextFloat();
		System.out.println("Enter a single character");
		char singleChar=sc.next().charAt(0);
		System.out.println(singleChar);
		System.out.println("Enter a boolean value (true/false)");
		boolean b=sc.nextBoolean();
		System.out.println("Enter your name");
		String name=sc.next();
		
		int sum= first+second;
		int difference=first-second;
		int product=first*second;
		
		float f1=f*2;
		char nextChar=(char) (singleChar+1);
		System.out.println(nextChar);
		boolean opposite=!b;
		
		System.out.println("Sum of "+first+" and "+second+" is: " +sum);
		System.out.println("Difference between"+first+" and "+second+" is:" +difference);
		System.out.println("Product of "+first+ " and " +second+" is:" +product);
		System.out.println(f +" multiplied by 2 is:" +f1);
		System.out.println("The next character after'"+singleChar+ "'is:"+ nextChar);
		System.out.println("The opposite of"+b+ " is:"+opposite);
		System.out.println("Hello,"+name);
		

	}
	

}
