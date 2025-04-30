/*
 * Author:- Tanmay
 */
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
//		int t=1;	
		int t=sc.nextInt();
//		outer:	
		while(t-- >0) {
			int n = sc.nextInt();
			int b[] = sc.readArray(n);
			TreeSet<Integer> set = new TreeSet<>();
			boolean f = true;
			set.add(b[0]);
			for(int i=1 ; i<n ; i++) {
				set.add(b[i]);
				if(b[i-1]==b[i]) {
					continue;
				}
				Integer find = set.lower(b[i]);
				if(find!=null && find==b[i-1]) {
					continue;
				}
				find = set.higher(b[i]);
				if(find!=null && find==b[i-1]) {
					continue;
				}
				f = false;
				break;
			}
			if(f == false) {
				out.println("NO");
			}
			else out.println("YES");
		}
		out.flush();
		out.close();
	}
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int [] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		long [] longArray(int n) {
			long[] a=new long[n];
			for(int i=0 ; i<n ; i++) a[i]=nextLong();
			return a;
		}
		double nextDouble() {
			return Double.parseDouble(next());
		}
	}
} 