import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main1582D {
    public static void main(String[] args) {
        final FastScanner in = new FastScanner(System.in);
        final PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = in.nextInt();
            }
            int[] b = solution(a, n);
            for (int j = 0; j < n; j++) {
                out.print(b[j]);
                out.print(" ");
            }
            out.println();
        }

        out.flush();
        out.close();
        in.close();
    }

    private static int[] solution(int[] a, int n) {
        int[] b = new int[n];
        int start = 0;

        if (n % 2 == 1) {
            if (a[0] + a[1] != 0) {
                b[0] = -a[2];
                b[1] = -a[2];
                b[2] = a[0] + a[1];
            } else if (a[0] + a[2] != 0) {
                b[0] = -a[1];
                b[1] = a[0] + a[2];
                b[2] = -a[1];
            } else {
                b[0] = a[1] + a[2];
                b[1] = -a[0];
                b[2] = -a[0];
            }
            start = 3;
        } else {
            b[0] = -a[1];
            b[1] = a[0];
            int gcd = gcd(b[0], b[1]);
            b[0] /= gcd;
            b[1] /= gcd;
            start = 2;
        }
        for (int i = start; i < n; i += 2) {
            b[i] = -a[i + 1];
            b[i + 1] = a[i];
        }
        return b;
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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

        double nextDouble() {
            return Double.parseDouble(next());
        }

        int[] readIntArr(int n) {
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                result[i] = Integer.parseInt(next());
            }
            return result;
        }

        long[] readLongArr(int n) {
            long[] result = new long[n];
            for (int i = 0; i < n; i++) {
                result[i] = Long.parseLong(next());
            }
            return result;
        }


        void close() {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        long nextLong() {
            return Long.parseLong(next());
        }

    }
}
