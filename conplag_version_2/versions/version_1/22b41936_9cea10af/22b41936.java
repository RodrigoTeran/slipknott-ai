


import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collections;
import java.io.InputStreamReader;
import static java.lang.Math.*;
import static java.lang.System.*;

public class Main1 {

     static ArrayList<Integer> list1 = new ArrayList<>() ;
     static ArrayList<Integer> list2 = new ArrayList<>() ;
     static int n , m ;
     static long dp[][] ;

     static long solver(int i , int j ){
         // i = empty chairs

         if (j == m)return 0 ;
         int tt1 = n-i ;
         int tt2 = m-j ;
         if (n-i < m-j)return  Long.MAX_VALUE/2  ;
         if ( dp[i][j] != -1 )return dp[i][j] ;

        long a = solver(i+1 , j) ;
        long b = abs( list1.get(i) - list2.get(j)) + solver(i+1 , j+1) ;

        return dp[i][j] = min(a , b) ;

     }



    public static void main(String[] args) throws IOException {

//        try {


            FastScanner in = new FastScanner();
            PrintWriter out = new PrintWriter(System.out);


            int N = in.nextInt() ;
            int a[] = in.readArray(N) ;
        for (int i = 0; i <N ; i++) {
            if (a[i] == 1)list2.add(i) ;
            else list1.add(i) ;
        }

         n = list1.size() ;
         m = list2.size() ;
            dp = new long[n][m] ;


            for(int i=0 ; i<n ; i++)
                for(int j=0 ; j<m ; j++)
                    dp[i][j] = -1 ;

     
        System.out.println(solver(0 , 0 ));








            out.flush();
            out.close();

//        }
//        catch (Exception e){
//            return;
//        }

    }

    static long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    static ArrayList<Integer> list = new ArrayList<>();
    static boolean A[] = new boolean[2 * 90000001];


    static void seive(int n) {
        int maxn = n;
        //int maxn = 1000000  ;
        A[0] = A[1] = true;

        for (int i = 2; i * i <= maxn; i++) {
            if (!A[i]) {
                for (int j = i * i; j <= maxn; j += i)
                    A[j] = true;
            }
        }

        for (int i = 2; i <= maxn; i++)
            if (!A[i])
                list.add(i);

    }

    static int findLCA(int a, int b, int par[][], int depth[]) {
        if (depth[a] > depth[b]) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }
        int diff = depth[b] - depth[a];
        for (int i = 19; i >= 0; i--) {
            if ((diff & (1 << i)) > 0) {
                b = par[b][i];
            }
        }
        if (a == b)
            return a;
        for (int i = 19; i >= 0; i--) {
            if (par[b][i] != par[a][i]) {
                b = par[b][i];
                a = par[a][i];
            }
        }
        return par[a][0];
    }

    static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    static void formArrayForBinaryLifting(int n, int par[][]) {
        for (int j = 1; j < 20; j++) {
            for (int i = 0; i < n; i++) {
                if (par[i][j - 1] == -1)
                    continue;
                par[i][j] = par[par[i][j - 1]][j - 1];
            }
        }
    }


    static void sort(int ar[]) {
        int n = ar.length;
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++)
            a.add(ar[i]);
        Collections.sort(a);
        for (int i = 0; i < n; i++)
            ar[i] = a.get(i);
    }

    static void sort1(long ar[]) {
        int n = ar.length;
        ArrayList<Long> a = new ArrayList<>();
        for (int i = 0; i < n; i++)
            a.add(ar[i]);
        Collections.sort(a);
        for (int i = 0; i < n; i++)
            ar[i] = a.get(i);
    }

    static long ncr(long n, long r, long mod) {
        if (r == 0)
            return 1;
        long val = ncr(n - 1, r - 1, mod);
        val = (n * val) % mod;
        val = (val * modInverse(r, mod)) % mod;
        return val;
    }

    static long fast_pow(long base, long n, long M) {
        if (n == 0)
            return 1;
        if (n == 1)
            return base % M;
        long halfn = fast_pow(base, n / 2, M);
        if (n % 2 == 0)
            return (halfn * halfn) % M;
        else
            return (((halfn * halfn) % M) * base) % M;
    }

    static long modInverse(long n, long M) {
        return fast_pow(n, M - 2, M);
    }


    private static int countDigits(long l) {
        if (l >= 1000000000000000000L) return 19;
        if (l >= 100000000000000000L) return 18;
        if (l >= 10000000000000000L) return 17;
        if (l >= 1000000000000000L) return 16;
        if (l >= 100000000000000L) return 15;
        if (l >= 10000000000000L) return 14;
        if (l >= 1000000000000L) return 13;
        if (l >= 100000000000L) return 12;
        if (l >= 10000000000L) return 11;
        if (l >= 1000000000L) return 10;
        if (l >= 100000000L) return 9;
        if (l >= 10000000L) return 8;
        if (l >= 1000000L) return 7;
        if (l >= 100000L) return 6;
        if (l >= 10000L) return 5;
        if (l >= 1000L) return 4;
        if (l >= 100L) return 3;
        if (l >= 10L) return 2;
        return 1;
    }


    static class FastOutput implements AutoCloseable, Closeable, Appendable {
        private static final int THRESHOLD = 32 << 10;
        private final Writer os;
        private StringBuilder cache = new StringBuilder(THRESHOLD * 2);

        public FastOutput append(CharSequence csq) {
            cache.append(csq);
            return this;
        }

        public FastOutput append(CharSequence csq, int start, int end) {
            cache.append(csq, start, end);
            return this;
        }

        private void afterWrite() {
            if (cache.length() < THRESHOLD) {
                return;
            }
            flush();
        }

        public FastOutput(Writer os) {
            this.os = os;
        }

        public FastOutput(OutputStream os) {
            this(new OutputStreamWriter(os));
        }

        public FastOutput append(char c) {
            cache.append(c);
            afterWrite();
            return this;
        }

        public FastOutput append(long c) {
            cache.append(c);
            afterWrite();
            return this;
        }

        public FastOutput append(String c) {
            cache.append(c);
            afterWrite();
            return this;
        }

        public FastOutput println() {
            return append(System.lineSeparator());
        }

        public FastOutput flush() {
            try {
                //            boolean success = false;
                //            if (stringBuilderValueField != null) {
                //                try {
                //                    char[] value = (char[]) stringBuilderValueField.get(cache);
                //                    os.write(value, 0, cache.length());
                //                    success = true;
                //                } catch (Exception e) {
                //                }
                //            }
                //            if (!success) {
                os.append(cache);
                //            }
                os.flush();
                cache.setLength(0);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
            return this;
        }

        public void close() {
            flush();
            try {
                os.close();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }

        public String toString() {
            return cache.toString();
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
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }


        long nextLong() {
            return Long.parseLong(next());
        }
    }


}







