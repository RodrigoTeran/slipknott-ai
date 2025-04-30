import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Task solver = new Task();
		int tcCnt = in.nextInt();
		for (int tc = 1; tc <= tcCnt; tc++)
			solver.solve(tc, in, out);
		out.close();
	}

	static class Task {
		public void solve(int testNumber, InputReader in, PrintWriter out) {
			int n = in.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();
			}
			for (int mask = 1; mask < (int)(Math.pow(3, n)); mask++) {
				int copy = mask;
				int sum = 0;
				for (int idx = 0; idx < n; idx++) {
					int digit = copy % 3;
					sum += digit == 0 ? 0 : digit == 1 ? a[idx] : -a[idx];
					copy = copy / 3;
				}
				if (sum == 0) {
					out.println("YES");
					return;
				}
			}
			out.println("NO");
		}

	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public String nextToken() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(nextLine());
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(nextToken());
		}

		public double nextDouble() {
			return Double.parseDouble(nextToken());
		}

		public long nextLong() {
			return Long.parseLong(nextToken());
		}

		public int[] nextIntArray(int size) {
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = nextInt();
			}
			return arr;
		}

	}
}