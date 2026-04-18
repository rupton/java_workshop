package org.cryptnerd.workshop.lambda;

public interface InterfaceA {

	default void fun() {
		System.out.println("Having fun from A");
	}
}
