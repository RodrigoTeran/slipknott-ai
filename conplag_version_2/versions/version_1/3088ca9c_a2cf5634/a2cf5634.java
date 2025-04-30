
/*
    Author : Kartikey Rana
    from MSIT New Delhi
 */
import java.util.*;

import javax.sql.rowset.serial.SerialArray;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;
import java.io.*;
import java.math.*;
import java.sql.Array;;

public class Main {
	static class FR {

		BufferedReader br;
		StringTokenizer st;

		public FR() {
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

		// NEXT INT ARRAY

		int[] NIA(int n) {
			int arr[] = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = nextInt();
			return arr;
		}

		// NEXT DOUBLE ARRAY

		double[] NDA(int n) {
			double arr[] = new double[n];
			for (int i = 0; i < n; i++)
				arr[i] = nextDouble();
			return arr;
		}

		// NEXT LONG ARRAY

		long[] NLA(int n) {
			long[] arr = new long[n];
			for (int i = 0; i < n; i++)
				arr[i] = nextLong();
			return arr;
		}

		// NEXT STRING ARRAY

		String[] NSA(int n) {
			String[] arr = new String[n];
			for (int i = 0; i < n; i++)
				arr[i] = next();
			return arr;
		}

		// NEXT CHARACTER ARRAY

		char[] NCA(int n) {
			char[] arr = new char[n];
			String s = sc.nextLine();

			for (int i = 0; i < n; i++)
				arr[i] = s.charAt(i);
			return arr;
		}

	}

//*************************  FR CLASS ENDS **********************************

	static long mod = (long) (1e9 + 7);

	public static int[] sieve(int n) {

		int[] primes = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			primes[i] = i;
		}

		for (int i = 2; i < n; i++) {
			if (primes[i] < 0)
				continue;
			if ((long) i * (long) i > n)
				break;
			for (int j = i * i; j < n; j++) {
				if (primes[j] > 0 && primes[j] % primes[i] == 0)
					primes[j] = -primes[j];
			}
		}
		return primes;
	}

	static int lcm(int a, int b) {
		return (int) ((a / gcd(a, b)) * b);
	}

	static long gcd(long a, long b) {
		if (b == 0)
			return a;

		return gcd(b, a % b);
	}

	static long[][] ncr(int n, int k) {
		long C[][] = new long[n + 1][k + 1];
		int i, j;

		// Calculate value of Binomial
		// Coefficient in bottom up manner
		for (i = 0; i <= n; i++) {
			for (j = 0; j <= Math.min(i, k); j++) {
				// Base Cases
				if (j == 0 || j == i)
					C[i][j] = 1;

				// Calculate value using
				// previously stored values
				else
					C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % mod;
			}
		}

		return C;
	}

	static long modInverse(long a, long m) {
		long g = gcd(a, m);

		return power(a, m - 2, m);

	}

	static long power(long x, long y, long m) {
		if (y == 0)
			return 1;
		long p = power(x, y / 2, m) % m;
		p = (int) ((p * (long) p) % m);
		if (y % 2 == 0)
			return p;
		else
			return (int) ((x * (long) p) % m);
	}

	static int XOR(int n) {
		if (n % 4 == 0)
			return n;

		if (n % 4 == 1)
			return 1;

		if (n % 4 == 2)
			return n + 1;

		return 0;
	}

//	----------------------------------DSU--------------------------------

	
	static int parent[];
	static int rank[];
	
	public static int find(int x) {
		
		if(x == parent[x]) {
			return x;
		}
		int temp = find(parent[x]);
		parent[x] = temp;
		return temp;
		
	}
	
	public static void union(int x, int y) {
		
		int lx = find(x);
		int ly = find(y);
		if(parent[x] == parent[y])
			return;
		if(rank[lx] < rank[ly]) {
			parent[lx] = ly;
		} else if(rank[lx] >rank[ly]) {
			parent[ly] = lx;
		} else {
			parent[lx] = ly;
			rank[ly]++;
		}
		find(x);
		find(y);
	}

	/* ***************************************************************************************************************************************************/


	static class Pair implements Comparable<Pair> {

		int x;
		int y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pair o) {
			return this.x - o.x;
		}

	}
	
	
	static FR sc = new FR();
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String args[]) throws IOException {
		
		int tc = sc.nextInt();
//		int tc = 1;
		while (tc-- > 0) {
			TEST_CASE();
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

	static void TEST_CASE() throws IOException {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = sc.nextInt();
		String[] strs = new String[n];
		
		for(int i = 0; i < n; i++) {
			strs[i] = sc.next();
		}
		
		int max = -1;
		
		for(int i = 0; i < 5; i++) {
			ArrayList<Integer> arr = new ArrayList<>();
			for(int j = 0; j < n; j++) {
				String s = strs[j];
				char letter = (char)(97+i);
				int val = 0;
				for(int k = 0; k < s.length(); k++) {
					if(s.charAt(k) == letter)
						val++;
					else
						val--;
				}
				arr.add(val);
			}
			Collections.sort(arr, Collections.reverseOrder());
			int val = 0;
			int ans = 0;
			for(int x : arr) {
				val += x;
				if(val <= 0)
					break;
				else
					ans++;
			}
			max = Math.max(ans, max);
		}
		sb.append(max + "\n");
	}
}



















