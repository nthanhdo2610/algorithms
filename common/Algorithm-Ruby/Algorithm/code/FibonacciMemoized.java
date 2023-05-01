/**
 * 
 * @author eyuel
 *
 */
public class FibonacciMemoized {
	public static int count;
	
	public static void main(String[] args) {
		long g = FindFibonacci(30);
		System.out.println(g);
		System.out.println("Count = "+count);
	} 
	public static long FindFibonacci(int n) {
	    long[] val = new long[n+1];
		for(int i=0;i<=n;i++) {
			val[i] = -1;
		}
		return RecursiveFib(n,val);
	}
	public static long RecursiveFib(int n,long[]val) {
		count++;
		if(val[n] < 0) {
			if(n == 0) {
				val[n] = 0;
			}
			else if(n == 1) {
				val[n] = 1;
			}
			else {
				val[n] = RecursiveFib(n-1,val) + RecursiveFib(n-2,val);
			}
		}
		return val[n];
	}

}