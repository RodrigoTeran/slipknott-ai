    import java.util.*;
    import java.io.*;
    public class D{
        static class InputReader {

            private final InputStream stream;
            private final byte[] buf = new byte[8192];
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
                while (isSpaceChar(c)) {
                    c = snext();
                }
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
                while (isSpaceChar(c)) {
                    c = snext();
                }
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
                for (int i = 0; i < n; i++) {
                    a[i] = nextInt();
                }
                return a;
            }

            public String readString() {
                int c = snext();
                while (isSpaceChar(c)) {
                    c = snext();
                }
                StringBuilder res = new StringBuilder();
                do {
                    res.appendCodePoint(c);
                    c = snext();
                } while (!isSpaceChar(c));
                return res.toString();
            }

            public String nextLine() {
                int c = snext();
                while (isSpaceChar(c))
                    c = snext();
                StringBuilder res = new StringBuilder();
                do {
                    res.appendCodePoint(c);
                    c = snext();
                } while (!isEndOfLine(c));
                return res.toString();
            }

            public boolean isSpaceChar(int c) {
                if (filter != null)
                    return filter.isSpaceChar(c);
                return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
            }

            private boolean isEndOfLine(int c) {
                return c == '\n' || c == '\r' || c == -1;
            }

            public interface SpaceCharFilter {
                public boolean isSpaceChar(int ch);
            }

        }
        static class OutputWriter {
            private final PrintWriter writer;
    
            public OutputWriter(OutputStream outputStream) {
                writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
            }
    
            public OutputWriter(Writer writer) {
                this.writer = new PrintWriter(writer);
            }
    
            public void print(Object...objects) {
                for (int i = 0; i < objects.length; i++) {
                    if (i != 0)
                        writer.print(' ');
                    writer.print(objects[i]);
                }
            }
    
            public void printLine(Object...objects) {
                print(objects);
                writer.println();
            }
    
            public void close() {
                writer.close();
            }
    
            public void flush() {
                writer.flush();
            }
    
            }
        static int gcd(int a, int b) 
        { 
            if (a == 0) 
                return b; 
            return gcd(b % a, a); 
        } 
        static int mod = (int)(1e9+7);
        public static long pow(long a,long b)
        {
            long ans = 1;
            while(b> 0)
            {
                if((b & 1)==1){
                    ans = (ans*a) % mod; 
                }
                a = (a*a) % mod;
                b = b>>1;
            }
            return ans;
        }

        public static void main(String[] args) {
            InputReader in = new InputReader(System.in);
            OutputWriter out = new OutputWriter(System.out);
            int n = in.nextInt();
            int[] arr = in.nextIntArray(n);
            Stack<Integer> min = new Stack<>();
            Stack<Integer> max = new Stack<>();
            int[] dp = new int[n];
            // Arrays.fill(dp,(int)1e9);
            dp[0] = 0;
            min.push(0);
            max.push(0);
            for(int i=1;i<n;i++)
            {
                int h=dp[i-1]+1;
                while(!max.isEmpty() && arr[i]>arr[max.peek()])
                {
                    int x = arr[max.peek()];
                    h = Math.min(h,1+dp[max.pop()]);
                    while(!max.isEmpty() && arr[max.peek()]==x)
                    {
                        max.pop();
                    }
                }
                if(!max.isEmpty())
                {
                    h = Math.min(h,1+dp[max.peek()]);
                }
                while(!min.isEmpty() && arr[i]<arr[min.peek()])
                {
                    int x = arr[min.peek()];
                    h = Math.min(h,1+dp[min.pop()]);
                    while(!min.isEmpty() && arr[min.peek()]==x)
                    {
                        min.pop();
                    }
                }
                if(!min.isEmpty())
                {
                    h = Math.min(h,1+dp[min.peek()]);
                }
                dp[i] = h;
                min.push(i);
                max.push(i);
            }
            out.printLine(dp[n-1]);
            out.flush();
            out.close();
        }
    }