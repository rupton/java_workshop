package org.ryptnerd.cvu.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("Hello.*world", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher("Hello, It's a brave new world");
		System.out.println("Match was found? " + matcher.find());
	}

}
