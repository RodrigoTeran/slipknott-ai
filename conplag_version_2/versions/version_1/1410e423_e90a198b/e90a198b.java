import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;
import static java.lang.System.out;
import java.util.*;
import java.io.*;
import java.math.*;

public class Template {
    
	static int mod = 1000000007;

	public static void main(String[] args){
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int yo = sc.nextInt();
        while (yo-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            String t = sc.next();
            int op1 = cal(s,t,n);
            int op2 = helper(s,t,n,'0');
            int op3 = helper(s,t,n,'1');
            int ans = min(min(op1,op2),op3);
            if(ans == Integer.MAX_VALUE){
                out.println("-1");
            }
            else {
                out.println(ans);
            }
        }
        out.close();
	}
    
    static int helper(String str1, String str2, int n, int ch){
        char[] s = str1.toCharArray();
        char[] t = str2.toCharArray();
        int idx = -1;
        for(int i = 0; i < n; i++){
            if(s[i] == '1' && t[i] == ch){
                idx = i;
                break;
            }
        }
        if(idx == -1){
            return Integer.MAX_VALUE;
        }
        for(int i = 0; i < n; i++){
            if(i == idx) continue;
            if(s[i] == '1') s[i] = '0';
            else s[i] = '1';
        }
        int ans = cal(String.valueOf(s),String.valueOf(t),n);
        if(ans == Integer.MAX_VALUE) return ans;
        return 1 + ans;
    }
    static int cal(String s, String t, int n){
        int op01 = 0;
        int op10 = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) != t.charAt(i)){
                if(s.charAt(i) == '1') op10++;
                else op01++;
            }
        }
        if(op10 != op01){
            return Integer.MAX_VALUE;
        }
        return op01 + op10;
    }
    
    /*
    Source: hu_tao
         Random stuff to try when stuck:
            - use bruteforcer
            - check for n = 1, n = 2, so on
            -if it's 2C then it's dp
            -for combo/probability problems, expand the given form we're interested in
            -make everything the same then build an answer (constructive, make everything 0 then do something)
            -something appears in parts of 2 --> model as graph
            -assume a greedy then try to show why it works
            -find way to simplify into one variable if multiple exist
            -treat it like fmc (note any passing thoughts/algo that could be used so you can revisit them)
            -find lower and upper bounds on answer
            -figure out what ur trying to find and isolate it
            -see what observations you have and come up with more continuations
            -work backwards (in constructive, go from the goal to the start)
            -turn into prefix/suffix sum argument (often works if problem revolves around adjacent array elements)
            -instead of solving for answer, try solving for complement (ex, find n-(min) instead of max)
            -draw something
            -simulate a process
            -dont implement something unless if ur fairly confident its correct
            -after 3 bad submissions move on to next problem if applicable
            -do something instead of nothing and stay organized
            -write stuff down
         Random stuff to check when wa:
            -if code is way too long/cancer then reassess
            -switched N/M
            -int overflow
            -switched variables
            -wrong MOD
            -hardcoded edge case incorrectly
         Random stuff to check when tle:
            -continue instead of break
            -condition in for/while loop bad
         Random stuff to check when rte:
            -switched N/M
            -long to int/int overflow
            -division by 0
            -edge case for empty list/data structure/N=1
            
      */

	public static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void sort(int[] arr) {
		ArrayList<Integer> ls = new ArrayList<Integer>();
		for (int x : arr)
			ls.add(x);
		Collections.sort(ls);
		for (int i = 0; i < arr.length; i++)
			arr[i] = ls.get(i);
	}

	public static long gcd(long a, long b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	static boolean[] sieve(int N) {
		boolean[] sieve = new boolean[N + 1];
		for (int i = 2; i <= N; i++)
			sieve[i] = true;

		for (int i = 2; i <= N; i++) {
			if (sieve[i]) {
				for (int j = 2 * i; j <= N; j += i) {
					sieve[j] = false;
				}
			}
		}
		return sieve;
	}

	public static long power(long x, long y, long p) {
		long res = 1L;
		x = x % p;
		while (y > 0) {
			if ((y & 1) == 1)
				res = (res * x) % p;
			y >>= 1;
			x = (x * x) % p;
		}
		return res;
	}

	public static void print(int[] arr, PrintWriter out) {
		//for debugging only
		for (int x : arr)
			out.print(x + " ");
		out.println();
	}
    
    public static int log2(int a){
        return (int)(Math.log(a)/Math.log(2));
    }
    
    public static long ceil(long x, long y){
        return (x + 0l + y - 1) / y;
    }

	static class FastScanner {
		private int BS = 1 << 16;
		private char NC = (char) 0;
		private byte[] buf = new byte[BS];
		private int bId = 0, size = 0;
		private char c = NC;
		private double cnt = 1;
		private BufferedInputStream in;

		public FastScanner() {
			in = new BufferedInputStream(System.in, BS);
		}

		public FastScanner(String s) {
			try {
				in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
			} catch (Exception e) {
				in = new BufferedInputStream(System.in, BS);
			}
		}

		private char getChar() {
			while (bId == size) {
				try {
					size = in.read(buf);
				} catch (Exception e) {
					return NC;
				}
				if (size == -1)
					return NC;
				bId = 0;
			}
			return (char) buf[bId++];
		}

		public int nextInt() {
			return (int) nextLong();
		}

		public int[] readInts(int N) {
			int[] res = new int[N];
			for (int i = 0; i < N; i++) {
				res[i] = (int) nextLong();
			}
			return res;
		}

		public long[] readLongs(int N) {
			long[] res = new long[N];
			for (int i = 0; i < N; i++) {
				res[i] = nextLong();
			}
			return res;
		}

		public long nextLong() {
			cnt = 1;
			boolean neg = false;
			if (c == NC)
				c = getChar();
			for (; (c < '0' || c > '9'); c = getChar()) {
				if (c == '-')
					neg = true;
			}
			long res = 0;
			for (; c >= '0' && c <= '9'; c = getChar()) {
				res = (res << 3) + (res << 1) + c - '0';
				cnt *= 10;
			}
			return neg ? -res : res;
		}

		public double nextDouble() {
			double cur = nextLong();
			return c != '.' ? cur : cur + nextLong() / cnt;
		}

		public double[] readDoubles(int N) {
			double[] res = new double[N];
			for (int i = 0; i < N; i++) {
				res[i] = nextDouble();
			}
			return res;
		}

		public String next() {
			StringBuilder res = new StringBuilder();
			while (c <= 32)
				c = getChar();
			while (c > 32) {
				res.append(c);
				c = getChar();
			}
			return res.toString();
		}

		public String nextLine() {
			StringBuilder res = new StringBuilder();
			while (c <= 32)
				c = getChar();
			while (c != '\n') {
				res.append(c);
				c = getChar();
			}
			return res.toString();
		}

		public boolean hasNext() {
			if (c > 32)
				return true;
			while (true) {
				c = getChar();
				if (c == NC)
					return false;
				else if (c > 32)
					return true;
			}
		}
	}

	//	For Input.txt and Output.txt	
	//	FileInputStream in = new FileInputStream("input.txt");
	//	FileOutputStream out = new FileOutputStream("output.txt");
	//	PrintWriter pw = new PrintWriter(out);
	//	Scanner sc = new Scanner(in);
}