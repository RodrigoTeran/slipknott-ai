
// import java.util.Vector;
import java.util.*;
import java.lang.Math;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import javax.management.Query;
import java.io.*;
import java.math.BigInteger;

public class Main {
    static int mod = 1000000007;

    /* ======================DSU===================== */
    static class dsu {
        static int parent[], n;// min[],value[];
        static long size[];

        dsu(int n) {
            parent = new int[n + 1];
            size = new long[n + 1];
            // min=new int[n+1];
            // value=new int[n+1];
            this.n = n;
            makeSet();
        }

        static void makeSet() {
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
                // min[i]=i;
            }
        }

        static int find(int a) {
            if (parent[a] == a)
                return a;
            else {
                return parent[a] = find(parent[a]);// Path Compression
            }
        }

        static void union(int a, int b) {
            int setA = find(a);
            int setB = find(b);
            if (setA == setB)
                return;
            if (size[setA] >= size[setB]) {
                parent[setB] = setA;
                size[setA] += size[setB];
            } else {
                parent[setA] = setB;
                size[setB] += size[setA];
            }
        }
    }

    /* ======================================================== */
    static class Pair implements Comparator<Pair> {
        long x;
        long y;

        // Constructor
        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public Pair() {
        }

        @Override
        public int compare(Main.Pair o1, Main.Pair o2) {
            return ((int) (o1.x - o2.x));
        }
    }

    static class FastReader {
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

        int[] intArr(int n) {
            int res[] = new int[n];
            for (int i = 0; i < n; i++)
                res[i] = nextInt();
            return res;
        }

        long[] longArr(int n) {
            long res[] = new long[n];
            for (int i = 0; i < n; i++)
                res[i] = nextLong();
            return res;
        }
    }

    static FastReader f = new FastReader();
    static BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

    static boolean isPrime(long n) {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (long i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        return true;
    }

    static int LowerBound(int a[], int x) { // x is the target value or key
        int l = -1, r = a.length;
        while (l + 1 < r) {
            int m = (l + r) >>> 1;
            if (a[m] >= x)
                r = m;
            else
                l = m;
        }
        return r;
    }

    static int UpperBound(int a[], int x) {// x is the key or target value
        int l = -1, r = a.length;
        while (l + 1 < r) {
            int m = (l + r) >>> 1;
            if (a[m] <= x)
                l = m;
            else
                r = m;
        }
        return l + 1;
    }

    static long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    static long power(long x, long y, long p) {
        long res = 1;
        x = x % p;
        while (y > 0) {
            if (y % 2 == 1)
                res = (res * x) % p;
            y = y >> 1; // y = y/2
            x = (x * x) % p;
        }
        return res;
    }

    static long power(long x, long y) {
        long res = 1;
        while (y > 0) {
            if (y % 2 == 1)
                res = (res * x);
            y >>= 1;
            x = (x * x);
        }
        return res;
    }

    static int power(int x, int y) {
        int res = 1;
        while (y > 0) {
            if (y % 2 == 1)
                res = (res * x);
            y >>= 1;
            x = (x * x);
        }
        return res;
    }

    static int ceil(int x, int y) {
        return (x % y == 0 ? x / y : (x / y + 1));
    }

    static long ceil(long x, long y) {
        return (x % y == 0 ? x / y : (x / y + 1));
    }

    /*
     * ===========Modular Operations==================
     */
    static long modInverse(long n, long p) {
        return power(n, p - 2, p);
    }

    static long modAdd(long a, long b) {
        return (a % mod + b % mod) % mod;

    }

    static long modMul(long a, long b) {
        return ((a % mod) * (b % mod)) % mod;
    }

    static long nCrModPFermat(int n, int r) {
        long p = 1000000007;
        if (r == 0)
            return 1;
        long[] fac = new long[n + 1];
        fac[0] = 1;
        for (int i = 1; i <= n; i++)
            fac[i] = fac[i - 1] * i % p;
        return (fac[n] * modInverse(fac[r], p) % p * modInverse(fac[n - r], p) % p) % p;
    }

    /*
     * ===============================================
     */
    static List<Character> removeDup(ArrayList<Character> list) {
        List<Character> newList = list.stream().distinct().collect(Collectors.toList());
        return newList;
    }

    static void ruffleSort(long[] a) {
        int n = a.length;
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            int oi = r.nextInt(n);
            long temp = a[i];
            a[i] = a[oi];
            a[oi] = temp;
        }
        Arrays.sort(a);
    }

    static void ruffleSort(int[] a) {
        int n = a.length;
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            int oi = r.nextInt(n);
            int temp = a[i];
            a[i] = a[oi];
            a[oi] = temp;
        }
        Arrays.sort(a);
    }

    /*
     * ===========Dynamic prog Recur Section===========
     */

    static int DP[][];
    static ArrayList<ArrayList<Integer>> g;
    static int count = 0;

    static ArrayList<Long> bitMask(ArrayList<Long> ar, int n) {
        ArrayList<Long> ans = new ArrayList<>();
        for (int mask = 0; mask <= Math.pow(2, n) - 1; mask++) {
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (((1 << i) & mask) > 0) {
                    sum += ar.get(i);
                }
            }
            ans.add(sum);
        }
        return ans;
    }

    /*
     * ====================================Main=================================
     */
    public static void main(String args[]) throws Exception {
        // File file = new File("D:\\VS Code\\Java\\Output.txt");
        // FileWriter fw = new FileWriter("D:\\VS Code\\Java\\Output.txt");
        Random rand = new Random();
        int t = 1;
        t = f.nextInt();
        int tc = 1;
        while (t-- != 0) {
            int n = f.nextInt();
            int c[] = new int[n];
            long minOdd = 0, minEven = 0;
            long sumEven = 0, sumOdd = 0;
            for (int i = 0; i < n ; i++) {
                c[i] = f.nextInt();
                // if (i % 2 == 0) {
                //     minEven = (c[minEven] > c[i]) ? i : minEven;
                //     sumEven += c[i];
                // } else {
                //     minOdd = (minOdd > c[i]) ? i : minOdd;
                //     sumOdd += c[i];
                // }
            }
            minEven = c[0];
            minOdd = c[1];
            sumEven=c[0];
            sumOdd=c[1];
            long min=minEven*n + minOdd*n;//for k=2
            int even=1,odd=1;
            for (int k = 3; k <= n; k++) {
                if(k%2==1){
                    sumEven+=c[k-1];
                    minEven=Math.min(minEven, c[k-1]);
                    even++;
                }else{
                    sumOdd+=c[k-1];
                    minOdd=Math.min(minOdd, c[k-1]);
                    odd++;
                }
                min=Math.min(min, sumEven-minEven+minEven*(n-even+1) + sumOdd-minOdd+minOdd*(n-odd+1));
            }
            w.write(min+"\n");

        }
        w.flush();
    }
}