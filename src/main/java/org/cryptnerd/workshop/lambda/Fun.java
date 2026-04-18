package org.cryptnerd.workshop.lambda;

public class Fun implements InterfaceA, InterfaceB {
	
	@Override
	public void fun(){
		InterfaceA.super.fun();
	}
	
	public static void main(String[] args) {
		Fun fun = new Fun();
		fun.fun();
	}

}
