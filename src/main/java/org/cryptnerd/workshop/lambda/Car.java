package org.cryptnerd.workshop.lambda;

public class Car implements Vehicle {

	@Override
	public void cleanVehicle() {
		// TODO Auto-generated method stub
		System.out.println("Cleaning the vehicle");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new Car();
		car.cleanVehicle();
		car.startVehicle();
	}

}
