import java.util.*;
import java.io.*;
import java.math.*;

public class A {

	// -- static variables --- //
	static FastReader		sc	= new FastReader();
	static PrintWriter	out	= new PrintWriter(System.out);
	static int					mod	= (int) 1000000007;

	public static void main(String[] args) throws Exception {

		int t = sc.nextInt();
		while (t-- > 0)
			A.go();
		// out.println();
		out.flush();
	}

	// >>>>>>>>>>>>>>>>>>> Code Starts <<<<<<<<<<<<<<<<<<<< //
	static class pair {
		int x, y;

		pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			pair other = (pair) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}
	static void go() throws Exception {
		int n=sc.nextInt();
		ArrayList<ArrayList<Integer>> aa=new ArrayList<>();
		for(int i=0;i<n;i++) {
			aa.add(new ArrayList<>());
		}
		LinkedHashMap<pair,Integer> map=new LinkedHashMap<>();
		for(int i=0;i<n-1;i++) {
			int u=sc.nextInt()-1,v=sc.nextInt()-1;
			aa.get(u).add(v);
			aa.get(v).add(u);
			if(u>v) {
				int temp=v;
				v=u;u=temp;
			}
			map.put(new pair(u,v),0);
		}
		
		for(ArrayList<Integer> i : aa) {
			if(i.size()>2) {
				out.println(-1);
				return;
			}
		}
	

		boolean vis[]=new boolean[n];
		dfs(aa,0,vis,2,map);
		for(pair i : map.keySet()) {
			out.print(map.get(i)+" ");
		}
		out.println();
	}
	static void dfs(ArrayList<ArrayList<Integer>> aa,int src,boolean vis[],int see,LinkedHashMap<pair,Integer> map) {
		vis[src]=true;
		for(int i: aa.get(src)) {
			if(vis[i]==false) {
					int x=src,y=i;
					if(x>y) {
						int temp=x;
						x=y;
						y=temp;
					}
					pair temp=new pair(x,y);
					if(see==2) {
							map.put(temp,5);
							see=5;
					}else {
						map.put(temp,2);
						see=2;
					}
					dfs(aa,i,vis,see,map);
			}
		}
	}
	static long lcm(long a, long b) {
		return a * b / gcd(a, b);
	}

	// >>>>>>>>>>> Code Ends <<<<<<<<< //

	// --For Rounding--//
	static double round(double value, int places) {

		if (places < 0)
			throw new IllegalArgumentException();
		BigDecimal bd = new BigDecimal(Double.toString(value));
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	// ----Greatest Common Divisor-----//
	static long gcd(long a, long b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	// --- permutations and Combinations ---//
	static long	fact[];
	static long	invfact[];

	static long ncr(int n, int k) {
		if (k < 0 || k > n) {
			return 0;
		}
		long x = fact[n];
		long y = fact[k];
		long yy = fact[n - k];
		long ans = (x / y);
		ans = (ans / yy);
		return ans;
	}

	// ---sieve---//
	static int prime[] = new int[1000006];

	// static void sieve() {
	//     Arrays.fill(prime, 1);
	//     prime[0] = 0;
	//     prime[1] = 0;
	//     for (int i = 2; i * i <= 1000005; i++) {
	//         if (prime[i] == 1)
	//             for (int j = i * i; j <= 1000005; j +)= i) {
	//                 prime[j] = 0;
	//             }
	//     }
	// }

	// ---- Manual sort ------//
	static void sort(long[] a) {
		ArrayList<Long> aa = new ArrayList<>();
		for (long i : a) {
			aa.add(i);
		}
		Collections.sort(aa);
		for (int i = 0; i < a.length; i++)
			a[i] = aa.get(i);
	}

	static void sort(int[] a) {
		ArrayList<Integer> aa = new ArrayList<>();
		for (int i : a) {
			aa.add(i);
		}
		Collections.sort(aa);
		for (int i = 0; i < a.length; i++)
			a[i] = aa.get(i);
	}

	// --- Fast exponentiation ---//
	static long pow(long x, long y) {
		long res = 1l;
		while (y != 0) {
			if (y % 2 == 1) {
				res = (x * res);
			}
			y /= 2;
			x = (x * x);
		}
		return res;
	}

	// >>>>>>>>>>>>>>> Fast IO <<<<<<<<<<<<<< //
	static class FastReader {
		BufferedReader	br;
		StringTokenizer	st;

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

		int[] intArray(int n) {
			int a[] = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();
			return a;
		}

		long[] longArray(int n) {
			long a[] = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = sc.nextLong();
			return a;
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
	}
}