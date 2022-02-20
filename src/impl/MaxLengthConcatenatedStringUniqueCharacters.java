package impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MaxLengthConcatenatedStringUniqueCharacters {
	
	private static int solve(List<String> arr, int usedChar, int index, HashMap<String, Integer> cache) {
		if(index == arr.size())
			return 0;
		
		String key = usedChar + "," + index;
		
		if(cache.containsKey(key)) return cache.get(key);
		
		int currUsedChar = 0;
		String s = arr.get(index);
		boolean valid = true;
		
		for (int i = 0; i < s.length(); i++) {
			if((currUsedChar & (1 << (s.charAt(i) - 'a'))) == 0) {
				currUsedChar |= (1 << (s.charAt(i) - 'a'));
			} else {
				valid = false;
				break;
			}
		}
		
		int output = 0;
		
		output = solve(arr, usedChar, index + 1, cache);
		
		if(valid && (usedChar & currUsedChar) == 0) {
			output = Math.max(output, s.length() + solve(arr, (usedChar | currUsedChar), index + 1, cache));
		}
		
		cache.put(key, output);
		
		return output;
	}
	
	public static int maxLength(List<String> arr) {
        return solve(arr, 0, 0, new HashMap<String, Integer>());
    }
	

	/**
	 * Solution 2
	 * @param arr
	 * @return
	 */
	public static int maxLength2(List<String> arr) {
        int[] result = new int[1];
        maxUnique(arr, 0, "", result);
        return result[0];
    }
    
    public static void maxUnique(List<String> arr, int index, String current, int[] result) {
    	if(index == arr.size()) {
            if(uniqueCharCount(current) > result[0]) {
                result[0] = current.length();
            }
    		return;
    	}
        
    	maxUnique(arr, index + 1, current, result);
    	maxUnique(arr, index + 1, current + arr.get(index), result);
    }
    
    public static int uniqueCharCount(String s) {
    	int[] counts = new int[26];
    	
    	for(char c : s.toCharArray()) {
    		if(counts[c - 'a']++ > 0) {
    			return -1;
    		}
    	}
    	
    	return s.length();
    }
	
	public static void main(String[] args) {
		List<String> arr = new ArrayList<String>();
		arr.add("cha");
		arr.add("r");
		arr.add("act");
		arr.add("ers");
		
		
		System.out.println(maxLength2(arr));
	}
}
