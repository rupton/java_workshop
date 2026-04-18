package org.cryptnerd.workshop.lambda;

public class Fun2 implements InterfaceA, InterfaceB {

	private static String interfaceType;
	
	@Override
	public void fun() {
		if(interfaceType != null || ! interfaceType.isEmpty()) {
			if(interfaceType.equals("interfaceA")) {
				InterfaceA.super.fun();
			}else {
				InterfaceB.super.fun();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fun2 fun2A = new Fun2();
		Fun2 fun2B = new Fun2();
		
		interfaceType = "interfaceA";
		fun2A.fun();
		
		interfaceType = "interfaceB";
		fun2B.fun();
		
	}

}
