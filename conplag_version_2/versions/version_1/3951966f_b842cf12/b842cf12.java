
import java.io.*;
import java.util.*;



public class A {

	static long modInverse(long a, long m) {
		long m0 = m;
		long y = 0, x = 1;

		if (m == 1)
			return 0;

		while (a > 1) {

			long q = a / m;

			long t = m;

			m = a % m;
			a = t;
			t = y;

			y = x - q * y;
			x = t;
		}

		if (x < 0)
			x += m0;

		return x;
	}

	static void pla() {

		int a = 0;
		int b = 2;
		int c = 0;
		int d = 0;

		a = (int) Math.pow(2, 32);

		c = a + b;
		b = c / a;
		d = a + b + c;

	}

	static int mod = (int) 1e9 + 7;

	static Scanner sc = new Scanner(System.in);
	static StringBuilder out = new StringBuilder();

	public static void main(String[] args) throws IOException {

		int t = 1;// sc.nextInt();

		while (t-- > 0) {

			A run = new A();

			run.run();

		}

		System.out.println(out);

	}

	public static int gcd(int a, int b) {
		return (b == 0) ? a : gcd(b, a % b);
	}

	public void run() throws IOException {

//	int k = sc.nextInt();

//		if(100%k==0)out.append((100/k)+"\n");
//		
//		else {
//			out.append(100+"\n");
//		}

//		int ans=(int)1e9;
//		for(int i=1;i<=k;i++) {
//			
//			
//			if(i*100%k==0) {
//				
//				ans=Math.min(ans,i*)
//				
//				
//			}
//			
//		}

//		
//		int ans = 100 - k;
//		if (k == 100)
//			out.append(1);
//		else {
//			int g = gcd(k, ans);
//			out.append((k / g) + (ans / g));
//		}
//		out.append("\n");
//		

//		int n = sc.nextInt();
//		int a[] = new int[n];
//		
//		for(int i=0;i<n;i++)a[i]=sc.nextInt();
//		int min = Integer.MAX_VALUE, mx = Integer.MIN_VALUE;
//		for (int i = 0; i < n; i++) {
//			min = Math.min(min, a[i]);
//			mx = Math.max(mx, a[i]);
//		}
//		int b[] = a.clone();
//		sort(b,n);
//		if (Arrays.equals(a, b)) {
//			out.append(0);
//		} else if (a[0] == min || a[n - 1] == mx) {
//			out.append(1);
//		} else if (a[0] == mx && a[n - 1] == min) {
//			out.append(3);
//		} else {
//			out.append(2);
//		}
//		out.append("\n");

		int n = sc.nextInt();

		int a[] = new int[n];

		TreeSet<Integer> ts = new TreeSet<>();

		ArrayList<Integer> a1 = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();
		for (int i = 0; i < n; i++) {

			a[i] = sc.nextInt();
			if (a[i] == 1)
				a1.add(i);
			else
				b.add(i);

		}

		int dp[] = new int[n];
		int sum = 0;

		memo = new int[n][n];

		for (int tem[] : memo)
			Arrays.fill(tem, -1);

		sum = solve(0, 0, a1, b);
		out.append(sum + "\n");
	}

	static int memo[][];

	static int solve(int i, int j, ArrayList<Integer> a, ArrayList<Integer> b) {

		if(i==a.size())return 0;
		if(a.size()-i>b.size()-j)return (int)1e9;
		if(j==b.size())return (int)1e9;
		if(memo[i][j]!=-1)return memo[i][j];
		int ans = (int) 1e9;

		
		
		

			ans = Math.min(solve(i + 1, j+1 , a, b) + Math.abs(a.get(i) - b.get(j)),solve(i,j+1,a,b));
		
		
		return memo[i][j]=ans;

	}

	static boolean check(int[] dp, int cnt) {

		int count = 0;

		for (int i = 0; i < dp.length; i++) {

			if (dp[i] == 1)
				count++;
		}

		return (count == cnt);

	}

	static void sort(int a[], int n) {

		ArrayList<Integer> al = new ArrayList<>();

		for (int i = 0; i < n; i++) {

			al.add(a[i]);
		}

		Collections.sort(al);

		for (int i = 0; i < n; i++) {

			a[i] = al.get(i);
		}
	}

	static void sort(long a[], int n) {

		ArrayList<Long> al = new ArrayList<>();

		for (int i = 0; i < n; i++) {

			al.add(a[i]);
		}

		Collections.sort(al);

		for (int i = 0; i < n; i++) {

			a[i] = al.get(i);
		}
	}

//	static Reader sc = new Reader();

	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public Reader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();

			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}

}