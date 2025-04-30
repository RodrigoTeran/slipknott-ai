import java.io.*;
import java.util.*;
import java.lang.*;

public class codeforces {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        if (System.getProperty("ONLINE_JUDGE") == null) {
            long startTime = System.currentTimeMillis();
            try {
                sc = new InputReader(new FileInputStream("input.txt"));
                out = new PrintWriter(new FileOutputStream("output.txt"));
                pr = new PrintWriter(new FileOutputStream("error.txt"));
            } catch (Exception ignored) {
            }
            int t = 1;
            int tt = t;
            t = sc.nextInt();
            while (t-- > 0) {
                solve();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Time: " + (endTime - startTime) / tt + " ms");
            out.flush();
            pr.flush();

        } else {
            sc = new InputReader(inputStream);
            out = new PrintWriter(outputStream);
            pr = new PrintWriter(outputStream);
            int t = 1;
            t = sc.nextInt();
            while (t-- > 0) {
                solve();
            }
            out.flush();
        }
    }

    public static void solve() {
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            dp[i] = inf;    
            ans[i] = inf;
        }
        m = sc.nextInt();
        for (int i = 0; i < m; i++)
            arr[i] = sc.nextInt() - 1;
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
            dp[(int)arr[i]] = arr2[i];
        }
        temp = inf;
        for (int i = 0; i < n; i++) {
            temp = Math.min(temp, dp[i]);
            ans[i] = Math.min(ans[i], temp);
            temp++;
        }
        temp = inf;
        for (int i = (int)n - 1; i > -1; i--) {
            temp = Math.min(temp, dp[i]);
            ans[i] = Math.min(ans[i], temp);
            temp++;
        }
        for (int i = 0; i < n; i++)
            out.print(ans[i] + " ");
        out.println("");
    }
    /*
     * Set Iterator Iterator value = set.iterator(); Displaying the values after
     * iterating through the iterator
     * System.out.println("The iterator values are: "); while (value.hasNext()) {
     * System.out.println(value.next()); }
     */

    /*
     * Map Iterator: for (Map.Entry<Integer, Integer> entry : map.entrySet()){
     * System.out.println("Key => " + entry.getKey() + ", Value => " +
     * entry.getValue());}
     */
    // Globals

    public static long n, m, temp;
    public static int template_array_size = (int) 1e6 + 16813;
    public static long[] arr = new long[template_array_size];
    public static long[] arr2 = new long[template_array_size];
    public static long[] dp = new long[template_array_size];
    public static long[] ans = new long[template_array_size];
    public static int inf = Integer.MAX_VALUE;
    public static int minf = Integer.MIN_VALUE;
    public static int mod = 1000000007;
    public static int ml = (int) 1e9;
    public static String s = "";
    public static InputReader sc;
    public static PrintWriter out;
    public static PrintWriter pr;

    // Pair

    static class Pair {
        int first, second;

        Pair(int x, int y) {
            this.first = x;
            this.second = y;
        }
    }

    // FastReader Class

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    // Req Functions
    public static void fill(int[][] dp, int x) {
        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < dp[0].length; ++j) {
                dp[i][j] = x;
            }
        }
    }

    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    public static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    public static long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    public static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    public static long nCr(int n, int k) {
        long ans = 1L;
        k = k > n - k ? n - k : k;
        int j = 1;
        for (; j <= k; j++, n--) {
            if (n % j == 0) {
                ans *= n / j;
            } else if (ans % j == 0) {
                ans = ans / j * n;
            } else {
                ans = (ans * n) / j;
            }
        }
        return ans;
    }

    public static String reverseString(String input) {
        StringBuilder str = new StringBuilder("");

        for (int i = input.length() - 1; i >= 0; i--) {
            str.append(input.charAt(i));
        }
        return str.toString();
    }

    public static int maxOf3(int x, int y, int z) {
        return Math.max(x, Math.max(y, z));
    }

    public static int minof3(int x, int y, int z) {
        return Math.min(x, Math.min(y, z));
    }

    public static long maxOf3(long x, long y, long z) {
        return Math.max(x, Math.max(y, z));
    }

    public static long minof3(long x, long y, long z) {
        return Math.min(x, Math.min(y, z));
    }

    public static void arrInput(int[] arr, int n) {
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
    }

    public static void arrInput(long[] arr, int n) {
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextLong();
    }

    public static void arrInput(Pair[] pair, int n) {
        for (int i = 0; i < n; i++)
            pair[i] = new Pair(sc.nextInt(), sc.nextInt());
    }

    public static int maxarrInput(int[] arr, int n) {
        int max = minf;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }
        return max;

    }

    public static long maxarrInput(long[] arr, int n) {
        long max = minf;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public static int minarrInput(int[] arr, int n) {
        int min = inf;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            min = Math.max(min, arr[i]);
        }
        return min;
    }

    public static long minarrInput(long[] arr, int n) {
        long min = inf;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
            min = Math.max(min, arr[i]);
        }
        return min;
    }

    public static int lowerBound(int[] arr, int x) {
        int l = -1, r = arr.length;
        while (l + 1 < r) {
            int m = (l + r) >>> 1;
            if (arr[m] >= x)
                r = m;
            else
                l = m;
        }
        return r;
    }

    public static int upperBound(int[] arr, int x) {
        int l = -1, r = arr.length;
        while (l + 1 < r) {
            int m = (l + r) >>> 1;
            if (arr[m] <= x)
                l = m;
            else
                r = m;
        }
        return l + 1;
    }

    public static void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] >= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void reversesort(int arr[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            reversesort(arr, l, m);
            reversesort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void merge(long arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        long L[] = new long[n1];
        long R[] = new long[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] >= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void reversesort(long arr[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            reversesort(arr, l, m);
            reversesort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    // debug

    public static boolean sysFlag = System.getProperty("ONLINE_JUDGE") == null;

    public static void debug(int[][] dp) {
        if (sysFlag) {
            for (int i = 0; i < dp.length; ++i) {
                pr.print(i + "--> ");
                for (int j = 0; j < dp[0].length; ++j) {
                    pr.print(dp[i][j] + " ");
                }
                pr.println("");
            }
        }
    }

    public static void debug(long[][] dp) {
        if (sysFlag) {
            for (int i = 0; i < dp.length; ++i) {
                pr.print(i + "--> ");
                for (int j = 0; j < dp[0].length; ++j) {
                    pr.print(dp[i][j] + " ");
                }
                pr.println("");
            }
        }
    }

    public static void debug(int x) {
        if (sysFlag)
            pr.println("Int-Ele: " + x);
    }

    public static void debug(String x) {
        if (sysFlag)
            pr.println("String: " + x);
    }

    public static void debug(char x) {
        if (sysFlag)
            pr.println("Char: " + x);
    }

    public static void debug(long x) {
        if (sysFlag)
            pr.println("Long-Ele: " + x);
    }

    public static void debug(int[] arr, int n) {
        if (sysFlag) {
            for (int i = 0; i < n; ++i) {
                pr.println(i + " -> " + arr[i]);
            }
        }
    }

    public static void debug(char[] arr) {
        if (sysFlag) {
            for (int i = 0; i < arr.length; ++i) {
                pr.println(i + " -> " + arr[i]);
            }
        }
    }

    public static void debug(long[] arr, int n) {
        if (sysFlag) {
            for (int i = 0; i < n; ++i) {
                pr.println(i + " -> " + arr[i]);
            }
        }
    }

    public static void debug(ArrayList<Integer> list) {
        if (sysFlag) {
            for (int i = 0; i < list.size(); ++i) {
                pr.println(i + " -> " + list.get(i));
            }
        }
    }

    public static void Ldebug(ArrayList<Long> list) {
        if (sysFlag) {
            for (int i = 0; i < list.size(); ++i) {
                pr.println(i + " -> " + list.get(i));
            }
        }
    }

    public static void debugmapII(HashMap<Integer, Integer> map) {
        if (sysFlag) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet())
                pr.println("Key => " + entry.getKey() + ", Value => " + entry.getValue());
        }
    }

    public static void debugmapLI(HashMap<Long, Integer> map) {
        if (sysFlag) {
            for (Map.Entry<Long, Integer> entry : map.entrySet())
                pr.println("Key => " + entry.getKey() + ", Value => " + entry.getValue());
        }
    }

    public static void debugmapLL(HashMap<Long, Long> map) {
        if (sysFlag) {
            for (Map.Entry<Long, Long> entry : map.entrySet())
                pr.println("Key => " + entry.getKey() + ", Value => " + entry.getValue());
        }
    }

    public static void debugmapIL(HashMap<Integer, Long> map) {
        if (sysFlag) {
            for (Map.Entry<Integer, Long> entry : map.entrySet())
                pr.println("Key => " + entry.getKey() + ", Value => " + entry.getValue());
        }
    }

    public static void debugmapSL(HashMap<String, Long> map) {
        if (sysFlag) {
            for (Map.Entry<String, Long> entry : map.entrySet())
                pr.println("Key => " + entry.getKey() + ", Value => " + entry.getValue());
        }
    }

    public static void debugmapCL(HashMap<Character, Long> map) {
        if (sysFlag) {
            for (Map.Entry<Character, Long> entry : map.entrySet())
                pr.println("Key => " + entry.getKey() + ", Value => " + entry.getValue());
        }
    }

    public static void debugmapSI(HashMap<String, Integer> map) {
        if (sysFlag) {
            for (Map.Entry<String, Integer> entry : map.entrySet())
                pr.println("Key => " + entry.getKey() + ", Value => " + entry.getValue());
        }
    }

    public static void debugmapCI(HashMap<Character, Integer> map) {
        if (sysFlag) {
            for (Map.Entry<Character, Integer> entry : map.entrySet())
                pr.println("Key => " + entry.getKey() + ", Value => " + entry.getValue());
        }
    }

    public static void debug(Set<Integer> set) {
        if (sysFlag) {
            Iterator value = set.iterator();
            int i = 1;
            while (value.hasNext()) {
                pr.println((i++) + "-> " + value.next());
            }
        }
    }
}
