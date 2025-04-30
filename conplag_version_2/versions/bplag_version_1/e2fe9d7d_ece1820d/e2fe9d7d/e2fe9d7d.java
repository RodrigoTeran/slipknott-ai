
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;


public class C_Edu_Round_120 {
    public static long MOD = 998244353;

    static int[] dp;


    public static void main(String[] args) throws FileNotFoundException {
        // PrintWriter out = new PrintWriter(new FileOutputStream(new File(
        // "output.txt")));
        PrintWriter out = new PrintWriter(System.out);
        Scanner in = new Scanner();
        int T = in.nextInt();
        //System.out.println(cal(1608737403, 1000000000) - 923456789987654321L);
        for (int z = 0; z < T; z++) {
            int n = in.nextInt();
            long k = in.nextLong();
            long[] data = new long[n];
            long total = 0;
            PriorityQueue<Integer> q = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                q.add(in.nextInt());
            }
            for (int i = 0; i < n; i++) {
                data[i] = q.poll();
                total += data[i];
            }
            Arrays.sort(data);
            long result = Long.max(0, total - k);
            long cur = 0;
            int num = 0;
            for (int i = n - 1; i > 0 && total > k + cur; i--) {

                num++;
                cur += data[i] - data[0];
                long left = Long.max(0, total - cur - k);
                left /= (num + 1);
                if (total - cur - (left * (num + 1)) > k) {
                    left++;
                }
                //System.out.println(num + " " + left + " " + cur + " " + total);
                result = Long.min(result, left + num);
            }


            out.println(result);

        }

        out.close();
    }

    static long cal(long msg, long k) {
        if (msg <= k) {
            return msg * (msg + 1L) / 2L;
        }
        long re = k * (k + 1L) / 2L;
        long left = 2 * k - 1 - msg;
        long other = (k - 1) * k / 2;
        other -= left * (left + 1) / 2;
        //System.out.println(other);
        return re + other;
    }

    static long cal2(long msg, long k) {
        if (msg <= k) {
            return BigInteger.valueOf(msg).multiply(BigInteger.valueOf(msg + 1)).shiftRight(1).longValue();
        }
        BigInteger re = BigInteger.valueOf(k).multiply(BigInteger.valueOf(k + 1)).shiftRight(1);
        long left = 2 * k - 1 - msg;
        BigInteger other = BigInteger.valueOf(k).multiply(BigInteger.valueOf(k - 1)).shiftRight(1);
        other = other.subtract(BigInteger.valueOf(left).multiply(BigInteger.valueOf(left + 1)).shiftRight(1));
        return re.add(other).longValue();

    }

    static int find(int index, int[] u) {
        if (u[index] != index) {
            return u[index] = find(u[index], u);
        }
        return index;
    }

    static int abs(int a) {
        return a < 0 ? -a : a;
    }


    public static int[] KMP(String val) {
        int i = 0;
        int j = -1;
        int[] result = new int[val.length() + 1];
        result[0] = -1;
        while (i < val.length()) {
            while (j >= 0 && val.charAt(j) != val.charAt(i)) {
                j = result[j];
            }
            j++;
            i++;
            result[i] = j;
        }
        return result;

    }

    public static boolean nextPer(int[] data) {
        int i = data.length - 1;
        while (i > 0 && data[i] < data[i - 1]) {
            i--;
        }
        if (i == 0) {
            return false;
        }
        int j = data.length - 1;
        while (data[j] < data[i - 1]) {
            j--;
        }
        int temp = data[i - 1];
        data[i - 1] = data[j];
        data[j] = temp;
        Arrays.sort(data, i, data.length);
        return true;
    }

    public static int digit(long n) {
        int result = 0;
        while (n > 0) {
            n /= 10;
            result++;
        }
        return result;
    }

    public static double dist(long a, long b, long x, long y) {
        double val = (b - a) * (b - a) + (x - y) * (x - y);
        val = Math.sqrt(val);
        double other = x * x + a * a;
        other = Math.sqrt(other);
        return val + other;

    }

    public static class Point {

        int x;
        int y;

        public Point(int start, int end) {
            this.x = start;
            this.y = end;
        }

        public String toString() {
            return x + " " + y;
        }

    }

    public static class FT {

        long[] data;

        FT(int n) {
            data = new long[n];
        }

        public void update(int index, long value) {
            while (index < data.length) {
                data[index] += value;
                index += (index & (-index));
            }
        }

        public long get(int index) {

            long result = 0;
            while (index > 0) {
                result += data[index];
                index -= (index & (-index));
            }
            return result;

        }
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static long pow(long a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }

        long val = pow(a, b / 2);
        if (b % 2 == 0) {
            return (val * val) % MOD;
        } else {
            return (val * ((val * a) % MOD)) % MOD;

        }
    }

    static class Scanner {

        BufferedReader br;
        StringTokenizer st;

        public Scanner() throws FileNotFoundException {
            // System.setOut(new PrintStream(new BufferedOutputStream(System.out), true));
            br = new BufferedReader(new InputStreamReader(System.in));
            //br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        }

        public String next() {

            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    throw new RuntimeException();
                }
            }
            return st.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            st = null;
            try {
                return br.readLine();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }

        public boolean endLine() {
            try {
                String next = br.readLine();
                while (next != null && next.trim().isEmpty()) {
                    next = br.readLine();
                }
                if (next == null) {
                    return true;
                }
                st = new StringTokenizer(next);
                return st.hasMoreTokens();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }
}