package impl;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * For example, Given s = "Hello World", return 5.
 * 
 * @author Mohamed Sherif.
 *
 */
public class LengthOfLastWord {

	public static int lengthOfLastWord(String s) {
		if(s.equalsIgnoreCase(""))
			return 0;
		
		String[] stArr = s.split(" ");
		
		if(stArr.length == 0)
			return 0;
		
		return stArr[stArr.length - 1].length();
	}
	
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord(" "));
	}

}
