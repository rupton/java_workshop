package org.cryptnerd.workshop.strings;

public class StringKeyManipulation {

	public static void main(String[] args) {
		
		String connectionString = "values:4958945//56989000909043//fkjgTUIY00045";
		String parsedConnectionString = connectionString.split(":", 2)[1];
		System.out.println("The parsed connection string is: " + parsedConnectionString);
		String[] authInfo = parsedConnectionString.split("//");
		if(authInfo.length != 2) {
			//return an error condition here
		}
		String authN = authInfo[0];
		String authZ = authInfo[1];
		String authIdent = authInfo.length == 3? authInfo[2]: "unset";
		
		System.out.println("Authentication Information: " + authN);
		System.out.println("Authorization Information: " + authZ);
		System.out.println("Identification Information: " + authIdent);

	}

}
