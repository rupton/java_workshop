package org.ryptnerd.cvu.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("Hello.*world", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher("Hello, It's a brave new world");
		System.out.println("Match was found? " + matcher.find());
		
		//use a character class to match American and British versions of the word gray
		
		String[] inputs ={"grey", "gray"};
		for(String input: inputs) {
			Matcher biMatch1 = Pattern.compile("gr[ea]y").matcher(input);
			if(biMatch1.find()){
				System.out.println("Matched: " + biMatch1.group());
			}
		}
	}

}
