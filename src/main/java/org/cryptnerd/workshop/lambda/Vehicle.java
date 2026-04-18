package org.cryptnerd.workshop.lambda;

public interface Vehicle {

	void cleanVehicle();
	
	default void startVehicle() {
		System.out.println("Starting vehicle");
	}
}
