import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Vector;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Stack;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        DDiscreteCentrifugalJumps solver = new DDiscreteCentrifugalJumps();
        solver.solve(1, in, out);
        out.close();
    }

    static class DDiscreteCentrifugalJumps {
        public void solve(int testNumber, InputReader s, PrintWriter w) {
            int n = s.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = s.nextInt();
            int[] dp = new int[n];
            for (int i = 0; i < n; i++)
                dp[i] = i;
            Stack<Integer> dec = new Stack<>();
            dec.push(0);
            Stack<Integer> inc = new Stack<>();
            inc.push(0);
            for (int i = 1; i < n; i++) {
                while (!dec.isEmpty() && a[dec.peek()] < a[i]) {
                    dp[i] = Math.min(dp[i], dp[dec.peek()] + 1);
                    dec.pop();
                }
                if (!dec.isEmpty()) {
                    dp[i] = Math.min(dp[i], dp[dec.peek()] + 1);
                    if (a[dec.peek()] == a[i])
                        dec.pop();
                }
                dec.push(i);
                while (!inc.isEmpty() && a[inc.peek()] > a[i]) {
                    dp[i] = Math.min(dp[i], dp[inc.peek()] + 1);
                    inc.pop();
                }
                if (!inc.isEmpty()) {
                    dp[i] = Math.min(dp[i], dp[inc.peek()] + 1);
                    if (a[inc.peek()] == a[i])
                        inc.pop();
                }
                inc.push(i);
            }
            w.println(dp[n - 1]);
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

