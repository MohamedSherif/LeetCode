package impl;

/**
 * Given an integer, convert it to a roman numeral, and return a string
 * corresponding to its roman numeral version
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * Example : 
 * - Input : 5 
 * - Return : "V"
 * 
 * - Input : 14 
 * - Return : "XIV"
 * 
 * @author Mohamed Sherif.
 *
 */
public class IntegerToRoman {

	public static String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();

		int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] strs = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

		for (int i = 0; i < values.length; i++) {
			while (num >= values[i]) {
				num -= values[i];
				sb.append(strs[i]);
			}
		}

		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(intToRoman(14));
	}
}
