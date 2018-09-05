package impl;

/**
 * Excel Column Number:
 * 	Given a column title as appears in an Excel sheet, return its
 * 	corresponding column number.
 * 
 * Example:
 * 		A -> 1
 * 		B -> 2
 * 		C -> 3
 * 		...
 * 		Z -> 26
 * 		AA -> 27
 * 		AB -> 28
 * 
 * @param A
 * @return
 */
public class ExcelColumnNumber {
	
	public static int excelColumnNumber(String A) {
		int n = A.length();

		int value = 0;
		for (int i = 0; i < n; i++) {
			value += Math.pow(26, i) * (A.charAt(n - (i + 1)) - 'A' + 1);
		}
		return value;
	}

	public int titleToNumber(String A) {
		int[] val;

		val = new int[26];

		for (int i = 0; i < 26; i++) {
			val[i] = i + 1;
		}

		int ten = 1;
		int value = 0;

		for (int i = A.length() - 1; i >= 0; i--) {
			char c = A.charAt(i);
			value += (ten * val[c - 'A']);
			ten *= 26;
		}

		return value;
	}
	
}
