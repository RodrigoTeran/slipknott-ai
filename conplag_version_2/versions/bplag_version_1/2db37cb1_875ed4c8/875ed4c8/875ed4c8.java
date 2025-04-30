/*
        "Everything in the universe is balanced. Every disappointment
                you face in life will be balanced by something good for you!
                        Keep going, never give up."

                        Just have Patience + 1...

*/



import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {

    static int MAX = 100005;
    static Map<Integer, List<int[]>> graph = new HashMap<>();
    static int[] value = new int[MAX];

    public static void main(String[] args) throws java.lang.Exception {
        out = new PrintWriter(new BufferedOutputStream(System.out));
        sc = new FastReader();

        int test = sc.nextInt();
        for (int t = 0; t < test; t++) {
            solve();
        }
        out.close();
    }

    private static void solve() {
        int n = sc.nextInt();
        graph.clear();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(new int[]{v, i});
            graph.get(v).add(new int[]{u, i});
        }

        int node = 0;
        for (int i = 1; i <= n; i++) {
            int childrens = graph.get(i).size();
            if (childrens > 2) {
                out.println(-1);
                return;
            }
            
            if (childrens == 1) {
                node = i;
            }
        }

        dfs(node, 0, 2);

        for (int i = 0; i < n - 1; i++) {
            out.print(value[i] + " ");
        }
        out.println();
    }

    private static void dfs(int currNode, int parent, int prime) {
        int addPrime = prime == 2 ? 3 : 2;
        for (int[] adjacentNode : graph.get(currNode)) {
            if (adjacentNode[0] == parent) {
                continue;
            }
            value[adjacentNode[1]] = prime;
            dfs(adjacentNode[0], currNode, addPrime);
        }
    }


    public static FastReader sc;
    public static PrintWriter out;
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer str;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (str == null || !str.hasMoreElements())
            {
                try
                {
                    str = new StringTokenizer(br.readLine());
                }
                catch (IOException  end)
                {
                    end.printStackTrace();
                }
            }
            return str.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException end)
            {
                end.printStackTrace();
            }
            return str;
        }
    }
}
