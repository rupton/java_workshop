package org.cryptnerd.workshop.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonService {
	
	public List<Person> getPersons(List<Person> persons){
		Collections.sort(persons, (p1, p2) -> (p1.getName().compareTo(p2.getName())));
		return persons;
	}
	
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		PersonService personService = new PersonService();
		persons.add(new Person("John" , 23 , "USA"));
        persons.add(new Person("Carl" , 23 , "Australia"));
        persons.add(new Person("Amit" , 23 , "India"));
        persons.add(new Person("Vikram" , 23 , "Bhutan"));
        persons.add(new Person("Kane" , 23 , "Brazil"));
        
        personService.getPersons(persons);
        for(Person p : persons) {
        	System.out.println(p.getName());
        }
	}
}
