import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class C_Phoenix_and_Towers {
    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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

    public static class Pair implements Comparable<Pair> {
        int id, h;

        public Pair(int id, int h) {
            this.id = id;
            this.h = h;
        }

        public int compareTo(Pair o) {
            return this.h - o.h;
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        FastReader sc = new FastReader();
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int x = sc.nextInt();
            int tow[] = new int[n];
            int ans[] = new int[n];
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                tow[i] = sc.nextInt();
            }
            for (int i = 0; i < m; i++) {
                ans[i] = i + 1;
                pq.add(new Pair(i + 1, tow[i]));
            }
            for (int i = m; i < n; i++) {
                Pair p = pq.poll();
                p.h = p.h + tow[i];
                ans[i] = p.id;
                pq.add(p);
            }
            System.out.println("YES");
            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}