import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import static java.lang.Math.*;

public class Ans implements Runnable {

	public static void main(String args[]) {
		Ans s = new Ans();
		s.run();
	}

	static void debug(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}

	InputReader sc = null;
	PrintWriter pw = null;
	static ArrayList<Integer>[] G = new ArrayList[(int)(3e5+10)];
	static int[] dist = new int[(int)(3e5+10)];
	static int[] a = new int[(int)(3e5+10)];
	
	private static int[] nge(int n){		
		int[] edges = new int[n];
		Arrays.fill(edges,  -1);
		Stack<Integer> st = new Stack<>();
		st.push(0);
		for(int i = 1; i < n; i++){			
			while(!st.isEmpty() && a[i] >= a[st.peek()]){
				edges[st.pop()] = i;
			}
			st.push(i);			
		}		
		//debug("nge", edges);
		return edges;
	}
	
	private static int[] nle(int n){	
		int[] edges = new int[n];
		Arrays.fill(edges,  -1);
		Stack<Integer> st = new Stack<>();
		st.push(0);
		for(int i = 1; i < n; i++){
			while(!st.isEmpty() && a[i] <= a[st.peek()]){
				edges[st.pop()] = i;
			}
			st.push(i);
		}
		//debug("nle", edges);
		return edges;
	}
	
	private static int[] pge(int n){		
		int[] edges = new int[n];
		Arrays.fill(edges,  -1);
		Stack<Integer> st = new Stack<>();
		st.push(n-1);
		for(int i = n-2; i >= 0; i--){
			while(!st.isEmpty() && a[i] >= a[st.peek()]){
				edges[st.pop()] = i;
			}
			st.push(i);
		}
		//debug("pge", edges);
		return edges;
	}
	
	private static int[] ple(int n){	
		int[] edges = new int[n];
		Arrays.fill(edges,  -1);
		Stack<Integer> st = new Stack<>();
		st.push(n-1);
		for(int i = n-2; i >= 0; i--){
			while(!st.isEmpty() && a[i] <= a[st.peek()]){
				edges[st.pop()] = i;
			}
			st.push(i);
		}
		//debug("ple", edges);
		return edges;
	}
	
	private static void buildGraph(int[] edges){		
		for(int i = 0; i < edges.length; i++){
			if(edges[i] != -1){				
//				G[i].add(edges[i]);
//				G[edges[i]].add(i);
				G[min(i, edges[i])].add(max(i, edges[i]));
			}
		}
	}
	
	private static void bfs(int n){		
		dist[0] = 0;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(0);
		
		while(!q.isEmpty()){
			int front = q.pollFirst();
			if(front == n-1){
				break;
			}
			for(int adj : G[front]){
				if(dist[adj] == (int)(1e9)){
					dist[adj] = 1 + dist[front];
					q.add(adj);
				}
			}
		}
	}
	
	public void run() {

		// InputStream is;
		// is = new FileInputStream(new File("input.txt"));
		sc = new InputReader(System.in);
		pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		a = new int[n];		
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			G[i] = new ArrayList<Integer>();
		}		
		
		buildGraph(nge(n));
		buildGraph(nle(n));
		buildGraph(ple(n));
		buildGraph(pge(n));
		Arrays.fill(dist, (int)(1e9));
		
		bfs(n);
		
		pw.println(dist[n-1]);
		
		// is.close();
		pw.close();

	}
		
	static class InputReader {
		private InputStream stream;
		private byte[] buf = new byte[5];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}

				if (numChars <= 0)
					return -1;
			}

			return buf[curChar++];
		}

		public String nextLine() {
			BufferedReader br = new BufferedReader(new InputStreamReader(stream));
			String stock = "";
			try {
				stock = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return stock;
		}

		public int nextInt() {
			int c = read();
			while (isSpaceChar(c))
				c = read();

			int sgn = 1;

			if (c == '-') {
				sgn = -1;
				c = read();
			}

			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));

			return res * sgn;
		}

		public long nextLong() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;

			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public double nextDouble() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') {
				if (c == 'e' || c == 'E')
					return res * Math.pow(10, nextInt());
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') {
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) {
					if (c == 'e' || c == 'E')
						return res * Math.pow(10, nextInt());
					if (c < '0' || c > '9')
						throw new InputMismatchException();
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
			return res * sgn;
		}

		public String readString() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));

			return res.toString();
		}

		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public String next() {
			return readString();
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}
}