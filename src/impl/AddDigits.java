package impl;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the
 * result has only one digit.
 * 
 * For example:
 * 
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only
 * one digit, return it.
 * 
 * Follow up: Could you do it without any loop/recursion in O(1) runtime?
 * 
 * Hint:
 * 	A naive implementation of the above process is trivial. Could you come up
 * 	with other methods?
 * 
 * @author MohamedSherif
 *
 */
public class AddDigits {

	public static int addDigits(int num) {
		int sum = 0;
		
		if(num < 10){
			return num;
		}
		
		while(num>0){
			sum = sum + (num%10);
			num = num/10;
		}
		
		return addDigits(sum);
	}
	
	public static void main(String[] args) {
		System.out.println(addDigits(38));
	}
}
