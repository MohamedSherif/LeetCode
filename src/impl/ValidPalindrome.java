package impl;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example, 
 * "A man, a plan, a canal: Panama" is a palindrome. 
 * "race a car" is not a palindrome.
 * 
 * Note: Have you consider that the string might be empty? This is a good
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * @author mohsherif
 *
 */
public class ValidPalindrome {
	public static boolean isPalindrome(String s) {
		boolean isPalindrome = true;

		String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

		System.out.println(actual);

		if (!actual.equalsIgnoreCase("")) {
			for (int i = 0; i <= actual.length() / 2; i++) {
				if (actual.charAt(i) != actual.charAt(actual.length() - 1 - i))
					return false;
			}
		}

		return isPalindrome;
	}

	public boolean isPalindrome2(String s) {
		String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
		String rev = new StringBuffer(actual).reverse().toString();
		return actual.equals(rev);
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));

		System.out.println(isPalindrome("race a car"));

		System.out.println(isPalindrome(""));
	}
}
