import java.io.*;
import java.util.*;

public class Template {

	static int mod = 1000000007;

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int yo = sc.nextInt();
		while (yo-- > 0) {
			int n = sc.nextInt();
			
			Map<Integer,Pair> map = new HashMap<>();
			
			for(int i = 0; i < n; i++) {
				map.put(i, new Pair(sc.nextLong(),sc.nextLong()));
			}
			
			List<List<Integer>> list = new ArrayList<>();
			for(int i = 0; i < n; i++) {
				list.add(new ArrayList<>());
			}
			for(int i = 0; i < n-1; i++) {
				int x = sc.nextInt()-1;
				int y = sc.nextInt()-1;
				list.get(x).add(y);
				list.get(y).add(x);
			}
			
			// l -> 0, r -> 1
			
			for(int i = 0; i < 1e5+3; i++) {
				for(int j = 0; j < 2; j++) {
					dp[i][j] = -1;
				}
			}
			long a1 = dfs(map,list,0,0,-1);
			long a2 = dfs(map,list,1,0,-1);
			long ans = Math.max(a1, a2);
			out.println(ans);
		}
		out.close();
	}

//	static Map<String,Long> dp = new HashMap<>();
	static long[][] dp = new long[(int)1e5+10][2];
	private static long dfs(Map<Integer, Pair> map, List<List<Integer>> list, 
							int x, int node, int parent) {
		
		
		if(dp[node][x] != -1) {
			return dp[node][x];
		}

		List<Integer> neighbours = list.get(node);
		
		long ans1 = 0;
		if(x == 0) {
			ans1 = map.get(node).x;
		}
		else {
			ans1 = map.get(node).y;
		}
		
		
		long uAns = 0;
		for(int e : neighbours) {
			if(e == parent) continue;
			long ua1 = dfs(map,list,0,e,node);
			long ua2 = dfs(map,list,1,e,node);
			// consider 0
			long a1 = ua1 + Math.abs(map.get(e).x-ans1);
			// consider 1
			long a2 = ua2 + Math.abs(map.get(e).y-ans1);
			uAns += Math.max(a1, a2);
		}
		
		return dp[node][x] = uAns;
	}

	static class Pair {
		long x;
		long y;

		public Pair(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}

	static void ruffleSort(int[] a) {
		
		int n = a.length;
		Random r = new Random();
		for (int i = 0; i < a.length; i++) {
			int oi = r.nextInt(n), temp = a[i];
			a[i] = a[oi];
			a[oi] = temp;
		}
		Arrays.sort(a);
	}

	static long gcd(long a, long b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	static boolean[] sieve(int N) {
		boolean[] sieve = new boolean[N];
		for (int i = 2; i < N; i++)
			sieve[i] = true;

		for (int i = 2; i < N; i++) {
			if (sieve[i]) {
				if (i * i < 0)
					continue;
				for (int j = i * i; j < N; j += i) {
					sieve[j] = false;
				}
			}
		}
		return sieve;
	}

	static long pow(int a, long b) {
		if (b == 0) {
			return 1;
		}
		if (b == 1) {
			return a;
		}
		if (b % 2 == 0) {
			long ans = pow(a, b / 2);
			return ans * ans;
		} else {
			long ans = pow(a, (b - 1) / 2);
			return a * ans * ans;
		}

	}

	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		String next() {
			while (!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}

	//	For Input.txt and Output.txt	
	//	FileInputStream in = new FileInputStream("input.txt");
	//	FileOutputStream out = new FileOutputStream("output.txt");
	//	PrintWriter pw = new PrintWriter(out);
	//	Scanner sc = new Scanner(in);
}
