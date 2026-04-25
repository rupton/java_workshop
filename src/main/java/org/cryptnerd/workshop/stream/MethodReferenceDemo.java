package org.cryptnerd.workshop.stream;
import java.util.List;
import java.util.OptionalInt;
import java.util.Arrays;
import java.util.ArrayList;
import org.cryptnerd.workshop.lambda.Person;

public class MethodReferenceDemo {

	public  int referencePersonMaxAge(List<Person> people) {
		OptionalInt maxAge = people.stream()
						.mapToInt(Person::getAge)
						.max();
	
		return maxAge.getAsInt();
	}
	
	public static void main(String[] args) {
		MethodReferenceDemo demo = new MethodReferenceDemo();
		//try a new way to build the list
		List<Person> people = new ArrayList<>(Arrays.asList(
				new Person("Bob", 50),
				new Person("Jim", 40),
				new Person("Stacy", 38)
		));
		
		System.out.println("The maximum age in the group is " + demo.referencePersonMaxAge(people));
		people.stream()
		      .map(Person::getName)
		      .forEach(System.out::println);
		people.stream()
			  .map( p -> String.format("Name: %s, Age: %d", p.getName().toUpperCase(), p.getAge()))
			  .forEach(System.out::println);
	}

}