package miu.edu.algorithms.assignment11.fib;

public class FiboMain {

    private static int[] F;
    private static int count = 0;

    public static void main(String[] args) {

        count = 0;
        int n = 30;
        System.out.println("-------------Brute force Version-------------------");
        System.out.println("Fibonacci Number : " + brute(n));
        System.out.println("No of recursive calls: " + count);
        count = 0;
        System.out.println("----------------Memoized Version-----------------");
        System.out.println("Fibonacci Number :" + memoized(n));
        System.out.println("No of recursive calls: " + count);
    }

    public static int brute(int n) {
        count++;
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return brute(n - 2) + brute(n - 1);
    }

    public static int memoized(int n) {
        F = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            F[i] = -1;
        }
        return fillFibo(n);
    }

    public static int fillFibo(int n) {
        count++;
        if (F[n] < 0) {
            if (n == 0)
                F[n] = 0;
            else if (n == 1)
                F[n] = 1;
            else
                F[n] = fillFibo(n - 2) + fillFibo(n - 1);
        }
        return F[n];
    }
}
