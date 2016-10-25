package impl;

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * 
 * @author MohamedSherif.
 */
public class SumOfTwoIntegers {

	/**
	 * Using Bitwise Operators.
	 * @param a
	 * @param b
	 * @return
	 */
	public int getSum(int a, int b) {
		int tempResult = a & b;

		return tempResult == 0 ? a ^ b : getSum(tempResult << 1, a ^ b);
	}
}
