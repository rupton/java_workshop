package org.cryptnerd.workshop.lambda;

public interface InterfaceB {

	default void fun() {
		System.out.println("Having fun from B");
	}
}
