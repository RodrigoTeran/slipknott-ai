import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solve {

	static int mod = 1000000000 + 7;
	static long fact[] = new long[2 * 100000 + 3];

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt(); // blocks
			int m = sc.nextInt(); // towers to build
			int x = sc.nextInt(); // maximum diff
			int heights[] = new int[n];
			int sum = 0;
			PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
			for (int i = 0; i < n; i++) {
				heights[i] = sc.nextInt();
			}
			for (int i = 0; i < m; i++) {
				pq.add(new Pair(i + 1, 0));
			}
			pw.println("YES");

			for (int i = 0; i < n; i++) {
				Pair p = pq.poll();
				p.value += heights[i];
				pq.add(p);
				pw.print(p.tower + " ");
			}

			pw.println();
		}
		pw.flush();
	}

	static long gcd(long a, long b) {
		if (a == 0)
			return b;
		if (b == 0)
			return a;

		return gcd(b, a % b);

	}

	static long nC2(long n) {
		return n * (n - 1) / 2;
	}

	static long nCrModp(int n, int r, int p) {
		if (r > n - r)
			r = n - r;

		// The array C is going to store last
		// row of pascal triangle at the end.
		// And last entry of last row is nCr
		int C[] = new int[r + 1];

		C[0] = 1; // Top row of Pascal Triangle

		// One by constructs remaining rows of Pascal
		// Triangle from top to bottom
		for (int i = 1; i <= n; i++) {

			// Fill entries of current row using previous
			// row values
			for (int j = Math.min(i, r); j > 0; j--)

				// nCj = (n-1)Cj + (n-1)C(j-1);
				C[j] = (C[j] + C[j - 1]) % p;
		}
		return C[r];
	}

	static void sort(int[] a) {
		ArrayList<Integer> l = new ArrayList<>();
		for (int i : a)
			l.add(i);
		Collections.sort(l);
		for (int i = 0; i < a.length; i++)
			a[i] = l.get(i);
	}

}

class Pair implements Comparable<Pair> {
	int tower;
	int value = 0;

	Pair(int x, int y) {
		tower = x;
		value = y;
	}

	public int compareTo(Pair o) {
		return this.value - o.value;
	}

}

class Scanner {
	BufferedReader br;
	StringTokenizer st;

	Scanner() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	String next() throws IOException {
		while (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	int nextInt() throws NumberFormatException, IOException {
		return Integer.parseInt(next());
	}

	long nextLong() throws NumberFormatException, IOException {
		return Long.parseLong(next());
	}

	double nextDouble() throws NumberFormatException, IOException {
		return Double.parseDouble(next());
	}
}

//creating a hash table
//Hashtable<Integer, String> h = new Hashtable<Integer, String>();
//
//Hashtable<Integer, String> h1 = new Hashtable<Integer, String>();
//
//h.put(3, "Geeks");
//h.put(2, "forGeeks");
//h.put(1, "isBest");
//System.out.println(h.get(1));
//if (h.containsKey(1)) {
//	System.out.println(1111111);
//}
//if (h.containsValue("isBest")) {
//	System.out.println(1111111);
//}
//
//// create a clone or shallow copy of hash table h
//h1 = (Hashtable<Integer, String>) h.clone();
//
//// checking clone h1
////System.out.println("values in clone: " + h1);
//
//// clear hash table h
//h.clear();

//Creating object of the 
// class linked list 
//LinkedList<String> ll 
//    = new LinkedList<String>(); 
//
//// Adding elements to the linked list 
//ll.add("A"); 
//ll.add("B"); 
//ll.addLast("C"); 
//ll.addFirst("D"); 
//ll.add(2, "E"); 
//
//System.out.println(ll); 
//
//ll.remove("B"); 
//ll.remove(3); 
//ll.removeFirst(); 
//ll.removeLast(); 
//
//System.out.println(ll); 

//Set<Integer> set = new HashSet<Integer>();
//try {
//   for(int i = 0; i < 5; i++) {
//      set.add(count[i]);
//   }
//   System.out.println(set);
//
//   TreeSet sortedSet = new TreeSet<Integer>(set);
//   System.out.println("The sorted list is:");
//   System.out.println(sortedSet);
//
//   System.out.println("The First element of the set is: "+ (Integer)sortedSet.first());
//   System.out.println("The last element of the set is: "+ (Integer)sortedSet.last());
//}
//catch(Exception e) {}