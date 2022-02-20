package microsoft;

public class UniqueIntegers {
	
	public static int[] sumZero(int n) {
		int[] arr = new int[n];
		
		arr[0] = -(n-1);
		arr[n-1] = n-1;
		
		for(int i = 1; i < n-1; i++) {
			arr[i] = arr[i-1] + 2;
		}
		
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = sumZero(7);
		
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			sum += arr[i];
		}
		System.out.println();
		System.out.println(sum);
	}
}
