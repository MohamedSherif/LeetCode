package impl;

import java.util.HashMap;

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
 * canConstruct("a", "b") -> false 
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * 
 * @author mohsherif
 *
 */

public class RansomNote {

	/**
	 * O(n) solution, using Hashmap as its addition and removal of time complexity of O(1)
	 * @param ransomNote
	 * @param magazine
	 * @return
	 */
	public static boolean canConstruct2(String ransomNote, String magazine){
		if (ransomNote.length() > magazine.length()) {
			return false;
		}
		
		HashMap<Character, Integer> magazineMap = new HashMap<Character, Integer>();
		
		for (int i = 0; i < magazine.length(); i++) {
			char temp = magazine.charAt(i);
			if(magazineMap.containsKey(temp)){
				magazineMap.put(temp, magazineMap.get(temp)+1);
			}else{
				magazineMap.put(temp, 1);
			}
		}
		
		for (int i = 0; i < ransomNote.length(); i++) {
			char temp = ransomNote.charAt(i);
			if((!magazineMap.containsKey(temp)) || (magazineMap.get(temp) <= 0)){
				return false;
			}else{
				magazineMap.put(temp, magazineMap.get(temp)-1);
			}
		}
		
		
		return true;
	}
	
	/**
	 * O(n^2) using string operations.
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
			if(!magazine.contains(""+ch)){
				return false;
			}else{
				magazine = magazine.replaceFirst(""+ch, "");
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(canConstruct2("aa", "aab"));
	}

}
