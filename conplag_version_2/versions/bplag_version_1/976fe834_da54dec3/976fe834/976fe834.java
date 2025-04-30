import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;
import static java.lang.System.out;
import java.util.*;
import java.io.*;
import java.math.*;
/*
-> Give your 100%, that's it!
-> Feynman Rule To Solve Any Problem:
    1. Read the problem.
    2. Think About It.
    3. Solve it!
*/

public class Template {
    
	static int mod = 1000000007;

	public static void main(String[] args){
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int yo = sc.nextInt();
        while (yo-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][m];
            for(int i = 0; i < n; i++){
                String s = sc.next();
                for(int j = 0; j < m; j++){
                    arr[i][j] = s.charAt(j)-'0';
                }
            }
            
            List<String> list = new ArrayList<>();
            for(int i = 0; i < n-1; i++){
                for(int j = 0; j < m-1; j++){
                    check(list,i,j,n,m,arr);
                }
            }
            
            // for(int i = 0; i < n; i++){
            //     for(int j = 0; j < m; j++){
            //         out.print(arr[i][j] + " ");
            //     }
            //     out.println();
            // }
            
            out.println(list.size()/3);
            for(int i = 0; i < list.size(); i+=3){
                out.println(list.get(i) + " " + list.get(i+1) + " " + list.get(i+2));
            }
            // out.println(list.size());
            // for(int i = 0; i < list.size(); i++){
            //     out.println(list.get(i));
            // }
        }
        out.close();    
	}
    
    static void check(List<String> list, int i, int j, int n, int m, int[][] arr){
        int[][] a = new int[2][2];
        a[0][0] = arr[i][j];
        a[0][1] = arr[i][j+1];
        a[1][0] = arr[i+1][j];
        a[1][1] = arr[i+1][j+1];
        
        int ones = 0;
        for(int x = 0; x < 2; x++){
            for(int y = 0; y < 2; y++){
                if(a[x][y] == 1) ones++;
            }
        }
        
        if(ones == 0) return;
        
        if(ones == 1){
            ones(i,j,list,a);
            twos(i,j,list,a);
            threes(i,j,list,a);
        }
        else if(ones == 2){
            twos(i,j,list,a);
            threes(i,j,list,a);
        }
        else if(ones == 3){
            threes(i,j,list,a);
        }
        else if(ones == 4){
            fours(i,j,list,a);
            // for(int x = 0; x < 2; x++){
            //     for(int y = 0; y < 2; y++){
            //         out.print(a[x][y] + " ");
            //     }
            //     out.println();
            // }
            ones(i,j,list,a);
            // for(int x = 0; x < 2; x++){
            //     for(int y = 0; y < 2; y++){
            //         out.print(a[x][y] + " ");
            //     }
            //     out.println();
            // }
            twos(i,j,list,a);
            // for(int x = 0; x < 2; x++){
            //     for(int y = 0; y < 2; y++){
            //         out.print(a[x][y] + " ");
            //     }
            //     out.println();
            // }
            threes(i,j,list,a);
            // for(int x = 0; x < 2; x++){
            //     for(int y = 0; y < 2; y++){
            //         out.print(a[x][y] + " ");
            //     }
            //     out.println();
            // }
        }
        
        arr[i][j] = a[0][0];
        arr[i+1][j] = a[1][0];
        arr[i][j+1] = a[0][1];
        arr[i+1][j+1] = a[1][1];
    }
    
    public static void twos(int i, int j, List<String> list, int[][] a){
        int count = 0;
        for(int x = 0; x < 2; x++){
            for(int y = 0; y < 2; y++){
                if(a[x][y] == 1 && count < 1) {
                    count++;
                    a[x][y] = 0;
                    list.add(get(x,y,i,j));
                }
                else if(a[x][y] == 0){
                    list.add(get(x,y,i,j));
                    a[x][y] = 1;
                }
            }
        }
    }
    
    public static void threes(int i, int j, List<String> list, int[][] a){
        int count = 0;
        for(int x = 0; x < 2; x++){
            for(int y = 0; y < 2; y++){
                if(a[x][y] == 1) {
                    a[x][y] = 0;
                    list.add(get(x,y,i,j));
                }
            }
        }
    }
    
    public static void fours(int i, int j, List<String> list, int[][] a){
        int count = 0;
        for(int x = 0; x < 2; x++){
            for(int y = 0; y < 2; y++){
                if(a[x][y] == 1 && count < 3) {
                    count++;
                    a[x][y] = 0;
                    list.add(get(x,y,i,j));
                }
            }
        }
    }
    
    public static void ones(int i, int j, List<String> list, int[][] a){
        int count = 0;
        for(int x = 0; x < 2; x++){
            for(int y = 0; y < 2; y++){
                if(a[x][y] == 1) {
                    a[x][y] = 0;
                    list.add(get(x,y,i,j));
                }
                else if(a[x][y] == 0 && count < 2){
                    a[x][y] = 1;
                    count++;
                    list.add(get(x,y,i,j));
                }
            }
        }
    }
    
    public static String get(int x, int y, int i, int j){
        if(x == 0 && y == 0) {
            return (i+1) + " " + (j+1);
        }
        else if(x == 0 && y == 1){
            return (i+1) + " " + (j+2);
        }
        else if(x == 1 && y == 0){
            return (i+2) + " " + (j+1);
        }
        else {
            return (i+2) + " " + (j+2);
        }
    }
    
   
    
    
    /*
         Random stuff to try when stuck:
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

	public static void print(int[] arr) {
		//for debugging only
		for (int x : arr)
			out.print(x + " ");
		out.println();
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