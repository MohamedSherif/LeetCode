package ctci;

import java.util.Iterator;

public class ConnectedOnes {

	/**
	 * You given a matrix of zeroes and ones and we want to find the largest region
	 * of connected one. Where that's defined to be ones that are adjacent to each
	 * other, either looking horizontally, vertically, or diagonally.
	 * 
	 * So, Depth First Search (DFS) is perfect for this problem.
	 * 
	 * We could use Breadth-First Search (BFS) instead but generally we find DFS
	 * easier to implement.
	 * 
	 * @param matrix
	 * @return
	 */
	public static int getBiggestRegion(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int maxRegion = 0;

		// To be used to mark every cell in the region as visited to not doing the same
		// work again.
		// If we are ok with destroying the original matrix, then let's just and every
		// time we get to a value in this region just update the original matrix and
		// clear that one to make it a zero. and that will avoid issue.
		// If we are not Okay with destroying the original matrix then we can just clone
		// the matrix, it is ulimately the same thing.
//		boolean[][] visited = new boolean[matrix.length][matrix[0].length];

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				if (matrix[row][col] == 1) {
					int regionSize = getRegionSize(matrix, row, col);
					maxRegion = Math.max(maxRegion, regionSize);
				}
			}
		}

		return maxRegion;
	}

	private static int getRegionSize(int[][] matrix, int row, int col) {
		// Boundary checks
		if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[row].length) {
			return 0;
		}
		
		if(matrix[row][col] == 0) {
			return 0;
		}
		matrix[row][col] = 0;
		
		int size = 1;
		
		for(int r = row - 1; r <= row +1; r++) {
			for(int c = col - 1; c <= row + 1; c++) {
				if(r != row || c != col) {
					size += getRegionSize(matrix, r, c);
				}
			}
		}
		
		return size;
	}
}
