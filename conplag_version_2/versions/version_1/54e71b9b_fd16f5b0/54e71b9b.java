

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;

public class C {
	private static int n, m, k, x, y;
	private static int[][] a, b;
	private static long ans;
	private static int[][] id;
	private static long[][] dp;
	private static int idf;
	private static String s, t;
	private static HashMap<Integer, ArrayList<Integer>> g;

	// CONSTANTS
	private static final int MOD = (int) 1e9 + 7;
	private static final int[] dx = { -1, 1, 0, 0 };
	private static final int[] dy = { 0, 0, -1, 1 };
	private static final int MAX = Integer.MAX_VALUE;
	private static final int MIN = Integer.MIN_VALUE;
	private static final long MAXLONG = (long) 1e18;
	private static final long MINLONG = -(long) 1e18;

	public static void main(String[] args) {
		int testCases = in.nextInt();

		id = new int[(int)1e5+10][2];
		dp = new long[(int)1e5+10][2];
		
		for (int z = 1; z <= testCases; z++) {
			initCase(z);

			n = ini();
			a = ina2d(n, 2);
			
			g = intree(n);
			
			println(Math.max(dfs(0, -1, 0), dfs(0, -1, 1)));
		}

		//Ax,  A*(B-x)

		out.flush();
		out.close();

	}
	
	private static long dfs(int u, int p, int f) {
		if (id[u][f]==idf) {
			return dp[u][f];
		}
		
		
		long ans = 0;
		
		for(int v: g.get(u)) {
			if (v==p) continue;
			
			ans += Math.max(Math.abs(a[v][1]-a[u][f])+dfs(v, u, 1), Math.abs(a[v][0]-a[u][f])+dfs(v, u, 0));
		}
		id[u][f] = idf;
		dp[u][f] = ans;
		
		return ans;
	}

	// INIT
	private static void initCase(int z) {
		idf = z;
		ans = 0;
	}

	// PRINT ANSWER
	private static void printAns(Object o) {
		out.println(o);
	}

	private static void printAns(Object o, int testCaseNo) {
		out.println("Case #" + testCaseNo + ": " + o);
	}

	private static void printArray(Object[] a) {
		for (int i = 0; i < a.length; i++) {
			out.print(a[i] + " ");
		}
		out.println();
	}

	// SORT SHORTCUTS - QUICK SORT TO MERGE SORT
	private static void sort(int[] a) {
		int n = a.length;
		Integer[] b = new Integer[n];
		for (int i = 0; i < n; i++) {
			b[i] = a[i];
		}

		Arrays.sort(b);

		for (int i = 0; i < n; i++) {
			a[i] = b[i];
		}
	}

	private static void sort(long[] a) {
		int n = a.length;
		Long[] b = new Long[n];
		for (int i = 0; i < n; i++) {
			b[i] = a[i];
		}

		Arrays.sort(b);

		for (int i = 0; i < n; i++) {
			a[i] = b[i];
		}
	}

	// INPUT SHORTCUTS

	private static int[] ina(int n) {
		int[] temp = new int[n];
		for (int i = 0; i < n; i++) {
			temp[i] = in.nextInt();
		}
		return temp;
	}

	private static int[][] ina2d(int n, int m) {
		int[][] temp = new int[n][m];
		for (int i = 0; i < n; i++) {
			temp[i] = ina(m);
		}
		return temp;
	}

	private static char[][] ina2dChar(int n, int m) {
		char[][] temp = new char[n][];
		for (int i = 0; i < n; i++) {
			temp[i] = ins().toCharArray();
		}
		return temp;
	}

	private static int ini() {
		return in.nextInt();
	}

	private static long inl() {
		return in.nextLong();
	}

	private static double ind() {
		return Double.parseDouble(ins());
	}

	private static String ins() {
		return in.readString();
	}

	// PRINT SHORTCUTS
	private static void println(Object... o) {
		for (Object x : o) {
			out.write(x + "");
		}
		out.write("\n");
	}

	private static void pd(Object... o) {
		for (Object x : o) {
			out.write(x + "");
		}
		out.flush();
		out.write("\n");
	}

