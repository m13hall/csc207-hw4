package hallmira.util;

public class StringUtils {

	/**
	 * splitAt takes a string and separates it into substrings
	 * with the separation point being the char splitter.
	 * 
	 * @param toSplit, a string whose components are separated
	 * by splitter
	 * splitter, the character separating parts of the string, 
	 * toSplit
	 * 
	 * @return an array of strings that are formed from
	 * splitting toSplit at the character splitter
	 * 
	 * Taken from csc207-hw3 by Andrew Kelley
	 */
	public static String[] splitAt (String toSplit, char splitter) {
	
		int placeHolder = 0; //tracks latest position of new substring
		int arrayCount = 0; //tracks of position of array entries
		int numberOfSplitters = 0; /*counts number of splitters so that
									*the length of array will be correct
									*/
		for (int x = 0; x < toSplit.length(); x++) {
			if (toSplit.charAt(x) == splitter)
				numberOfSplitters += 1;
		}
		/*
		 * creates array to return with the correct number of 
		 * elements based on number of splitters plus 1
		 */
		String[] splitArray = new String[numberOfSplitters + 1];
		for (int x = 0; x < toSplit.length(); x++){
			if (toSplit.charAt(x) == splitter) {
				splitArray[arrayCount] = 
						toSplit.substring(placeHolder, x);
				placeHolder = x + 1;
				arrayCount += 1;
			}
		}
	    //adds substring from last splitter to end of string
		splitArray[arrayCount] = 
				toSplit.substring(placeHolder);
		return splitArray;
	}//splitAt(string, char)

}
