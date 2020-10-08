package assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * The following Class containing the solutions for finding the largest word and
 * Transpose that word.
 * 
 * Sample test cases are: Test 1: Finding the largest word from the file and
 * Transpose the letters in the largest word Test 2: Finding the largest integer
 * value from the file and Transpose the value Test 3 (Negative Test) : Passing
 * the empty text file Test 4 (Negative Test) : Passing the path file doesn't
 * exists
 */
public class Longest {

	public static void main(String[] args) throws Exception {

		StringPair regularStringPair = null;

		File dir = new File("files");

		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {

			for (int i = 0; i < directoryListing.length; i++) {

				regularStringPair = checkLongest(directoryListing[i].getPath());

				if (directoryListing[i].getName().equals("data.txt") && regularStringPair.getString().equals("abcde")
						&& regularStringPair.getTransposed().equals("edcba")) {
					System.out.println("TEST 1: regular file: passed");
				} else if (directoryListing[i].getName().equals("numberdata.txt")
						&& regularStringPair.getString().equals("233131331")
						&& regularStringPair.getTransposed().equals("133131332")) {
					System.out.println("TEST 2: regular file: passed");
				} else if (directoryListing[i].getName().equals("empty.txt")
						&& regularStringPair.getString().equals(""))
					System.out.println("TEST: failed");

			}
		}

		boolean error = false;
		try {
			regularStringPair = checkLongest("files\\nofile.txt");
		} catch (Exception e) {
			error = true;
		} if (error == true) {
			System.out.println("TEST 4: Empty file: Passed");
		} else {
			System.out.println("TEST 4: Empty file: Failed");
		}
	}
	/*
	 * this method returns longest word from the input file
	 */

	public static StringPair checkLongest(String fileName) throws Exception {
		String longestLine = "";

		BufferedReader reader;

		reader = new BufferedReader(new FileReader(fileName));

		String line = reader.readLine();

		while (line != null) {
			if (line.length() > longestLine.length()) {
				longestLine = line;
			}

			// read next line
			line = reader.readLine();
		}
		reader.close();

		return new StringPair(longestLine);

	}
}
