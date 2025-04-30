 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Map;
import java.util.HashMap;

public class cf1515 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}

	static class Task {
		public void solve(InputReader in, PrintWriter out) {
			int t = in.nextInt();
			while (t-- != 0) {
				int n = in.nextInt();
				int m = in.nextInt();
				int x = in.nextInt();
				TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
				for (int i = 0; i < n; i++) {
					int j = in.nextInt();
					if (!map.containsKey(j)) {
						map.put(j, new ArrayList<Integer>());
					}
					map.get(j).add(i);
				}
				out.println("YES");
				int[] ans = new int[n];
				int sta = 0;
				for (int s : map.keySet()) {
					for (int i = 0; i < map.get(s).size(); i++) {
						ans[map.get(s).get(i)] = (sta++) % m + 1;
					}
				}
				for(int i=0;i<n;i++) {
					out.print(ans[i]+" ");
				}
				out.println();
			}

		}
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreElements()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}

