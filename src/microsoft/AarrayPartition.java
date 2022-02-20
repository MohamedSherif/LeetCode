package microsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AarrayPartition {

	public static List<List<Integer>> partition(int[] arr, int k){
		int[] sums = new int[k];
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> sums[a] - sums[b]);
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		for(int i = 0; i < k; i++) {
			result.add(new ArrayList<Integer>());
			pq.add(i);
		}
		
		for(int i = arr.length - 1; i >= 0;i--) {
			int c = pq.poll();
			
			result.get(c).add(arr[i]);
			sums[c] += arr[i];
			pq.add(c);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		List<List<Integer>> result = partition(new int[] {1,2,3,4,5,6,7,8,9,10}, 8);
		System.out.println(result);
	}

}
