/*
        "Everything in the universe is balanced. Every disappointment
                you face in life will be balanced by something good for you!
                        Keep going, never give up."

*/



import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
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
        int[] permutation = new int[n];
        Arrays.fill(permutation, -1);

        // there may be multiple cycles in the given permutation
        for (int i = 0; i < n; i++) {
            if (permutation[i] == -1) { // ith permutation value is not found yet
                // so we find all values of permutation having i in their cycle
                // for that we always ask(i) so that we can get all values in that cycle
                List<Integer> cycle = new ArrayList<>();

                int startCycleValue = ask(i + 1);
                int currValueAt = ask(i + 1);

                cycle.add(currValueAt);
                while (currValueAt != startCycleValue) {
                    currValueAt = ask(i + 1);
                    cycle.add(currValueAt);
                }

                int m = cycle.size();
                for (int j = 0; j < m; j++) {
                    permutation[cycle.get(j)] = cycle.get((j + 1) % m);
                }
            }
        }

        out.println("! ");
        for (int i = 0; i < n; i++) {
            out.print((permutation[i] + 1) + " ");
        }
        out.println();
        out.flush();
    }

    private static int ask(int i) {
        out.println("? " + i + " ");
        out.flush();
        int value = sc.nextInt();
        return value - 1;
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