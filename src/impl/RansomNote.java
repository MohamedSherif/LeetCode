package impl;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * Given an arbitrary ransom note string and another string containing letters
 * from all the magazines, write a function that will return true if the ransom
 * note can be constructed from the magazines ; otherwise, it will return false.
 * 
 * Each letter in the magazine string can only be used once in your ransom note.
 * 
 * Note: You may assume that both strings contain only lowercase letters.
 * 
 * canConstruct("a", "b") -> false canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * 
 * @author mohsherif
 *
 */

public class RansomNote {

	/*
	 * The first line contains two space-separated integers describing the
	 * respective values of m (the number of words in the magazine) and n (the
	 * number of words in the ransom note). The second line contains m
	 * space-separated strings denoting the words present in the magazine. The
	 * third line contains n space-separated strings denoting the words present in
	 * the ransom note.
	 */
	public static boolean canConstruct(String[] ransomNote, String[] magazine) {
		if (ransomNote.length > magazine.length) {
			return false;
		}

		HashMap<String, Integer> magazineMap = new HashMap<String, Integer>();

		for (int i = 0; i < magazine.length; i++) {
			String temp = magazine[i];

			if (magazineMap.containsKey(temp)) {
				magazineMap.put(temp, magazineMap.get(temp) + 1);
			} else {
				magazineMap.put(temp, 1);
			}
		}

		for (int i = 0; i < ransomNote.length; i++) {
			String temp = ransomNote[i];

			if (!magazineMap.containsKey(temp) || magazineMap.get(temp) <= 0) {
				return false;
			} else {
				magazineMap.put(temp, magazineMap.get(temp) - 1);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		String magazine[] = new String[m];
		for (int magazine_i = 0; magazine_i < m; magazine_i++) {
			magazine[magazine_i] = in.next();
		}
		String ransom[] = new String[n];
		for (int ransom_i = 0; ransom_i < n; ransom_i++) {
			ransom[ransom_i] = in.next();
		}
		if (canConstruct(ransom, magazine))
			System.out.println("Yes");
		else
			System.out.println("No");
	}

	/**
	 * O(n) solution, using Hashmap as its addition and removal of time
	 * complexity of O(1).
	 * 
	 * Run Time: 69 ms.
	 * 
	 * @param ransomNote
	 * @param magazine
	 * @return
	 */
	public static boolean canConstruct2(String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length()) {
			return false;
		}

		HashMap<Character, Integer> magazineMap = new HashMap<Character, Integer>();

		for (int i = 0; i < magazine.length(); i++) {
			char temp = magazine.charAt(i);
			if (magazineMap.containsKey(temp)) {
				magazineMap.put(temp, magazineMap.get(temp) + 1);
			} else {
				magazineMap.put(temp, 1);
			}
		}

		for (int i = 0; i < ransomNote.length(); i++) {
			char temp = ransomNote.charAt(i);
			if ((!magazineMap.containsKey(temp)) || (magazineMap.get(temp) <= 0)) {
				return false;
			} else {
				magazineMap.put(temp, magazineMap.get(temp) - 1);
			}
		}

		return true;
	}

	/**
	 * O(n^2) using string operations.
	 * 
	 * Run Time: 301 ms
	 * 
	 * @param ransomNote
	 * @param magazine
	 * @return
	 */
	public static boolean canConstruct(String ransomNote, String magazine) {

		if (ransomNote.length() > magazine.length()) {
			return false;
		}

		for (int i = 0; i < ransomNote.length(); i++) {
			char ch = ransomNote.charAt(i);
			if (!magazine.contains("" + ch)) {
				return false;
			} else {
				magazine = magazine.replaceFirst("" + ch, "");
			}
		}
		return true;
	}

	// public static void main(String[] args) {
	// System.out.println(canConstruct2("aa", "aab"));
	// }

}
