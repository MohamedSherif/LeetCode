package impl;

/**
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * @author Mohamed Sherif
 *
 */
public class PowerOfTwo {

	public static boolean isPowerOfTwo(int n) {
		if (n <= 0)
			return false;

		while (n >= 1) {
			if (n % 2 != 0 && n != 1) {
				return false;
			}
			n = n / 2;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(8));
	}
}
