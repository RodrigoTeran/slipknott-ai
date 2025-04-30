import java.io.*;
import java.util.*;

public class ddd {
    //----------------------------START--------------------------------------//
    public static void main(String[] args)
            throws IOException {

        ADMIN_MODE();

        int t = sc.ni();while(t-->0)
            solve();


        w.close();
    }

    static boolean[] neg;

    static void solve() throws IOException {
        int n = sc.ni();
        neg = new boolean[n];
        pr[] arr = new pr[n];
        for(int i = 0; i < n; i++) {
            long curr = sc.nl();
            if(curr < 0) neg[i] = true;
            arr[i] = new pr(Math.abs(curr), i);
        }
        Arrays.sort(arr);
        long[] res = new long[n];
        for(int i = 0; i < n-1; i+=2) {
            long lcm = lcm(arr[i].val, arr[i+1].val);
            res[arr[i].idx] = lcm/arr[i].val * (neg[arr[i].idx] ? -1 :1) * -1;
            res[arr[i+1].idx] = lcm/arr[i+1].val * (neg[arr[i+1].idx] ? -1 :1);
        }

        if(n%2==1) {
            long aa = arr[n-3].val * (neg[arr[n-3].idx] ? -1 : 1);
            long bb = arr[n-2].val * (neg[arr[n-2].idx] ? -1 : 1);
            long cc = arr[n-1].val * (neg[arr[n-1].idx] ? -1 : 1);

            if (aa == -1*bb) {
                if(aa == cc) {
                    pr temp = arr[n-1];
                    arr[n-1] = arr[n-2];
                    arr[n-2] = temp;
                } else {
                    pr temp = arr[n-3];
                    arr[n-3] = arr[n-1];
                    arr[n-1] = temp;
                }
            }
        }

        if(n%2==1) {
            long a = arr[n-2].val * (neg[arr[n-2].idx] ? -1 :1) +
                    arr[n-3].val * (neg[arr[n-3].idx] ? -1 :1);
            boolean f = (a < 0);
            a = Math.abs(a);
            long b = arr[n-1].val;
            long lcm = lcm(a, b);
            if(f) {
                res[arr[n-2].idx] = lcm/a * -1;
                res[arr[n-3].idx] = lcm/a * -1;
            } else {
                res[arr[n - 2].idx] = lcm / a;
                res[arr[n - 3].idx] = lcm / a;
            }
            res[arr[n-1].idx] = lcm/b * (neg[arr[n-1].idx] ? -1 :1) * - 1;
        }

        for(int i = 0; i < n; i++) {
            w.pr(res[i]+" ");
        }
        w.pl();
    }

    static class pr implements Comparable<pr>{
        long val;int idx;

        public pr(long val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(pr o) {
            return Long.compare(val, o.val);
        }
    }

    //--------------------------INPUT READER--------------------------------//
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
        public void p(int i) {w.println(i);};
        public void p(long l) {w.println(l);};
        public void p(double d) {w.println(d);};
        public void p(String s) { w.println(s);};
        public void pr(int i) {w.print(i);};
        public void pr(long l) {w.print(l);};
        public void pr(double d) {w.print(d);};
        public void pr(String s) { w.print(s);};
        public void pl() {w.println();};
        public void close() {w.close();};
    }
    //------------------------------------------------------------------------//

    //--------------------------VARIABLES------------------------------------//
    static fs sc = new fs();
    static OutputStream outputStream = System.out;
    static Printer w = new Printer(outputStream);
    //-----------------------------------------------------------------------//

    //--------------------------ADMIN_MODE-----------------------------------//
    private static void ADMIN_MODE() throws IOException {
        if (System.getProperty("ONLINE_JUDGE") == null) {
            w = new Printer(new FileOutputStream("output.txt"));
            sc = new fs(new FileInputStream("input.txt"));
        }
    }
    //-------------------------------UTILS------------------------------------//
    static long gcd(long a, long b) {
        return b == 0 ? (a < 0L ? -a: a) : gcd(b, a%b);
    }

    static long lcm(long a, long b) {
        return a/gcd(a, b)*b;
    }

    // region pow(a, b, mod) -> a^b
    static long mp (long b , long x, long mod) {
        if (x == 0) return 1;
        if (x == 1) return b;
        if (x % 2 == 0) return mp (b * b % mod, x / 2, mod) % mod;

        return b * mp (b * b % mod, x / 2, mod) % mod;
    }
    // endregion
}