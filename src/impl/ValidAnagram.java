package impl;

/**
 * Given two strings s and t, write a function to determine if t is an anagram
 * of s.
 * 
 * For example, s = "anagram", t = "nagaram", return true. s = "rat", t = "car",
 * return false.
 * 
 * Note: You may assume the string contains only lowercase alphabets.
 * 
 * 
 * @author mohsherif
 *
 */
public class ValidAnagram {

	// public static boolean isAnagram(String s, String t) {
	//
	// if(s.length() != t.length()){
	// return false;
	// }
	//
	// for (int i = 0; i < s.length(); i++) {
	// if(!t.contains(""+s.charAt(i)))
	// return false;
	//
	//
	// }
	//
	// return true;
	// }

	public static boolean isAnagram(String s, String t) {

		if (s.length() != t.length()) {
			return false;
		}

		int[] chars = new int[26];
		
		for (char c : s.toCharArray()) {
			chars[c - 'a']++;
		}
		
		for (char c : t.toCharArray()){
			chars[c - 'a']--;
		}
		
		for (int i = 0; i < chars.length; i++) {
			if(chars[i] != 0){
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "nagaram"));

		System.out.println(isAnagram("rat", "car"));

		System.out.println(isAnagram("aacc", "ccac"));
	}
}
