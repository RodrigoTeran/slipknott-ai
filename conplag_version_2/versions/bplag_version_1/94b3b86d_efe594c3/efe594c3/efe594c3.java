import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class problemD {
    static ArrayList<Integer>[] adj;
    static boolean found = false;
    static int[] D = new int[212345];
    private static void solve() throws Exception {
        int n = fs.nextInt();
        int a = fs.nextInt();
        int b = fs.nextInt();
        int da = fs.nextInt();
        int db = fs.nextInt();
        adj = new ArrayList[n+1];
        for (int i = 0 ; i <= n ; i ++ ) adj[i] = new ArrayList<Integer>();
        for (int i = 0 ; i < n-1; i ++ ) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }


        found = false;
        dfs(a, 0, 0, da, b);
        if (found) {
            out.println("Alice");
            return;
        }

        dfs(b,0,0);
        int maxD = -1;
        int node = -1;
        for (int i = 1; i <= n; i ++ ) {
            if (D[i] > maxD) {
                maxD = D[i];
                node = i;
            }
        }

        dfs(node, 0, 0);
        maxD = -1;
        for (int i = 1; i <= n; i ++ ) {
            if (D[i] > maxD) {
                maxD = D[i];
            }
        }


        boolean bob = db > da * 2 && maxD > da * 2;
        out.println(bob ? "Bob" : "Alice");
    }

    private static void dfs(int node, int parent, int dist) {
        D[node] = dist;
        for (int x: adj[node]) {
            if (x != parent) {
                dfs(x, node, dist+1);
            }
        }
    }

    private  static void dfs(int node, int parent, int dist, int da, int b) {

        if (node == b) { found = true; return; }
        for (int x: adj[node]) {
            if (x != parent) {
                if (dist+1 <= da) {
                    dfs(x, node, dist + 1, da, b);
                }
            }
        }
    }

    private static FastScanner fs = new FastScanner();
    private static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        int T = 1;
        T = fs.nextInt();
        for (int t = 0; t < T; t++) {
            solve();
        }
        out.close();
    }

    static void debug(Object... O) {
        System.err.print("DEBUG ");
        System.err.println(Arrays.deepToString(O));
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

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextString() {
            return next();
        }
    }
}
