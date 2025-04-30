import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.BitSet;
import java.util.function.BinaryOperator;

public class D {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
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

    static FastReader s = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    private static int[] rai(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        return arr;
    }

    private static int[][] rai(int n, int m) {
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.nextInt();
            }
        }
        return arr;
    }

    private static long[] ral(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextLong();
        }
        return arr;
    }

    private static long[][] ral(int n, int m) {
        long[][] arr = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.nextLong();
            }
        }
        return arr;
    }

    private static int ri() {
        return s.nextInt();
    }

    private static long rl() {
        return s.nextLong();
    }

    private static String rs() {
        return s.next();
    }


    static long gcd(long a,long b)
    {
        if(b==0)
        {
            return a;
        }
        return gcd(b,a%b);
    }

    static int MOD=(int)1e9+7;

    public static int primeFactors(long n)
    {
        // Print the number of 2s that divide n
        int count=0;
        while (n % 2 == 0) {
            count++;
            n /= 2;
        }

        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for (long i = 3; i * i<=n; i += 2) {
            // While i divides n, print i and divide n
            while (n % i == 0) {
                count++;
                n /= i;
            }
        }

        // This condition is to handle the case whien
        // n is a prime number greater than 2
        if (n > 2)
            count++;

        return count;
    }

    static class Node
    {
        int val, i;

        public Node(int val, int i) {
            this.val = val;
            this.i = i;
        }
    }
    public static void main(String[] args) {
        StringBuilder ans = new StringBuilder();
        int t = ri();
//        int t=1;
        while(t-- >0)
        {
            int n=ri();
            int[] arr=rai(n);
            int[] res = new int[n];
            if(n%2==0)
            {

                for(int i=0;i<n;i+=2)
                {
                    res[i] = -arr[i+1];
                    res[i+1]=arr[i];
                }


            }
            else {
                for(int i=0;i<n-3;i+=2)
                {
                    res[i] = -arr[i+1];
                    res[i+1]=arr[i];
                }

                int val = arr[n-1]+arr[n-2];
                if(val!=0) {
                    res[n - 3] = -val;
                    res[n - 2] = arr[n - 3];
                    res[n - 1] = arr[n - 3];
                }
                else
                {
                    val = arr[n-1]+arr[n-3];
                    if(val!=0) {
                        res[n - 2] = -val;
                        res[n - 1] = arr[n - 2];
                        res[n - 3] = arr[n - 2];
                    }
                    else
                    {
                        val = arr[n-2]+arr[n-3];
                        res[n-1] = -val;
                        res[n-2]=arr[n-1];
                        res[n-3]=arr[n-1];
                    }
                }

            }

            for(int i:res)
            {
                ans.append(i).append(" ");
            }
            ans.append("\n");

//            int sum=0;
//            for(int i=0;i<n;i++)
//            {
//                sum+=arr[i]*res[i];
//            }
//            System.out.println(sum);

        }
        out.print(ans.toString());
        out.flush();
    }
}