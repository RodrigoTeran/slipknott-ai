import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class Main {

    // static final File ip = new File("input.txt");
    // static final File op = new File("output.txt");
    // static {
    // try {
    // System.setOut(new PrintStream(op));
    // System.setIn(new FileInputStream(ip));
    // } catch (Exception e) {
    // }
    // }
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int test = 1;
        test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            sortL(a);
            long[] pref = new long[n + 1];
            for (int i = 0; i < n; i++) {
                pref[i + 1] = pref[i] + a[i];
            }
            long ans = (long) 9e18;
            for (int t = 0; t <= n - 1; t++) {
                long sum = pref[n - t] + a[0] * t;
                long cur = t;
                if (sum > k) {
                    long diff = sum - k;
                    cur += (diff + t) / (t + 1);
                }
                ans = Math.min(ans, cur);
            }
            out.println(ans);
        }
        out.close();
    }

    static long power(long x, long y, long p) {
        long res = 1;
        x = x % p;
        if (x == 0)
            return 0;
        while (y > 0) {
            if ((y & 1) != 0)
                res = (res * x) % p;
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

    public static int countSetBits(long number) {
        int count = 0;
        while (number > 0) {
            ++count;
            number &= number - 1;
        }
        return count;
    }

    static int lower_bound(long target, long[] a, int pos) {
        if (pos >= a.length)
            return -1;
        int low = pos, high = a.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (a[mid] < target)
                low = mid + 1;
            else
                high = mid;
        }
        return a[low] >= target ? low : -1;
    }

    private static <T> void swap(long[] a, int i, int j) {
        long tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    static class pair {
        long a;
        int b;

        pair(long x, int y) {
            this.a = x;
            this.b = y;
        }
    }

    static class first implements Comparator<pair> {

        public int compare(pair p1, pair p2) {
            if (p1.a > p2.a)
                return 1;
            else if (p1.a < p2.a)
                return -1;
            return 0;
        }
    }

    static class second implements Comparator<pair> {

        public int compare(pair p1, pair p2) {
            if (p1.b > p2.b)
                return 1;
            else if (p1.b < p2.b)
                return -1;
            return 0;
        }
    }

    private static long getSum(int[] array) {
        long sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }

    private static boolean isPrime(Long x) {
        if (x < 2)
            return false;
        for (long d = 2; d * d <= x; ++d) {
            if (x % d == 0)
                return false;
        }
        return true;
    }

    static long[] reverse(long a[]) {
        int n = a.length;
        int i;
        long t;
        for (i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
        return a;
    }

    private static boolean isPrimeInt(int x) {
        if (x < 2)
            return false;
        for (int d = 2; d * d <= x; ++d) {
            if (x % d == 0)
                return false;
        }
        return true;
    }

    public static String reverse(String input) {
        StringBuilder str = new StringBuilder("");

        for (int i = input.length() - 1; i >= 0; i--) {
            str.append(input.charAt(i));
        }

        return str.toString();
    }

    private static int[] getPrimes(int n) {
        boolean[] used = new boolean[n + 1];
        used[0] = used[1] = true;
        // int size = 0;
        for (int i = 2; i <= n; ++i) {
            if (!used[i]) {
                // ++size;
                for (int j = 2 * i; j <= n; j += i) {
                    used[j] = true;
                }
            }
        }
        int[] primes = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            if (!used[i]) {
                primes[i] = 1;
            }
        }
        return primes;
    }

    private static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private static long gcd(long a, long b) {
        return (a == 0 ? b : gcd(b % a, a));
    }

    static void sortI(int[] arr) {
        int n = arr.length;
        Random rnd = new Random();
        for (int i = 0; i < n; ++i) {
            int tmp = arr[i];
            int randomPos = i + rnd.nextInt(n - i);
            arr[i] = arr[randomPos];
            arr[randomPos] = tmp;
        }
        Arrays.sort(arr);
    }

    static void shuffleList(ArrayList<Long> arr) {
        int n = arr.size();
        Random rnd = new Random();
        for (int i = 0; i < n; ++i) {
            long tmp = arr.get(i);
            int randomPos = i + rnd.nextInt(n - i);
            arr.set(i, arr.get(randomPos));
            arr.set(randomPos, tmp);
        }
    }

    static void factorize(long n) {
        int count = 0;
        while (!(n % 2 > 0)) {
            n >>= 1;

            count++;
        }
        if (count > 0) {
            // System.out.println("2" + " " + count);
        }
        long i = 0;
        for (i = 3; i <= (long) Math.sqrt(n); i += 2) {
            count = 0;
            while (n % i == 0) {
                count++;
                n = n / i;
            }
            if (count > 0) {
                // System.out.println(i + " " + count);
            }
        }

        if (n > 2) {
            // System.out.println(i + " " + count);
        }
    }

    static void sortL(long[] arr) {
        int n = arr.length;
        Random rnd = new Random();
        for (int i = 0; i < n; ++i) {
            long tmp = arr[i];
            int randomPos = i + rnd.nextInt(n - i);
            arr[i] = arr[randomPos];
            arr[randomPos] = tmp;
        }
        Arrays.sort(arr);
    }

    ////////////////////////////////// DSU START ///////////////////////////

    static class DSU {
        int[] parent, rank, total_Elements;

        DSU(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            total_Elements = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                rank[i] = 1;
                total_Elements[i] = 1;
            }
        }

        int find(int u) {
            if (parent[u] == u)
                return u;
            return parent[u] = find(parent[u]);
        }

        void unionByRank(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if (pu != pv) {
                if (rank[pu] > rank[pv]) {
                    parent[pv] = pu;
                    total_Elements[pu] += total_Elements[pv];
                } else if (rank[pu] < rank[pv]) {
                    parent[pu] = pv;
                    total_Elements[pv] += total_Elements[pu];
                } else {
                    parent[pu] = pv;
                    total_Elements[pv] += total_Elements[pu];
                    rank[pv]++;
                }
            }
        }

        boolean unionBySize(int u, int v) {
            u = find(u);
            v = find(v);
            if (u != v) {
                parent[u] = v;
                total_Elements[v] += total_Elements[u];
                total_Elements[u] = 0;
                return true;
            }
            return false;
        }
    }

    ////////////////////////////////// DSU END /////////////////////////////

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public boolean hasNext() {
            return false;
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