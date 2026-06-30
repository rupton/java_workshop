package org.cryptnerd.classloaders;

import java.util.ArrayList;

public class FunWithClassLoaders {

	public void printClassLoaders() throws ClassNotFoundException{
		System.out.println("Platform Class Loader = " + ClassLoader.getPlatformClassLoader());
		System.out.println("System Class Loader = " + ClassLoader.getSystemClassLoader());
		System.out.println("The Class Loader of this class = " + FunWithClassLoaders.class.getClassLoader());
		System.out.println("ArrayList Class Loader = " + ArrayList.class.getClassLoader());
	}
	public static void main(String[] args) {
		FunWithClassLoaders fwc = new FunWithClassLoaders();
		try {
			fwc.printClassLoaders();
		}catch (ClassNotFoundException cnfE){
			System.out.println(cnfE.getMessage());
		}

	}

}
