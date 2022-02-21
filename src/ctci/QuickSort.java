package ctci;

public class QuickSort {
	
	public static void quicksort(int[] array) {
		quicksort(array, 0, array.length - 1);
	}
	
	private static void quicksort(int[] array, int left, int right) {
		if(left >= right) {
			return;
		}
		
		// Select a pivot element first. 
		//In the center but there is other ways you can do it.
		int pivot = array[(left + right) / 2];
		
		int index = partition(array, left, right, pivot);
		
		quicksort(array, left, index - 1);
		quicksort(array, index, right);
	}
	
	private static int partition(int[] array, int left, int right, int pivot) {
		while(left <= right) {
			while(array[left] < pivot) {
				left++;
			}
			while(array[right] > pivot) {
				right--;
			}
			
			if(left <= right) {
				swap(array, left, right);
				left++;
				right--;
			}
		}
		return left;
	}
	
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
