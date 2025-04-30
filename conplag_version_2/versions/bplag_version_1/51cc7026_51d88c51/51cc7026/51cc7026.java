
import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;
public class C_Balanced_Stone_Heaps {
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;
 
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
 
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
 
		int nextInt() {
			return Integer.parseInt(next());
		}
 
		long nextLong() {
			return Long.parseLong(next());
		}
 
		double nextDouble() {
			return Double.parseDouble(next());
		}
 
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
 
		int[] nextIntArray(int n) {
			int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(next());
			}
			return a;
		}
 
	}
	
    public static int t, n;
    public static int H[];
	private static long startTime = System.currentTimeMillis();
	public static void main(String[] args) {
		FastReader sc =new FastReader();
		t = sc.nextInt();
        while (t-->0) {
            n = sc.nextInt();
            H = new int[n];
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
                H[i] = sc.nextInt();
                max = Math.max(H[i], max);
                min = Math.min(H[i], min);
            }
            int mid = 0;
            while (min < max) {
                mid = min + (max-min+1)/2;
                if(check(mid)) {
                    min = mid;
                }
                else max = mid-1;
            }			

            System.out.println(min);
        }

	}

    public static boolean check(int x){
        int S[] = Arrays.copyOf(H, H.length);
        for (int i = n-1; i >= 2; i--) {
            if(S[i]<x) return false;

            int move = Math.min(S[i]-x, H[i])/3;
            if(i>=2){
                // S[i]-=move*3;
                S[i-1]+=(move);
                S[i-2]+=2*(move);
            }
        }
        return S[0]>= x && S[1] >= x;
    }

}
