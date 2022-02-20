package microsoft;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OA {

	public static int solution(String S) {
		// write your code in Java SE 8

		int B = 0, A = 0, L = 0, O = 0, N = 0;

		for (char c : S.toCharArray()) {
//            System.out.println(c);
			switch (c) {
			case 'B':
				B++;
				break;
			case 'A':
				A++;
				break;
			case 'L':
				L++;
				break;
			case 'O':
				O++;
				break;
			case 'N':
				N++;
				break;
			default:
				break;
			}
		}

		L = L / 2;
		O = O / 2;

		return Math.min(B, Math.min(A, Math.min(L, Math.min(O, N))));
	}

	/**
	 * Split the given string into minimum number of substrings with unique
	 * characters such that the concatenation of all the substrings will result in
	 * the given string.
	 * 
	 * @param str
	 * @return
	 */
	private static int minimumNumOfSubstring(String str) {
		int count = 0;

		Set<Character> occurMap = new HashSet<>();

		for (int i = 0; i < str.length(); i++) {
			if (occurMap.contains(str.charAt(i))) {
				count++;
				occurMap.clear();
			}
			occurMap.add(str.charAt(i));
		}
		return count + 1;
	}

	public static int minimumNumOfSubstring2(String S) {
		// write your code in Java SE 8
		int[] occur = new int[26];

		for (char c : S.toCharArray()) {
			occur[c - 'a']++;
		}

		Arrays.sort(occur);

		return occur[25];

	}

	public int potholes(String s) {
		int holes = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'X') {
				holes++;
				i += 2;
			}
		}
		return holes;
	}

	public static int solution(String S, int B) {
		// write your code in Java SE 8
		if (S == null || S.length() == 0 || !S.contains("x"))
			return 0;

		int count = 0;

		while (B > 0) {
			int potholeLength = 0;

			int i = S.length() > 0 && S.charAt(0) == 'x' ? 0 : S.indexOf(".x") + 1;

			while (i < S.length()) {
				if (S.charAt(i) == 'x' && (B - (potholeLength + 1)) >= 0) {
					potholeLength++;
					i++;
				}
				S = S.substring(i);
				break;
			}

			B = B - (potholeLength + 1);
			count += potholeLength;
		}

		return count;
	}

	/**
	 * There is a road consisting of N segments, numbered from 0 to
	 * 
	 * N-1, represented by a string S. Segment S[K] of the road may
	 * 
	 * contain a pothole, denoted by a single uppercase "x"
	 * 
	 * character, or may be a good segment without any potholes,
	 * 
	 * denoted by a single dot, ".".
	 * 
	 * For example, string ".X..X" means that there are two potholes in total in the
	 * road: one is located in segment S[1] and one in segment S[4]. All other
	 * segments are good.
	 * 
	 * The road fixing machine can patch over three consecutive segments at once
	 * with asphalt and repair all the potholes located within each of these
	 * segments. Good or already repaired segments remain good after patching them.
	 * 
	 * Your task is to compute the minimum number of patches required to repair all
	 * the potholes in the road.
	 * 
	 * Write a function:
	 * 
	 * int solution (string &S); that, given a string S of length N, returns the
	 * minimum number of patches required to repair all the potholes.
	 * 
	 * Examples:
	 * 
	 * Given S = ".x..x", your function should return 2. The road fixing machine
	 * could patch, for example, segments 0-2 and 2-4.
	 * 
	 * @return
	 */
	public static int minNumOfMachine(String s) {
		if (s== null || s.length() == 0) return 0;
		
		int machineCount = 0, n = s.length();
		
		for(int i = 0; i<n; i++) {
			if(s.charAt(i) == 'x') {
				machineCount++;
				i += 2;
			}
		}
		return machineCount;
	}

	public static void main(String[] args) {
//		System.out.println(solution("QAWABAWONL"));
//		System.out.println(minimumNumOfSubstring2("abba"));
//		System.out.println(minimumNumOfSubstring("abba"));

//		'...xxx..x....xxx.', 7
//		System.out.println(solution("x.x.xxx...x", 14));
//		System.out.println(solution("...xxx..x....xxx.", 7));
		
		System.out.println(minNumOfMachine(".xxxx.xx"));

	}

}