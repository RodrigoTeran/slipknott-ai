
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Round659 {

	static int rec = 0;
	static int X[] = { -1, 0, 0, 1 };
	static int Y[] = { 0, -1, 1, 0 };
	static long mod = 1000000007;
	static int last=0;
	static int maxDepth=0;
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

	public static long[] initArray(int n, Reader scan) throws IOException {

		long arr[] = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextLong();
		}

		return arr;
	}

	public static long sum(long arr[]) {

		long sum = 0;
		for (long i : arr) {
			sum += (long) i;
		}

		return sum;
	}

	public static long max(long arr[]) {

		long max = Long.MIN_VALUE;

		for (long i : arr) {
			max = Math.max(i, max);
		}

		return max;
	}

	public static long min(long arr[]) {
		long min = Long.MAX_VALUE;

		for (long i : arr) {
			min = Math.min(i, min);
		}

		return min;
	}

	public static List<Integer>[] initAdjacency(int n, int e, Reader scan, boolean type) throws IOException {

		List<Integer> adj[] = new ArrayList[n + 1];

		for (int i = 0; i < e; i++) {
			int u = scan.nextInt();
			int v = scan.nextInt();

			if (adj[u] == null)
				adj[u] = new ArrayList<>();
			if (type && adj[v] == null)
				adj[v] = new ArrayList<>();

			adj[u].add(v);

			if (type)
				adj[v].add(u);

		}

		return adj;
	}

	public static void main(String[] args) throws IOException {

		Reader scan = new Reader();
//		Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();
		while (t-- > 0) {
			
			D(scan);
		}

	}
	
	
	public static void D(Reader scan) throws IOException {
		
		int n=scan.nextInt();
		int a=scan.nextInt();
		int b=scan.nextInt();
		int da=scan.nextInt();
		int db=scan.nextInt();
		
		List<Integer> adj[]=initAdjacency(n, n-1, scan, true);
		
		int d= dist(a, 0, adj, b);
		
		if(d<=da) {
			System.out.println("Alice");
			return;
		}
		
		if(db<=2*da) {
			System.out.println("Alice");
			return;
		}
		
		MyPair far1= farthest(1, 0, adj);
		MyPair far2=farthest(far1.weight, 0, adj);
		
		int diameter= far2.value-1;
		
		
		if(diameter<=2*da) {
			System.out.println("Alice");
		}else {
			System.out.println("Bob");
		}
		
		
//		int val=d-2*a;
//		
//		if(val>0) {
//			System.out.println("Bob");
//			return;
//		}
//		
//		int dep=0;
//		for(Integer x: adj[a]) {
//			if(x==last) continue;
//			
//			dep=Math.max(getDepth(x, a, adj), dep);
//		}
//		
//		if(dep>=val) {
//			System.out.println("Bob");
//		}else {
//			System.out.println("Alice");
//		}
		
		
		
	}
	
	public static MyPair farthest(int i, int parent, List<Integer> adj[]) {
		
		int dist=0;
		int node= i;
		
		for(Integer x: adj[i]) {
			if(x==parent) continue;
			
			MyPair recAns= farthest(x, i, adj);
			if(recAns.value>dist) {
				dist= recAns.value;
				node= recAns.weight;
			}
		}
		
		return new MyPair(dist+1, node);
		
	}
	
	public static int getDepth(int i, int parent, List<Integer> adj[]) {
		
		int max=0;
		
		for(Integer x: adj[i]) {
			if(x==parent) continue;
			
			
			max=Math.max(max, getDepth(x, i, adj));
		}
		
		return max+1;
		
	}
	
	public static int dist(int i, int parent, List<Integer> adj[], int target) {
		
		if(i==target) return 0;
		
		for(Integer x: adj[i]) {
			if(x==parent) continue;
			
			int recAns= dist(x, i, adj, target);
			if(recAns!=-1) {
				last=x;
				return recAns+1;
			}
		}
		
		return -1;
		
		
	}
	
	
	public static void C(int n, String s, int k) {
		
		char arr[]= s.toCharArray();
		
		for(int i=0;i<n;i++) {
			
			if(i+k>=n) break;
			
			if(arr[i]=='0'&&arr[i+k]=='1') {
				System.out.println("NO");
				return;
			}
			
			if(arr[i]=='1'&&arr[i+k]=='0') {
				System.out.println("NO");
				return;
			}
			
			if(arr[i]=='0'||arr[i]=='1') {
				if(arr[i+k]=='?') {
					arr[i+k]=arr[i];
				}
				
				continue;
			}
			
			if(arr[i+k]=='0'||arr[i+k]=='1') {
				if(arr[i]=='?') {
					arr[i]=arr[i+k];
				}
				
				continue;
			}
		}
		
		int c0[]=new int[n];
		int c1[]=new int[n];
		
		
		int last0=0;
		int last1=0;
		for(int i=0;i<n;i++) {
			
			if(arr[i]=='0') {
				last0++;
			}else if(arr[i]=='1'){
				last1++;
			}
			
			c0[i]=last0;
			c1[i]=last1;
			
		}
		
		
		for(int i=k-1;i<n;i++) {
			
			int count0= c0[i]- ((i-k<0)?0: c0[i-k]);
			int count1= c1[i]- ((i-k<0)?0: c1[i-k]);
			
			if(count0>k/2||count1>k/2) {
				System.out.println("NO");
				return;
			}
			
		}
		
		System.out.println("YES");
		
		
		
	}
	
	public static void A(int n, long arr[]) {
		
		for(int i=n-1;i>=0;i--) {
			System.out.print(arr[i]+" ");
		}
		
		System.out.println();
		
	}
	
	public static void B(int n, long arr[]) {
		
		
		for(int i=1;i<n;i++) {
			
			if(arr[i-1]>0) {
				
				arr[i]+= arr[i-1];
				arr[i-1]=0;
			}
			
		}
		
//		System.out.println(Arrays.toString(arr));
		
		long ans=0;
		
		for(Long x: arr) {
			if(x<0) ans+= -x;
		}
		
		System.out.println(ans);
		
	}

}

class MyPair {

	int value;
	int weight;

	public MyPair(int value, int w) {
		this.value = value;
		weight = w;
	}

}