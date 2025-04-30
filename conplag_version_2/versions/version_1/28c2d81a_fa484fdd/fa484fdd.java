//import java.io.IOException;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class AirConditioners {
    static InputReader inputReader=new InputReader(System.in);
    static void solve()
    {
        int n=inputReader.nextInt();
        int k=inputReader.nextInt();
        int pos[]=inputReader.nextIntArray(k);
        int power[]=inputReader.nextIntArray(k);
        int answer[]=new int[n];
        Arrays.fill(answer,(int)(2e9));
        for (int i=0;i<k;i++)
        {
            answer[pos[i]-1]=power[i];
        }
        for (int i=1;i<n;i++)
        {
            answer[i]=Math.min(answer[i],answer[i-1]+1);
        }
        for (int i=n-2;i>=0;i--)
        {
            answer[i]=Math.min(answer[i],answer[i+1]+1);
        }
        for (int i=0;i<n;i++)
        {
            out.print(answer[i]+" ");
        }
    }
    static PrintWriter out=new PrintWriter((System.out));
    public static void main(String args[])throws IOException
    {
        int t=inputReader.nextInt();
        while(t-->0)
        {
            solve();
            out.println();
        }
        out.close();
    }
    static class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public String readString() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}
