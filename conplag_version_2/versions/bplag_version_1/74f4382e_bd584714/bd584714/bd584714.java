
import java.io.*;
import java.util.*;

public class Solution {

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

	//static Scanner sc = new Scanner(System.in);
	static StringBuilder out = new StringBuilder();

	
	static int pri[] = new int[(int) 1e5 + 5];
	static void sieve() {
		pri[1] = pri[0] = 1;
		for (int i = 2; i < pri.length; i++) {
			pri[i] = i;
		}
		for (int i = 2; i < Math.sqrt(pri.length); i++) {
			if (pri[i] != i)
				continue;

			for (int j = i * i; j < pri.length; j += i) {
				if (pri[j] == j)
					pri[j] = i;
			}

		}
	}
	
	public static void main(String[] args) throws IOException {

		int t = sc.nextInt();

		//sieve();
		int tc = 1;
		while (tc <= t) {

			// out.append("Case #" + tc + ": ");
			Solution run = new Solution();

			run.run();

			tc++;
		}

		System.out.println(out);

	}

	
	ArrayList<Integer> gr[];
	long a[][];
	public static int gcd(int a, int b) {
		return (b == 0) ? a : gcd(b, a % b);
	}

	public void run() throws IOException {

		int n = sc.nextInt();
		
		gr=new ArrayList[n+1];
		a=new long[n+1][2];
		for(int i=0;i<=n;i++)gr[i]=new ArrayList<>();
		
	
		for(int i=1;i<=n;i++) {
			
			a[i][0]=sc.nextInt();
			a[i][1]=sc.nextInt();
		}
		
		for(int i=0;i<n-1;i++) {
			
			int u=sc.nextInt();
			int v=sc.nextInt();
			
			gr[u].add(v);
			gr[v].add(u);
		}
		
		dp=new long[n+1][2];
		
		for(long a1[]:dp)Arrays.fill(a1, -1L);
		
		//dfs(1,-1);
		
		long res=Math.max(dfs(1,-1,0), dfs(1,-1,1));
		
		out.append(res+"\n");
		
		
	}
	
	long dp[][];
	
	
	long dfs(int u, int pa,int ok) {
		
		
		
			
			if(dp[u][ok]!=-1)return dp[u][ok];
			
			
		
		
		
		long ans=0;
		for(int ch: gr[u]) {
			
			
			if(ch==pa)continue;
			long res=0;
			
			
				
				if(ok==0) {
					
					res=Math.max(dfs(ch,u,0)+Math.abs(a[u][0]-a[ch][0]), dfs(ch,u,1)+Math.abs(a[u][0]-a[ch][1]));
					
				}
				else {
					
					res=Math.max(dfs(ch,u,0)+Math.abs(a[u][1]-a[ch][0]), dfs(ch,u,1)+Math.abs(a[u][1]-a[ch][1]));
					
					
				}
			
			
			
			ans+=res;
			
			
			
			
		}
		
		return dp[u][ok]=ans;
	}
	
	
	void dfs(int u, int pa) {
		
		if(gr[u].size()==1) {
			dp[u][0]=dp[u][1]=0L;
		}
		
		
		for(int ch:gr[u]) {
			
			
			if(ch==pa)continue;
			
			
			dfs(ch,u);
		}
		
		
		
		for(int ch: gr[u]) {
			
			if(ch==pa)continue;
			
			long ans1=0;
			long ans2=0;
			
			
			ans1=Math.max(dp[ch][0]+Math.abs(a[u][0]-a[ch][0]), dp[ch][1]+Math.abs(a[u][0]-a[u][1]));
			
			dp[u][0]+=ans1;
			
			ans1=Math.max(dp[ch][0]+Math.abs(a[u][1]-a[ch][0]), dp[ch][1]+Math.abs(a[u][1]-a[u][1]));
			
			dp[u][1]+=ans2;
			
			
			
		}
		
		
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

	static Reader sc = new Reader();

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