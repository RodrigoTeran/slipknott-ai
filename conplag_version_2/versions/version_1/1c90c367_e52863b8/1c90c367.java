
/*

    /$$$$$  /$$$$$$  /$$    /$$  /$$$$$$                                                                  
   |__  $$ /$$__  $$ |$$    |$$ /$$__  $$                                                                 
          | $$| $$  \ $$|    $$|$$| $$  \ $$                                                                 
          | $$| $$$$$$$$|  $$ / $$/| $$$$$$$$                                                                 
/ $$  | $$| $$__  $$ \  $$ $$/ | $$__  $$                                                                 
| $$  | $$| $$  | $$  \  $$$/  | $$  | $$                                                                 
|  $$$$$$/| $$  | $$   \  $/   | $$  | $$                                                                 
 \______/ |__/  |__/    \_/    |__/  |__/                                                                 
/$$$$$$$  /$$$$$$$   /$$$$$$   /$$$$$$  /$$$$$$$   /$$$$$$  /$$      /$$ /$$      /$$ /$$$$$$$$ /$$$$$$$ 
| $$__  $$| $$__  $$ /$$__  $$ /$$__  $$| $$__  $$ /$$__  $$| $$$    /$$$| $$$    /$$$| $$_____/| $$__  $$
| $$  \ $$| $$  \ $$| $$  \ $$| $$  \__/| $$  \ $$| $$  \ $$| $$$$  /$$$$| $$$$  /$$$$| $$      | $$  \ $$
| $$$$$$$/| $$$$$$$/| $$  | $$| $$ /$$$$| $$$$$$$/| $$$$$$$$| $$ $$/$$ $$| $$ $$/$$ $$| $$$$$   | $$$$$$$/
| $$____/ | $$__  $$| $$  | $$| $$|_  $$| $$__  $$| $$__  $$| $$  $$$| $$| $$  $$$| $$| $$__/   | $$__  $$
| $$      | $$  \ $$| $$  | $$| $$  \ $$| $$  \ $$| $$  | $$| $$\  $ | $$| $$\  $ | $$| $$      | $$  \ $$
| $$      | $$  | $$|  $$$$$$/|  $$$$$$/| $$  | $$| $$  | $$| $$ \/  | $$| $$ \/  | $$| $$$$$$$$| $$  | $$
|__/      |__/  |__/ \______/  \______/ |__/  |__/|__/  |__/|__/     |__/|__/     |__/|________/|__/  |__/
																																																				
																																																				

*/

import java.io.BufferedReader;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.io.*;

public class abc {
	static PrintWriter pw;

	static long x = 1, y = 1;

	/*
	 * static long inv[]=new long[1000001]; static long dp[]=new long[1000001];
	 */
	/// MAIN FUNCTION///
	public static void main(String[] args) throws Exception {

		FastReader sc = new FastReader();
		pw = new PrintWriter(System.out);
		// use arraylist as it uses the concept of dynamic table(amortized analysis)
		// Arrays.stream(array).forEach(a -> Arrays.fill(a, 0));
		/* List<Integer> l1 = new ArrayList<Integer>(); */
		// Random rand = new Random();
		int tst = sc.nextInt();
		while(tst-->0) {
			int n=sc.nextInt();
			int app[]=new int[n];
			int h[]=new int[n];
			for(int i=0;i<n;i++)
			{
				app[i]=sc.nextInt();
			}
			for(int i=0;i<n;i++)
			{
				h[i]=sc.nextInt();
			}
			long man = 0;
			long last = app[n - 1] - h[n - 1] + 1;
			int end = n-1;
			for (int i = n-2; i >=0; i--) {
				if(app[i]>=last) {
					last = Math.min(last,app[i] - h[i] + 1);
				}
				else {
					long s = app[end]-last+1;
					man += (s*(s+1))/2;
					end = i;
					last = app[i] - h[i] + 1;;
				}
			}
			long s = app[end]-last+1;
			man += (s*(s+1))/2;
			pw.println(man);
		}
		pw.flush();
	}

	public static long eculidean_gcd(long a, long b) {
		if (a == 0) {
			x = 0;
			y = 1;
			return b;
		}
		long ans = eculidean_gcd(b % a, a);
		long x1 = x;
		x = y - (b / a) * x;
		y = x1;
		return ans;
	}

	public static int sum(int n) {
		int sum = 1;
		if (n == 0)
			return 0;
		while (n != 0) {
			sum = sum * n;
			n = n - 1;
		}
		return sum;
	}

	public static boolean isLsbOne(int n) {
		if ((n & 1) != 0)
			return true;
		return false;
	}

	public static pair helper(int arr[], int start, int end, int k, pair dp[][]) {
		if (start >= end) {
			if (start == end)
				return (new pair(arr[start], 0));
			else
				return (new pair(0, 0));
		}
		if (dp[start][end].x != -1 && dp[start][end].y != -1) {
			return dp[start][end];
		}
		pair ans = new pair(0, Integer.MAX_VALUE);
		for (int i = start; i < end; i++) {
			pair x1 = helper(arr, start, i, k, dp);
			pair x2 = helper(arr, i + 1, end, k, dp);
			long tip = k * (x1.x + x2.x) + x1.y + x2.y;
			if (tip < ans.y)
				ans = new pair(x1.x + x2.x, tip);
		}
		return dp[start][end] = ans;
	}

