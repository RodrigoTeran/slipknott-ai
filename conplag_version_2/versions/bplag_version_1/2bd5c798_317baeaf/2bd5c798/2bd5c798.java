import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;
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

	public static void process() throws IOException {

		int n = sc.nextInt();
		String s = sc.next(),t = sc.next();
		int zs = 0, zt = 0;
		for(int i = 0; i<n; i++) {
			if(s.charAt(i) == '0')zs++;
			if(t.charAt(i) == '0')zt++;
		}
		
		int ans = n+1;
		if(zs == zt) {
			int min = 0;
			for(int i = 0; i<n; i++)if(s.charAt(i) != t.charAt(i))min++;
			ans = min(ans, min);
		}
		if(n-zs-1 == zt) {
			int min = 0;
			for(int i = 0; i<n; i++)if(s.charAt(i) == t.charAt(i))min++;
			ans = min(ans, min);
		}
		if(ans == n+1)ans = -1;
		System.out.println(ans);

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
	static FastWriter out;

	public static void main(String[] args) throws IOException {
		boolean oj = true;
		if (oj) {
			sc = new FastScanner();
			out = new FastWriter(System.out);
		} else {
			sc = new FastScanner("input.txt");
			out = new FastWriter("output.txt");
		}
		long s = System.currentTimeMillis();
		int t = 1;
		t = sc.nextInt();
		int TTT = 1;
		while (t-- > 0) {
			//			google(TTT++);
			process();
		}
		out.flush();
		//		tr(System.currentTimeMillis()-s+"ms");
	}

	private static boolean oj = System.getProperty("ONLINE_JUDGE") != null;

	private static void tr(Object... o) {
		if (!oj)
			System.err.println(Arrays.deepToString(o));
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

		/*
		 	@Override
		    public boolean equals(Object o) {
		        if (this == o) return true;
		        if (!(o instanceof Pair)) return false;
		        Pair key = (Pair) o;
		        return x == key.x && y == key.y;
		    }
		 
		    @Override
		    public int hashCode() {
		        int result = x;
		        result = 31 * result + y;
		        return result;
		    }
		*/
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////

	static int ceil(int x, int y) {
		return (x % y == 0 ? x / y : (x / y + 1));
	}

	static long ceil(long x, long y) {
		return (x % y == 0 ? x / y : (x / y + 1));
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

	public static long gcd(long a, long b) {
		if (a > b)
			a = (a + b) - (b = a);
		if (a == 0L)
			return b;
		return gcd(b % a, a);
	}

	public static long lcm(long a, long b) {
		return (a * b) / gcd(a, b);
	}

	public static int lower_bound(int[] arr, int x) {
		int low = 0, high = arr.length - 1, mid = -1;
		int ans = -1;
		while (low <= high) {
			mid = (low + high) / 2;

			if (arr[mid] > x) {
				high = mid - 1;
			} else {
				ans = mid;
				low = mid + 1;
			}
		}

		return ans;
	}

	public static int upper_bound(int[] arr, int x) {
		int low = 0, high = arr.length - 1, mid = -1;
		int ans = arr.length;
		while (low < high) {
			mid = (low + high) / 2;

			if (arr[mid] >= x) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return ans;
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

	static void reverseArray(int[] a) {
		int n = a.length;
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = a[n - i - 1];
		for (int i = 0; i < n; i++)
			a[i] = arr[i];
	}

	static void reverseArray(long[] a) {
		int n = a.length;
		long arr[] = new long[n];
		for (int i = 0; i < n; i++)
			arr[i] = a[n - i - 1];
		for (int i = 0; i < n; i++)
			a[i] = arr[i];
	}

	//custom multiset (replace with HashMap if needed)
	public static void push(TreeMap<Integer, Integer> map, int k, int v) {
		//map[k] += v;
		if (!map.containsKey(k))
			map.put(k, v);
		else
			map.put(k, map.get(k) + v);
	}

	public static void pull(TreeMap<Integer, Integer> map, int k, int v) {
		//assumes map[k] >= v
		//map[k] -= v
		int lol = map.get(k);
		if (lol == v)
			map.remove(k);
		else
			map.put(k, lol - v);
	}

	// compress Big value to Time Limit
	public static int[] compress(int[] arr) {
		ArrayList<Integer> ls = new ArrayList<Integer>();
		for (int x : arr)
			ls.add(x);
		Collections.sort(ls);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int boof = 1; //min value
		for (int x : ls)
			if (!map.containsKey(x))
				map.put(x, boof++);
		int[] brr = new int[arr.length];
		for (int i = 0; i < arr.length; i++)
			brr[i] = map.get(arr[i]);
		return brr;
	}

	// Fast Writer 

	public static class FastWriter {
		private static final int BUF_SIZE = 1 << 13;
		private final byte[] buf = new byte[BUF_SIZE];
		private final OutputStream out;
		private int ptr = 0;

		private FastWriter() {
			out = null;
		}

		public FastWriter(OutputStream os) {
			this.out = os;
		}

		public FastWriter(String path) {
			try {
				this.out = new FileOutputStream(path);
			} catch (FileNotFoundException e) {
				throw new RuntimeException("FastWriter");
			}
		}

		public FastWriter write(byte b) {
			buf[ptr++] = b;
			if (ptr == BUF_SIZE)
				innerflush();
			return this;
		}

		public FastWriter write(char c) {
			return write((byte) c);
		}

		public FastWriter write(char[] s) {
			for (char c : s) {
				buf[ptr++] = (byte) c;
				if (ptr == BUF_SIZE)
					innerflush();
			}
			return this;
		}

		public FastWriter write(String s) {
			s.chars().forEach(c -> {
				buf[ptr++] = (byte) c;
				if (ptr == BUF_SIZE)
					innerflush();
			});
			return this;
		}

		private static int countDigits(int l) {
			if (l >= 1000000000)
				return 10;
			if (l >= 100000000)
				return 9;
			if (l >= 10000000)
				return 8;
			if (l >= 1000000)
				return 7;
			if (l >= 100000)
				return 6;
			if (l >= 10000)
				return 5;
			if (l >= 1000)
				return 4;
			if (l >= 100)
				return 3;
			if (l >= 10)
				return 2;
			return 1;
		}

		public FastWriter write(int x) {
			if (x == Integer.MIN_VALUE) {
				return write((long) x);
			}
			if (ptr + 12 >= BUF_SIZE)
				innerflush();
			if (x < 0) {
				write((byte) '-');
				x = -x;
			}
			int d = countDigits(x);
			for (int i = ptr + d - 1; i >= ptr; i--) {
				buf[i] = (byte) ('0' + x % 10);
				x /= 10;
			}
			ptr += d;
			return this;
		}

		private static int countDigits(long l) {
			if (l >= 1000000000000000000L)
				return 19;
			if (l >= 100000000000000000L)
				return 18;
			if (l >= 10000000000000000L)
				return 17;
			if (l >= 1000000000000000L)
				return 16;
			if (l >= 100000000000000L)
				return 15;
			if (l >= 10000000000000L)
				return 14;
			if (l >= 1000000000000L)
				return 13;
			if (l >= 100000000000L)
				return 12;
			if (l >= 10000000000L)
				return 11;
			if (l >= 1000000000L)
				return 10;
			if (l >= 100000000L)
				return 9;
			if (l >= 10000000L)
				return 8;
			if (l >= 1000000L)
				return 7;
			if (l >= 100000L)
				return 6;
			if (l >= 10000L)
				return 5;
			if (l >= 1000L)
				return 4;
			if (l >= 100L)
				return 3;
			if (l >= 10L)
				return 2;
			return 1;
		}

		public FastWriter write(long x) {
			if (x == Long.MIN_VALUE) {
				return write("" + x);
			}
			if (ptr + 21 >= BUF_SIZE)
				innerflush();
			if (x < 0) {
				write((byte) '-');
				x = -x;
			}
			int d = countDigits(x);
			for (int i = ptr + d - 1; i >= ptr; i--) {
				buf[i] = (byte) ('0' + x % 10);
				x /= 10;
			}
			ptr += d;
			return this;
		}

		public FastWriter write(double x, int precision) {
			if (x < 0) {
				write('-');
				x = -x;
			}
			x += Math.pow(10, -precision) / 2;
			//		if(x < 0){ x = 0; }
			write((long) x).write(".");
			x -= (long) x;
			for (int i = 0; i < precision; i++) {
				x *= 10;
				write((char) ('0' + (int) x));
				x -= (int) x;
			}
			return this;
		}

		public FastWriter writeln(char c) {
			return write(c).writeln();
		}

		public FastWriter writeln(int x) {
			return write(x).writeln();
		}

		public FastWriter writeln(long x) {
			return write(x).writeln();
		}

		public FastWriter writeln(double x, int precision) {
			return write(x, precision).writeln();
		}

		public FastWriter write(int... xs) {
			boolean first = true;
			for (int x : xs) {
				if (!first)
					write(' ');
				first = false;
				write(x);
			}
			return this;
		}

		public FastWriter write(long... xs) {
			boolean first = true;
			for (long x : xs) {
				if (!first)
					write(' ');
				first = false;
				write(x);
			}
			return this;
		}

		public FastWriter writeln() {
			return write((byte) '\n');
		}

		public FastWriter writeln(int... xs) {
			return write(xs).writeln();
		}

		public FastWriter writeln(long... xs) {
			return write(xs).writeln();
		}

		public FastWriter writeln(char[] line) {
			return write(line).writeln();
		}

		public FastWriter writeln(char[]... map) {
			for (char[] line : map)
				write(line).writeln();
			return this;
		}

		public FastWriter writeln(String s) {
			return write(s).writeln();
		}

		private void innerflush() {
			try {
				out.write(buf, 0, ptr);
				ptr = 0;
			} catch (IOException e) {
				throw new RuntimeException("innerflush");
			}
		}

		public void flush() {
			innerflush();
			try {
				out.flush();
			} catch (IOException e) {
				throw new RuntimeException("flush");
			}
		}

		public FastWriter print(byte b) {
			return write(b);
		}

		public FastWriter print(char c) {
			return write(c);
		}

		public FastWriter print(char[] s) {
			return write(s);
		}

		public FastWriter print(String s) {
			return write(s);
		}

		public FastWriter print(int x) {
			return write(x);
		}

		public FastWriter print(long x) {
			return write(x);
		}

		public FastWriter print(double x, int precision) {
			return write(x, precision);
		}

		public FastWriter println(char c) {
			return writeln(c);
		}

		public FastWriter println(int x) {
			return writeln(x);
		}

		public FastWriter println(long x) {
			return writeln(x);
		}

		public FastWriter println(double x, int precision) {
			return writeln(x, precision);
		}

		public FastWriter print(int... xs) {
			return write(xs);
		}

		public FastWriter print(long... xs) {
			return write(xs);
		}

		public FastWriter println(int... xs) {
			return writeln(xs);
		}

		public FastWriter println(long... xs) {
			return writeln(xs);
		}

		public FastWriter println(char[] line) {
			return writeln(line);
		}

		public FastWriter println(char[]... map) {
			return writeln(map);
		}

		public FastWriter println(String s) {
			return writeln(s);
		}

		public FastWriter println() {
			return writeln();
		}
	}

	// Fast Inputs
	static class FastScanner {
		//I don't understand how this works lmao
		private int BS = 1 << 16;
		private char NC = (char) 0;
		private byte[] buf = new byte[BS];
		private int bId = 0, size = 0;
		private char c = NC;
		private double cnt = 1;
		private BufferedInputStream in;

		public FastScanner() {
			in = new BufferedInputStream(System.in, BS);
		}

		public FastScanner(String s) {
			try {
				in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
			} catch (Exception e) {
				in = new BufferedInputStream(System.in, BS);
			}
		}

		private char getChar() {
			while (bId == size) {
				try {
					size = in.read(buf);
				} catch (Exception e) {
					return NC;
				}
				if (size == -1)
					return NC;
				bId = 0;
			}
			return (char) buf[bId++];
		}

		public int nextInt() {
			return (int) nextLong();
		}

		public int[] readArray(int N) {
			int[] res = new int[N];
			for (int i = 0; i < N; i++) {
				res[i] = (int) nextLong();
			}
			return res;
		}

		public long[] readArrayLong(int N) {
			long[] res = new long[N];
			for (int i = 0; i < N; i++) {
				res[i] = nextLong();
			}
			return res;
		}

		public int[][] readArrayMatrix(int N, int M, int Index) {
			if (Index == 0) {
				int[][] res = new int[N][M];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++)
						res[i][j] = (int) nextLong();
				}
				return res;
			}
			int[][] res = new int[N][M];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++)
					res[i][j] = (int) nextLong();
			}
			return res;

		}

		public long[][] readArrayMatrixLong(int N, int M, int Index) {
			if (Index == 0) {
				long[][] res = new long[N][M];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++)
						res[i][j] = nextLong();
				}
				return res;
			}
			long[][] res = new long[N][M];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++)
					res[i][j] = nextLong();
			}
			return res;

		}

		public long nextLong() {
			cnt = 1;
			boolean neg = false;
			if (c == NC)
				c = getChar();
			for (; (c < '0' || c > '9'); c = getChar()) {
				if (c == '-')
					neg = true;
			}
			long res = 0;
			for (; c >= '0' && c <= '9'; c = getChar()) {
				res = (res << 3) + (res << 1) + c - '0';
				cnt *= 10;
			}
			return neg ? -res : res;
		}

		public double nextDouble() {
			double cur = nextLong();
			return c != '.' ? cur : cur + nextLong() / cnt;
		}

		public double[] readArrayDouble(int N) {
			double[] res = new double[N];
			for (int i = 0; i < N; i++) {
				res[i] = nextDouble();
			}
			return res;
		}

		public String next() {
			StringBuilder res = new StringBuilder();
			while (c <= 32)
				c = getChar();
			while (c > 32) {
				res.append(c);
				c = getChar();
			}
			return res.toString();
		}

		public String nextLine() {
			StringBuilder res = new StringBuilder();
			while (c <= 32)
				c = getChar();
			while (c != '\n') {
				res.append(c);
				c = getChar();
			}
			return res.toString();
		}

		public boolean hasNext() {
			if (c > 32)
				return true;
			while (true) {
				c = getChar();
				if (c == NC)
					return false;
				else if (c > 32)
					return true;
			}
		}
	}

}
