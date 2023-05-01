/**
 * 
 * @author eyuel
 *
 */
public class LCSMemoized {
	public static int count;
	public static void main(String[] args) {
		//char[] s1 = {'G','A','A','T','T','C','A','G','T','T','A'};
		String s1 = "GAATTCAGTTA";
		String s2 = "GGATCGA";
		//char[] s2 = {'G','G','A','T','C','G','A'};
		double x = LCS(s1,s2);
		System.out.println("Count = "+count);
		System.out.println(x);
	}
	
	public static int LCS(String s1, String s2,int m,int n,int[][] L) {
		count++;
		if(L[m][n] < 0) {
			if(m==0) {
				
				L[0][n] = 0;
			}
			else if( n == 0) {
				L[m][0] = 0;
			}
			else if(s1.charAt(m-1)== s2.charAt(n-1)) {
				L[m][n] = LCS(s1,s2,m-1,n-1,L) + 1;
			}
			else {
				L[m][n] = Math.max(LCS(s1,s2,m,n-1,L), LCS(s1,s2,m-1,n,L));
			}	
		}
		return L[m][n];
	}
	public static int LCS(String s1, String s2) {
		int x = s1.length()-1;
		int y = s2.length()-1;
		int[][] L = new int[x+1][y+1];
		for(int i=0;i<=x;i++) {
			for(int j=0;j<=y;j++) {
				L[i][j]= -1;
			}
		}
		return LCS(s1,s2,x,y,L);
	}

}
