package impl;

public class LongestSubStringWithoutTwoContOccurencesOfLetter {

	public static String solution(String s) {
		int size = s.length();

		// start position and length of the longest sequence
		// which doesn't contain 3 contiguous occurrences of a and b
		int start_ml = 0, max_length = 0;

		// start of current processing string of the same letters.
		int start = 0;
		
		// length of current processing string of the same letters.
	    int count = 1; 
		
		for(int i = 1; i < size; i++) {
			if(s.charAt(i) == s.charAt(i-1)) {
				// if we met two the same letters, increase the counter of the same letters
	            count++;
			} else {
				// if next letter is different drop the counter to 1
	            count = 1;
			}
			if(count <= 2) {
				// if the sequence of different letters continuing, 
	            // set it's current length as
	            // max_length if it is bigger than current max_length
	            // "i - start + 1" is length of the current 
	            // processed sequence
				
				if (i - start + 1 > max_length) {
	                max_length = i - start + 1;
	                start_ml = start;
	            }
			} else {
				// if the sequence of the same letters continuing, 
	            // move the pointer to points to the last two 
	            // chars of this sequence
	            // drop the count to 2
	            start = i - 1;
	            count = 2;	
			}
		}
		return s.substring(start_ml, max_length);
	}
	
	public static void main(String[] args) {
		System.out.println(solution("aabbaabbaabbaa"));
	}
}
