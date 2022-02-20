package microsoft;

public class LargestAlphabeticCharacter {

	public static String largestCharacter(String str) {
		boolean[] lowerCaseChars = new boolean[26];
		boolean[] upperCaseChars = new boolean[26];

		for (char c : str.toCharArray()) {
			if (Character.isLowerCase(c)) {
				lowerCaseChars[c - 'a'] = true;
			} else if (Character.isUpperCase(c)) {
				upperCaseChars[c - 'A'] = true;
			}
		}
		
//		Iterate from right side of array to get the largest index character
		for (int i = 25; i >= 0; i--) {
			if (lowerCaseChars[i] && upperCaseChars[i]) {
				return Character.toString((char) (i + 'A'));
			}
		}

		return "-1";
	}

	public static void main(String[] args) {
		System.out.println(largestCharacter("admeDCAB"));
	}
}
