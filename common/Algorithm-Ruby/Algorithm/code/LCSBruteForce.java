/**
 * 
 * @author eyuel
 *
 */
public class LCSBruteForce {
	public static int count;
	public static void main(String[] args) {
		char[] s1 = {'G','A','A','T','T','C','A','G','T','T','A'};
		char[] s2 = {'G','G','A','T','C','G','A'};
		double x = FindLCS(s1,s2,s1.length,s2.length);
		System.out.println("Count = "+count);
		System.out.println(x);
	}
	
	public static double FindLCS(char[] s1, char[] s2,int m, int n) {
		count++;
		if (m == 0) {
			return 0;
		}
		else if (n == 0) {
			return 0;
		}
		else if(s1[m-1] == s2[n-1]) {
			return FindLCS(s1,s2,m-1,n-1)+1;
		}
		else {
			return Math.max(FindLCS(s1, s2, m, n-1), FindLCS(s1, s2, m-1, n));

		}

	}

}