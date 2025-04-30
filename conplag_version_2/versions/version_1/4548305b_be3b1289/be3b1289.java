import java.util.*;
import java.lang.*;
import java.io.*;


public class cf {
    static PrintWriter out;
    static int MOD = 1000000007;
    static FastReader scan;

    /*-------- I/O using short named function ---------*/
    public static String ns() {
        return scan.next();
    }

    public static int ni() {
        return scan.nextInt();
    }

    public static long nl() {
        return scan.nextLong();
    }

    public static double nd() {
        return scan.nextDouble();
    }

    public static String nln() {
        return scan.nextLine();
    }

    public static void p(Object o) {
        out.print(o);
    }

    public static void ps(Object o) {
        out.print(o + " ");
    }

    public static void pn(Object o) {
        out.println(o);
    }

    /*-------- for output of an array ---------------------*/
    static void iPA(int arr[]) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < arr.length; i++) output.append(arr[i] + " ");
        out.println(output);
    }

    static void lPA(long arr[]) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < arr.length; i++) output.append(arr[i] + " ");
        out.println(output);
    }

    static void sPA(String arr[]) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < arr.length; i++) output.append(arr[i] + " ");
        out.println(output);
    }

    static void dPA(double arr[]) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < arr.length; i++) output.append(arr[i] + " ");
        out.println(output);
    }

    /*-------------- for input in an array ---------------------*/
    static void iIA(int arr[]) {
        for (int i = 0; i < arr.length; i++) arr[i] = ni();
    }

    static void lIA(long arr[]) {
        for (int i = 0; i < arr.length; i++) arr[i] = nl();
    }

    static void sIA(String arr[]) {
        for (int i = 0; i < arr.length; i++) arr[i] = ns();
    }

    static void dIA(double arr[]) {
        for (int i = 0; i < arr.length; i++) arr[i] = nd();
    }

    /*------------ for taking input faster ----------------*/
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
    }

    public static ArrayList<Integer> sieveOfEratosthenes(int n) {
        // Create a boolean array
        // "prime[0..n]" and
        // initialize all entries
        // it as true. A value in
        // prime[i] will finally be
        // false if i is Not a
        // prime, else true.
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++) {
            // If prime[p] is not changed, then it is a
            // prime
            if (prime[p] == true) {
                // Update all multiples of p
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
        ArrayList<Integer> arr = new ArrayList<>();
        // Print all prime numbers
        for (int i = 2; i <= n; i++) {
            if (prime[i] == true)
                arr.add(i);
        }
        return arr;
    }

    // Method to check if x is power of 2
    static boolean isPowerOfTwo(int x) {
        return x != 0 && ((x & (x - 1)) == 0);
    }

    //Method to return lcm of two numbers
    static int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }

    //Method to count digit of a number
    static int countDigit(long n) {
        String sex = Long.toString(n);
        return sex.length();
    }

    static void reverse(int a[]) {
        int i, k, t;
        int n = a.length;
        for (i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
    }

    static final Random random = new Random();

    //Method for sorting
    static void ruffleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int j = random.nextInt(n);
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        Arrays.sort(arr);
    }

    static void sortadv(long[] a) {
        ArrayList<Long> l = new ArrayList<>();
        for (long value : a) {
            l.add(value);
        }
        Collections.sort(l);
        for (int i = 0; i < l.size(); i++)
            a[i] = l.get(i);
    }

    //Method for checking if a number is prime or not
    static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        return true;
    }

    public static void main(String[] args) throws java.lang.Exception {
        OutputStream outputStream = System.out;
        out = new PrintWriter(outputStream);
        scan = new FastReader();
        //for fast output sometimes
        StringBuilder sb = new StringBuilder();
        int t = ni();
        while (t-- != 0) {
            int n=ni();
            int k=ni();
            int[] a=new int[k];
            int[] temp=new int[k];
            iIA(a);
            iIA(temp);
            long dp[]=new long[n];
            Arrays.fill(dp,Integer.MAX_VALUE);
            for(int i=0;i<k;i++){
                dp[a[i]-1]=temp[i];
            }
            //iPA(dp);
            for(int i=1;i<n;i++){
                dp[i]=Math.min(dp[i-1]+1,dp[i]);
            }
            //iPA(dp);
            for(int i=n-2;i>=0;i--){
                dp[i]=Math.min(dp[i+1]+1,dp[i]);
            }
            lPA(dp);
            //pn("");
        }

        out.flush();
        out.close();
    }
}

