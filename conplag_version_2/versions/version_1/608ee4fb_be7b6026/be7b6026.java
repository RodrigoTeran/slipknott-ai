import java.io.*;
import java.util.*;

public class C {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int T = in.nextInt();
        for(int ttt = 1; ttt <= T; ttt++) {
            int n = in.nextInt();
            int[][] edges = new int[n-1][2];
            Map<Integer, List<int[]>> map = new HashMap<>();
            int max = 0;
            for(int i = 0; i < n-1; i++) {
                edges[i][0] = in.nextInt();
                edges[i][1] = in.nextInt();

                if(!map.containsKey(edges[i][0])) map.put(edges[i][0], new ArrayList<>());
                if(!map.containsKey(edges[i][1])) map.put(edges[i][1], new ArrayList<>());
                map.get(edges[i][0]).add(new int[]{edges[i][1], 0});
                map.get(edges[i][1]).add(new int[]{edges[i][0], 0});

                max = Math.max(max, Math.max(map.get(edges[i][0]).size(), map.get(edges[i][1]).size()));
            }

            if(max > 2) out.println(-1);
            else {
                int start = 1;
                for(int key : map.keySet()) {
                    if(map.get(key).size()==1) {
                        start = key;
                    }
                }

                dfs(start, 0, map, 2);

                for(int[] e : edges) {
                    for(int[] u : map.get(e[0])) {
                        if(u[0]==e[1]) {
                            out.print(u[1] + " ");
                        }
                    }
                }
                out.println();
            }
        }

        out.close();
    }

    static void dfs(int v, int p, Map<Integer, List<int[]>> map, int val) {
        for(int[] u : map.get(v)) {
            if(u[0]!=p) {
                dfs(u[0], v, map, (val==2 ? 3: 2));
            }
        }
        for(int[] e : map.get(v)) {
            if(e[0]==p) {
                e[1] = val;
            }
        }
        if(map.containsKey(p)) {
            for(int[] e : map.get(p)) {
                if(e[0]==v) {
                    e[1] = val;
                }
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch(IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            String str = "";
            try { str = br.readLine(); }
            catch(IOException e) { e.printStackTrace(); }
            return str;
        }
        int[] readInt(int size) {
            int[] arr = new int[size];
            for(int i = 0; i < size; i++)
                arr[i] = Integer.parseInt(next());
            return arr;
        }
        long[] readLong(int size) {
            long[] arr = new long[size];
            for(int i = 0; i < size; i++)
                arr[i] = Long.parseLong(next());
            return arr;
        }
        int[][] read2dArray(int rows, int cols) {
            int[][] arr = new int[rows][cols];
            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < cols; j++)
                    arr[i][j] = Integer.parseInt(next());
            }
            return arr;
        }
    }
}