package org.ryptnerd.cvu.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuantifierDemo {

	public static void main(String[] args) {
		String[] strings = {"CCQQ", "QQCC", "CQQ", "QUACK", "CCQ", "CQC", "CQQQ", "CCCQQ"};

	    for(String s: strings){
	      Pattern pattern = Pattern.compile("C+Q{2}");
	      Matcher matcher = pattern.matcher(s);
	      System.out.println(matcher.matches());
	    }

	}

}
