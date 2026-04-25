package org.cryptnerd.workshop.stream;

import java.util.Arrays;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;
import org.cryptnerd.workshop.lambda.Person;

public class StreamDemo {

	public void filterIntValuesLessThan(List<Integer> list, int filter) {
		list.stream().
				filter(p -> p < filter).
					forEach(System.out::println);
	}
	public void filerByAgeAndLocation(List<Person> people, int age, String location) {
		people.stream().
			filter(person -> person.getAge() > age && person.getCountry() == location).
				forEach(person ->{
					System.out.println(person.getName() + " " + person.getAge() + " " + person.getCountry());					
				});
	}
	public void filerByAgeAndLocationChained(List<Person> people, int age, String location) {
		people.stream().
			filter(person -> person != null).
			filter(person -> person.getAge() > age).
			filter(person -> person.getCountry() == location).
				forEach(System.out::println);
	}
    public static void main(String[] args) {
        List<Integer> magicNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 100, 120, 130, 1000, 1100, 10000));
        Stream<Integer> magicNumberStream = magicNumbers.stream();
        magicNumberStream.forEach(System.out::println);
        int filterVal = 10;
        StreamDemo demo = new StreamDemo();
        demo.filterIntValuesLessThan(magicNumbers, filterVal);
        List<Person> people = new ArrayList<>();
        people.add(new Person("John Smith", 23, "England"));
        people.add(new Person("Pocahontas", 15, "North America"));
        people.add(new Person("Joe Schmo", 45, "North America"));
        people.add(new Person("Ben Dover", 55, "North America"));
        demo.filerByAgeAndLocation(people, 20, "North America");
        demo.filerByAgeAndLocationChained(people, filterVal, "North America");
    }
}

