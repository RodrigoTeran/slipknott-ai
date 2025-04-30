//package codeforces.round766div2;

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class C {
    static InputReader in;
    static PrintWriter out;

    public static void main(String[] args) {
        //initReaderPrinter(true);
        initReaderPrinter(false);
        solve(in.nextInt());
        //solve(1);        
    }

    /*
        General tips
        1. It is ok to fail, but it is not ok to fail for the same mistakes over and over!
        2. Train smarter, not harder!
        3. If you find an answer and want to return immediately, don't forget to flush before return!
    */
    /*
        Read before practice
        1. Set a timer based on a problem's difficulty level: 45 minutes at your current target practice level;
        2. During a problem solving session, focus! Do not switch problems or even worse switch to do something else;
        3. If fail to solve within timer limit, read editorials to get as little help as possible to get yourself unblocked;
        4. If after reading the entire editorial and other people's code but still can not solve, move this problem to to-do list
           and re-try in the future.
        5. Keep a practice log about new thinking approaches, good tricks, bugs; Review regularly;
    */
    /*
        Read before contests and lockout 1 v 1
        Mistakes you've made in the past contests:
        1. Tried to solve without going through given test examples -> wasting time on solving a different problem than asked;
        2. Rushed to coding without getting a comprehensive sketch of your solution -> implementation bugs and WA;
        3. Forgot about possible integer overflow;

        When stuck:
        1. Understand problem statements? Walked through test examples?
        2. Take a step back and think about other approaches?
        3. Check rank board to see if you can skip to work on a possibly easier problem?
        4. If none of the above works, take a guess?
    */
    static int n;
    static List<int[]>[] adj;
    static int[] ans;
    static void solve(int testCnt) {
        for (int testNumber = 0; testNumber < testCnt; testNumber++) {
            n = in.nextInt();
            adj = new List[n + 1];
            for(int i = 0; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }
            ans = new int[n - 1];
            for(int i = 0; i < n - 1; i++) {
                int u = in.nextInt(), v = in.nextInt();
                adj[u].add(new int[]{v, i});
                adj[v].add(new int[]{u, i});
            }
            if(adj[1].size() > 2) out.println(-1);
            else {
                boolean can = false;
                if(adj[1].size() == 1) {
                    ans[adj[1].get(0)[1]] = 2;
                    if(dfs(adj[1].get(0)[0], 1, 2)) {
                        can = true;
                    }
                }
                else {
                    ans[adj[1].get(0)[1]] = 2;
                    ans[adj[1].get(1)[1]] = 3;
                    if(dfs(adj[1].get(0)[0] ,1, 2) && dfs(adj[1].get(1)[0], 1, 3)) {
                        can = true;
                    }
                }
                if(can) {
                    for(int v : ans) out.print(v + " ");
                    out.println();
                }
                else out.println(-1);
            }
        }
        out.close();
    }

    static boolean dfs(int curr, int par, int prev) {
        if(adj[curr].size() - 1 > 1) return false;
        for(int[] next : adj[curr]) {
            if(next[0] == par) continue;
            ans[next[1]] = prev == 2 ? 3 : 2;
            if(!dfs(next[0], curr, prev == 2 ? 3 : 2)) {
                return false;
            }
        }
        return true;
    }

    static void initReaderPrinter(boolean test) {
        if (test) {
            try {
                in = new InputReader(new FileInputStream("src/input.in"));
                out = new PrintWriter(new FileOutputStream("src/output.out"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            in = new InputReader(System.in);
            out = new PrintWriter(System.out);
        }
    }

    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        InputReader(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream), 32768);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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

        Integer[] nextIntArray(int n) {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        int[] nextIntArrayPrimitive(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        int[] nextIntArrayPrimitiveOneIndexed(int n) {
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) a[i] = nextInt();
            return a;
        }

        Long[] nextLongArray(int n) {
            Long[] a = new Long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }

        long[] nextLongArrayPrimitive(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }

        long[] nextLongArrayPrimitiveOneIndexed(int n) {
            long[] a = new long[n + 1];
            for (int i = 1; i <= n; i++) a[i] = nextLong();
            return a;
        }

        String[] nextStringArray(int n) {
            String[] g = new String[n];
            for (int i = 0; i < n; i++) g[i] = next();
            return g;
        }

        List<Integer>[] readGraphOneIndexed(int n, int m) {
            List<Integer>[] adj = new List[n + 1];
            for (int i = 0; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                int u = nextInt();
                int v = nextInt();
                adj[u].add(v);
                adj[v].add(u);
            }
            return adj;
        }

        List<Integer>[] readGraphZeroIndexed(int n, int m) {
            List<Integer>[] adj = new List[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                int u = nextInt() - 1;
                int v = nextInt() - 1;
                adj[u].add(v);
                adj[v].add(u);
            }
            return adj;
        }

        /*
            A more efficient way of building an undirected graph using int[] instead of ArrayList to store each node's neighboring nodes.
            1-indexed.
         */
        int[][] buildUndirectedGraph(int nodeCnt, int edgeCnt) {
            int[] end1 = new int[edgeCnt], end2 = new int[edgeCnt];
            int[] edgeCntForEachNode = new int[nodeCnt + 1], idxForEachNode = new int[nodeCnt + 1];
            for (int i = 0; i < edgeCnt; i++) {
                int u = in.nextInt(), v = in.nextInt();
                edgeCntForEachNode[u]++;
                edgeCntForEachNode[v]++;
                end1[i] = u;
                end2[i] = v;
            }
            int[][] adj = new int[nodeCnt + 1][];
            for (int i = 1; i <= nodeCnt; i++) {
                adj[i] = new int[edgeCntForEachNode[i]];
            }
            for (int i = 0; i < edgeCnt; i++) {
                adj[end1[i]][idxForEachNode[end1[i]]] = end2[i];
                idxForEachNode[end1[i]]++;
                adj[end2[i]][idxForEachNode[end2[i]]] = end1[i];
                idxForEachNode[end2[i]]++;
            }
            return adj;
        }

        /*
            A more efficient way of building a directed graph using int[] instead of ArrayList to store each node's neighboring nodes.
            1-indexed.
         */
        int[][] buildDirectedGraph(int nodeCnt, int edgeCnt) {
            int[] from = new int[edgeCnt], to = new int[edgeCnt];
            int[] edgeCntForEachNode = new int[nodeCnt + 1], idxForEachNode = new int[nodeCnt + 1];
            //from u to v: u -> v
            for (int i = 0; i < edgeCnt; i++) {
                int u = in.nextInt(), v = in.nextInt();
                edgeCntForEachNode[u]++;
                from[i] = u;
                to[i] = v;
            }
            int[][] adj = new int[nodeCnt + 1][];
            for (int i = 1; i <= nodeCnt; i++) {
                adj[i] = new int[edgeCntForEachNode[i]];
            }
            for (int i = 0; i < edgeCnt; i++) {
                adj[from[i]][idxForEachNode[from[i]]] = to[i];
                idxForEachNode[from[i]]++;
            }
            return adj;
        }
    }
}