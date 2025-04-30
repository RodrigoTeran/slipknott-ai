import java.util.*;
import java.io.*;

public class Main {
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	public static FastReader obj = new FastReader();
	public static PrintWriter out = new PrintWriter(System.out);

	public static void sort(long[] a) {
		ArrayList<Long> arr = new ArrayList<>();
		for (int i = 0; i < a.length; i++)
			arr.add(a[i]);
		Collections.sort(arr);
		for (int i = 0; i < arr.size(); i++)
			a[i] = arr.get(i);
	}

	public static void revsort(long[] a) {
		ArrayList<Long> arr = new ArrayList<>();
		for (int i = 0; i < a.length; i++)
			arr.add(a[i]);
		Collections.sort(arr, Collections.reverseOrder());
		for (int i = 0; i < arr.size(); i++)
			a[i] = arr.get(i);
	}

	//Cover the small test cases like for n=1 .
	public static class pair {
		int a;
		int b;

		pair(int  x, int y) {
			a = x;
			b = y;
		}
	}

	public static long l() {
		return obj.nextLong();
	}

	public static int i() {
		return obj.nextInt();
	}

	public static String s() {
		return obj.next();
	}

	public static long[] l(int n) {
		long[] arr = new long[n];
		for (int i = 0; i < n; i++)
			arr[i] = l();
		return arr;
	}

	public static int[] i(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = i();
		return arr;
	}

	public static long ceil(long a, long b) {
		return (a + b - 1) / b;
	}

	public static void p(long val) {
		out.println(val);
	}

	public static void p(String s) {
		out.println(s);
	}

	public static void pl(long[] arr) {
		for (int i = 0; i < arr.length; i++) {
			out.print(arr[i] + " ");
		}
		out.println();
	}

	public static void p(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			out.print(arr[i] + " ");
		}
		out.println();
	}

	public static void sortpair(ArrayList<pair> arr) {
		//ascending just change return 1 to return -1 and vice versa to get descending.
		//compare based on value of pair.a
		arr.sort(new Comparator<pair>() {
			public int compare(pair o1, pair o2) {
				long val = o1.a - o2.a;
				if (val == 0)
					return 0;
				else if (val > 0)
					return 1;
				else
					return -1;
			}
		});
	}

	// Take of the small test cases such as when n=1,2 etc.
	// remember in case of fenwick tree ft is 1 based but our array should be 0 based.
	// in fenwick tree when we update some index it doesn't change the value to val but it
	// adds the val value in it so remember to add val-a[i] instead of just adding val.
	//in case of finding the inverse mod do it (biexpo(a,mod-2)%mod + mod )%mod
    public static ArrayList<ArrayList<pair>> adj;
    public static int[] ans;
	public static void main(String[] args) {

		int len = i();
		while (len-- != 0) {
			int n = i();
			adj=new ArrayList<>(n+1);
			ans=new int[n];
			int ok=0;
			for(int i=0;i<=n;i++)adj.add(new ArrayList<>());
			for(int i=0;i<n-1;i++)
			{
				int a=obj.nextInt();
				int b=obj.nextInt();
				adj.get(a).add(new pair(b,i));
				adj.get(b).add(new pair(a,i));
				if(adj.get(a).size()>2)ok=1;
				if(adj.get(b).size()>2)ok=1;
			}
			if(ok==1)out.println(-1);
			else
			{
				int[] vis=new int[n+1];
				if(adj.get(1).size()==2)
				{
					vis[adj.get(1).get(1).a]=1;
					dfs(1,vis,11);
					vis[adj.get(1).get(1).a]=0;
					vis[1]=0;
					dfs(1,vis,2);
				}
				else
				{
					dfs(1,vis,11);
				}
				for(int i=0;i<n-1;i++)out.print(ans[i]+" ");
				out.println();
			}
		}
		out.flush();
	}
	public static void dfs(int cur,int[] vis,int c)
	{
		vis[cur]=1;
		for(pair nd:adj.get(cur))
		{
			if(vis[nd.a]==1)continue;
			if(c==2)ans[nd.b]=11;
			else ans[nd.b]=2;
			dfs(nd.a,vis,ans[nd.b]);
		}
	}
}