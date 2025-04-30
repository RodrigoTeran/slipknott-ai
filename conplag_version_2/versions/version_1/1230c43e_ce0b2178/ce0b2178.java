import java.io.*;
import java.util.*;

public class D {
	
	static class Pair implements Comparable<Pair>{
		int a;
		char b;

		public Pair(int a, char b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Pair p) {
			if(this.b == p.b) 
				return this.a - p.a;
			return this.b - p.b;
		}
	}
	
	public static void main(String[] args)throws IOException {
		
		FastScanner scan = new FastScanner();
		PrintWriter output = new PrintWriter(System.out);
		int t = scan.nextInt();
		for(int tt = 0;tt<t;tt++) {
			
			int n = scan.nextInt();
			int arr[] = scan.readArray(n);
			char line[] = scan.next().toCharArray();
			ArrayList<Pair> pairs = new ArrayList<Pair>();
			for(int i = 0;i<n;i++) {
				pairs.add(new Pair(arr[i], line[i]));
			}
			Collections.sort(pairs);
			boolean possible = true;
			for(int i = 1;i<=n;i++) {
				if(pairs.get(i-1).a == i) {
					continue;
				}
				else if(pairs.get(i-1).a < i && pairs.get(i-1).b == 'R') {
					continue;
				}
				else if(pairs.get(i-1).a > i && pairs.get(i-1).b == 'B') {
					continue;
				}
				else {
					possible = false;
					break;
				}
			}
			output.println(possible == true ? "YES" : "NO");
		}
		output.flush();

	}
	
	public static int[] sort(int arr[]) {
		List<Integer> list = new ArrayList<>();
		for(int i:arr) list.add(i);
		Collections.sort(list);
		for(int i = 0;i<list.size();i++) arr[i] = list.get(i);
		return arr;
	}
	
	public static int gcd(int a, int b) {
		if(a == 0) return b;
		return gcd(b%a, a);
	}
	
	static boolean isPrime(int n) {
        if (n <= 1) return false;
        else if (n == 2) return true;
        else if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) if (n % i == 0) return false;
        return true;
    }
	
	public static void printArray(int arr[]) {
		for(int i:arr) System.out.print(i+" ");
		System.out.println();
	}
	
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
	}

}
