package miu.edu.algorithms.assignment11.fib;

public class LCSMain {
    private static int[][] L;
    private static int count = 0;

    public static void main(String[] args) {
        String s1 = "cababc";
        String s2 = "abdcb";
        System.out
                .println("-------------Brute force Version-------------------");
        count = 0;
        System.out.println("LCS Length : " + brute(s1, s2, 6, 5));
        System.out
                .println("No of recursive calls: " + count);

        System.out.println("----------------Memoized Version-----------------");
        count = 0;
        System.out.println("LCS Length : " + memoized(s1, s2, 6, 5));
        System.out.println("No of recursive calls: " + count);
    }

    public static int brute(String s1, String s2, int m, int n) {
        count++;
        if (m == 0)
            return 0;
        else if (n == 0)
            return 0;
        else if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return brute(s1, s2, m - 1, n - 1) + 1;
        else
            return Math.max(brute(s1, s2, m, n - 1), brute(s1, s2, m - 1, n));
    }

    public static int memoized(String s1, String s2, int m, int n) {
        L = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= n; j++)
                L[i][j] = -1;
        return computeMemoized(s1, s2, m, n);
    }

    public static int computeMemoized(String s1, String s2, int m, int n) {
        if (L[m][n] < 0) {
            count++;
            if (n == 0)
                L[m][0] = 0;
            else if (m == 0)
                L[0][n] = 0;
            else if (s1.charAt(m - 1) == s2.charAt(n - 1))
                L[m][n] = computeMemoized(s1, s2, m - 1, n - 1) + 1;
            else
                L[m][n] = Math.max(computeMemoized(s1, s2, m, n - 1),
                        computeMemoized(s1, s2, m - 1, n));
        }
        return L[m][n];
    }
}
