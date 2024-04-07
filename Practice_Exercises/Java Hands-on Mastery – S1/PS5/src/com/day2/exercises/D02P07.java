package com.day2.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class D02P07 {

	// Function to find all strings in the dictionary that match the given pattern
	public static List<String> findMatchingStrings(String[] dictionary, String pattern) {
		List<String> matches = new ArrayList<>();

		for (String word : dictionary) {
			if (matchesPattern(word, pattern)) {
				matches.add(word);
			}
		}

		return matches;
	}

	// Function to check if a word matches the given pattern
	private static boolean matchesPattern(String word, String pattern) {
		if (word.length() != pattern.length()) {
			return false;
		}

		// Arrays to store the mapping of characters
		char[] wordToPattern = new char[26]; 
		char[] patternToWord = new char[26];

		// Iterate through each character of the word and pattern
		for (int i = 0; i < word.length(); i++) {
			char wordChar = word.charAt(i);
			char patternChar = pattern.charAt(i);

			// Calculate the indices for the mapping arrays
			int wordIndex = wordChar - 'a';
			int patternIndex = patternChar - 'a';

			// If mapping is not established yet, set it
			if (wordToPattern[wordIndex] == 0 && patternToWord[patternIndex] == 0) {
				wordToPattern[wordIndex] = patternChar;
				patternToWord[patternIndex] = wordChar;
			} else {
				// If the mapping conflicts, return false
				if (wordToPattern[wordIndex] != patternChar || patternToWord[patternIndex] != wordChar) {
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		String[] dictionary = { "abb", "abc", "xyz", "xyy" };
		String pattern = "foo";

		List<String> matches = findMatchingStrings(dictionary, pattern);

		System.out.println("Strings in the dictionary matching the pattern " + pattern + ":");
		for (String match : matches) {
			System.out.println(match);
		}
	}
}
