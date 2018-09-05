package impl;

import java.math.BigInteger;

/**
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
 * 
 * Note: 
 * 	- The given integer is guaranteed to fit within the range of a 32-bit signed integer. 
 * 	- You could assume no leading zero bit in the integer’s binary representation. 
 * Example 1: 
 * 	- Input: 5 
 * 	- Output: 2 
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 *  
 * Example 2: 
 * 	- Input: 1 
 * 	- Output: 0 
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0
 * 
 * @author Mohamed Sherif.
 *
 */
public class NumberComplement {

	
	public static int findComplement(int num) {
		int mask = (Integer.highestOneBit(num) << 1) - 1;
        num = ~num;
        return num & mask;
    }
	
	public static int findComplement2(int num) {
		
		BigInteger bin = new BigInteger(""+num);
		
		System.out.println();
        return num;
    }
	
	
	
	/**
	 * Slightly Off-Topic.  This function reverse the order if bits of an Integer.
	 * 
	 * It doesn't flip the bits.
	 */
	public static int reverseInteger(int num) {
		int b = 0;
        while (num!=0){
    	  b<<=1;
    	  b|=( num &1);
    	  num>>=1;
    	}
        return b;
    }
	
	public static void main(String[] args) {
		System.out.println(findComplement(5));
	}
}
