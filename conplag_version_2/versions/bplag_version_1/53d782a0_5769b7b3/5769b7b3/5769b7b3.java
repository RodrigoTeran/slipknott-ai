import java.io.*;
import java.util.*;

public class B {
    //--------------------------INPUT READER---------------------------------//
    static class fs {
        public BufferedReader br;
        StringTokenizer st = new StringTokenizer("");

        public fs() { this(System.in); }
        public fs(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }
        String next() {
            while (!st.hasMoreTokens()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }

        int ni() { return Integer.parseInt(next()); }
        long nl() { return Long.parseLong(next()); }
        double nd() { return Double.parseDouble(next()); }
        String ns() { return next(); }

        int[] na(long nn) {
            int n = (int) nn;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = ni();
            return a;
        }

        long[] nal(long nn) {
            int n = (int) nn;
            long[] l = new long[n];
            for(int i = 0; i < n; i++) l[i] = nl();
            return l;
        }
    }
    //-----------------------------------------------------------------------//

    //---------------------------PRINTER-------------------------------------//
    static class Printer {
        static PrintWriter w;
        public Printer() {this(System.out);}
        public Printer(OutputStream os) {
            w = new PrintWriter(os);
        }
        public void p(int i) {w.println(i);}
        public void p(long l) {w.println(l);}
        public void p(double d) {w.println(d);}
        public void p(String s) { w.println(s);}
        public void pr(int i) {w.print(i);}
        public void pr(long l) {w.print(l);}
        public void pr(double d) {w.print(d);}
        public void pr(String s) { w.print(s);}
        public void pl() {w.println();}
        public void close() {w.close();}
    }
    //-----------------------------------------------------------------------//

    //--------------------------VARIABLES------------------------------------//
    static fs sc = new fs();
    static OutputStream outputStream = System.out;
    static Printer w = new Printer(outputStream);
    static long lma = Long.MAX_VALUE, lmi = Long.MIN_VALUE;
    static int ima = Integer.MAX_VALUE, imi = Integer.MIN_VALUE;
    static long mod = 1000000007;
    //-----------------------------------------------------------------------//

    //--------------------------ADMIN_MODE-----------------------------------//
    private static void ADMIN_MODE() throws IOException {
        if (System.getProperty("ONLINE_JUDGE") == null) {
            w = new Printer(new FileOutputStream("output.txt"));
            sc = new fs(new FileInputStream("input.txt"));
        }
    }
    //-----------------------------------------------------------------------//

    //----------------------------START--------------------------------------//
    public static void main(String[] args)
            throws IOException {

        ADMIN_MODE();

        int t = sc.ni();while(t-->0)
            solve();


        w.close();
    }

    static void solve() throws IOException {
        int n = sc.ni();
        long k = sc.nl();
        Long[] arr = new Long[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nl();
        Arrays.sort(arr);
        long sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if(sum <= k) {
            w.p(0);
            return;
        }


        long cont = 0;
        long min = sum-k;
        for(int i = n-1; i >= 0; i--) {
            cont += arr[i];
            long psum = sum-cont;


            if(psum <= k) {
                long extra = k-psum;
                if(arr[0]*(n-i)<=extra) {
                    min = Math.min(min, n-i);
                    continue;
                }

                if(i == 0) {
                    long q = k/n;
                    long ans = arr[0]-q+n-1;
                    min = Math.min(min, ans);
                    continue;
                }
                extra += arr[0];
                long q = extra/(n-i+1);
                long ans = arr[0]-q+n-i;
                min = Math.min(min, ans);

            } else {
                long toRem = psum-k-arr[0];
                long q = (long)Math.ceil(toRem/(n-i+1.0));
                long ans = q+arr[0]+n-i;
                min = Math.min(min, ans);
            }
        }

        w.p(min);
    }

}