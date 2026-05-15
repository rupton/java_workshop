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
		
		// match American and British version of the word gray using Alternation
		String input = "Vibrant light bloomed across the gray sky, illuminating its grey haze in flashes amidst rolling hills of wispy gray clouds. "
				+ "Colors of gold, pink, and purple painted the horizon, the dull grey of the sky overtaken by brief moments of a quiet twilight storm.";
		Pattern pattern2 = Pattern.compile("gray|grey");
	    Matcher matcher2 = pattern2.matcher(input);
	    int count = 0;
	    while(matcher2.find())count++;
	    System.out.println("There are " + count + " instances of 'grey' or 'grey' in: " + input);
	}

}
