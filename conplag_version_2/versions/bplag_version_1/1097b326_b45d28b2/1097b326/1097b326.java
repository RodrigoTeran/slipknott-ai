/*
Codeforces
Problem 1499C
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MinimumGridPath {
	
	public static void main(String[] args) throws IOException {
		FastIO in = new FastIO(System.in);
		
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			long[] c = new long[n];
			long[] sums = new long[n];
			long[] mins = new long[n];
			
			for (int i = 0; i < n; i++) c[i] = in.nextInt();
			
			sums[0] = mins[0] = c[0];
			sums[1] = mins[1] = c[1];
			for (int i = 2; i < n; i++) {
				sums[i] = sums[i-2] + c[i];
				mins[i] = Math.min(mins[i-2], c[i]);
			}
			
			long ans = Long.MAX_VALUE;
			for (int i = 1; i < n; i++) {
				ans = Math.min(ans, (n - (long) Math.ceil((double) (i+1) / 2)) * mins[i] + (n - (i+1) / 2) * mins[i-1] + sums[i] + sums[i-1]);
			}
			
			System.out.println(ans);
		}
		
		in.close();
	}
	
	public static class FastIO {
		private InputStream dis;
		private byte[] buffer = new byte[1 << 17];
		private int pointer = 0;
	
		public FastIO(String fileName) throws IOException {
			dis = new FileInputStream(fileName);
		}
	
		public FastIO(InputStream is) throws IOException {
			dis = is;
		}
	
		public int nextInt() throws IOException {
			int ret = 0;
			byte b;
			
			do {
				b = nextByte();
			} while (b <= ' ');
			
			boolean negative = false;
			if (b == '-') {
				negative = true;
				b = nextByte();
			}
			
			while (b >= '0' && b <= '9') {
				ret = 10 * ret + b - '0';
				b = nextByte();
			}
	
			return (negative) ? -ret : ret;
		}
	
		public long nextLong() throws IOException {
			long ret = 0;
			byte b;
			
			do {
				b = nextByte();
			} while (b <= ' ');
			
			boolean negative = false;
			if (b == '-') {
				negative = true;
				b = nextByte();
			}
			
			while (b >= '0' && b <= '9') {
				ret = 10 * ret + b - '0';
				b = nextByte();
			}
			
			return (negative) ? -ret : ret;
		}
	
		public byte nextByte() throws IOException {
			if (pointer == buffer.length) {
				dis.read(buffer, 0, buffer.length);
				pointer = 0;
			}
			return buffer[pointer++];
		}
	
		public String next() throws IOException {
			StringBuffer ret = new StringBuffer();
			byte b;
			
			do {
				b = nextByte();
			} while (b <= ' ');
			
			while (b > ' ') {
				ret.appendCodePoint(b);
				b = nextByte();
			}
	
			return ret.toString();
		}
	
		public void close() throws IOException {
			dis.close();
		}
	}
}