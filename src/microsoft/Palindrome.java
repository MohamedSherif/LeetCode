package microsoft;

public class Palindrome {
	
	public static boolean isPalindrome(String str, boolean ignoreCase, boolean ignoreSpaces) {
		boolean result = true;
		int left = 0;
		int right = str.length() - 1;
		
		while(left < right) {
			if(ignoreSpaces) {
				while(str.charAt(left) == ' ') {
					left++;
				}
				while(str.charAt(right) == ' ') {
					right--;
				}
			}
			
			char leftChar = ignoreCase? Character.toUpperCase(str.charAt(left)) : str.charAt(left);
			char rightChar = ignoreCase? Character.toUpperCase(str.charAt(right)) : str.charAt(right);
			
			if(leftChar != rightChar) {
				return false;
			}
			left++;
			right--;
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("M", true, true));
	}
}
