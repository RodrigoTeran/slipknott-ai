import java.util.*;
import java.io.*;
import java.math.*;

/**
 *
 * @Har_Har_Mahadev
 */

/**
 * Main , Solution , Remove Public
 */
public class A {

	private static long[][] dp;
	private static ArrayList<Integer> lis1,lis0;

	public static void process() throws IOException {

		int n = sc.nextInt();
		int arr[] = sc.readArray(n);
		lis1 = new ArrayList<Integer>();
		lis0 = new ArrayList<Integer>();
		for(int i = 0; i<n; i++) {
			if(arr[i] == 1)lis1.add(i+1);
			else lis0.add(i+1);
		}
		Collections.sort(lis0);
		Collections.sort(lis1);
		int n0 = lis0.size();
		int n1 = lis1.size();
		dp = new long[n0+1][n1+1];
		for(int i = 0; i<=n0; i++) {
			Arrays.fill(dp[i], -1);
		}
		long ans = solve(0,0,n0,n1);
		println(ans);
		

	}

	private static long solve(int i, int j, int n0, int n1) {
		if(j == n1)return 0;
		if(i == n0)return INF;
		if(dp[i][j] != -1)return dp[i][j];
		long ans = solve(i+1, j, n0, n1);
		ans = min(ans,abs(lis0.get(i) - lis1.get(j)) + solve(i+1, j+1, n0, n1));
		return dp[i][j] = ans;
	}

	//=============================================================================
	//--------------------------The End---------------------------------
	//=============================================================================
	private static long INF = 2000000000000000000L, M = 1000000007, MM = 998244353;
	private static int N = 0;

	private static void google(int tt) {
		System.out.print("Case #" + (tt) + ": ");
	}

	static FastScanner sc;
	static PrintWriter out;

	public static void main(String[] args) throws IOException {
		boolean oj = true;
		if (oj) {
			sc = new FastScanner();
			out = new PrintWriter(System.out);
		} else {
			sc = new FastScanner(100);
			out = new PrintWriter("output.txt");
		}
		int t = 1;
//		t = sc.nextInt();
		int TTT = 1;
		while (t-- > 0) {
			//			google(TTT++);
			process();
		}
		out.flush();
		out.close();
	}

	static class Pair implements Comparable<Pair> {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pair o) {
			return Integer.compare(this.x, o.x);
		}

		//		 @Override
		//		    public boolean equals(Object o) {
		//		        if (this == o) return true;
		//		        if (!(o instanceof Pair)) return false;
		//		        Pair key = (Pair) o;
		//		        return x == key.x && y == key.y;
		//		    }
		//		 
		//		    @Override
		//		    public int hashCode() {
		//		        int result = x;
		//		        result = 31 * result + y;
		//		        return result;
		//		    }
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////

	static void println(Object o) {
		out.println(o);
	}

	static void println() {
		out.println();
	}

	static void print(Object o) {
		out.print(o);
	}

	static void pflush(Object o) {
		out.println(o);
		out.flush();
	}

	static int ceil(int x, int y) {
		return (x % y == 0 ? x / y : (x / y + 1));
	}

	static long ceil(long x, long y) {
		return (x % y == 0 ? x / y : (x / y + 1));
	}

	static int max(int x, int y) {
		return Math.max(x, y);
	}

	static int min(int x, int y) {
		return Math.min(x, y);
	}

	static int abs(int x) {
		return Math.abs(x);
	}

	static long abs(long x) {
		return Math.abs(x);
	}

	static long sqrt(long z) {
		long sqz = (long) Math.sqrt(z);
		while (sqz * 1L * sqz < z) {
			sqz++;
		}
		while (sqz * 1L * sqz > z) {
			sqz--;
		}
		return sqz;
	}

	static int log2(int N) {
		int result = (int) (Math.log(N) / Math.log(2));
		return result;
	}

	static long max(long x, long y) {
		return Math.max(x, y);
	}

	static long min(long x, long y) {
		return Math.min(x, y);
	}

	public static int gcd(int a, int b) {
		BigInteger b1 = BigInteger.valueOf(a);
		BigInteger b2 = BigInteger.valueOf(b);
		BigInteger gcd = b1.gcd(b2);
		return gcd.intValue();
	}

	public static long gcd(long a, long b) {
		BigInteger b1 = BigInteger.valueOf(a);
		BigInteger b2 = BigInteger.valueOf(b);
		BigInteger gcd = b1.gcd(b2);
		return gcd.longValue();
	}

	public static long lcm(long a, long b) {
		return (a * b) / gcd(a, b);
	}

	public static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}

	public static int lower_bound(int[] arr, int x) {
		int low = 0, high = arr.length, mid = -1;

		while (low < high) {
			mid = (low + high) / 2;

			if (arr[mid] >= x)
				high = mid;
			else
				low = mid + 1;
		}

		return low;
	}

	public static int upper_bound(int[] arr, int x) {
		int low = 0, high = arr.length, mid = -1;

		while (low < high) {
			mid = (low + high) / 2;

			if (arr[mid] > x)
				high = mid;
			else
				low = mid + 1;
		}

		return low;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner() throws FileNotFoundException {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		FastScanner(int a) throws FileNotFoundException {
			br = new BufferedReader(new FileReader("input.txt"));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		String nextLine() throws IOException {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

		int[] readArray(int n) throws IOException {
			int[] A = new int[n];
			for (int i = 0; i != n; i++) {
				A[i] = sc.nextInt();
			}
			return A;
		}

		long[] readArrayLong(int n) throws IOException {
			long[] A = new long[n];
			for (int i = 0; i != n; i++) {
				A[i] = sc.nextLong();
			}
			return A;
		}
	}

	static void ruffleSort(int[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
		Arrays.sort(a);
	}

	static void ruffleSort(long[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
			long temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
		Arrays.sort(a);
	}
}
