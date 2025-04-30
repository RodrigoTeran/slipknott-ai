import java.util.*;
import java.io.*;

public class CodeforcesRound734 {
	static FastReader sc = new FastReader();

	public static void main(String[] args) throws IOException {
		try {
			int t = sc.nextInt();
			while (t-- > 0) {
//				A();
//				B1();
//				B2();
				C();
			}
		} catch (Exception e) {
//			return;
			e.printStackTrace();
		}
	}

	static void C() {
		int n = sc.nextInt();
		int a[][] = new int[5][n];
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == 'a')
					a[0][i]++;
				else
					a[0][i]--;
				if (s.charAt(j) == 'b')
					a[1][i]++;
				else
					a[1][i]--;
				if (s.charAt(j) == 'c')
					a[2][i]++;
				else
					a[2][i]--;
				if (s.charAt(j) == 'd')
					a[3][i]++;
				else
					a[3][i]--;
				if (s.charAt(j) == 'e')
					a[4][i]++;
				else
					a[4][i]--;
			}
		}
		for (int x[] : a) {
			Arrays.sort(x);
		}
		int ans = 0;
		for (int i = 0; i < 5; i++) {
			int temp = 0, cnt = 0;
			for (int j = n - 1; j >= 0; j--) {
				temp += a[i][j];
				if (temp <= 0)
					break;
				else
					cnt++;
			}
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	}

	static void B2() {
		int n = sc.nextInt();
		int k = sc.nextInt();
		ArrayList<ArrayList<Integer>> al = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			al.add(new ArrayList<>());
		}
		int ans[] = new int[n + 1];
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			al.get(x).add(i + 1);
		}
		ArrayList<Integer> temp = new ArrayList<>();
		for (ArrayList<Integer> ind : al) {
			if (ind.size() >= k) {
				for (int i = 0; i < k; i++) {
					ans[ind.get(i)] = i + 1;
				}
			} else {
				temp.addAll(ind);
			}
		}
		int color = 0;
		for (int i = 0; i < temp.size() / k; i++) {
			for (int j = i * k; j < i * k + k; j++) {
				ans[temp.get(j)] = ++color;
				if (color == k)
					color = 0;
			}
		}
		for (int i = 1; i <= n; i++) {
			System.out.print(ans[i] + " ");
		}
		System.out.println();
	}

	static void B1() {
		String s = sc.next();
		HashMap<Character, Integer> map = new HashMap<>();
		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		if (s.length() < 2) {
			System.out.println(0);
			return;
		}
		int s1 = 0;
		for (int v : map.values()) {
			if (v > 2) {
				s1 += 2;
			} else {
				s1 += v;
			}
		}
		System.out.println(s1 / 2);
	}

	static void A() {
		int n = sc.nextInt();
		if (n % 3 == 0) {
			System.out.println(n / 3 + " " + n / 3);
		} else if (n % 3 == 1) {
			System.out.println((n / 3 + 1) + " " + (n / 3));
		} else {
			System.out.println((n / 3) + " " + (n / 3 + 1));
		}
	}

	static boolean[] seiveOfEratosthenes(int n) {
		boolean[] isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);
		for (int i = 2; i * i <= n; i++) {
			for (int j = i * i; j <= n; j += i) {
				isPrime[j] = false;
			}
		}
		return isPrime;
	}

	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	static boolean isPrime(long n) {
		if (n < 2)
			return false;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

}

class FastReader {
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

	int[] readIntArray(int n) {
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(next());
		}
		return a;
	}

	void printIntArray(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	long[] readLongArray(int n) {
		long a[] = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = Long.parseLong(next());
		}
		return a;
	}

	void printLongArray(long a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
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
