package impl;

public class StringWitout3IdenticalConsicutiveLetters {
	public static String solution(String s) {
		if(s == null || s.length() == 0 || s.length() == 2)
			return s;
		
		StringBuilder sb = new StringBuilder();
		sb.append(s.substring(0, 2));
		
		for(int i = 2; i < s.length(); i++) {
			if(s.charAt(i) != s.charAt(i-1) || s.charAt(i) != s.charAt(i - 2)) {
				sb.append(s.charAt(i));
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(solution("eedaaad"));
		System.out.println(solution("XXXTXXX"));

		System.out.println(solution("uuuuxxaaaxuuu"));
	}
}
