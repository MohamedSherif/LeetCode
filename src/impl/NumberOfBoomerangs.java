package impl;

import java.util.HashMap;

public class NumberOfBoomerangs {
	public int numberOfBoomerangs(int[][] points) {
		int res = 0;
		HashMap<Integer, Integer> pointsMap = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points.length; j++) {
				int dist = getDistance(points[i], points[j]);
				pointsMap.put(dist, pointsMap.getOrDefault(dist, 0)+1);
			}
			for (int val : pointsMap.values()) {
				res += val*(val-1);
			}
			pointsMap.clear();
		}
		
		return res;
	}
	
	public static int getDistance(int[]a, int[]b){
		int i = a[0] - b[0];
		int j = a[1] - b[1];
		return i*i + j*j;
	}
}
