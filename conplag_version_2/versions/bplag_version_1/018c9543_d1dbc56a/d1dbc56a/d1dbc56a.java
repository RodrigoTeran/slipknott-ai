import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int a[] = new int[12];
    public static int b[] = new int[12];

    public static boolean f(int p) {
        if (p > n) return false;

        for (int i = 0; i < p; i++) {
            b[p] = a[p] + b[i];
            for (int j = 0; j < p; j++) {
                if (b[j] == b[p])
                    return true;
            }
            if (f(p + 1)) {
                return true;
            }


//            b[p] = b[i] - a[p];
//            for (int j = 0; j < p; j++) {
//                if (b[j] == b[p])
//                    return true;
//            }
//            if (f(p + 1)) {
//                return true;
//            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        int T = r.readInt();
        for (int t = 0; t < T; t++) {
            n = r.readInt();
            for (int i = 1; i <= n; i++) {
                a[i] = r.readInt();
            }

            boolean ans = false;
            if (n == 1) {
                ans = a[1] == 0;
            } else {
                b[0] = 1;
                ans = f(1);
            }

            if (ans) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static public InputReader r = new InputReader(System.in);
    static public OutputWriter w = new OutputWriter(System.out);

    static public class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] readIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = this.readInt();
            }
            return array;
        }

        public long[] readLongArray(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                array[i] = this.readLong();
            }
            return array;
        }

        public long readLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

    static public class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }
    }
}

//            1
//            10
//            1 2 4 8 16 32 64 128 256 512