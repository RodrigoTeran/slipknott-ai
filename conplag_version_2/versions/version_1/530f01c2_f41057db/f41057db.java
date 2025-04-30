import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution{
	

	public static void main(String[] args) throws Exception{

		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int tt = fs.nextInt();
		
		while(tt-->0) {
			
			int n = fs.nextInt(), aStart = fs.nextInt()-1, bStart = fs.nextInt()-1, aMove = fs.nextInt(), bMove = fs.nextInt();
			
			Node[] nodes = new Node[n];
			for(int i=0;i<n;i++) {
				nodes[i] = new Node();
			}
			
			for(int i=0;i<n-1;i++) {
				int u = fs.nextInt()-1, v = fs.nextInt()-1;
				nodes[u].adjList.add(nodes[v]);
				nodes[v].adjList.add(nodes[u]);
			}
			
			if(2*aMove>=bMove) {
				out.println("Alice");
				continue;
			}
			
			bfs(nodes,nodes[aStart]);
			
			if(nodes[bStart].dis<=aMove) {
				out.println("Alice");
				continue;
			}
			
			Node fNode = farthest(nodes);
			bfs(nodes, fNode);
			fNode = farthest(nodes);
			
			
			if(fNode.dis>=2*aMove+1) {
				out.println("Bob");
			}
			else {
				out.println("Alice");
			}
			
		}
		

		out.close();
	}
	
	static Node farthest(Node[] nodes) {
		Node fNode = nodes[0];
		for(Node n: nodes) {
			if(n.dis>fNode.dis) {
				fNode = n;
			}
		}
		return fNode;
	}
	
	static void bfs(Node[] nodes, Node start) {
		for(Node n: nodes) n.dis = -1;
		start.dis = 0;
		ArrayDeque<Node> queue = new ArrayDeque<Node>();
		queue.add(start);
		while(!queue.isEmpty()) {
			Node n = queue.remove();
			for(Node node: n.adjList) {
				if(node.dis==-1) {
					node.dis = n.dis + 1;
					queue.add(node);
				}
			}
		}
	}
	
	static class Node{
		LinkedList<Node> adjList = new LinkedList<Node>();
		int dis = -1;
	}
	
	
	
	
	static class FastScanner{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		public String next(){
			while(!st.hasMoreElements()){
				try{
					st = new StringTokenizer(br.readLine());
				} catch(IOException e){
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		public String nextLine() throws IOException {
			return br.readLine();
		}
		
		public int nextInt(){
			return Integer.parseInt(next());
		}

		public int[] readArray(int n){
			int[] a = new int[n];
			for(int i=0;i<n;i++)
				a[i] = nextInt();
			return a;
		}
		
		public long nextLong() {
			return Long.parseLong(next());
		}
	}
	
	
	static int lowerBound(int[] arr, int l, int r, int k) {
		while(r>l) {
			int mid = (l+r)/2;
			if(arr[mid]>=k) {
				r = mid;
			}
			else {
				l = mid+1;
			}
		}
		if(arr[l]<k)
			return -1;
		return l;
	}
	
	
	
	static int upperBound(int[] arr, int l, int r, int k) {
		while(r>l) {
			int mid = (l+r)/2;
			if(arr[mid]>k) {
				r = mid;
			}
			else {
				l = mid+1;
			}
		}
		if(arr[l]<=k)
			return -1;
		return l;
	}
	
	static long gcd(long a,long b) {
		return (b==0)?a:gcd(b,a%b);
	}

}