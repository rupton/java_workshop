package org.cryptnerd.workshop.lambda;

import java.util.function.Supplier;
import java.util.function.Predicate;

public class SupplierPredicateDemo {

	static boolean isPersonEligibleToVote(Supplier<Person> supplier, Predicate<Person> predicate) {
		return predicate.test(supplier.get());
		
	}
	
	public static void main(String[] args) {
		boolean eligible;
		Supplier<Person> supplier = () -> new Person("Ryan Upton", 54, "US");
		Predicate<Person> predicate = (p) -> p.getAge() > 18;
		eligible = isPersonEligibleToVote(supplier, predicate);
		System.out.println("Person is eligible to vote: " + eligible);
	}
}
