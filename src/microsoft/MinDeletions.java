package microsoft;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 1647. Minimum Deletions to Make Character Frequencies Unique Medium
 * 
 * A string s is called good if there are no two different characters in s that
 * have the same frequency.
 * 
 * Given a string s, return the minimum number of characters you need to delete
 * to make s good.
 * 
 * The frequency of a character in a string is the number of times it appears in
 * the string. For example, in the string "aab", the frequency of 'a' is 2,
 * while the frequency of 'b' is 1.
 * 
 * Example 1:
 * 
 * Input: s = "aab" Output: 0 Explanation: s is already good. Example 2:
 * 
 * Input: s = "aaabbbcc" Output: 2 Explanation: You can delete two 'b's
 * resulting in the good string "aaabcc". Another way it to delete one 'b' and
 * one 'c' resulting in the good string "aaabbc". Example 3:
 * 
 * Input: s = "ceabaacb" Output: 2 Explanation: You can delete both 'c's
 * resulting in the good string "eabaab". Note that we only care about
 * characters that are still in the string at the end (i.e. frequency of 0 is
 * ignored).
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 105 s contains only lowercase English letters.
 * 
 * @author m.sherif
 *
 */
public class MinDeletions {
	public static int minDeletions(String s) {

		if (s == null || s.length() < 2) {
			return 0;
		}

		int deletionCount = 0;

		Map<Character, Integer> charFreq = new HashMap<Character, Integer>();

		for (char c : s.toCharArray()) {
			charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
		}

		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);

		maxHeap.addAll(charFreq.values());

		while (!maxHeap.isEmpty()) {
			int num = maxHeap.remove();

			if (maxHeap.contains(num)) {
				num--;
				deletionCount++;
				if (num != 0) {
					maxHeap.add(num);
				}
			}
		}

		return deletionCount;
	}

	public static int minDeletions2(String s) {
		int[] freq = new int[26];

		for (char c : s.toCharArray()) {
			freq[c - 'a']++;
		}

		Arrays.sort(freq);

		int exp = freq[25];
		int res = 0;

		for (int i = 25; i >= 0; i--) {
			if (freq[i] == 0)
				break;
			if (freq[i] > exp) {
				res += freq[i] - exp;
			} else {
				exp = freq[i];
			}
			if (exp > 0) {
				exp--; // Lowest exp is zero, cannot be negative
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String s = "aaabbbcc";

		System.out.println(minDeletions(s));
		System.out.println(minDeletions2(s));
	}
}
