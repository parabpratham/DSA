package study.dsa.algo;

import java.util.HashMap;
import java.util.Map;

public class AnagramAllSubstring {

	/*
	 * Given 2 strings, check if any one of them has any anagram of the other
	 * string, as a substring of it.
	 */

	public static void main(String[] args) {

		String ip1 = "BACDGABCDAGFASCCDADFAW";
		String ip2 = "ABCDGFWA";

		char[] pat = ip1.toCharArray();
		char[] txt = ip2.toCharArray();

		for (int i = 0; i < pat.length; i++) {
			for (int k = 0; k < txt.length; k++)
				for (int j = 0; j < txt.length - k; j++) {

					if (i + j >= pat.length)
						continue;

					if (isAnagram(pat, txt, i, j, k))
						System.out.println("Found at " + i + " of length "
								+ (j + 1) + " ");
				}
		}

	}

	private static boolean isAnagram(char[] pat, char[] txt, int i, int j,
			int k2) {
		Map<Character, Integer> patMap = new HashMap<Character, Integer>();
		for (int k = i, t = k2; k <= i + j; k++, t++) {
			Character c1 = pat[k];
			if (patMap.get(c1) == null)
				patMap.put(c1, 1);
			else
				patMap.put(c1, 1 + patMap.get(c1));

			Character c2 = txt[t];
			if (patMap.get(c2) == null)
				patMap.put(c2, -1);
			else
				patMap.put(c2, patMap.get(c2) - 1);
		}

		if (patMap.size() == 0)
			return false;

		for (Character c : patMap.keySet())
			if (patMap.get(c) != 0) {
				return false;
			}
		return true;
	}

}
