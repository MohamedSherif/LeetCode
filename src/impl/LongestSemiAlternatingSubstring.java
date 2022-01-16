package impl;

public class LongestSemiAlternatingSubstring {
	
	public static int solution(String s) {
		int result = 0, count = 0;
		char ch = 0;
		
		int j = 0;
		for(int i = 0; i < s.length(); i++) {
			if(i == 0 || s.charAt(i) != ch) {
				ch = s.charAt(i);
				count = 1;
			} else {
				count++;
				
				if(count >= 3) {
					j = i - 1;
				}
			}
			result = Math.max(result, i - j + 1);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(solution("baaabbabbbb"));
	}
}
