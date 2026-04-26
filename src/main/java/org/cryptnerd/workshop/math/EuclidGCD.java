package org.cryptnerd.workshop.math;

/*
 * Euclidean algoritm for find the greatest common divisor between two numbers
 */
public class EuclidGCD {
	/*
	 * For two integers (a) and (b), calculate the remainder (r) 
	 * when (a) is divided by (b) ((a = bq + r)). The algorithm then replaces (a) with (b) and (b) with (r), 
	 * repeating this process until (r=0). This implementation doesn't need to use the value of a, it's only concerned with
	 * the remainder of a / b on each subsequent invocation.
	 */
	public int getGCD(int a, int b) {
		a = Math.abs(a);
		b = Math.abs(b);
		//there's no need to check a value since the next recursive call will trigger this return
		if(b == 0) return a;
		return getGCD(b, a % b);
	}
	
}
