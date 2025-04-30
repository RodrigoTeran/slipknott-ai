import java.util.*;
import java.io.*;
import java.math.*;

public class cf {
	static PrintWriter pw = new PrintWriter(System.out);

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			char[] a = sc.next().toCharArray();
			char[] b = sc.next().toCharArray();
			int x = 0, y = 0, lit = 0,lit2 = 0;
			for (int i = 0; i < n; i++) {
				if (a[i] == '1')
					lit++;
				if (b[i] == '1')
					lit2++;
				if (a[i] == b[i])
					x++;
				else
					y++;
			}
			if(lit == lit2 || n - lit + 1 == lit2) {
				if (lit == lit2 && n - lit + 1 == lit2) {
					pw.println(Math.min(x,y));
				}else if(lit == lit2) {
					pw.println(y);
				}else {
					pw.println(x);
				}
			}else {
				pw.println(-1);
			}
		}
		pw.close();
	}

	public static class tuble implements Comparable<tuble> {
		int x;
		int y;
		int z;

		public tuble(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public String toString() {
			return x + " " + y + " " + z;
		}

		public int compareTo(tuble other) {
			if (this.x == other.x) {
				if (this.y == other.y)
					return this.z - other.z;
				return this.y - other.y;
			} else {
				return this.x - other.x;
			}
		}
	}

	public static class pair implements Comparable<pair> {
		int x;
		int y;

		public pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public String toString() {
			return x + " " + y;
		}

		public boolean equals(Object o) {
			if (o instanceof pair) {
				pair p = (pair) o;
				return p.x == x && p.y == y;
			}
			return false;
		}

		public int hashCode() {
			return new Integer(x).hashCode() * 31 + new Integer(y).hashCode();
		}

		public int compareTo(pair other) {
			if (this.x == other.x) {
				return Long.compare(this.y, other.y);
			}
			return Long.compare(this.x, other.x);
		}
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(FileReader r) {
			br = new BufferedReader(r);
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}

}