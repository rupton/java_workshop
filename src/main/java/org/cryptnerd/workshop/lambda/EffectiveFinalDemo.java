package org.cryptnerd.workshop.lambda;
 
import java.util.function.UnaryOperator;
/*
 * Effectively final is a new concept that was introduced in Java 8. A non-final, local variable whose value is never changed after initialization is known as effectively final.

 *	Before Java 8, we cannot use a non-final, local variable in an anonymous class. If you need to access a local variable in an anonymous class, then it should be declared as final. 
 *	This restriction is relaxed in Java 8. Now, the compiler, itself can check if the value of a variable is not changed after the assignment. 
  * Then, it is effectively final.
 */
  
public class EffectiveFinalDemo {

	private static int multiple = 10;
	
	public static void main(String[] args) {
		
		int i = 5; //this will not change after initialization so it's effectively final
		UnaryOperator<Integer> operator = (input) -> input * i;
		// This should be 25. We can access the enclosing scope variable i because it's effectively final
		System.out.println(operator.apply(i)); 
		// This should work too. We can access the enclosing instance variable multiple because it's effectively 
		UnaryOperator<Integer> staticOperator = (input) -> input * multiple;
		System.out.println(staticOperator.apply(i)); 
		// Oddly this works too. Even though the variable is reassigned, since it's not a local variable, it works
		multiple = 3;
		System.out.println(staticOperator.apply(i)); 
	}

}