	private static void print(Object... o) {
		for (Object x : o) {
			out.write(x + "");
		}
	}

	// GRAPH SHORTCUTS
	private static HashMap<Integer, ArrayList<Integer>> intree(int n) {

		HashMap<Integer, ArrayList<Integer>> g = new HashMap<>();
		for (int i = 0; i < n; i++) {
			g.put(i, new ArrayList<>());
		}

		for (int i = 0; i < n - 1; i++) {
			int u = ini() - 1;
			int v = ini() - 1;
			g.get(u).add(v);
			g.get(v).add(u);
		}

		return g;
	}

	private static HashMap<Integer, ArrayList<Integer>> ingraph(int n, int m) {
		HashMap<Integer, ArrayList<Integer>> g = new HashMap<>();

		for (int i = 0; i < n; i++) {
			g.put(i, new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			int u = ini() - 1;
			int v = ini() - 1;
			g.get(u).add(v);
			g.get(v).add(u);
		}

		return g;

	}

	private static HashMap<Integer, ArrayList<Integer>> indirectedgraph(int n, int m) {
		HashMap<Integer, ArrayList<Integer>> g = new HashMap<>();

		for (int i = 0; i < n; i++) {
			g.put(i, new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			int u = ini() - 1;
			int v = ini() - 1;
			g.get(u).add(v);
		}

		return g;

	}

	private static HashMap<Integer, ArrayList<Edge>> inweightedgraph(int n, int m) {
		HashMap<Integer, ArrayList<Edge>> g = new HashMap<>();

		for (int i = 0; i < n; i++) {
			g.put(i, new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			int u = ini() - 1;
			int v = ini() - 1;
			int w = ini();
			Edge edge = new Edge(u, v, w);
			g.get(u).add(edge);
			g.get(v).add(edge);
		}

		return g;

	}

	private static class Edge implements Comparable<Edge> {
		private int u, v;
		private long w;

		public Edge(int a, int b, long c) {
			u = a;
			v = b;
			w = c;
		}

		public int other(int x) {
			return (x == u ? v : u);
		}

		public int compareTo(Edge edge) {
			return Long.compare(w, edge.w);
		}
	}

	private static class Pair {
		private int u, v;

		public Pair(int a, int b) {
			u = a;
			v = b;
		}

		public int hashCode() {
			return u + v + u * v;
		}

		public boolean equals(Object object) {
			Pair pair = (Pair) object;
			return u == pair.u && v == pair.v;
		}
	}

	private static class Triplet {
		private int u, v, w;

		public Triplet(int a, int b, int c) {
			u = a;
			v = b;
			w = c;
		}

		public int hashCode() {
			return u + v + w + u * v + v * w + u * w + u * v * w;
		}

		public boolean equals(Object object) {
			Triplet triplet = (Triplet) object;
			return u == triplet.u && v == triplet.v && v == triplet.w;
		}
	}

	private static class Node implements Comparable<Node> {
		private int u;
		private long dist;

		public Node(int a, long b) {
			u = a;
			dist = b;
		}

		public int compareTo(Node node) {
			return Long.compare(dist, node.dist);
		}
	}

	// MATHS AND NUMBER THEORY SHORTCUTS
	private static int gcd(int a, int b) {
		// O(log(min(a,b)))
		if (b == 0)
			return a;

		return gcd(b, a % b);
	}

	private static long modExp(long a, long b) {
		if (b == 0)
			return 1;

		a %= MOD;

		long exp = modExp(a, b / 2);

		if (b % 2 == 0) {
			return (exp * exp) % MOD;
		} else {
			return (a * ((exp * exp) % MOD)) % MOD;
		}
	}

	private static long mul(int a, int b) {
		return a * 1L * b;
	}

	// Segment Tree
	private static class SegmentTree<T extends Comparable<T>> {
		private int n, m;
		private T[] a;
		private T[] seg;
		private T NULLVALUE;

		public SegmentTree(int n, T NULLVALUE) {
			this.NULLVALUE = NULLVALUE;
			this.n = n;
			m = 4 * n;
			seg = (T[]) new Object[m];

		}

		public SegmentTree(T[] a, int n, T NULLVALUE) {
			this.NULLVALUE = NULLVALUE;
			this.a = a;
			this.n = n;
			m = 4 * n;
			seg = (T[]) new Object[m];
			construct(0, n - 1, 0);
		}

		private void update(int pos) {
			// Range Sum
			// seg[pos] = seg[2*pos+1]+seg[2*pos+2];

			// Range Min
			if (seg[2 * pos + 1].compareTo(seg[2 * pos + 2]) <= 0) {
				seg[pos] = seg[2 * pos + 1];
			} else {
				seg[pos] = seg[2 * pos + 2];
			}
		}

		private T optimum(T leftValue, T rightValue) {
			// Range Sum
			// return leftValue+rightValue;

			// Range Min
			if (leftValue.compareTo(rightValue) <= 0) {
				return leftValue;
			} else {
				return rightValue;
			}
		}

		public void construct(int low, int high, int pos) {
			if (low == high) {
				seg[pos] = a[low];
				return;
			}

			int mid = (low + high) / 2;

			construct(low, mid, 2 * pos + 1);
			construct(mid + 1, high, 2 * pos + 2);
			update(pos);
		}

		public void add(int index, T value) {
			add(index, value, 0, n - 1, 0);
		}

		private void add(int index, T value, int low, int high, int pos) {
			if (low == high) {
				seg[pos] = value;
				return;
			}

			int mid = (low + high) / 2;

			if (index <= mid) {
				add(index, value, low, mid, 2 * pos + 1);
			} else {
				add(index, value, mid + 1, high, 2 * pos + 2);
			}
			update(pos);
		}

		public T get(int qlow, int qhigh) {
			return get(qlow, qhigh, 0, n - 1, 0);
		}

		public T get(int qlow, int qhigh, int low, int high, int pos) {
			if (qlow > low || low > qhigh) {
				return NULLVALUE;
			} else if (qlow <= low || qhigh >= high) {
				return seg[pos];
			} else {
				int mid = (low + high) / 2;
				T leftValue = get(qlow, qhigh, low, mid, 2 * pos + 1);
				T rightValue = get(qlow, qhigh, mid + 1, high, 2 * pos + 2);

				return optimum(leftValue, rightValue);
			}
		}
	}

	// DSU
	private static class DSU {
		private int[] id;
		private int[] size;
		private int n;

		public DSU(int n) {
			this.n = n;

			id = new int[n];
			for (int i = 0; i < n; i++) {
				id[i] = i;
			}

			size = new int[n];
			Arrays.fill(size, 1);
		}

		private int root(int u) {
			while (u != id[u]) {
				id[u] = id[id[u]];
				u = id[u];
			}
			return u;
		}

		public boolean connected(int u, int v) {
			return root(u) == root(v);
		}

		public void union(int u, int v) {
			int p = root(u);
			int q = root(v);

			if (size[p] >= size[q]) {
				id[q] = p;
				size[p] += size[q];
			} else {
				id[p] = q;
				size[q] += size[p];
			}
		}
	}

	// KMP
	private static int countSearch(String s, String p) {
		int n = s.length();
		int m = p.length();

		int[] b = backTable(p);

		int j = 0;
		int count = 0;

		for (int i = 0; i < n; i++) {
			if (j == m) {
				j = b[j - 1];
				count++;
			}
			while (j != 0 && s.charAt(i) != p.charAt(j)) {
				j = b[j - 1];
			}
			if (s.charAt(i) == p.charAt(j)) {
				j++;
			}
		}

		if (j == m)
			count++;

		return count;
	}

	private static int[] backTable(String p) {
		int m = p.length();

		int j = 0;
		int[] b = new int[m];

		for (int i = 1; i < m; i++) {
			while (j != 0 && p.charAt(i) != p.charAt(j)) {
				j = b[j - 1];
			}
			if (p.charAt(i) == p.charAt(j)) {
				b[i] = ++j;
			}
		}
		return b;
	}

	private static int[][] countMap(String s) {
		int n = s.length();

		int[][] map = new int[n][26];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 26; j++) {
				map[i][j] = (i - 1 >= 0 ? map[i - 1][j] : 0);
			}
			map[i][s.charAt(i) - 'a']++;
		}

		return map;
	}

	private static int[][] rightOcc(String s) {
		int n = s.length();

		int[][] right = new int[n][26];

		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < 26; j++) {
				right[i][j] = (i + 1 < n ? right[i + 1][j] : -1);
			}
			right[i][s.charAt(i) - 'a'] = i;
		}

