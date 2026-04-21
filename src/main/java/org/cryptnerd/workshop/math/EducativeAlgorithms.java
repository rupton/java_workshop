package org.cryptnerd.workshop.math;

public class EducativeAlgorithms {

	public int getGCD(int a, int b) {
		if(a == 0) return b;
		if(b == 0) return a;
		return getGCD(b, a % b);
	}
	
	
	public static void main(String[] args) {
		EducativeAlgorithms algos = new EducativeAlgorithms();
		System.out.println(algos.getGCD(120, 2));
		System.out.println(algos.getGCD(120, 120));
	}
}
