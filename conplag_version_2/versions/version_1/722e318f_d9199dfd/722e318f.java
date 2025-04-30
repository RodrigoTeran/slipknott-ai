import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class TaskB {

    static long mod = 1000000007;
    static FastScanner scanner;

    static final StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        // 2 : 1000000000
        scanner = new FastScanner();
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            solve(t + 1);
            result.append("\n");
        }
        System.out.println(result);
    }

    static void solve(int t) {
        int n = scanner.nextInt();
        int[] a = scanner.nextIntArray(n);
        String s = scanner.nextToken();

        List<Integer> blue = new ArrayList<>();
        List<Integer> red = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'B') {
                blue.add(a[i]);
            } else {
                red.add(a[i]);
            }
        }
        Collections.sort(blue);
        Collections.sort(red);
        for (int i = 0; i < blue.size(); i++) {
            if (blue.get(i) < i + 1) {
                result.append("NO");
                return;
            }
        }
        for (int i = 0; i < red.size(); i++) {
            if (red.get(i) > i + 1 + blue.size()) {
                result.append("NO");
                return;
            }
        }
        result.append("YES");
    }

    static class WithIdx implements Comparable<WithIdx> {
        int val, idx;

        public WithIdx(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(WithIdx o) {
            if (val == o.val) {
                return Integer.compare(idx, o.idx);
            }
            return Integer.compare(val, o.val);
        }
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            try {
                return br.readLine();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }

        int nextInt() {
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }

        int[] nextIntArray(int n) {
            int[] res = new int[n];
            for (int i = 0; i < n; i++) res[i] = nextInt();
            return res;
        }

        long[] nextLongArray(int n) {
            long[] res = new long[n];
            for (int i = 0; i < n; i++) res[i] = nextLong();
            return res;
        }

        String[] nextStringArray(int n) {
            String[] res = new String[n];
            for (int i = 0; i < n; i++) res[i] = nextToken();
            return res;
        }
    }

    static class PrefixSums {
        long[] sums;

        public PrefixSums(long[] sums) {
            this.sums = sums;
        }

        public long sum(int fromInclusive, int toExclusive) {
            if (fromInclusive > toExclusive) throw new IllegalArgumentException("Wrong value");
            return sums[toExclusive] - sums[fromInclusive];
        }

        public static PrefixSums of(int[] ar) {
            long[] sums = new long[ar.length + 1];
            for (int i = 1; i <= ar.length; i++) {
                sums[i] = sums[i - 1] + ar[i - 1];
            }
            return new PrefixSums(sums);
        }

        public static PrefixSums of(long[] ar) {
            long[] sums = new long[ar.length + 1];
            for (int i = 1; i <= ar.length; i++) {
                sums[i] = sums[i - 1] + ar[i - 1];
            }
            return new PrefixSums(sums);
        }
    }

    static class ADUtils {
        static void sort(int[] ar) {
            Random rnd = ThreadLocalRandom.current();
            for (int i = ar.length - 1; i > 0; i--) {
                int index = rnd.nextInt(i + 1);
                // Simple swap
                int a = ar[index];
                ar[index] = ar[i];
                ar[i] = a;
            }
            Arrays.sort(ar);
        }

        static void reverse(int[] arr) {
            int last = arr.length / 2;
            for (int i = 0; i < last; i++) {
                int tmp = arr[i];
                arr[i] = arr[arr.length - 1 - i];
                arr[arr.length - 1 - i] = tmp;
            }
        }

        static void sort(long[] ar) {
            Random rnd = ThreadLocalRandom.current();
            for (int i = ar.length - 1; i > 0; i--) {
                int index = rnd.nextInt(i + 1);
                // Simple swap
                long a = ar[index];
                ar[index] = ar[i];
                ar[i] = a;
            }
            Arrays.sort(ar);
        }
    }

    static class MathUtils {
        static long[] FIRST_PRIMES = {
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
                73, 79, 83, 89, 97, 101, 103, 107, 109, 113,
                127, 131, 137, 139, 149, 151, 157, 163, 167, 173,
                179, 181, 191, 193, 197, 199, 211, 223, 227, 229,
                233, 239, 241, 251, 257, 263, 269, 271, 277, 281,
                283, 293, 307, 311, 313, 317, 331, 337, 347, 349,
                353, 359, 367, 373, 379, 383, 389, 397, 401, 409,
                419, 421, 431, 433, 439, 443, 449, 457, 461, 463,
                467, 479, 487, 491, 499, 503, 509, 521, 523, 541,
                547, 557, 563, 569, 571, 577, 587, 593, 599, 601,
                607, 613, 617, 619, 631, 641, 643, 647, 653, 659,
                661, 673, 677, 683, 691, 701, 709, 719, 727, 733,
                739, 743, 751, 757, 761, 769, 773, 787, 797, 809,
                811, 821, 823, 827, 829, 839, 853, 857, 859, 863,
                877, 881, 883, 887, 907, 911, 919, 929, 937, 941,
                947, 953, 967, 971, 977, 983, 991, 997, 1009, 1013,
                1019, 1021, 1031, 1033, 1039, 1049, 1051};

        static long[] primes(int to) {
            long[] all = new long[to + 1];
            long[] primes = new long[to + 1];
            all[1] = 1;
            int primesLength = 0;
            for (int i = 2; i <= to; i++) {
                if (all[i] == 0) {
                    primes[primesLength++] = i;
                    all[i] = i;
                }
                for (int j = 0; j < primesLength && i * primes[j] <= to && all[i] >= primes[j];
                        j++) {
                    all[(int) (i * primes[j])] = primes[j];
                }
            }
            return Arrays.copyOf(primes, primesLength);
        }

        static long modpow(long b, long e, long m) {
            long result = 1;

            while (e > 0) {
                if ((e & 1) == 1) {
                    /* multiply in this bit's contribution while using modulus to keep
                     * result small */
                    result = (result * b) % m;
                }
                b = (b * b) % m;
                e >>= 1;
            }

            return result;
        }

        static long submod(long x, long y, long m) {
            return (x - y + m) % m;
        }

        static long modInverse(long a, long m) {
            long g = gcdF(a, m);
            if (g != 1) {
                throw new IllegalArgumentException("Inverse doesn't exist");
            } else {
                // If a and m are relatively prime, then modulo
                // inverse is a^(m-2) mode m
                return modpow(a, m - 2, m);
            }
        }

        static public long gcdF(long a, long b) {
            while (b != 0) {
                long na = b;
                long nb = a % b;
                a = na;
                b = nb;
            }
            return a;
        }
    }
}

/*
5
3 2 3 8 8
2 8 5 10 1

 */