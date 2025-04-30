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
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] res = new int[n];
        if (n % 2 == 0) {
            for (int i = 1; i < n; i += 2) {
                res[i] = arr[i - 1];
                res[i - 1] = -arr[i];
            }
        }else {
            for (int i = 4; i < n; i += 2) {
                res[i] = arr[i - 1];
                res[i - 1] = -arr[i];
            }

            if (arr[0] + arr[1] != 0) {
                res[0] = -arr[2];
                res[1] = -arr[2];
                res[2] = arr[0] + arr[1];
            }else if (arr[0] + arr[2] != 0) {
                res[0] = -arr[1];
                res[2] = -arr[1];
                res[1] = arr[0] + arr[2];
            }else {
                res[1] = -arr[0];
                res[2] = -arr[0];
                res[0] = arr[1] + arr[2];
            }
        }

        for (int i = 0; i < n; i++) {
            out.print(res[i] + " ");
        }
        out.println();
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