package impl;

import java.util.HashMap;

/**
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * 
 * 
 * @author mohsherif
 *
 */
public class FirstUniqChar {

	public static int firstUniqChar(String s) {
//		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//		
//		for(char c : s.toCharArray()){
//			if(map.containsKey(c)){
//				map.put(c, map.get(c)+1);
//			}else{
//				map.put(c, 1);
//			}
//		}
//
//		for(char c : map.keySet()){
//			if(map.get(c) == 1){
//				return s.indexOf(c);
//			}
//		}
		
		for (int i = 0; i < s.length(); i++) {
			if(s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))){
				return i;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(firstUniqChar("z"));
	}
}
