/**
 * 
 * @author eyuel
 *
 */
public class FibonacciBrute {
	static int counter;
	public static void main(String[] args) {
		long x = findFibonacci(30);
		System.out.println(x);
				System.out.println("Count = "+counter);
	}
	
	public static long findFibonacci(long n) {
		counter ++;
		if(n == 0) {
			return 0;
		}
		else if(n == 1) {
			return 1;
		}
		else {
			return findFibonacci(n-1)+findFibonacci(n-2);
		}

	}
}