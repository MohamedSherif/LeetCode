package ctci;

public class MergeSort {
	
	public static void mergesort(int[] array) {
		mergesort(array, new int[array.length], 0, array.length - 1);
	}
	
	private static void mergesort(int[] array, int[] temp, int leftStart, int rightEnd) {
		if(leftStart >= rightEnd)
			return;
		
		int mid = (leftStart + rightEnd) / 2;
		
		mergesort(array, temp, leftStart, mid);
		mergesort(array, temp, mid + 1, rightEnd);
		mergeHalves(array, temp, leftStart, rightEnd);
	}
	
	private static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {
		int leftEnd = (rightEnd + leftStart) / 2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart + 1;
		
		int left = leftStart;
		int right = rightStart;
		int index = leftStart;
		
		while(left <= leftEnd && right <= rightEnd) {
			if(array[left] <= array[right]) {
				temp[index] = array[left];
				left++;
			} else {
				temp[index] = array[right];
			}
			index++;
		}
		
		System.arraycopy(array, left, temp, index, leftEnd - left + 1);
		System.arraycopy(array, right, temp, index, rightEnd - right + 1);
		System.arraycopy(temp, leftStart, array, leftStart, size);
	}
}
