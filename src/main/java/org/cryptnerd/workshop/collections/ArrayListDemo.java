package org.cryptnerd.workshop.collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

	public static void main(String[] args) {
		List <Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		System.out.println(list);
		// this will add 4 at the end of the list
		list.add(4);
		System.out.println(list);
		
		// this will add 50 at index 1 and shift all others to the right
		list.add(1, 50);
		System.out.println(list);
		
		//create a new list that will be added to the original list
		List <Integer> newList = new ArrayList<>();
		newList.add(150);
		newList.add(160);
		newList.add(160);
		
		// this will add the two lists together
		list.addAll(newList);
		System.out.println(list);
		
		// fetch an item
		System.out.println("The item at index two is " + list.get(1));
	}
}
