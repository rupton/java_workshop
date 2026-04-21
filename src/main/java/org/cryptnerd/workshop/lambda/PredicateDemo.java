package org.cryptnerd.workshop.lambda;

import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.logging.Level;

public class PredicateDemo {

	private static final Logger LOGGER = Logger.getLogger(PredicateDemo.class.getName());
	static boolean isPersonEligibleToVote(Person person, Predicate predicate) {
		return predicate.test(person);
	}
	
	public static void main(String[] args) {
		
		Person p1 = new Person("Ryan Upton",54, "United States of America");
		Predicate<Person> predicateAge = (p) -> p.getAge() > 21;
		Predicate<Person> predicateCountry = (p) -> p.getCountry().equals("US") || p.getCountry().equals("United States") ||
				p.getCountry().equals("United States of America");
		Predicate<Person> predicateFinal = predicateAge.and(predicateCountry);
		boolean isEligible = isPersonEligibleToVote(p1, predicateFinal);
		LOGGER.log(Level.INFO, String.valueOf(isEligible));
	}

}