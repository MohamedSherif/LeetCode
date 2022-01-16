package impl;

public class MaxInsertsToObtainStringWithout3ConsicutiveA {
	private static int solution(String s) {
		if(s == null || s.contains("aaa"))
			return -1;
		
		if(s.length() == 0)
			return 2;
		
		int countAs = 0, countOthers = 0, length = s.length();
		
		for(int i = 0; i < length; i++) {
			if(s.charAt(i) == 'a') {
				countAs++;
			} else {
				countOthers ++;
			}
		}
		
		return 2 * (countOthers + 1) - (countAs); 
		
	}
	
	public static void main(String[] args) {
		System.out.println(solution("aabab"));
	}
}
