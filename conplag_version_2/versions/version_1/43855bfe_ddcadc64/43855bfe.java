import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class O4 {
    private static String solve(int n, int[] a) {

        if (n == 2) {
            return a[1] + " " + (-a[0]);
        }
        int res[] = new int[n];
        if (n % 2 == 0) {
            diagonalAlignment(a, res, n);
        } else {

            diagonalAlignment(a, res, n - 3);
            if ( a[n - 3] + a[n - 2] != 0)
            {
                res[n - 1] = a[n - 3] + a[n - 2];
                res[n - 2] = -a[n - 1];
                res[n - 3] = -a[n - 1];
            }

            else if (a[n - 1] + a[n - 2] != 0){
                res[n - 3] = a[n - 1] + a[n - 2];
                res[n - 2] = -a[n - 3];
                res[n - 1] = -a[n - 3];
            }
            else {
                res[n - 2] = a[n - 1] + a[n - 3];
                res[n - 1] = -a[n - 2];
                res[n - 3] = -a[n - 2];

            }
        }


        return formattedArray(res);

    }

    private static void diagonalAlignment(int[] a, int[] res, int n) {


        for (int i = 0; i < n; i += 2) {
            res[i + 1] = -a[i];
            res[i] = a[i + 1];
        }


    }


    public static void main(String[] args)
            throws IOException {
        Scanner s = new Scanner();
        int t = 1;
        t = s.nextInt();
        StringBuilder ans = new StringBuilder();
        int count = 0;
        while (t-- > 0) {
            int n = s.nextInt();

            int a[] = new int[n];
            getInputs(s, a, n);


            ans.append(solve(n, a)).append("\n");
        }
        System.out.println(ans.toString());
    }

    static class Scanner {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Scanner() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Scanner(String file_name) throws IOException {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }

    public static long norm(long a, long MOD) {
        return ((a % MOD) + MOD) % MOD;
    }

    public static long msub(long a, long b, long MOD) {
        return norm(norm(a, MOD) - norm(b, MOD), MOD);

    }

    public static long madd(long a, long b, long MOD) {
        return norm(norm(a, MOD) + norm(b, MOD), MOD);

    }

    public static long mMul(long a, long b, long MOD) {
        return norm(norm(a, MOD) * norm(b, MOD), MOD);


    }

    public static long mDiv(long a, long b, long MOD) {
        return norm(norm(a, MOD) / norm(b, MOD), MOD);
    }

    public static String formattedArray(int a[]) {
        StringBuilder res = new StringBuilder("");
        for (int e : a)
            res.append(e).append(" ");
        return res.toString().trim();

    }

    private static void getInputs(Scanner s, int[] a, int n) throws IOException {
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
    }
}
