package org.cryptnerd.classloaders;

public class LazyTest {
	/** 
	 * Run this with JVM args -verbose:class to see the class loading operations in the program's console output
	 * To see the process builder class being loaded, pass in any application argument
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("--- JVM Started ---");
		System.out.println("The class loader for me = " + LazyTest.class.getName());
		new LazyTest();
		if(args.length > 0) {
			// This will only trigger loading if an argument is passed
			ProcessBuilder pb;
			System.out.println("Process Builder Class = " + ProcessBuilder.class.getName());
		}
		
		System.out.println("--- JVM Exiting ---");
	}

}
