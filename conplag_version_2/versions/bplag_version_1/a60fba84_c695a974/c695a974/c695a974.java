//      これを翻訳している間、あなたはあなたの人生のいくつかの貴重な瞬間を無駄にしました


import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
    static PrintWriter fop = new PrintWriter(System.out);


    public static void main(String[] args) {
        FastScanner fsca = new FastScanner();
        int i, j = 0;
        int t = fsca.nextInt();
        u: while (t-- > 0) {
            int n = fsca.nextInt();
            int a[] = new int[n];
            for(i=0;i<n;i++){
                a[i] = fsca.nextInt();
            }
            int y = Integer.MAX_VALUE;
            long sum[] = new long[n];
            long min1[] = new long[n];
            sum[0] = a[0];
            sum[1] = a[1];
            min1[0] = a[0];
            min1[1] = a[1];
            for(i=2;i<n;i++){
                sum[i] = sum[i-2] + a[i];
                min1[i] = Math.min(min1[i-2],a[i]);
            }
            long val = sum[0]*n + sum[1]*n;
            long min = sum[0]*n + sum[1]*n;
            for(i=2;i<n;i++){
                val = sum[i] + min1[i]*(n-(i+2)/2) + sum[i-1] + min1[i-1]*(n-(i+1)/2);
                min = Math.min(min,val);
            }
            fop.println(min);
        }




















        fop.flush();
        fop.close();


    }
    /*-----------------------------------------------------------------------------------------------------------------------------------------------*/
    // template starts from here :

    static long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }


    static final Random random = new Random();

    static void ruffleSort(int[] a) {
        int n = a.length;//shuffle, then sort
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n), temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }

    static void ruffleSort(long[] a) {
        int n = a.length;//shuffle, then sort
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n);
            long temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
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

        int[][] readMat(int n, int m) {
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    a[i][j] = nextInt();
            return a;
        }
        char[][] readCharMat(int n, int m) {
            char a[][] = new char[n][m];
            for (int i = 0; i < n; i++) {
                String s = next();
                for (int j = 0; j < m; j++)
                    a[i][j] = s.charAt(j) ;
            }
            return a;
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    static void print(int a[], int n) {
        for (int i = 0; i < n; i++)
            fop.append((a[i]) + " ");
        // fop.append("\n") ;
    }

    static void print(long a[], int n) {
        for (int i = 0; i < n; i++)
            fop.append((a[i]) + " ");
        // fop.append("\n") ;
    }
}
        