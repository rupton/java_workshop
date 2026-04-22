package org.cryptnerd.workshop.strings;

public class StringKeyManipulationDemo {
	
    public static void main(String[] args) {
        try {
            String connectionString = "values:4958945//56989000909043//fkjgTUIY00045";
            processConnectionString(connectionString);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void processConnectionString(String connectionString) {
        if (connectionString == null || connectionString.isEmpty()) {
            throw new IllegalArgumentException("Connection string cannot be null or empty");
        }

        String[] parts = connectionString.split(":", 2);
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid connection string format");
        }

        String parsedConnectionString = parts[1];
        System.out.println("The parsed connection string is: " + parsedConnectionString);

        String[] authInfo = parsedConnectionString.split("//");
        if (authInfo.length < 2) {
            throw new IllegalArgumentException("Insufficient authentication information");
        }

        String authN = authInfo[0];
        String authZ = authInfo[1];
        String authIdent = authInfo.length >= 3 ? authInfo[2] : "unset";

        System.out.println("Authentication Information: " + authN);
        System.out.println("Authorization Information: " + authZ);
        System.out.println("Identification Information: " + authIdent);
    }
}