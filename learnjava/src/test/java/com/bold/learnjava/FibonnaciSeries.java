package com.bold.learnjava;

public class FibonnaciSeries {

	static int  a = 0;
	static int b = 1;
	static int endpoint ,c;
	public static void main(String[] args) {
		int d = 0;
		System.out.println(a);
		System.out.println(b);
		endpoint = 10;
		
		while (endpoint!=0)
		{
			c = a+b;
			d = a;
			a = b;
			b = c;
			
			System.out.println(c);
			
			endpoint--;
			
			
		}
		
		
		
		
		
		
		
		
		

	}

}
