import java.util.*;
import java.io.*;

public class _724 {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            TreeSet<Long> set = new TreeSet<>();
            long prev = -1;
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                long x = sc.nextInt();
                if (i == 0) {
                    set.add(x);
                    prev = x;
                    continue;
                }
                if (x > prev) {
                    Long high = set.higher(prev);
                    if (high == null) set.add(x);
                    else if (high >= x) set.add(x);
                    else {
                        ok = false;
                    }
                } else if (x < prev) {
                    Long low = set.lower(prev);
                    if (low == null) set.add(x);
                    else if (low <= x) set.add(x);
                    else {
                        ok = false;
                    }
                }
                prev = x;
            }
            out.println(ok ? "YES" : "NO");
        }
        out.close();
    }





    static void sort(int[] a) {
        ArrayList<Integer> q = new ArrayList<>();
        for (int i : a) q.add(i);
        Collections.sort(q);
        for (int i = 0; i < a.length; i++) a[i] = q.get(i);
    }

    static void sort(long[] a) {
        ArrayList<Long> q = new ArrayList<>();
        for (long i : a) q.add(i);
        Collections.sort(q);
        for (int i = 0; i < a.length; i++) a[i] = q.get(i);
    }


    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
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

}