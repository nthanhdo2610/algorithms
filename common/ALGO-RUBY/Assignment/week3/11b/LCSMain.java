/**
 *
 * @author 984233
 */
public class LCSMain {
	public static int L[][];
	public static int recCount = 0;

	public static void main(String[] args) {

		System.out
				.println("-------------Brute force Version-------------------");
		recCount = 0;
		System.out.println("LCS Length : "+bruteForceLcs("cababc", "abdcb", 6, 5));
		System.out
				.println("No of recursive calls: " + recCount);

		System.out.println("----------------Memoized Version-----------------");
		recCount = 0;
		System.out.println("LCS Length : "+memoizedLCS("cababc", "abdcb", 6, 5));
		System.out.println("No of recursive calls: " + recCount);
	}

	public static int bruteForceLcs(String s1, String s2, int m, int n) {
		recCount++;
		if (m == 0)
			return 0;
		else if (n == 0)
			return 0;
		else if (s1.charAt(m - 1) == s2.charAt(n - 1))
			return bruteForceLcs(s1, s2, m - 1, n - 1) + 1;
		else
			return Math.max(bruteForceLcs(s1, s2, m, n - 1), bruteForceLcs(s1, s2, m - 1, n));
	}

	public static int memoizedLCS(String s1, String s2, int m, int n) {
		L = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++)
			for (int j = 0; j <= n; j++)
				L[i][j] = -1;
		return computeLCSMemoized(s1, s2, m, n);
	}

	public static int computeLCSMemoized(String s1, String s2, int m, int n) {
		if (L[m][n] < 0) {
			recCount++;
			if (n == 0)
				L[m][0] = 0;
			else if (m == 0)
				L[0][n] = 0;
			else if (s1.charAt(m - 1) == s2.charAt(n - 1))
				L[m][n] = computeLCSMemoized(s1, s2, m - 1, n - 1) + 1;
			else
				L[m][n] = Math.max(computeLCSMemoized(s1, s2, m, n - 1),
						computeLCSMemoized(s1, s2, m - 1, n));
		}
		return L[m][n];
	}
}