		return right;
	}

	private static int[][] leftOcc(String s) {
		int n = s.length();

		int[][] left = new int[n][26];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 26; j++) {
				left[i][j] = (i - 1 >= 0 ? left[i - 1][j] : -1);
			}
			left[i][s.charAt(i) - 'a'] = i;
		}

		return left;
	}

	// LCA
	private static class LCA {
		private HashMap<Integer, ArrayList<Integer>> g;
		private int[] level;
		private int[] a;
		private int[][] P;
		private int n, m;
		private int[] xor;

		public LCA(HashMap<Integer, ArrayList<Integer>> g, int[] a) {
			this.g = g;
			this.a = a;
			n = g.size();
			m = (int) (Math.log(n) / Math.log(2)) + 5;
			P = new int[n][m];
			xor = new int[n];
			level = new int[n];

			preprocess();
		}

		private void preprocess() {
			dfs(0, -1);

			for (int j = 1; j < m; j++) {
				for (int i = 0; i < n; i++) {
					if (P[i][j - 1] != -1) {
						P[i][j] = P[P[i][j - 1]][j - 1];
					}
				}
			}
		}

		private void dfs(int u, int p) {
			P[u][0] = p;
			xor[u] = a[u] ^ (p == -1 ? 0 : xor[p]);
			level[u] = (p == -1 ? 0 : level[p] + 1);

			for (int v : g.get(u)) {
				if (v == p)
					continue;
				dfs(v, u);
			}
		}

		public int lca(int u, int v) {
			if (level[v] > level[u]) {
				int temp = v;
				v = u;
				u = temp;
			}

			for (int j = m; j >= 0; j--) {
				if (level[u] - (1 << j) < level[v]) {
					continue;
				} else {
					u = P[u][j];
				}
			}

			if (u == v)
				return u;

			for (int j = m - 1; j >= 0; j--) {
				if (P[u][j] == -1 || P[u][j] == P[v][j]) {
					continue;
				} else {
					u = P[u][j];
					v = P[v][j];
				}
			}

			return P[u][0];
		}

		private int xor(int u, int v) {
			int l = lca(u, v);

			return xor[u] ^ xor[v] ^ a[l];
		}
	}

	// Geometry
	private static class Line {
		private int a, b, c;

		public Line(int x1, int y1, int x2, int y2) {
			a = y2 - y1;
			b = x1 - x2;
			c = a * x1 + b * y1;

			int g = gcd(a, gcd(b, c));

			a /= g;
			b /= g;
			c /= g;
		}

		public int hashCode() {
			return a + b + c + a * b + b * c + c * a + a * b * c;
		}

		public boolean equals(Object o) {
			Line line = (Line) o;
			return a == line.a && b == line.b && c == line.c;
		}
	}

	// FAST INPUT OUTPUT LIBRARY
	private static InputReader in = new InputReader(System.in);
	private static PrintWriter out = new PrintWriter(System.out);

	private static class InputReader {

		private final InputStream stream;
		private final byte[] buf = new byte[8192];
		private int curChar, snumChars;

		public InputReader(InputStream st) {
			this.stream = st;
		}

		public int read() {
			if (snumChars == -1)
				throw new InputMismatchException();
			if (curChar >= snumChars) {
				curChar = 0;
				try {
					snumChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (snumChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public int nextInt() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public long nextLong() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public String readString() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public String nextLine() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndOfLine(c));
			return res.toString();
		}

		public boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		private boolean isEndOfLine(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}

	}
}


