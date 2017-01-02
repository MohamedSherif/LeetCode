package impl;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * Note: m and n will be at most 100.
 * 
 * @author Mohamed Sherif.
 *
 */
public class UniquePaths {

	/**
	 * Backtracking Solution: The most direct way is to write code that
	 * traverses each possible path, which can be done using backtracking. When
	 * you reach row=m and col=n, you know you’ve reached the bottom-right
	 * corner, and there is one additional unique path to it. However, when you
	 * reach row>m or col>n, then it’s an invalid path and you should stop
	 * traversing. For any grid at row=r and col=c, you have two choices:
	 * Traverse to the right or traverse to the bottom. Therefore, the total
	 * unique paths at grid (r,c) is equal to the sum of total unique paths from
	 * the grid to the right and the grid below. Below is the backtracking code
	 * in 5 lines of code:
	 * 
	 * 
	 * @param r
	 * @param c
	 * @param m
	 * @param n
	 * @return
	 */
	public static int backtrack(int r, int c, int m, int n) {
		if (r == (m - 1) && c == (n - 1))
			return 1;
		if (r > (m-1) || c > (n-1))
			return 0;

		return backtrack(r + 1, c, m, n) + backtrack(r, c + 1, m, n);
	}

	// ***********************************

	final static int M_MAX = 100;
	final static int N_MAX = 100;

	/**
	 * Improved Backtracking Solution using Memoization: 
	 * Although the above backtracking solution is easy to code, it is very inefficient in the
	 * sense that it recalculates the same solution for a grid over and over
	 * again. By caching the results, we prevent recalculation and only
	 * calculates when necessary. Here, we are using a dynamic programming (DP)
	 * technique called memoization.
	 * 
	 * 
	 * @param r
	 * @param c
	 * @param m
	 * @param n
	 * @param mat
	 * @return
	 */
	public static int backtrack(int r, int c, int m, int n, int mat[][]) {
		if (r == m && c == n)
			return 1;
		
		if (r > m || c > n)
			return 0;

		if (mat[r + 1][c] == -1)
			mat[r + 1][c] = backtrack(r + 1, c, m, n, mat);
		
		if (mat[r][c + 1] == -1)
			mat[r][c + 1] = backtrack(r, c + 1, m, n, mat);

		return mat[r + 1][c] + mat[r][c + 1];
	}

	public static int td(int m, int n) {
		int mat[][] = new int[M_MAX + 2][N_MAX + 2];
		for (int i = 0; i < M_MAX + 2; i++) {
			for (int j = 0; j < N_MAX + 2; j++) {
				mat[i][j] = -1;
			}
		}
		return backtrack(1, 1, m, n, mat);
	}

	/**
	 * Dynamic Programming Solution using Bottom-up Approach: 
	 * If you notice closely, the above DP solution is using a top-down approach. Now let’s
	 * try a bottom-up approach. Remember this important relationship that is
	 * necessary for this DP solution to work
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public static int dp(int m, int n) {
		int mat[][] = new int[M_MAX + 2][N_MAX + 2];

		for (int i = 0; i < M_MAX + 2; i++) {
			for (int j = 0; j < N_MAX + 2; j++) {
				mat[i][j] = 0;
			}
		}

		mat[m][n + 1] = 1;

		for (int r = m; r >= 1; r--) {
			for (int c = n; c >= 1; c--) {
				mat[r][c] = mat[r + 1][c] + mat[r][c + 1];
			}
		}
		return mat[1][1];
	}
	
	
	/**
	 * Another solution with 0 ms time.
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public static long getPaths(int m, int n){
		long[][] mat = new long[m+1][n+1];
		
		mat[0][1] = 1;
		
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				mat[i][j] = mat[i-1][j] + mat[i][j-1];
			}
		}
		
		return mat[m][n];
	}
	
	
	
	
	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		System.out.println(td(23, 12));
		long t2 = System.currentTimeMillis();
		
		System.out.println(dp(23, 12));
		long t3 = System.currentTimeMillis();
		
		System.out.println(getPaths(23, 12));
		long t4 = System.currentTimeMillis();
		
//		System.out.println(backtrack(0, 0, 23, 12));
//		long t5 = System.currentTimeMillis();
		
		System.out.println(t2-t1);
		System.out.println(t3-t2);
		System.out.println(t4-t3);
//		System.out.println(t5-t4);
	}

}
