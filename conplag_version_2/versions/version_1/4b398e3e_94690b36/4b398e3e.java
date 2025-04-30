import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.StringTokenizer;

public class codeforces_750_D {
    private static void solve(FastIOAdapter io) {
        int n = io.nextInt();
        int[] a = io.readArray(n);

        if (n % 2 == 0) {
            for (int i = 0; i < n; i += 2) {
                io.out.print(a[i + 1] + " ");
                io.out.print(-a[i] + " ");
            }
        } else {
            for (int i = 0; i < n - 3; i += 2) {
                io.out.print(a[i + 1] + " ");
                io.out.print(-a[i] + " ");
            }
            if (a[n - 3] + a[n - 2] != 0) {
                io.out.print(-a[n - 1] + " ");
                io.out.print(-a[n - 1] + " ");
                io.out.print(a[n - 3] + a[n - 2] + " ");
            } else if (a[n - 3] + a[n - 1] != 0) {
                io.out.print(-a[n - 2] + " ");
                io.out.print(a[n - 3] + a[n - 1] + " ");
                io.out.print(-a[n - 2] + " ");
            } else {
                io.out.print(a[n - 2] + a[n - 1] + " ");
                io.out.print(-a[n - 3] + " ");
                io.out.print(-a[n - 3] + " ");
            }
        }
        io.out.println();
    }

    public static void main(String[] args) throws Exception {
        try (FastIOAdapter ioAdapter = new FastIOAdapter()) {
            int count = 1;
            count = ioAdapter.nextInt();
            while (count-- > 0) {
                solve(ioAdapter);
            }
        }
    }

    static void ruffleSort(int[] arr) {
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

    static class FastIOAdapter implements AutoCloseable {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        public PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter((System.out))));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long[] readArrayLong(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        @Override
        public void close() throws Exception {
            out.flush();
            out.close();
            br.close();
        }
    }
}
