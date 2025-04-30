import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Main solver = new Main();
        boolean multipleTC = true;
        int testCount = multipleTC ? Integer.parseInt(in.next()) : 1;
        for (int i = 1; i <= testCount; i++)
            solver.solve(in, out, i);
        out.close();
    }
    static class Main {
        PrintWriter out;
        InputReader in;

        public void solve(InputReader in, PrintWriter out, int test) {
            this.out = out;
            this.in = in;
            int n = ni();
            String[] arr = new String[n];
            int[][] freq = new int[n][5];
            int[][] rem = new int[n][5];
            for(int i = 0; i < n; i++){
                arr[i] = n();
                for(int j = 0; j < arr[i].length(); j++)
                    freq[i][arr[i].charAt(j) - 'a']++;
                for(int j = 0; j < 5; j++)
                    rem[i][j] = arr[i].length() - freq[i][j];
            }
            int ans = 0;
            for(int i = 0; i < 5; i++){
                int[] vals = new int[n];
                for(int j = 0; j < n; j++)
                    vals[j] = freq[j][i] - rem[j][i];
                Arrays.sort(vals);
                int sum = 0, x = 0;
                for(int j = n - 1; j >= 0; j--){
                    if(sum + vals[j] > 0){
                        x++;
                        sum += vals[j];
                    } else {
                        break;
                    }
                }
                if(x > ans) {
                    ans = x;
                }
            }
            pn(ans);
        }

        int gcd(int a, int b)
        {
            if (a == 0)
                return b;

            return gcd(b%a, a);
        }


        String n(){
            return in.next();
        }

        int ni() {
            return in.nextInt();
        }

        long nl() {
            return in.nextLong();
        }

        void pn(long zx) {
            out.println(zx);
        }

        void pn(String sz) {
            out.println(sz);
        }

        void pn(double dx){
            out.println(dx);
        }

        class Tuple {
            long x;
            long y;

            Tuple(long a, long b) {
                x = a;
                y = b;
            }
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new UnknownError();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new UnknownError();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuffer res = new StringBuffer();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));

            return res.toString();
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }
}