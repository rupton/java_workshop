package org.cryptnerd.workshop.stream;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import org.cryptnerd.workshop.lambda.Person;

public class StreamFilterDemo {

	public void filterAndMapByAge(List<Person> people, int ageFilter) {
		people.stream()
		.filter(person -> person.getAge() > ageFilter)
		.map(person -> person.getName().toUpperCase())
		.forEach(System.out::println);
	}
	
	public void flatFilterDemo() {
		List<List<String>> list = new ArrayList<>();
			list.add(Arrays.asList("a","b","c"));
	        list.add(Arrays.asList("d","e","f"));
	        list.add(Arrays.asList("g","h","i"));
	        list.add(Arrays.asList("j","k","l"));
	        
	    list.stream()
	    .flatMap(s -> s.stream())
	    .filter( str -> "a".equals(str))
	    .forEach(System.out::println);
	    
	}
	public static void main(String[] args) {
		StreamFilterDemo demo = new StreamFilterDemo();
		List<Person> people = new ArrayList<>();
		people.add(new Person("Ryan", 30));
		people.add(new Person("Jennifer", 29));
		people.add(new Person("Brianna", 18));
		people.add(new Person("Brett", 16));
		people.add(new Person("Brooke",16));
		// Show original list state
		for(Person p : people) {
			System.out.println(p.getName());
		}
		demo.filterAndMapByAge(people, 15);
		// Show the list still hasn't been modified after the map function
		for(Person p : people) {
			System.out.println(p.getName());
		}
		demo.flatFilterDemo();
	}
}
