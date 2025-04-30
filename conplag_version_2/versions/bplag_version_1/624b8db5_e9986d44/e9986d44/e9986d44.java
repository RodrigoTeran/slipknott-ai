



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class cp23 {
	static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	static int mod = 1000000007;
	static String toReturn = "";

	static int steps = Integer.MAX_VALUE;
	static int maxlen = 1000005;
	
	
	
	/*MATHEMATICS FUNCTIONS START HERE
	MATHS
	MATHS
	MATHS
	MATHS*/
	static long gcd(long a, long b) {
		if(b == 0) return a;
		else return gcd(b, a % b);
	}

	static long powerMod(long x, long y, int mod) {
		if(y == 0) return 1;
		long temp = powerMod(x, y / 2, mod);
		temp = ((temp % mod) * (temp % mod)) % mod;
		if(y % 2 == 0) return temp;
		else return ((x % mod) * (temp % mod)) % mod;
	}
	
	static long modInverse(long n, int p) {
		return powerMod(n, p - 2, p);
	}
	
	static long nCr(int n, int r, int mod, long [] fact, long [] ifact) {
		return ((fact[n] % mod) * ((ifact[r] * ifact[n - r]) % mod)) % mod;
	}
	/*
	 * static long [] seive(long n) {
	 * 
	 * }
	 */
	/*MATHS
	MATHS
	MATHS
	MATHS
	MATHEMATICS FUNCTIONS END HERE */
	
	/*SWAP FUNCTION START HERE
	  SWAP
	  SWAP
	  SWAP
	  SWAP
	 */
	static void swap(int i, int j, int [] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	/*SWAP
	  SWAP
	  SWAP
	  SWAP
	 SWAP FUNCTION END HERE*/
	
	
	
	/*BINARY SEARCH METHODS START HERE
	 * BINARY SEARCH
	 * BINARY SEARCH
	 * BINARY SEARCH
	 * BINARY SEARCH
	 */
	static boolean BinaryCheck(long test, long [] arr, long health) {
		for(int i = 0; i <= arr.length - 1; i++) {
			if(i == arr.length - 1) health -= test;
			else if(arr[i + 1] - arr[i] > test) {
				health = health - test;
			}else {
				health = health - (arr[i + 1] - arr[i]);
			}
			if(health <= 0) return true;
		}
		return false;
	}
	
	static long binarySearchModified(long n, long [] arr) {
		long start = 0, end = n, ans = n;
		while(start < end) {
			long mid = (start + end) / 2;
			if(BinaryCheck(mid, arr, n)) {
				ans = Math.min(ans, mid);
				end = mid;
			}else {
				start = mid + 1;
				
			}
		}
		return ans;
	}
	/*BINARY SEARCH
	 * BINARY SEARCH
	 * BINARY SEARCH
	 * BINARY SEARCH
	 * BINARY SEARCH
	 BINARY SEARCH METHODS END HERE*/
	
	
	/*RECURSIVE FUNCTION START HERE
	 * RECURSIVE
	 * RECURSIVE
	 * RECURSIVE
	 * RECURSIVE
	 */
	
	static int recurse(int x, int y, int n, int steps1, Integer [][] dp) {
		if(x > n || y > n) return 0;
		if(dp[x][y] != null) {
			return dp[x][y];
		}
		else if(x == n || y == n) {
			
			return steps1;
		}
		
		return dp[x][y] = Math.max(recurse(x + y, y, n, steps1 + 1, dp), recurse(x, x + y, n, steps1 + 1, dp));
	}
	/*RECURSIVE
	 * RECURSIVE
	 * RECURSIVE
	 * RECURSIVE
	 * RECURSIVE
	 RECURSIVE FUNCTION END HERE*/
	
	/*GRAPH FUNCTIONS START HERE
	 * GRAPH
	 * GRAPH
	 * GRAPH
	 * GRAPH
	 * */
	static class edge{
		int from, to, weight;
		public edge(int x, int y, int z) {
			this.from = x;
			this.to = y;
			this.weight = z;
		}
	}
	static void addEdge(ArrayList<ArrayList<edge>> graph, int from, int to, int weight) {
		edge temp = new edge(from, to, weight);
		edge temp1 = new edge(to, from, weight);
		graph.get(from).add(temp);
		graph.get(to).add(temp1);
	}
	static int ans = 0;
	static void dfs(ArrayList<ArrayList<edge>> graph, int vertex, boolean [] visited, int [] toReturn, int weight) {
		//System.out.println(graph.get(vertex).size());
		if(visited[vertex]) return;
		visited[vertex] = true;
		if(graph.get(vertex).size() > 2) return;
		for(int i = 0; i < graph.get(vertex).size(); i++) {
			edge temp = graph.get(vertex).get(i);
			if(!visited[temp.to]) {
				//System.out.println(temp.to);
				toReturn[temp.weight] = weight;
				dfs(graph, temp.to, visited, toReturn, 5 - weight);
				weight = 5 - weight;
			}
		}
	}
	static void bfs(ArrayList<ArrayList<edge>> graph, int vertex, boolean [] visited, int [] toReturn, Queue<Integer> q, int weight) {
		if(visited[vertex]) return;
		visited[vertex] = true;
		if(graph.get(vertex).size() > 2) return;
		int first = weight;
		for(int i = 0; i < graph.get(vertex).size(); i++) {
			edge temp = graph.get(vertex).get(i);
			if(!visited[temp.to]) {
				q.add(temp.to);
				toReturn[temp.weight] = weight;
				weight = 5 - weight;
			}
		}
		if(!q.isEmpty())bfs(graph, q.poll(), visited, toReturn, q, 5 - first);
	}
	
	static void topoSort(ArrayList<ArrayList<Integer>> graph, int vertex, boolean [] visited, ArrayList<Integer> toReturn) {
		if(visited[vertex]) return;
		visited[vertex] = true;
		for(int i = 0; i < graph.get(vertex).size(); i++) {
			if(!visited[graph.get(vertex).get(i)]) topoSort(graph, graph.get(vertex).get(i), visited, toReturn);
		}
		toReturn.add(vertex);
	}
	static boolean isCyclicDirected(ArrayList<ArrayList<Integer>> graph, int vertex, boolean [] visited, boolean [] reStack) {
		if(reStack[vertex]) return true;
		if(visited[vertex]) return false;
		reStack[vertex] = true;
		visited[vertex] = true;
		
		for(int i = 0; i < graph.get(vertex).size(); i++) {
			if(isCyclicDirected(graph, graph.get(vertex).get(i), visited, reStack)) return true;
		}
		reStack[vertex] = false;
		return false;
	}
	/*GRAPH FUNCTIONS END HERE
	 * GRAPH
	 * GRAPH
	 * GRAPH
	 * GRAPH
	 */
	/*disjoint Set START HERE
	 * disjoint Set
	 * disjoint Set
	 * disjoint Set
	 * disjoint Set
	 */
	static int [] rank;
	static int [] parent;
	static int parent(int [] parent, int x) {
		if(parent[x] == x) return x;
		else return parent[x] = parent(parent, parent[x]);
	}
	static void union(int x, int y, int [] rank, int [] parent) {
		if(parent(parent, x) == parent(parent, y)) {
			return;
		}
		if(rank[x] > rank[y]) {
			swap(x, y, rank);
		}
		rank[x] += rank[y];
		parent[x] = y;
	}
	/*disjoint Set END HERE
	 * disjoint Set
	 * disjoint Set
	 * disjoint Set
	 * disjoint Set
	 */
	
	
	/*INPUT START HERE
	 * INPUT
	 * INPUT
	 * INPUT
	 * INPUT
	 * INPUT
	 */
	
	static int nexInt() throws NumberFormatException, IOException {
		return Integer.parseInt(sc.readLine());
	}
	static long nexLong() throws NumberFormatException, IOException {
		return Long.parseLong(sc.readLine());
	}
	static long [] inputLongArr() throws NumberFormatException, IOException{
		String [] s = sc.readLine().split(" ");
		long [] toReturn = new long[s.length];
		for(int i = 0; i < s.length; i++) {
			toReturn[i] = Long.parseLong(s[i]);
		}
		return toReturn;
	}
	static int [] inputIntArr() throws NumberFormatException, IOException{
		String [] s = sc.readLine().split(" ");
		int [] toReturn = new int[s.length];
		for(int i = 0; i < s.length; i++) {
			toReturn[i] = Integer.parseInt(s[i]);
		}
		return toReturn;
	}
	/*INPUT
	 * INPUT
	 * INPUT
	 * INPUT
	 * INPUT
	 * INPUT END HERE
	 */
	static void solve() throws IOException {
		
		int n = nexInt();
		ArrayList<ArrayList<edge>> tree = new ArrayList<>();
		for(int i = 0; i < n; i++) tree.add(new ArrayList<edge>());
		for(int i = 0; i < n - 1; i++) {
		int [] s1 = inputIntArr();
		addEdge(tree, s1[0] - 1, s1[1] - 1, i);
		}
		int vertex = 0;
		for(int i = 0; i < tree.size(); i++) {
			if(tree.get(i).size() > 2) {
				System.out.println(-1);
				return;
			}else if(tree.size() == 1) {
				vertex = i;
			}
		}
		int [] toReturn = new int[n - 1];
		//toReturn.add(2);
		dfs(tree, vertex, new boolean[n], toReturn,  2);
		//System.out.println(toReturn.size());
		
		
			for(int i = 0; i <  toReturn.length; i++) 
				if(toReturn[i] != 0)System.out.print(toReturn[i] + " ");
			System.out.println();
		
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		 int t = Integer.parseInt(sc.readLine()); for(int i = 0; i < t; i++) 
		  solve();
		
		
	}
	}




