package com.wp.eltest;

public class MyMath {

	public static int intervalSum(int start, int end) {
		int sum = 0;
		
		if (start <= end) {
			for (int i=start; i<=end; i++) {
				sum += i;
			}
		}
		
		return sum;
	}
	
}
