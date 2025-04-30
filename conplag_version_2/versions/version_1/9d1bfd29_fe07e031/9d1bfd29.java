 //import java.io.IOException;
 
    import java.io.IOException;
    import java.io.InputStream;
    import java.io.PrintWriter;
    import java.util.*;
 
    public class SetorDecrease {
        static InputReader inputReader=new InputReader(System.in);
        static void solve()
        {
            int n=inputReader.nextInt();
            long k=inputReader.nextLong();
            long sum=0;
            long arr[]=new long[n];
            for (int i=0;i<n;i++)
            {
                arr[i]=inputReader.nextLong();
            }
            SortDec(arr);
            for (int i=0;i<n-1;i++)
            {
                sum+=arr[i];
            }
            long ans=Long.MAX_VALUE;
            for (int i=0;i<n;i++)
            {
               long remval=k-sum;
               long val=fdiv(remval,i+1);
               ans=Math.min(ans,i+Math.max(arr[n-1]-val,0));
               sum-=arr[i];
            }
            out.println(ans);
        }
        static void SortDec(long arr[])
        {
            List<Long>list=new ArrayList<>();
            for(long ele:arr)
            {
                list.add(ele);
            }
            Collections.sort(list,Collections.reverseOrder());
            int n=arr.length;
            for (int i=0;i<n;i++)
            {
                arr[i]=list.get(i);
 
            }
 
        }
       static long fdiv(long X, long Y) {
            if (X >= 0) {
                return X / Y;
            } else {
                return (X-Y+1) / Y;
            }
        }
        static PrintWriter out=new PrintWriter((System.out));
        public static void main(String args[])throws IOException
        {
            int t=inputReader.nextInt();
            while (t-->0) {
                solve();
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