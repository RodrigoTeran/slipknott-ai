 //package eround101;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.StringTokenizer;

public class Solution {

    static HritikScanner sc = new HritikScanner();
    static PrintWriter pw = new PrintWriter(System.out, true);
    final static int MOD = 1000000007;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        int t = ni();
        while (t-- > 0) {
            solve();
        }
    }

    static void solve() {
        int n = ni();
        int[] arr = nextIntArray(n);
        char[] col = sc.next().toCharArray();
        int[] cB = new int[n+1];
        int[] cR = new int[n+1];
        for(int i = 0; i < n; i++)
        {
//            pl((col[i] == 'R' && arr[i] > n));
//            pl((col[i] == 'B' && arr[i] < 1));
            if((col[i] == 'R' && arr[i] > n)||(col[i] == 'B' && arr[i] < 1))
            {
                pl("NO");
                return;
            }
            if(col[i] == 'B')
            {
                if(arr[i] > n)
                    continue;
                cB[arr[i]]++;
                if(cB[arr[i]] > arr[i])
                {
                    pl("NO");
                    return;
                }
            }
            else
            {
                if(arr[i] < 1)
                    continue;
                cR[arr[i]]++;
                if(cR[arr[i]] > (n-(arr[i]-1)))
                {
                    pl("NO");
                    return;
                }
            }
//            pa(cB);
//            pa(cR);
        }
//        pa(cB);
//        pa(cR);
        int[] psum = new int[n+1];
        for(int i = 1; i<= n; i++)
        {
            psum[i] = psum[i-1]+cB[i];
            if(psum[i] > i)
            {
                pl("NO");
                return;
            }
        }
//        pa(psum);
        int[] psum1 = new int[n+1];
        psum1[n] = cR[n];
        for(int i = n-1; i>= 0; i--)
        {
            psum1[i] = psum1[i+1]+cR[i];
            if(psum1[i] > (n-(i-1)))
            {
                pl("NO");
                return;
            }
        }
//        pa(psum1);
        
        pl("YES");
        
    }
        /////////////////////////////////////////////////////////////////////////////////
    static class FenwickTree { // Binary Index Tree
        int[] tree;
        static int size;

        public FenwickTree(int size) {
            this.size = size;
            tree = new int[size + 5];
        }

        public void add(int i, int val) {
            while (i <= size) {
                tree[i] += val;
                i += i & -i;  // adding the decimal value of the last set bit.
            }
        }

        public int sum(int i) {
            int res = 0;
            while (i >= 1) {
                res += tree[i];
                i -= i & -i; // deleting the last set bit
            }
            return res;
        }

        public int sum(int l, int r) {
            return sum(r) - sum(l - 1);
        }
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
        pw.print(o + " ");
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

        int num, row, col;

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

        public String toString() {
            return num + " " + row + " " + col;
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
    static long lcm(long a, long b) {
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
