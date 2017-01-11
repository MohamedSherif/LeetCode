package impl;

/**
 * Given an integer, write an algorithm to convert it to hexadecimal. For
 * negative integer, two’s complement method is used.
 * 
 * Note:
 * 
 * 1- All letters in hexadecimal (a-f) must be in lowercase. 2- The hexadecimal
 * string must not contain extra leading 0s. If the number is zero, it is
 * represented by a single zero character '0'; otherwise, the first character in
 * the hexadecimal string will not be the zero character. 3- The given number is
 * guaranteed to fit within the range of a 32-bit signed integer. 4- You must
 * not use any method provided by the library which converts/formats the number
 * to hex directly
 * 
 * Example 1: Input: 26 Output: "1a"
 * 
 * Example 2: Input: -1 Output: "ffffffff"
 * 
 * @author mohsherif
 *
 */
public class ConvertNumberToHexadecimal {

	/**
	 * Right Solution.
	 * 
	 * @param num
	 * @return
	 */
	public static String toHex(int num) {
		String hex = "";

		if (num == 0)
			return "0";

		long n = num & 0xffffffffL;
		
		long hexDig = 0;

		while (n > 0) {
			hexDig = n % 16;

			hex = ((hexDig < 10) ? (char)(hexDig + '0') : (char)(hexDig - 10 + 'a')) + hex;

			n = n/16;
		}
		
		return hex;
	}
	
	
	
	
	/**
	 * Wrong Solution. Can't handle the case of negative numbers two's complement.
	 * 
	 * @param num
	 * @return
	 */
	public static String toHex_old(int num) {
		String hex = "";

//		if (num < 0){
//			String twos = Integer.toBinaryString(num);
////			String st = twos.substring(twos.length()-8, twos.length());
////			System.out.println(st);
//			num = Integer.valueOf(twos, 2);
//		}
		
		if (num == 0)
			return "0";

		long n = num & 0xffffffffL;
		
		int hexDig = 0;

		while (n > 0) {
			hexDig = (int) n % 16;
			if (hexDig < 10) {
				hex = hexDig + hex;
			} else {
				char newDig = '0';
				switch (hexDig) {
					case 10:
						newDig = 'a';
						break;
					case 11:
						newDig = 'b';
						break;
					case 12:
						newDig = 'c';
						break;
					case 13:
						newDig = 'd';
						break;
					case 14:
						newDig = 'e';
						break;
					case 15:
						newDig = 'f';
						break;
				}
				hex = newDig + hex;
			}
			n = n/16;
		}
		
		return hex;
	}
	
	
	public static void main(String[] args) {
		System.out.println(toHex(-2));
	}

}
