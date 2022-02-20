package microsoft;

public class PalindromesSolver {

	public static int minAdjacentSwapsPalindrome(String s) {
		if (s == null || s.length() == 0)
			return -1;

		int noOfSwaps = 0;

		if (isShufflePalindrome(s)) {

			char[] chars = s.toCharArray();

			int p1 = 0, p2 = chars.length - 1;

			while (p1 < p2) {
				if (chars[p1] != chars[p2]) {
					int k = p2;

					while (k > p1 && chars[k] != chars[p1])
						k--;

					if (k == p1) {
						swap(chars, p1, p1 + 1);
						noOfSwaps++;
					} else {
						while (k < p2) {
							swap(chars, k, k + 1);
							noOfSwaps++;
							k++;
						}
						p1++;
						p2--;
					}
				} else {
					p1++;
					p2--;
				}
			}

		} else {
			return -1;
		}

		return noOfSwaps;
	}

	private static void swap(char[] chars, int i, int j) {
		char temp = chars[i];

		chars[i] = chars[j];
		chars[j] = temp;
	}

	private static boolean isShufflePalindrome(String s) {
		int[] freq = new int[26];

		for (int i = 0; i < s.length(); i++) {
			freq[s.charAt(i) - 'a']++;
		}

		int oddCount = 0;

		for (int value : freq) {
			if (value % 2 != 0) {
				oddCount++;
			}
		}

		return oddCount <= 1;

	}
	
	public static void main(String[] args) {
		System.out.println(minAdjacentSwapsPalindrome("ntiin"));
	}
}
