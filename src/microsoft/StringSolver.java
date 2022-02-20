package microsoft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringSolver {
	
	public static int  maxLengthConcatStringWithUniqueCharacters(List<String> arr) {
		int[] result = new int[1];
		
		maxUnique(arr, 0, "", result);
		
		return result[0];
	}
	
	private static void maxUnique(List<String> arr, int index, String current, int[] result) {
		if(index == arr.size() && uniqueCharCount(current) > result[0]) {
			result[0] = current.length();
			return;
		}
		if(index == arr.size()) {
			return;
		}
		
		maxUnique(arr, index + 1, current, result);
		maxUnique(arr, index + 1, current + arr.get(index), result);
	}
	
	private static int uniqueCharCount(String s) {
		int[] counts = new int[26];
		
		for(char c : s.toCharArray()) {
			if(counts[c - 'a']++ > 0) {
				return -1;
			}
		}
		
		return s.length();
	}
}
