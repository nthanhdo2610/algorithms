public class Fibonacci {

    static int[] F;
    static int countRecursiveCall = 0;
    public static void main(String[] args) {
    	
        countRecursiveCall = 0;
        System.out.println("-------------Brute force Version-------------------");
        System.out.println("miu.edu.algorithms.Fibonacci Number : "+bruteForceFibo(30));
        System.out.println("No of recursive calls: "+countRecursiveCall);
        countRecursiveCall = 0;
        System.out.println("----------------Memoized Version-----------------");
        System.out.println("miu.edu.algorithms.Fibonacci Number :"+ memoizedFibo(30));
        System.out.println("No of recursive calls: "+countRecursiveCall);
    }
    
    public static int bruteForceFibo(int n){
        countRecursiveCall++;
        if( n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else
            return bruteForceFibo(n - 2) + bruteForceFibo(n - 1);
    }
    
    public static int memoizedFibo(int n){
        F = new int[n + 1];
        for(int i = 0; i <= n;i++){
            F[i] = -1;
        }
        return fibo(n);
    }
    public static int fibo(int n){
    	countRecursiveCall++;
        if(F[n] < 0){
            if( n == 0)
                F[n] = 0;
            else if(n == 1)
                F[n] = 1;
            else
                F[n] = fibo(n - 2) + fibo(n - 1);
        }
        return F[n];
    }
}
