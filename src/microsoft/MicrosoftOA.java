package microsoft;

class Node {
	int data;
	Node left, right;

	// Constructor of the class
	public Node(int item) {
		data = item;
		left = right = null;
	}
}

public class MicrosoftOA {

	static int countDeletions(String s) {
		int result = 0;
		char[] str = s.toCharArray();

		for (int i = 0; i < str.length - 1; i++) {
			// If two consecutive characters are
			// the same, delete one of them.
			if (str[i] == str[i + 1])
				result++;
		}

		return result;
	}

	public int solution(String S, int[] C) {
		// write your code in Java SE 8

		int totalCost = 0;

		int numOfDeletion = 0;

		for (int i = 0; i < S.length() - 1; i++) {
			if (S.charAt(i) == S.charAt(i + 1)) {
				numOfDeletion++;

				totalCost = totalCost + Math.min(C[i], C[i + 1]);
			}
		}

		return totalCost;
	}

	

	static int preOrder(Node node, int max) {

		// Base case
		if (node == null) {
			return 0;
		}
		
		int count = 0;

		// If the current node value is greater
		// or equal to the max value,
		// then update count variable
		// and also update max variable
		if (node.data >= max) {
			count++;
		}
		
		max = Math.max(node.data, max);

		// Traverse to the left
		return preOrder(node.left, max) + preOrder(node.right, max) + count;
	}
	
	public static int solution(Node root) {
		return preOrder(root, Integer.MIN_VALUE);
	}
	
	public static int solution33(int[] A) {
        // write your code in Java SE 8
        int numOfRelocations = 0;
        
        int currentSum = 0;

        for(int i = 0; i < A.length - numOfRelocations; i++) {
            int maxExpense = 0;
            int maxExpenseIndex = -1;
            currentSum += A[i];

            if(currentSum < 0) {
                // Find the largest expense, and move it to the end.
                for(int j = 0; j < A.length - numOfRelocations; j++){
                    if(A[j] < maxExpense){
                        maxExpense = A[j];
                        maxExpenseIndex = j;
                    }
                }
                // maxExpense contains the Largest Expense;
                relocate(A, maxExpenseIndex);
                numOfRelocations ++;
                
                currentSum = currentSum - A[i];
                i--;
            }
            
        }

        return numOfRelocations;
    }

    private static void relocate(int[] A, int index) {
        int temp = A[index];

        for(int i = index; i < A.length - 1; i++) {
            A[i] = A[i + 1];
        }
        A[A.length - 1] = temp;
    }
    
    public static void main(String[] args) {
//		int[] arr =  {-1, -1, -1, 1, 1, 1, 1};
//		
//		solution33(arr);
    	
    	Node root = new Node(5);
    	root.left = new Node(3);
    	root.right = new Node(10);
    	
    	root.left.left = new Node(20);
    	root.left.right = new Node(21);
    	
    	root.right.left = new Node(1);
    	
    	System.out.println(solution(root));
	}
}