	public static void debugger() {
		Random rand = new Random();
		int tst = (int) (Math.abs(rand.nextInt()) % 2 + 1);
		pw.println(tst);
		while (tst-- > 0) {
			int n = (int) (Math.abs(rand.nextInt()) % 5 + 1);
			pw.println(n);
			for (int i = 0; i < n; i++) {
				pw.print((int) (Math.abs(rand.nextInt()) % 6 + 1) + " ");
			}
			pw.println();
		}
	}

	static int UpperBound(long a[], long x) {// x is the key or target value
		int l = -1, r = a.length;
		while (l + 1 < r) {
			int m = (l + r) >>> 1;
			if (a[m] <= x)
				l = m;
			else
				r = m;
		}
		return l + 1;
	}

	static int LowerBound(long a[], long x) { // x is the target value or key
		int l = -1, r = a.length;
		while (l + 1 < r) {
			int m = (l + r) >>> 1;
			if (a[m] >= x)
				r = m;
			else
				l = m;
		}
		return r;
	}

	static void recursion(int n) {
		if (n == 1) {
			pw.print(n + " ");
			return;
		}
		// pw.print(n+" "); gives us n to 1
		recursion(n - 1);
		// pw.print(n+" "); gives us 1 to n
	}

	// ch.charAt(i)+"" converts into a char sequence
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

		/* CREATED BY ME */
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}
	}

	public static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	public static boolean isPrime(long n) {
		if (n == 2)
			return true;
		long i = 2;
		while (i * i <= n) {
			if (n % i == 0)
				return false;
			i++;
		}
		return true;
	}

	static int ceil(int x, int y) {
		return (x % y == 0 ? x / y : (x / y + 1));
	}

	static long ceil(long x, long y) {
		return (x % y == 0 ? x / y : (x / y + 1));
	}

	static double max(double x, double y) {
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

	public static class pair {
		long x;
		long y;

		public pair(long a, long b) {
			x = a;
			y = b;
		}
	}

	public static class Comp implements Comparator<pair> {
		public int compare(pair a, pair b) {
			long ans = a.x - b.x;
			if (ans > 0)
				return 1;
			if (ans < 0)
				return -1;
			return 0;
		}
	}

	// modular exponentiation
	public static long fastExpo(long a, int n, int mod) {
		if (n == 0)
			return 1;
		else {
			if ((n & 1) == 1) {
				long x = fastExpo(a, n / 2, mod);
				return (((a * x) % mod) * x) % mod;
			} else {
				long x = fastExpo(a, n / 2, mod);
				return (((x % mod) * (x % mod)) % mod) % mod;
			}
		}
	}

	public static long modInverse(long n, int p) {
		return fastExpo(n, p - 2, p);
	}

	/*
	 * public static void extract(ArrayList<Integer> ar, int k, int d) { int c = 0;
	 * for (int i = 1; i < k; i++) { int x = 0; boolean dm = false; while (x > 0) {
	 * long dig = x % 10; x = x / 10; if (dig == d) { dm = true; break; } } if (dm)
	 * ar.add(i); } }
	 */

	public static int[] prefixfuntion(String s) {
		int n = s.length();
		int z[] = new int[n];
		for (int i = 1; i < n; i++) {
			int j = z[i - 1];
			while (j > 0 && s.charAt(i) != s.charAt(j))
				j = z[j - 1];
			if (s.charAt(i) == s.charAt(j))
				j++;
			z[i] = j;
		}
		return z;
	}

// counts the set(1) bit of a number
	public static long countSetBitsUtil(long x) {
		if (x <= 0)
			return 0;
		return (x % 2 == 0 ? 0 : 1) + countSetBitsUtil(x / 2);
	}

//tells whether a particular index has which bit of a number	
	public static int getIthBitsUtil(int x, int y) {
		return (x & (1 << y)) != 0 ? 1 : 0;
	}

	public static void swaper(long x, long y) {
		x = x ^ y;
		y = y ^ x;
		x = x ^ y;
	}

	public static double decimalPlaces(double sum) {
		DecimalFormat df = new DecimalFormat("#.00");
		String angleFormated = df.format(sum);
		double fin = Double.parseDouble(angleFormated);
		return fin;
	}

//use collections.swap for swapping 
	static boolean isSubSequence(String str1, String str2, int m, int n) {
		int j = 0;

		for (int i = 0; i < n && j < m; i++)
			if (str1.charAt(j) == str2.charAt(i))
				j++;

		return (j == m);
	}

	static long sum(long n) {
		long s2 = 0, max = -1, min = 10;
		while (n > 0) {
			s2 = (n % 10);
			min = min(s2, min);
			max = max(s2, max);
			n = n / 10;
		}
		return max * min;
	}

	static long pow(long base, long power) {
		if (power == 0) {
			return 1;
		}
		long result = pow(base, power / 2);
		if (power % 2 == 1) {
			return result * result * base;
		}
		return result * result;
	}

	// return the hash value of a string
	static long compute_hash(String s) {
		long val = 0;
		long p = 31;
		long mod = (long) (1000000007);
		long pow = 1;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			val = (val + (int) (ch - 'a' + 1) * pow) % mod;
			pow = (pow * p) % mod;
		}
		return val;
	}

}
