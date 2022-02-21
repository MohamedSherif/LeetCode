package ctci;

public class BitManipulation {

	public static int lonelyIteger(int[] array) {
		int result = 0;
		
		for(int value : array) {
			result ^= value;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] array = {9, 1, 2, 3, 2, 9, 1, 7, 7};
		
		System.out.println(lonelyIteger(array));
	}
}
