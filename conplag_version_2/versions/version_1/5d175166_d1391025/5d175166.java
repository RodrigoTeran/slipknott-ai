import java.io.*;
import java.util.*;

public class A {
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

    static int[] res;
    static List<List<Integer>> graph;
    static boolean two = true;
    static HashMap<pr<Integer, Integer>, Integer> hm;

    static void solve() throws IOException {
        int n = sc.ni();
        graph = new ArrayList<>();
        res = new int[n-1];
        hm = new HashMap<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        boolean f = false;
        for(int i = 0; i < n-1; i++) {
            int a = sc.ni(), b = sc.ni();
            graph.get(a).add(b);
            graph.get(b).add(a);
            if(graph.get(a).size() > 2 || graph.get(b).size() > 2) f = true;
            hm.put(new pr<>(a, b), i);
            hm.put(new pr<>(b, a), i);
        }

        if(f) {
            w.p(-1);
            return;
        }

        int one = 0;
        for(int i = 0; i < n; i++) {
            if(graph.get(i).size() == 1) {
                one = i;
                break;
            }
        }
        dfs(one, -1);
        for(int i: res) {
            w.pr(i+" ");
        }
        w.pl();
    }

    static void dfs(int at, int pt) {
        List<Integer> li = graph.get(at);
        if(pt != -1) {
            res[hm.get(new pr<>(at, pt))] = two?2:3;
            two = !two;
        }
        for(int to: li) {
            if(to == pt) continue;
            dfs(to, at);
        }
    }

    static class pr <T, V> {
            T a; V b;

            public pr(T a, V b) {
                this.a = a;
                this.b = b;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof pr)) return false;
                pr<?, ?> pr = (pr<?, ?>) o;
                return a.equals(pr.a) && b.equals(pr.b);
            }

            @Override
            public int hashCode() {
                return Objects.hash(a, b);
            }
        }

}