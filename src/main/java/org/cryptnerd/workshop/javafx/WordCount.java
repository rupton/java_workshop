package org.cryptnerd.workshop.javafx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCount {

	public static void main(String[] args) {
		String input = "A BANANA CAN FLY BETTER";
		Matcher m  = Pattern.compile("[BCN]").matcher(input);
		int count = 0;
		while(m.find()) count++;
		System.out.println("There are " + count + " occurences of B, C, or N in the string " + input);
		

	}

}
