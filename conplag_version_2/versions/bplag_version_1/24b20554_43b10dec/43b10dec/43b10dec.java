// package eround101;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

public class C101 {

    static HritikScanner sc = new HritikScanner();
    static PrintWriter pw = new PrintWriter(System.out, true);
    final static int MOD = (int) 1e9 + 7;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        int t = ni();
        while (t-- > 0) {
            solve();
        }
    }

     static void solve() {
         int n = ni();
         int m = ni(), x = ni();
         Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
         pl("YES");
         for(int i = 0; i < n; i++)
         {
             int num = ni();
             if(!map.containsKey(num))
             {
                 map.put(num, new ArrayList<Integer>());
             }
             map.get(num).add(i);
         }
         int[] ans = new int[n];
         int q = 0;
         for(int block : map.keySet())
         {
             for(int i = 0; i < map.get(block).size(); i++)
             {
                 ans[map.get(block).get(i)] = (q++)%m+1;
             }
         }
         for(int ele : ans)
         {
             p(ele + " ");
         }
         pl();
     }
    
    
    /////////////////////////////////////////////////////////////////////////////////
    static int[] nextIntArray(int n) {
        int[] arr = new int[n];
        int i = 0;
        while (i < n) {
            arr[i++] = ni();
        }
        return arr;
    }

    static long[] nextLongArray(int n) {
        long[] arr = new long[n];
        int i = 0;
        while (i < n) {
            arr[i++] = nl();
        }
        return arr;
    }

    static int[] nextIntArray1(int n) {
        int[] arr = new int[n + 1];
        int i = 1;
        while (i <= n) {
            arr[i++] = ni();
        }
        return arr;
    }

    /////////////////////////////////////////////////////////////////////////////////
    static int ni() {
        return sc.nextInt();
    }

    static long nl() {
        return sc.nextLong();
    }

    static double nd() {
        return sc.nextDouble();
    }

    /////////////////////////////////////////////////////////////////////////////////
    static void pl() {
        pw.println();
    }

    static void p(Object o) {
        pw.print(o);
    }

    static void pl(Object o) {
        pw.println(o);
    }

    static void psb(StringBuilder sb) {
        pw.print(sb);
    }

    static void pa(Object arr[]) {
        for (Object o : arr) {
            p(o);
        }
        pl();
    }

    static void pa(int arr[]) {
        for (int o : arr) {
            p(o);
        }
        pl();
    }

    static void pa(long arr[]) {
        for (long o : arr) {
            p(o);
        }
        pl();
    }

    static void pa(double arr[]) {
        for (double o : arr) {
            p(o);
        }
        pl();
    }

    static void pa(char arr[]) {
        for (char o : arr) {
            p(o);
        }
        pl();
    }

    static void pa(List list) {
        for (Object o : list) {
            p(o);
        }
        pl();
    }

    static void pa(Object[][] arr) {

        for (int i = 0; i < arr.length; ++i) {
            for (Object o : arr[i]) {
                p(o);
            }
            pl();
        }
    }

    static void pa(int[][] arr) {
        for (int i = 0; i < arr.length; ++i) {
            for (int o : arr[i]) {
                p(o);
            }
            pl();
        }
    }

    static void pa(long[][] arr) {
        for (int i = 0; i < arr.length; ++i) {
            for (long o : arr[i]) {
                p(o);
            }
            pl();
        }
    }

    static void pa(char[][] arr) {
        for (int i = 0; i < arr.length; ++i) {
            for (char o : arr[i]) {
                p(o);
            }
            pl();
        }
    }

    static void pa(double[][] arr) {
        for (int i = 0; i < arr.length; ++i) {
            for (double o : arr[i]) {
                p(o);
            }
            pl();
        }
    }

/////////////////////////////////////////////////////////////////////////////////
    static void print(Object s) {
        System.out.println(s);
    }

    /////////////////////////////////////////////////////////////////////////////////
    //-----------HritikScanner class for faster input----------//
    static class HritikScanner {

        BufferedReader br;
        StringTokenizer st;

        public HritikScanner() {
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

    //////////////////////////////////////////////////////////////////
    public static class Pair implements Comparable<Pair> {

        int num, row,col;

        Pair(int num, int row, int col) {
            this.num = num;
            this.row = row;
            this.col = col;
        }

        public int get1() {
            return num;
        }

        public int get2() {
            return row;
        }

        public int compareTo(Pair A) {
            return this.num - A.num;
        }
        
        public String toString()
        {
            return num +" "+ row+" "+col;
        }
    }

    //////////////////////////////////////////////////////////////////
    // Function to return gcd of a and b time complexity O(log(a+b))
    static long gcd(long a, long b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    // method to return LCM of two numbers 
    static long lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    //////////////////////////////////////////////////////////////////
    static boolean isPrime(long n) {
        // Corner cases 
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }

        // This is checked so that we can skip  
        // middle five numbers in below loop 
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        for (long i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
    //////////////////////////////////////////////////////////////////

    static boolean isPowerOfTwo(long n) {
        if (n == 0) {
            return false;
        }

        return (long) (Math.ceil((Math.log(n) / Math.log(2))))
                == (long) (Math.floor(((Math.log(n) / Math.log(2)))));
    }

    public static long getFact(int n) {
        long ans = 1;
        while (n > 0) {
            ans *= n;
            ans %= MOD;
            n--;
        }
        return ans;
    }

    public static long pow(long n, int pow) {
        if (pow == 0) {
            return 1;
        }
        long temp = pow(n, pow / 2) % MOD;
        temp *= temp;
        temp %= MOD;
        if (pow % 2 == 1) {
            temp *= n;
        }
        temp %= MOD;
        return temp;

    }

    public static long nCr(int n, int r) {
        long ans = 1;
        int temp = n - r;
        while (n > temp) {
            ans *= n;
            ans %= MOD;
            n--;
        }
        ans *= pow(getFact(r) % MOD, MOD - 2) % MOD;
        ans %= MOD;
        return ans;
    }

    //////////////////////////////////////////////////////////////////
    // method returns Nth power of A 
    static double nthRoot(int A, int N) {

        // intially guessing a random number between 
        // 0 and 9 
        double xPre = Math.random() % 10;

        // smaller eps, denotes more accuracy 
        double eps = 0.001;

        // initializing difference between two 
        // roots by INT_MAX 
        double delX = 2147483647;

        // xK denotes current value of x 
        double xK = 0.0;

        // loop untill we reach desired accuracy 
        while (delX > eps) {
            // calculating current value from previous 
            // value by newton's method 
            xK = ((N - 1.0) * xPre
                    + (double) A / Math.pow(xPre, N - 1)) / (double) N;
            delX = Math.abs(xK - xPre);
            xPre = xK;
        }

        return xK;
    }

}
